package controller;

import persistence.enums.ContextType;
import config.IniFileManager;
import view.QuizApplication;
import persistence.*;
import model.factory.*;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;

/**
 * Primary controller that initializes the app, its properties, the secondary controllers
 * and finally the main UI view
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131211-01 - added reading of ini file properties
 * 
 */
public class OpstartController {
	
	//data members	
	private static IniFileManager iniProps = null;
	private static ContextType contextType;
	private static DataContext dc = null;
	private static OpdrachtCatalogus opdrachtcatalogus = null;
	private static QuizCatalogus quizcatalogus = null;
	//View
	private static QuizApplication application = null;
	
	//constructor
	public OpstartController(QuizCatalogus quizcl, OpdrachtCatalogus opdrachtcl, QuizApplication app)
	{
		opdrachtcatalogus = opdrachtcl;
		quizcatalogus = quizcl;
		application = app;
	}
	
	//getters & setters
	private static IniFileManager getIniProps() {
		return iniProps;
	}

	private static void setIniProps(IniFileManager iniProps) {
		OpstartController.iniProps = iniProps;
	}
	
	private static ContextType getContextType() {
		return contextType;
	}
	
	//methodes
	private static void setContextType() {
		contextType = ContextType.valueOf(getIniProps().getProperty("persistencemethod").toUpperCase());
		dc = new DataContext();
		switch(contextType){
		case LOCALFS: 
		{System.out.println("Gekozen voor text files");
		dc.setStrategy(new LocalFSPersistenceStrategy());
		break;}
		case MYSQL:{
			System.out.println("Gekozen voor MySQL database");
			dc.setStrategy(new MySQLPersistenceStrategy());
			break;
		}
		default:{
			System.out.println("Default persistence MySQL database");
			dc.setStrategy(new MySQLPersistenceStrategy());
			break;
		}
		}
	}
	
	public static OpdrachtCatalogus getOpdrachtCatalogus(){
		return opdrachtcatalogus;
	}
	
	public static QuizCatalogus getQuizCatalogus(){
		return quizcatalogus;
	}

	//Refer to MainProgram.java
	//main
	//public static void main(String[] args) {
	//	initialize();
	//}

	public void initialize() {
		
		//load app properties
		setIniProps(IniFileManager.getInstance());
		
		//set initial Data ContextType
		setContextType();
		
		//create OpdrachtCatalogus and QuizCatalogus
		//opdrachtcatalogus = new OpdrachtCatalogus();
		//quizcatalogus = new QuizCatalogus();
		
		//create singleton OpdrachtFactory
		OpdrachtFactory.Initialise(opdrachtcatalogus);
				
		//initialize secondary controllers
		
		//Load data
		try{
		dc.getStrategy().ReadData(quizcatalogus,opdrachtcatalogus);
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		//
		
		//Initialize menu
		try{
			application.ShowMenu();
		}
		catch (Exception e){
			System.out.println("Fout in het opbouwen van de menu!");
			
		}
	}

}

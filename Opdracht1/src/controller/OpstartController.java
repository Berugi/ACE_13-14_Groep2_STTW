package controller;

import persistence.enums.ContextType;
import config.IniFileManager;
import view.QuizApplication;
import persistence.*;

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
	
	private static void setContextType() {
		contextType = ContextType.valueOf(getIniProps().getProperty("persistencemethod").toUpperCase());
		dc = new DataContext();
		switch(contextType){
		case LOCALFS: 
			{System.out.println("Gekozen voor text files");
			dc.setStrategy(new LocalFSPersistenceStrategy());
			break;}
		case MYSQL:{
			dc.setStrategy(new MySQLPersistenceStrategy());
			break;
		}
		default:{
			break;
		}
		}
	}

	//main
	public static void main(String[] args) {
		initialize();
	}

	private static void initialize() {
		
		//load app properties
		setIniProps(IniFileManager.getInstance());
		
		//set initial ContextType
		setContextType();
		
		
		//initialize secondary controllers
		
		
		//Initialize menu
		try{
		QuizApplication qa = new QuizApplication();
		}
		catch (Exception e){
			System.out.println("Fout in het opbouwen van de menu!");
		}
		
		//initialize the main UI view
		//QuizUI ui = new QuizUI();
        //ui.setVisible(true);
		
		//Load data
		
	}

}

package controller;

import persistence.enums.ContextType;
import config.IniFileManager;
import view.QuizApp;
import persistence.*;
import model.factory.OpdrachtFactory;
import model.ObservableOpdrachtCatalogus;
import model.ObservableQuizCatalogus;

/**
 * Primary controller that initializes the app, its properties, the secondary controllers
 * and finally the main UI view
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131211-01 - added reading of ini file properties
 * @version 20131226-01 - Tom Scheepers - added DataContext, Opdrachtfactory, ReadData
 * @version 20131228-01 - Tom Vaes - changes towards MVC for main program
 * @version 20131228-02 - Wim Ombelets -
 * @version 20130110-01 - Tom Scheepers - getInstance + Singleton
 */
public class OpstartController {
	
	//data members	
	private static IniFileManager iniProps = null;
	private static ContextType contextType;
	private static DataContext dc = null;
	private static ObservableOpdrachtCatalogus opdrachtcatalogus = null;
	private static ObservableQuizCatalogus quizcatalogus = null;
	private static OpstartController opstartcontroller = null;
	
	//View
	private static QuizApp quizapplicatie=null;
	
	//constructor
	private OpstartController()
	{
		opdrachtcatalogus = new ObservableOpdrachtCatalogus();
		quizcatalogus = new ObservableQuizCatalogus();
		Startup();
		opstartcontroller = this;
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
	
	private static void setDataContext() {
		dc = new DataContext();
	}
	
	private static void setDataContext(ContextType contextType) {
		
		dc = new DataContext(contextType);
		
	}
	
	public static DataContext getDataContext(){
		return dc;
	}
	
	public static ObservableOpdrachtCatalogus getOpdrachtCatalogus(){
		return opdrachtcatalogus;
	}
	
	public static ObservableQuizCatalogus getQuizCatalogus(){
		return quizcatalogus;
	}

	//methods
	
	public void Startup() {
		
		//load app properties
		setIniProps(IniFileManager.getInstance());
		
		//set initial Data ContextType
		setDataContext();
		//QuizApplication.datacontext=this.getDataContext();
		
		//create singleton OpdrachtFactory
		OpdrachtFactory.Initialise(getOpdrachtCatalogus());
		
		//Load data
		try{
		dc.getStrategy().ReadData(getQuizCatalogus(),getOpdrachtCatalogus());
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		//initialize secondary controllers
		CreatieQuizController.getInstance();
		VerwijderQuizController.getInstance();
		AfsluitController.getInstance();
		//
		
		/*Initialize menu
		try{
			//QuizApp quizapplicatie = new QuizApp();
			//application.ShowMenu();
		}
		catch (Exception e){
			System.out.println("Fout in het opbouwen van de menu!");
			
		}
		*/
	}
	// Singleton pattern
	public static OpstartController getInstance(){
		if(opstartcontroller==null){
		opstartcontroller = new OpstartController();
		}
		return opstartcontroller;
	}
	
}

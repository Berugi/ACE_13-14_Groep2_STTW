package controller;

import persistence.enums.ContextType;
import config.IniFileManager;
import view.QuizUI;
import view.QuizApplication;

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
	}

}

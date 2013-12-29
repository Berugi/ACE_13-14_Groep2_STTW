package view;

import persistence.DataContext;
import controller.*;
import view.*;
import model.*;

/**
 * 
 * @author Tom Vaes
 * @version 20131228-01 - Initial version
 * 
 */

public class MainProgram {
	
	public static void main(String[] args) {
		
		//Models
		OpdrachtCatalogus opdrachtCatalogus = new OpdrachtCatalogus();
		QuizCatalogus quizCatalogus = new QuizCatalogus();

		//View
		QuizApplication application = new QuizApplication(quizCatalogus, opdrachtCatalogus);
		
		//Controllers
		OpstartController startup = new OpstartController(quizCatalogus,opdrachtCatalogus, application); 
		//Afsluitcontroller afsluiten = new AfsluitController();
		
		startup.initialize();
		
		//afsluiten.closeu();
	}
}
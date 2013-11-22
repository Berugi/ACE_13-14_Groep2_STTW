package controller;

import controller.basecontroller.BaseController;

/**
 * Factory that enables the creation of controllers
 * 
 * @author Wim Ombelets
 *
 */
public final class ControllerFactory {
	//private static OpstartController opstartController = null;
	private static AfsluitController afsluitController = null;
	private static QuizController quizController = null;
	
	public static BaseController getController(String T) {
		if(T == "AfsluitController")
			return afsluitController.getInstance();
		else if(T == "QuizController")
			return quizController.getInstance();
		else
			return null;
	}
}

package controller;

import view.QuizUI;

/**
 * Starts a new QuizUI and makes it visible.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * 
 */
public class OpstartController {

	public static void main(String[] args) {
        
		QuizUI ui = new QuizUI();
        ui.setVisible(true);
        
	}

}

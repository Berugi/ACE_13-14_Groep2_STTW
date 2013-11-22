package controller;

import view.QuizUI;

/**
 * De OpstartController start een nieuwe QuizUI op en maakt deze zichtbaar.
 * 
 * @author Wim
 * @version 20131122-01 - initial commit
 *
 */
public class OpstartController {

	public static void main(String[] args) {
        QuizUI ui = new QuizUI();
        ui.setVisible(true);
	}

}

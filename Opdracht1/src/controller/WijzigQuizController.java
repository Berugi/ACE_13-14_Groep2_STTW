package controller;

import view.WijzigQuizView;
import model.Quiz;
import model.enums.QuizStatus;

/**
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131229 - Sander Van der Borght
 *
 */
public class WijzigQuizController {

	private WijzigQuizView view;
	
	public WijzigQuizController() {
		this.view = new WijzigQuizView();
	}
	
	public void wijzigen(Quiz q) throws Exception {
		if(q.getQuizStatus() != QuizStatus.INCONSTRUCTIE){
			throw new Exception("Quiz niet wijzigbaar. Quizstatus is niet 'in constructie'!");
		}
		this.view.selectQuiz(q);
	}
	
	public void showView() {		
		this.view.setVisible(true);		
	}
	
	public void hideView() {		
		this.view.setVisible(false);		
	}
	
}

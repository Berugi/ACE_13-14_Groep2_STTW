package controller;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import persistence.DataContext;
import persistence.enums.ContextType;
import view.WijzigQuizView;
import model.Quiz;
import model.QuizActionEvent;
import model.enums.QuizStatus;
import model.interfaces.IObservable;

/**
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131229 - Sander Van der Borght (implementatie)
 * @version 20140109 - Sander Van der Borght
 */
public class WijzigQuizController {

	private static WijzigQuizController instance = null;
	private DataContext dc;
	private WijzigQuizView view;
	private IObservable quizCatalogusModel;
	
	private final String[] quizCommands = {"changeQuiz"};
	
	public WijzigQuizController(ContextType contextType) {
		dc = new DataContext(contextType);
		this.quizCatalogusModel = OpstartController.getQuizCatalogus();
		this.view = new WijzigQuizView(quizCatalogusModel);		
	}
	
	public static WijzigQuizController getInstance(ContextType contextType) {
		if(instance == null){
			instance = new WijzigQuizController(contextType);
		}
		return instance;
	}
	
	public void showView() {		
		this.view.setVisible(true);		
	}
	
	public void hideView() {		
		this.view.setVisible(false);		
	}
	
	public void actionPerformed(ActionEvent e) throws NullPointerException, UnsupportedOperationException,IllegalArgumentException {		
		if(e == null){
			throw new NullPointerException();
		}
		if(Arrays.asList(quizCommands).contains(e.getActionCommand())){
			QuizActionEvent event = (QuizActionEvent)e;
			Quiz q = event.getEventData();
			
			if(e.getActionCommand()=="changeQuiz"||e.getActionCommand()=="wijzigQuiz") {
				wijzigQuiz(q);
			}
		}		
		else{
			throw new UnsupportedOperationException("Unsupported ActionEvent Command.");
		}
	}
	
	public void wijzigQuiz(Quiz q) throws IllegalArgumentException {
		if(q.getQuizStatus() != QuizStatus.INCONSTRUCTIE){
			throw new IllegalArgumentException("Quiz niet wijzigbaar. Quizstatus is niet 'in constructie'!");
		}
		this.view.selectQuiz(q);
	}
}
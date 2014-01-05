package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.ObservableQuizCatalogus;
import model.Quiz;
import model.QuizActionEvent;
import model.interfaces.IObservable;
import persistence.DataContext;
import persistence.enums.ContextType;
import view.CreatieQuizView;

/**
 * Singleton controller responsible for creating new Quizzes.
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131228-01 - added beginnings of link to model and view
 * @version 20140104-01 - added further MVC
 *
 */
public class CreatieQuizController implements ActionListener {
	
	private static CreatieQuizController instance = null;
	private DataContext dc;
	private ContextType contextType;
	private CreatieQuizView view;
	private IObservable quizCatalogusModel;
	private IObservable opdrachtCatalogusModel;
	
	private final String[] quizCommands = {"addQuiz", "deleteQuiz"};
	
	private CreatieQuizController(ContextType contextType) {
		
		dc = new DataContext(contextType);
		this.quizCatalogusModel = OpstartController.getQuizCatalogus();
		this.opdrachtCatalogusModel = OpstartController.getOpdrachtCatalogus();
		this.view = new CreatieQuizView();
		
	}

	public static CreatieQuizController getInstance(ContextType contextType) {
		
		if(instance == null)
			instance = new CreatieQuizController(contextType);
		return instance;
		
	}
	
	public void showView() {
		
		this.view.setVisible(true);
		
	}
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void actionPerformed(ActionEvent e) throws NullPointerException, UnsupportedOperationException {
		
		if(e == null)
			throw new NullPointerException();
		
		if(Arrays.asList(quizCommands).contains(e.getActionCommand())){
			
			QuizActionEvent event = (QuizActionEvent)e;
			Quiz q = event.getEventData();
			
			switch(e.getActionCommand()) {
			case "addQuiz":
				addQuiz(q);
				break;
			case "deleteQuiz":
				removeQuiz(q);
				break;
			}
			
		}		
		else
			throw new UnsupportedOperationException("Unsupported ActionEvent Command.");
		
	}
	
	private void addQuiz(Quiz q) {
		
		((ObservableQuizCatalogus) quizCatalogusModel).add(q);
		
	}
	
	private void removeQuiz(Quiz q) {
		
		((ObservableQuizCatalogus) quizCatalogusModel).remove(q);
		
	}

}

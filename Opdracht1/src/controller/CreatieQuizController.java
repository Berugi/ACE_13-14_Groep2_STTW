package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.ObservableQuizCatalogus;
import model.Quiz;
import actionevents.QuizActionEvent;
import model.interfaces.IObservable;
import persistence.DataContext;
import persistence.enums.ContextType;
import view.CreateQuizView;

/**
 * Singleton controller responsible for creating new Quizzes.
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131228-01 - added beginnings of link to model and view
 * @version 20140104-01 - added further MVC
 * @version 20140110-01	- Tom Scheepers - added more MVC: link view & controller
 *
 */
public class CreatieQuizController implements ActionListener {
	
	private static CreatieQuizController instance = null;
	private DataContext dc;
	private ContextType contextType;
	private static CreateQuizView view;
	private IObservable quizCatalogusModel;
	private IObservable opdrachtCatalogusModel;
	
	private final String[] quizCommands = {"deleteQuiz", "newQuiz"};
	
	//Getters & Setters
	public static CreateQuizView getView(){
		return view;
	}
	
	private CreatieQuizController() {
		
		this.dc = OpstartController.getDataContext();
		this.quizCatalogusModel = OpstartController.getQuizCatalogus();
		this.opdrachtCatalogusModel = OpstartController.getOpdrachtCatalogus();
		this.view = new CreateQuizView();
		view.setActionListener(this);
		
	}
	
	public static CreatieQuizController getInstance(){
		if(instance == null)
			instance = new CreatieQuizController();
		return instance;
	}
	

	public void actionPerformed(ActionEvent e) throws NullPointerException, UnsupportedOperationException {
		
		if(e == null)
			throw new NullPointerException();
		
		if(Arrays.asList(quizCommands).contains(e.getActionCommand())){
			
			try{
				
				QuizActionEvent event = (QuizActionEvent)e;
				Quiz q = event.getActionData();
				
				switch(event.getActionCommand()) {
				case "newQuiz":
					addQuiz(q);
					break;
				case "deleteQuiz":
					removeQuiz(q);
					break;
				}
				
			}
			catch(NullPointerException n) {
				
				throw n;
				
			}
		}		
		else
			throw new UnsupportedOperationException("Unsupported ActionEvent Command.");
		
	}
	
	private void addQuiz(Quiz q) throws NullPointerException {
		
		if(q == null)
			throw new NullPointerException();
		
		((ObservableQuizCatalogus) quizCatalogusModel).add(q);
		
	}
	
	private void removeQuiz(Quiz q) throws NullPointerException {
		
		if(q == null)
			throw new NullPointerException();
		
		((ObservableQuizCatalogus) quizCatalogusModel).remove(q);
		
	}
	
	

}

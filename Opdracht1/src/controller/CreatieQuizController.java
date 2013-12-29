package controller;

import model.interfaces.IObservable;
import persistence.DataContext;
import persistence.enums.ContextType;
import view.CreatieQuizView;

/**
 * Singleton controller responsible for creating new Quizzes.
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131209-01 - refactor using {@link IRepositoryCreate}
 * @version 20131228-01 - added beginnings of link to model and view
 *
 */
public class CreatieQuizController {
	
	private CreatieQuizController instance = null;
	private DataContext dc;
	private ContextType contextType;
	private CreatieQuizView view;
	private IObservable quizCatalogusModel;
	private IObservable opdrachtCatalogusModel;
	
	private CreatieQuizController(ContextType contextType) {
		
		dc = new DataContext(contextType);
		this.quizCatalogusModel = OpstartController.getQuizCatalogus();
		this.opdrachtCatalogusModel = OpstartController.getOpdrachtCatalogus();
		this.view = new CreatieQuizView();
		
	}

	public CreatieQuizController getInstance(ContextType contextType) {
		
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

}

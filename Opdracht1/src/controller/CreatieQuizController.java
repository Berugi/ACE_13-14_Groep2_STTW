package controller;

import javax.swing.JFrame;

import model.ObservableQuizCatalogus;
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
 *
 */
public class CreatieQuizController {
	
	private CreatieQuizController instance = null;
	private DataContext dc;
	private ContextType contextType;
	private JFrame view;
	private IObservable model;
	
	private CreatieQuizController(IObservable observableQuizCatalogus, JFrame creatieQuizView, ContextType contextType) {
		
		dc = new DataContext(contextType);
		this.model = observableQuizCatalogus;
		this.view = creatieQuizView;
		
	}

	public CreatieQuizController getInstance(IObservable observableQuizCatalogus, JFrame creatieQuizView, ContextType contextType) {
		
		if(instance == null)
			instance = new CreatieQuizController(observableQuizCatalogus, creatieQuizView, contextType);
		return instance;
		
	}
	
	public void showView() {
		
		this.view.setVisible(true);
		
	}
	
	public void hideView() {
		
		this.view.setVisible(false);
		
	}

}

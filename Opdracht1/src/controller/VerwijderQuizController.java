package controller;

import java.util.HashSet;

import persistence.enums.ContextType;
import persistence.interfaces.IRepositoryDelete;
import model.Quiz;
import view.VerwijderQuizView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131209-01 - refactor using {@link IRepositoryDelete}
 * @version 20140112-01 - Tom Scheepers - Singleton + MVC
 *
 */
public class VerwijderQuizController implements IRepositoryDelete<Quiz>, ActionListener {
	
	private static VerwijderQuizView view;
	private static VerwijderQuizController instance=null;
	
	//getters & Setters
	
	public static VerwijderQuizView getView(){
		return view;
	}
	
	//Constructor
	private VerwijderQuizController() {
		this.view = new VerwijderQuizView();
		//view.setActionListener(this);
	}
	
	public static VerwijderQuizController getInstance(){
		if(instance == null)
			instance = new VerwijderQuizController();
		return instance;
	}

	public boolean delete(Quiz t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteSubset(HashSet<Quiz> subset) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

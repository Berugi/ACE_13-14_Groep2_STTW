package controller;

import java.util.HashSet;

import controller.interfaces.IRepositoryDelete;
import persistence.enums.ContextType;
import model.Quiz;

/**
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131209-01 - refactor using {@link IRepositoryDelete}
 *
 */
public class VerwijderQuizController implements IRepositoryDelete<Quiz> {
	
	public VerwijderQuizController(ContextType type) {
		// TODO Auto-generated constructor stub
	}

	public boolean delete(Quiz t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteSubset(HashSet<Quiz> subset) {
		// TODO Auto-generated method stub
		return false;
	}

}

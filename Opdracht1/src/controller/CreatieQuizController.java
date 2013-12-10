package controller;

import java.io.IOException;

import persistence.DataAccessHelperFactory;
import persistence.baseclasses.DataAccessHelper;
import persistence.enums.ContextType;
import persistence.interfaces.IRepositoryCreate;
import model.Quiz;

/**
 * 
 * @author Wim Ombelets
 * @version 20131201-01 - initial commit
 * @version 20131209-01 - refactor using {@link IRepositoryCreate}
 *
 */
public class CreatieQuizController implements IRepositoryCreate<Quiz> {
	
	private final DataAccessHelper daHelper;	
	
	public CreatieQuizController(ContextType contextType) {
		
		daHelper = DataAccessHelperFactory.getDataAccessHelper(contextType);
		
	}

	public void create(Quiz t) {
		
		if(daHelper != null) {
			
			daHelper
			
		}
		
	}
	
}

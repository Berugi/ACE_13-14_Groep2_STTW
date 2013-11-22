package controller;

import persistence.interfaces.IRepository;
import model.Quiz;
import controller.baseclasses.BaseController;
import controller.interfaces.IController;

/**
 * Singleton controller, die een aantal basismethodes vanuit IRepository<Quiz> implementeert.
 * 
 * @author Tom Vaes
 * @version 20131109-01 - initial version.
 * @version 20131122-02 - modification done by Wim Ombelets - extends base class to ensure Singleton, implements basic repository methods
 *
 */
public class QuizController extends BaseController implements IRepository<Quiz> {
	
	//IRepository interface method implementations
	
	public boolean write(Quiz... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public Quiz[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Quiz... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Quiz... objs) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
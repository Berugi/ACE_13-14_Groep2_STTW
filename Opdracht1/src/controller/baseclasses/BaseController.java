package controller.baseclasses;
import controller.interfaces.IController;

/**
 * 
 * Singleton base class from which all other controllers extend
 * 
 * @author Wim Ombelets
 * @version 20131122-01 initial commit
 * @param <T>
 *
 */
public class BaseController implements IController<BaseController> {

	private BaseController instance = null;
	
	protected BaseController() { }
	
	public BaseController getInstance() {
		if(instance == null)
			instance = new BaseController();
		return instance;
	}
	
}

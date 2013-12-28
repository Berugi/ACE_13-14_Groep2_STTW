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
@Deprecated
public class Controller implements IController<Controller> {

	private Controller instance = null;
	
	protected Controller() { }
	
	public Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
}

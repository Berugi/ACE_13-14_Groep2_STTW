package controller.interfaces;

import controller.baseclasses.BaseController;

/**
 * Interface for controllers that extend BaseController
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @param <T>
 */
public interface IController<T extends BaseController> {
	T getInstance();
}

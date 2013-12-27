package model.interfaces;

/**
 * Provides a mechanism for receiving push-based notifications.
 * 
 * @author Wim Ombelets
 * @version 20131227-01 - initial commit
 *
 */
public interface IObserver {

	void update(IObservable observable);
	
}

package model.interfaces;

/**
 * Defines a provider for push-based notification.
 * 
 * @author Wim Ombelets
 * @version 20131227-01 - initial commit
 *
 */
public interface IObservable {

	void addObserver(IObserver observer);
	void removeObserver(IObserver observer);
	//void notifyObservers(); -> needs to be implemented privately !!!
	
}

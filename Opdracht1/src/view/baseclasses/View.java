package view.baseclasses;

import model.interfaces.IObservable;
import model.interfaces.IObserver;

/**
 * An abstract observer View
 * 
 * @author Wim Ombelets
 * @version 20131229-01 - initial commit
 *
 */
public abstract class View implements IObserver {

	public abstract void update(IObservable observable);
	
}

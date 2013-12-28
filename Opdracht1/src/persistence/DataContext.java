package persistence;

import persistence.enums.ContextType;
import persistence.interfaces.IPersistenceStrategy;

/**
 * Represents a container for a persistence strategy
 * 
 * @author Tom Scheepers
 * @version 20131221-01 - initial commit
 * @version 20131228-01 - modified by Wim Ombelets - now uses PersistenceStrategyFactory to set the strategy.
 *
 */
public class DataContext {
	
	private IPersistenceStrategy dataStrategie = null;
	
	public IPersistenceStrategy getStrategy(){
		return this.dataStrategie;
	}
	
	public void setStrategy(IPersistenceStrategy st){
		this.dataStrategie = st;
	}
	
	/**
	 * De default constructor zal de persistence strategy uit de ini file halen
	 */
	public DataContext() {
		
		setStrategy(PersistenceStrategyFactory.createPersistenceStrategy());
		
	}
	
	/**
	 * Deze constructor zal de persistence strategy instellen op basis van een ContextType.
	 * 
	 * @param contextType
	 */
	public DataContext(ContextType contextType) {
		
		setStrategy(PersistenceStrategyFactory.createPersistenceStrategy(contextType));
		
	}

}

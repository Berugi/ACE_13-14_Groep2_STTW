package persistence;

import config.IniFileManager;
import persistence.enums.ContextType;
import persistence.interfaces.IPersistenceStrategy;


/**
 * Singleton factory class that returns a number of different persistence strategies.
 * 
 * @author Wim Ombelets
 * @version 20131228-01 - initial commit
 *
 */
public class PersistenceStrategyFactory {
	
	public static IPersistenceStrategy createPersistenceStrategy() {
		
		ContextType contextType = ContextType.valueOf(IniFileManager.getInstance().getProperty("persistencestrategy").toUpperCase());
		
		return createPersistenceStrategy(contextType);
		
	}
	
	public static IPersistenceStrategy createPersistenceStrategy(ContextType contextType) {
		
		switch(contextType) {
		case LOCALFS:
			return new LocalFSPersistenceStrategy();
		case MYSQL:
		default:
			return new LocalFSPersistenceStrategy();
		}
		
	}
	
}

package persistence;

import persistence.baseclasses.AbstractDataAccessHelper;
import persistence.enums.ContextType;

/**
 * Can generate DataAccessHelper objects per ContextType
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131123-01 - added comment
 */
public class DataAccessHelperFactory {
	
	public DataAccessHelperFactory() { }
	
	public static AbstractDataAccessHelper getDataAccessHelper(ContextType type) {
		
		switch(type) {
			case LocalFS:
				return new LocalFSDataAccessHelper();
			case MySQL:
				return new MySQLDataAccessHelper();
			default:
				return null; //unreachable code because ContextType is an enum
		}
		
	}
	
}

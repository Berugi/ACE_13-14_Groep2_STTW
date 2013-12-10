package persistence;

import persistence.baseclasses.DataAccessHelper;
import persistence.enums.ContextType;

/**
 * Can generate DataAccessHelper objects per ContextType
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131123-01 - added comment
 * @version 20131210-01 - further work on persistence
 */
public class DataAccessHelperFactory {
	
	//data members
	
	private String connectionString;
	
	//getters & setters
	
	public String getConnectionString() {
		
		return connectionString;
		
	}
	
	private void setConnectionString(String connectionString) {
		
		if(connectionString != null && !connectionString.isEmpty()) {
			this.connectionString = connectionString;
		}
		
	}
	
	public DataAccessHelperFactory(String connectionString) {
		
		setConnectionString(connectionString);
		
	}
	
	public DataAccessHelper getDataAccessHelper(ContextType type) throws IllegalArgumentException {
		
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

package persistence;

import persistence.baseclasses.DataAccessHelper;
import persistence.enums.ContextType;

/**
 * Concrete data access strategy aimed towards local file system access.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131210-01 - further work on persistence
 */
public class LocalFSDataAccessHelper extends DataAccessHelper {
	
	//constructors
	
	public LocalFSDataAccessHelper(ContextType contextType, String filePath) {
		super(contextType, filePath);
	}
	
	public LocalFSDataAccessHelper(String filePath) {
		super(ContextType.LocalFS);
		super.setConnectionString(filePath);
	}
	
	public LocalFSDataAccessHelper() {
		super(ContextType.LocalFS);
		
		//the default constructor should retrieve the default file path from the ini file
		//super.setConnectionString(blabla);
	}

}

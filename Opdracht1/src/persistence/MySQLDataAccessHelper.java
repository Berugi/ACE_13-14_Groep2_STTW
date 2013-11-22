package persistence;

import persistence.baseclasses.AbstractDataAccessHelper;

/**
 * Concrete data access strategy aimed towards MySQL database access.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 */
public class MySQLDataAccessHelper extends AbstractDataAccessHelper {

	//data members
	
	//getters & setters
	
	//constructors
	
	//IRepository interface method implementations
	
	public boolean write(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

}

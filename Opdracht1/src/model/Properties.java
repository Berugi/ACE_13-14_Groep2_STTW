package model;

import model.enums.DBType;

/**
 * Can read from and write to the start.ini file.
 * Important to know, is that this class does not use nor extend java.util.Properties.
 * 
 * @author Wim Ombelets
 * @version 20131124-01 - initial commit
 *
 */
public class Properties {
	
	//data members
	
	private DBProperties dbProperties;
	
	//getters & setters
	
	public DBProperties getDbProperties() {
		return dbProperties;
	}

	public void setDbProperties(DBProperties dbProperties) {
		this.dbProperties = dbProperties;
	}
	
	//constructors
	
	public Properties(DBProperties dbProperties) {
		
		if(dbProperties != null && !this.dbProperties.equals(dbProperties))
			this.dbProperties = dbProperties;
		
	}
	
}

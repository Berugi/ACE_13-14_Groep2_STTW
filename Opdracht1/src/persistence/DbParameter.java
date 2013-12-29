package persistence;

import persistence.enums.DbParamType;

/**
 * Defines a database query parameter by type and value.
 * 
 * @author Wim Ombelets
 * @version 20131210-01 - initial commit
 *
 */
public class DbParameter {

	//data members
	
	private DbParamType dbParamType;
	
	private String value;
	
	//getters & setters
	
	public DbParamType getDbParamType() {
		return dbParamType;
	}

	private void setDbParamType(DbParamType dbParamType) {
		this.dbParamType = dbParamType;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	//constructors
	
	public DbParameter(DbParamType dbParamType, String value) {
		
		setDbParamType(dbParamType);
		setValue(value);
		
	}

	//methods
	
	@Override
	public String toString() {
		return "DbParameter [dbParamType=" + getDbParamType() + ", value=" + getValue()	+ "]";
	}
	
}

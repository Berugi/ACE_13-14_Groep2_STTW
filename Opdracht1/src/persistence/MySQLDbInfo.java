package persistence;

import persistence.baseclasses.DbInfo;
import persistence.enums.DBType;

/**
 * Simple POJO that contains all relevant info regarding a MySQL database connection.
 * 
 * @author Wim Ombelets
 * @version 20131211-01 - initial commit
 *
 */
public class MySQLDbInfo extends DbInfo {

	//data members
	
	private DBType dbType;
	private String connector;
	
	//getters & setters
	
	public DBType getDbType() {
		return dbType;
	}

	public void setDbType(DBType dbType) {
		this.dbType = dbType;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}
	
	//constructors
	
	public MySQLDbInfo(String connector, String server, String port, String database, String username, String password) {
		
		setDbType(DBType.MYSQL);
		setConnector(connector);
		super.setServer(server);
		super.setPort(port);
		super.setDatabase(database);
		super.setUsername(username);
		super.setPassword(password);
		
	}
	
	//method overrides

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((connector == null) ? 0 : connector.hashCode());
		result = prime * result + ((dbType == null) ? 0 : dbType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof MySQLDbInfo)) {
			return false;
		}
		MySQLDbInfo other = (MySQLDbInfo) obj;
		if (connector == null) {
			if (other.connector != null) {
				return false;
			}
		} else if (!connector.equals(other.connector)) {
			return false;
		}
		if (dbType != other.dbType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MySQLDbInfo [dbType=" + dbType + ", connector=" + connector
				+ ", getServer()=" + getServer() + ", getPort()=" + getPort()
				+ ", getDatabase()=" + getDatabase() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + "]";
	}
	
}

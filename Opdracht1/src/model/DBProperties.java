package model;

import model.enums.DBType;

/**
 * Encapsulates all relevant database properties for use in connections.
 * 
 * @author Wim Ombelets
 * @version 20131124-01 - initial commit
 */
public class DBProperties {
	
	//data members

	private DBType type;
	
	private String connector;
	
	private String host;
	
	private int port;
	
	private String database;
	
	//getters & setters
	
	public DBType getType() {
		return type;
	}
	
	private void setType(DBType type) {
		if(type != null)
			this.type = type;
	}
	
	private void setType(String type) {
		if(type != null && !type.isEmpty()) {
			setType(DBType.valueOf(type.toUpperCase()));
		}
	}
	
	public String getConnector() {
		return connector;
	}
	
	private void setConnector(String connector) {
		if(connector == null || connector.isEmpty())
			throw new IllegalArgumentException("Connector cannot be null or empty.");
		else
			this.connector = connector;
	}
	
	public String getHost() {
		return host;
	}
	
	private void setHost(String host) {
		if(host == null || host.isEmpty())
			throw new IllegalArgumentException("Host cannot be null or empty.");
		else
			this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	private void setPort(int port) {
		this.port = port;
	}
	
	private void setPort(String port) {
		if(port == null || port.isEmpty())
			throw new IllegalArgumentException("Port cannot be null or empty.");
		try{
			int portAsInt = Integer.parseInt(port);
			setPort(portAsInt);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		if(database == null || database.isEmpty())
			throw new IllegalArgumentException("Database cannot be null or empty.");
		else
			this.database = database;
	}
	
	//constructors
	/**
	 * Creates an instance of DBProperties using all String arguments.
	 * 
	 * @param dbType
	 * @param connector
	 * @param host
	 * @param port
	 * @param database
	 */
	public DBProperties(String dbType, String connector, String host, String port, String database) {
		setType(dbType);
		setConnector(connector);
		setHost(host);
		setPort(port);
		setDatabase(database);
	}
	
	public DBProperties() {}
	
	/**
	 * Creates an instance of DBProperties.
	 * 
	 * @param type
	 * @param connector
	 * @param host
	 * @param port
	 * @param database
	 */
	public DBProperties(DBType type, String connector, String host, int port, String database) {
		setType(type);
		setConnector(connector);
		setHost(host);
		setPort(port);
		setDatabase(database);
	}
	
	//overrides

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connector == null) ? 0 : connector.hashCode());
		result = prime * result
				+ ((database == null) ? 0 : database.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + port;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DBProperties)) {
			return false;
		}
		DBProperties other = (DBProperties) obj;
		if (connector == null) {
			if (other.connector != null) {
				return false;
			}
		} else if (!connector.equals(other.connector)) {
			return false;
		}
		if (database == null) {
			if (other.database != null) {
				return false;
			}
		} else if (!database.equals(other.database)) {
			return false;
		}
		if (host == null) {
			if (other.host != null) {
				return false;
			}
		} else if (!host.equals(other.host)) {
			return false;
		}
		if (port != other.port) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DBProperties [getType()=" + getType() + ", getConnector()="
				+ getConnector() + ", getHost()=" + getHost() + ", getPort()="
				+ getPort() + ", getDatabase()=" + getDatabase() + "]";
	}
	
	
	
}
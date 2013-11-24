package model;

import model.enums.DBType;

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
	
	public void setType(DBType type) {
		this.type = type;
	}
	
	public String getConnector() {
		return connector;
	}
	
	public void setConnector(String connector) {
		this.connector = connector;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	//constructors
	
	public DBProperties() {
		// TODO Auto-generated constructor stub
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
	
}
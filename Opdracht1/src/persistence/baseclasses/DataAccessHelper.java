package persistence.baseclasses;

import java.io.Closeable;
import java.io.IOException;

import persistence.enums.ContextType;

/**
 * This is a base class that all other DataAccessHelper classes extend from
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 * @version 20131210-01 - added ContextType and constructor
 *
 */
public class DataAccessHelper implements Closeable {

	//data members
	
	private String connectionString;
	
	private ContextType contextType;

	//getters & setters
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) throws IllegalArgumentException {
		if(connectionString != null && !connectionString.isEmpty()) {
			this.connectionString = connectionString;
		}
		else throw new IllegalArgumentException("ConnectionString cannot be null or empty.");
	}
	
	public ContextType getContextType() {
		return contextType;
	}

	private void setContextType(ContextType contextType) {
		this.contextType = contextType;
	}
	
	//constructors
	
	public DataAccessHelper(ContextType contextType, String connectionStringOrFilePath) {
		
		setContextType(contextType);
		setConnectionString(connectionStringOrFilePath);
		
	}
	
	public DataAccessHelper(ContextType contextType) {
		setContextType(contextType);
	}
	
	//methods

	@Override
	public String toString() {
		return "DataAccessHelper [connectionString=" + connectionString
				+ ", contextType=" + contextType + "]";
	}

	public void close() throws IOException {
		try {			
			this.close();
		}
		catch(IOException e) {
			throw e;
		}
	}
	
}

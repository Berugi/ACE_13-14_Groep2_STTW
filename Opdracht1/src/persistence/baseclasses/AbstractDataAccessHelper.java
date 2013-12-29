package persistence.baseclasses;

import java.io.Closeable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import persistence.LocalFSPersistenceStrategy;
import persistence.MySQLPersistenceStrategy;
import persistence.enums.ContextType;
import persistence.interfaces.IPersistenceStrategy;

/**
 * This is a base class that all other DataAccessHelper classes extend from
 * 
 * @author Wim Ombelets
 * @version 20131209-01 - initial commit
 * @version 20131210-01 - added ContextType and constructor
 *
 */
public abstract class AbstractDataAccessHelper<T> implements Closeable {
	
	private IPersistenceStrategy persistenceStrategy;
	
	private void setPersistenceStrategy(ContextType contextType) {
		
		switch(contextType) {
		case LOCALFS:
			this.persistenceStrategy = new LocalFSPersistenceStrategy();
			break;
		case MYSQL:
			this.persistenceStrategy = new MySQLPersistenceStrategy();
			break;
		}
		
	}
	
	public AbstractDataAccessHelper(ContextType contextType) {
		setPersistenceStrategy(contextType);
	}
	
	@SuppressWarnings("unchecked")
	public T read(T id) {
		return (T) persistenceStrategy.readByID(id);
	}
	
//	//data members
//	
//	private String connectionString;
//	
//	private ContextType contextType;
//
//	//getters & setters
//	
//	public String getConnectionString() {
//		return connectionString;
//	}
//
//	public void setConnectionString(String connectionString) throws IllegalArgumentException {
//		if(connectionString != null && !connectionString.isEmpty()) {
//			this.connectionString = connectionString;
//		}
//		else throw new IllegalArgumentException("ConnectionString cannot be null or empty.");
//	}
//	
//	public ContextType getContextType() {
//		return contextType;
//	}
//
//	private void setContextType(ContextType contextType) {
//		this.contextType = contextType;
//	}
//	
//	//constructors
//	
//	public DataAccessHelper(ContextType contextType, String connectionStringOrFilePath) {
//		
//		setContextType(contextType);
//		setConnectionString(connectionStringOrFilePath);
//		
//	}
//	
//	public DataAccessHelper(ContextType contextType) {
//		setContextType(contextType);
//	}
//	
//	//methods
//
//	@Override
//	public String toString() {
//		return "DataAccessHelper [connectionString=" + connectionString
//				+ ", contextType=" + contextType + "]";
//	}
//
//	public void close() throws IOException {
//		try {			
//			this.close();
//		}
//		catch(IOException e) {
//			throw e;
//		}
//	}
//	
//	/**
//	 * Executes the SQL statement in this PreparedStatement object, which may be any kind of SQL statement.
//	 * 
//	 * @param p
//	 * @return boolean
//	 */
//	private boolean execute(PreparedStatement p) {
//		
//		try {
//			
//			return p.execute();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
//	
//	/**
//	 * Executes the SQL statement in this PreparedStatement object, 
//	 * which must be an SQL INSERT, UPDATE or DELETE statement; 
//	 * or an SQL statement that returns nothing, such as a DDL statement.
//	 * 
//	 * @param p
//	 * @return int (Number of affected rows)
//	 */
//	private int executeUpdate(PreparedStatement p) {
//		
//		try {
//			
//			return p.executeUpdate();
//			
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		
//		return 0;
//	}
//	
//	/**
//	 * Executes the SQL query in this PreparedStatement object and 
//	 * returns the ResultSet object generated by the query.
//	 * 
//	 * @param p
//	 * @return Resultset
//	 */
//	private ResultSet executeQuery(PreparedStatement p) {
//		
//		try {
//			
//			return p.executeQuery();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
}

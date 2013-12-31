package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.IniFileManager;
import persistence.enums.DbParamType;
import persistence.interfaces.IPersistenceStrategy;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MySQLPersistenceStrategy implements IPersistenceStrategy {
	
	//data members
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";	
	private MySQLDbInfo db;
	private Connection conn;
	
	//getters & setters
	
	public MySQLDbInfo getDb() {
		return db;
	}

	public void setDb(MySQLDbInfo db) {
		this.db = db;
	}
	
	public String getConnectionString() {
		if(db == null)
			return null;
		return "jdbc:mysql://" + db.getServer() + ":" + db.getPort() + "/" + db.getDatabase();
	}
	
	//constructors
	
	public MySQLPersistenceStrategy() {
		//uitlezen van de MySQL database info in de ini file
		setDb(IniFileManager.getInstance().getMySQLDbInfoProperties());
	}
	
	//methods

	/**
	 * Executes a parameterized SELECT statement.
	 * 
	 * @param statement
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet select(PreparedStatement statement) throws SQLException {
		try {
			conn = DriverManager.getConnection(getConnectionString(), db.getUsername(), db.getPassword());
			return statement.executeQuery();
		}
		catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * Executes a parameterized INSERT statement.
	 * 
	 * @param statement
	 * @throws SQLException
	 */
	public void insert(PreparedStatement statement) throws SQLException {
		try {
			conn = DriverManager.getConnection(getConnectionString(), db.getUsername(), db.getPassword());
			statement.execute();
		}
		catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * Executes a parameterized UPDATE statement.
	 * 
	 * @param statement
	 * @return int (number of affected rows)
	 * @throws SQLException
	 */
	public int update(PreparedStatement statement) throws SQLException {
		try {
			conn = DriverManager.getConnection(getConnectionString(), db.getUsername(), db.getPassword());
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	/**
	 * Executes a parameterized DELETE statement.
	 * 
	 * @param statement
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delete(PreparedStatement statement) throws SQLException {
		try {
			conn = DriverManager.getConnection(getConnectionString(), db.getUsername(), db.getPassword());
			return statement.execute();
		}
		catch(SQLException e) {
			throw e;
		}
	}

	/**
	 * Creates a parameterized SQL statement.
	 * 
	 * @param statement
	 * @param paramsList
	 * @return PreparedStatement
	 * @throws IllegalArgumentException
	 */
	public PreparedStatement createPreparedStatement(String statement, ArrayList<DbParameter> paramsList) throws IllegalArgumentException {
		
		PreparedStatement pS = null;
		
		if(conn != null) {
			
			if((statement != null && !statement.isEmpty()) && (paramsList != null && paramsList.size() > 0)) {
				
				try {
					
					pS = (PreparedStatement) conn.prepareStatement(statement);
					DbParameter dbParam = null;
					
					for (int i=0; i<paramsList.size(); i++) {
						
						dbParam = paramsList.get(i);
						
						switch(dbParam.getDbParamType()) {
						case Int:
							pS.setInt(i, Integer.parseInt(dbParam.getValue()));
							break;
						case Double:
							pS.setDouble(i, Double.parseDouble(dbParam.getValue()));
							break;
						case String:
							pS.setString(i, dbParam.getValue());
							break;
						}
					}
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			else throw new IllegalArgumentException("Neither statement nor list of parameters can be null or empty.");
			
		}
		
		return pS;
	}
	
}

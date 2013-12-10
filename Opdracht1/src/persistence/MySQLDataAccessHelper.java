package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import persistence.baseclasses.DataAccessHelper;
import persistence.enums.ContextType;

/**
 * Concrete data access strategy aimed towards
 * MySQL database access using parameterized queries.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131210-01 - further work on persistence
 */
public class MySQLDataAccessHelper extends DataAccessHelper {
	
	//data members
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private String serverName;
	
	private String dbName;
	
	private String connectionString;
	
	private String userName;
	
	private String password;
	
	private Connection conn;
	
	//getters & setters
	
	public String getServerName() {
		return serverName;
	}

	private void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String getDBName() {
		return dbName;
	}
	
	private void setDBName(String dbName) {
		this.dbName = dbName;
	}
	
	public String getConnectionString() {
		return connectionString;
	}
	
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	public void setConnectionString(String serverName, String dbName) throws IllegalArgumentException {
		
		if(serverName != null && !serverName.isEmpty() && dbName != null && !dbName.isEmpty()) {
			
			setServerName(serverName);
			setDBName(dbName);
			setConnectionString("jdbc:mysql://" + getServerName() + "/" + getDBName());
			
		}
		else throw new IllegalArgumentException("ServerName and/or Database Name cannot be null or empty.");
		
	}
	
	private String getUserName() {
		return this.userName;
	}
	
	private void setUserName(String userName) throws IllegalArgumentException {
		if(userName != null && !userName.isEmpty()) {
			this.userName = userName;
		}
		else throw new IllegalArgumentException("UserName cannot be null or empty.");
	}
	
	private String getPassword() {
		return this.password;
	}
	
	private void setPassword(String password) throws IllegalArgumentException {
		if(password != null && !password.isEmpty()) {
			this.password = password;
		}
		else throw new IllegalArgumentException("Password cannot be null or empty.");
	}
	
	public Connection getConn() {
		return conn;
	}

	private void setConn(Connection conn) {
		this.conn = conn;
	}
	
	//constructors
	
	public MySQLDataAccessHelper(String connectionString) {
		super(ContextType.MySQL, connectionString);
	}
	
	public MySQLDataAccessHelper(String serverName, String dbName) {
		
		super(ContextType.MySQL);
		this.setConnectionString(serverName, dbName);
	}
	
	public MySQLDataAccessHelper() {
		
		//default constructor should read from ini file for serverName, dbName, userName and passWord
		super(ContextType.MySQL);
		
	}
	
	//methods
	
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
	
	public ResultSet executePreparedStatement(PreparedStatement p) {
		
		ResultSet rs = null;
		
		if(p != null) {
			
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				setConn(DriverManager.getConnection(getConnectionString(), getUserName(), getPassword()));
				rs = p.executeQuery();
				
			}
			catch (SQLException se) {
				se.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		
		return rs;
		
	}

}

package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import config.IniFileManager;
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
		setDb(IniFileManager.getInstance().getMySQLDbInfoProperties());
	}
	
	//methods

	public Object read(String statement, ArrayList<DbParameter> paramsList) {
		try {
			conn = DriverManager.getConnection(getConnectionString(), db.getUsername(), db.getPassword());
			PreparedStatement pS = createPreparedStatement(statement, paramsList);
			ResultSet rs = pS.executeQuery();
			return rs.getObject(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Object create(Object t) throws NotImplementedException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object update(Object t) throws NotImplementedException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object t) throws NotImplementedException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Creates a parameterized SQL statement.
	 * 
	 * @param statement
	 * @param paramsList
	 * @return PreparedStatement
	 * @throws IllegalArgumentException
	 */
	private PreparedStatement createPreparedStatement(String statement, ArrayList<DbParameter> paramsList) throws IllegalArgumentException {
		
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
	
	private ResultSet executePreparedStatement(PreparedStatement p) {
		
		ResultSet rs = null;
		
		if(p != null) {
			
			try {
				
				Class.forName(JDBC_DRIVER).newInstance();
				this.conn = DriverManager.getConnection(this.getConnectionString(), db.getUsername(), db.getPassword());
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

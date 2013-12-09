package persistence;

import persistence.baseclasses.DataAccessHelper;

/**
 * Concrete data access strategy aimed towards MySQL database access.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 */
public class MySQLDataAccessHelper extends DataAccessHelper {
	
	//data members
	
	private String serverName;
	
	private String dbName;
	
	private String connectionString;
	
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
	
	private void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	private void setConnectionString(String serverName, String dbName) throws IllegalArgumentException {
		if(serverName != null && !serverName.isEmpty() && dbName != null && !dbName.isEmpty()) {
			setServerName(serverName);
			setDBName(dbName);
			setConnectionString("jdbc:mysql://" + getServerName() + "/" + getDBName());
		}
		else throw new IllegalArgumentException("ServerName and/or Database Name cannot be null or empty.");
	}
	

//	String DB_URL = "jdbc:mysql://localhost/quiz";
//	 try{
//		 Connection con  = DriverManager.getConnection(DB_URL, "root","WolleWolle2");
//		 Statement st = con.createStatement();
//		 ResultSet res = st.executeQuery("select * from quiz.quiz");
//		 while (res.next()){
//			 System.out.println(res.getString(2));
//		 }			 
//	 }
//	 catch(SQLException ex){System.out.println("Aiaiai "+ex.getMessage());}

}

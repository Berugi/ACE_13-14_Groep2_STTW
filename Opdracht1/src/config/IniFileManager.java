package config;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import persistence.MySQLDbInfo;

/**
 * This singleton class manages the ini file and must be used in a try-with-resources block.
 * 
 * @author Wim Ombelets
 * @version 20131211-01 - initial commit
 *
 */
public class IniFileManager implements Closeable {

	//data members
	
	private static IniFileManager instance = null;
	
	private Properties props;	
	
	//constructors
	
	private IniFileManager() {		
		initProps();
	}
	
	//methods
	
	public static IniFileManager getInstance() {
		if(instance == null)
			instance = new IniFileManager();
		return instance;
	}
	
	private void initProps() {
		this.props = new Properties();
		try {
			
			this.props.load(new FileInputStream("start.ini"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public void setProperty(String key, String value) throws IllegalArgumentException {
		
		if(key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
			try {
				props.setProperty(key, value);
			}
			catch(IllegalArgumentException e) {
				throw e;
			}
		}
	}
	
	public MySQLDbInfo getMySQLDbInfoProperties() {		
		
		String dbType = props.getProperty("dbtype");
		if(dbType != null && !dbType.isEmpty() && dbType == "mysql")
			return new MySQLDbInfo(
					getProperty("dbconnector"), 
					getProperty("dbserver"), 
					getProperty("dbport"), 
					getProperty("dbdatabase"), 
					getProperty("dbusername"), 
					getProperty("dbpassword")
			);		
		else return null;
	}
	
	public void setMySQLDbInfoProperties(MySQLDbInfo db) {
		setProperty("dbconnector", db.getConnector());
		setProperty("dbserver", db.getServer());
		setProperty("dbport", db.getPort());
		setProperty("dbdatabase", db.getDatabase());
		setProperty("dbusername", db.getUsername());
		setProperty("dbpassword", db.getPassword());
	}
	
	public void close() throws IOException {
		
		this.close();
		
	}

}

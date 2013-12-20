package config;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	private static final String fileName = "bin/config/start.ini";
	private Properties props;	
	
	//constructors
	
	private IniFileManager() {		
		loadProperties();
	}
	
	//methods
	
	public static IniFileManager getInstance() {
		if(instance == null)
			instance = new IniFileManager();
		return instance;
	}
	
	private void loadProperties() {
		this.props = new Properties();
		try {
			FileInputStream input = new FileInputStream(fileName);
			this.props.load(input);
			input.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void saveProperties() {
		try {
			FileOutputStream output = new FileOutputStream(fileName);
			this.props.store(output, null);
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
				props.put(key, value);
				saveProperties();
			}
			catch(IllegalArgumentException e) {
				throw e;
			}
		}
	}
	
	public MySQLDbInfo getMySQLDbInfoProperties() {		
		
		String dbType = props.getProperty("dbtype");
		System.out.println(dbType);
		if (dbType !=null && !dbType.isEmpty() && dbType.matches("mysql"))
			return new MySQLDbInfo(
					props.getProperty("dbconnector"), 
					props.getProperty("dbserver"), 
					props.getProperty("dbport"), 
					props.getProperty("dbdatabase"), 
					props.getProperty("dbusername"), 
					props.getProperty("dbpassword")
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
		saveProperties();
	}
	
	public void close() throws IOException {
		
		this.close();
		
	}

}

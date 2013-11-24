package model;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import utils.SimpleIniFile;

/**
 * Can read from and write to the start.ini file.
 * Important to know, is that this class does not use nor extend java.util.Properties.
 * 
 * @author Wim Ombelets
 * @version 20131124-01 - initial commit
 * @version 20131124-02 - added functionality to read ini file
 */
public class Properties {
	
	//data members

	private Path startIniPath;
	
	private DBProperties dbProperties;
	
	//getters & setters
	
	public Path getStartIniPath() {
		return startIniPath;
	}

	private void setStartIniPath(Path startIniPath) {
		this.startIniPath = startIniPath;
	}
	
	private void setStartIniPath(String startIniPath) {
		if(startIniPath == null || startIniPath.isEmpty())
			throw new IllegalArgumentException("Path to start.ini cannot be null or empty");
	}
	
	public void setStartIniPath() {
		this.startIniPath = FileSystems.getDefault().getPath("config", "start.ini");
	}
	
	public DBProperties getDbProperties() {
		return dbProperties;
	}

	private void setDbProperties(DBProperties dbProperties) {
		this.dbProperties = dbProperties;
	}
	
	//constructors
	
	/**
	 * Creates a new instance of Properties based on a .ini file that it reads from.
	 * @param pathToIniFile
	 */
	public Properties(String pathToIniFile) {
		setDbProperties(SimpleIniFile.deserialize(pathToIniFile));
	}
	
	public Properties(){
		
	}
	
	//overrides
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dbProperties == null) ? 0 : dbProperties.hashCode());
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
		if (!(obj instanceof Properties)) {
			return false;
		}
		Properties other = (Properties) obj;
		if (dbProperties == null) {
			if (other.dbProperties != null) {
				return false;
			}
		} else if (!dbProperties.equals(other.dbProperties)) {
			return false;
		}
		return true;
	}
	
}

package persistence;

import java.nio.file.Path;
import java.nio.file.Paths;

import persistence.baseclasses.DataAccessHelper;

/**
 * Concrete data access strategy aimed towards local file system access.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 */
public class LocalFSDataAccessHelper extends DataAccessHelper {

	//data members
	
	private Path filePath;
	
	//getters & setters
	
	public Path getFilePath() {
		return this.filePath;
	}
	
	private void setFilePath(String filePath) {
		if(filePath != null && !filePath.isEmpty())
			this.filePath = Paths.get(filePath);
		else
			throw new IllegalArgumentException("File path cannot be null or empty.");
	}
	
	//constructors
	public LocalFSDataAccessHelper() {
		//ik zou anraden om hier iets met de temp dir te doen of zo,
		//maar het moet werken op zowel Windows als Linux. (Wim)
	}
	
	public LocalFSDataAccessHelper(String filePath) {
		setFilePath(filePath);
	}
	
	//IRepository method implementations
	public boolean write(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object... objs) {
		// TODO Auto-generated method stub
		return false;
	}

}

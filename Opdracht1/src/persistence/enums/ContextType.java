package persistence.enums;

/**
 * The types of persistence contexts.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 *
 */
public enum ContextType {
	Local, //data will be persisted to the local file system
	Database, //data will be persisted to database
	DatabaseAndLocal //data will be persisted to both database and local file system
}

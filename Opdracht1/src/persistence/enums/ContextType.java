package persistence.enums;

/**
 * The types of persistence contexts.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 *
 */
public enum ContextType {
	LOCALFS, //data will be persisted to the local file system
	MYSQL, //data will be persisted to database
}

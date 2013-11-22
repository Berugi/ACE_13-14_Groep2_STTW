package persistence.enums;

/**
 * The types of persistence contexts.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 *
 */
public enum ContextType {
	LocalFS, //data will be persisted to the local file system
	MySQL, //data will be persisted to database
}

package persistence.enums;

/**
 * The types of persistence contexts.
 * 
 * @author Wim Ombelets
 * @version 20131122-01 - initial commit
 * @version 20131221-01 - description added - Tom Scheepers
 *
 */
public enum ContextType {
	LOCALFS("LocalFSPersistenceStrategy"), //data will be persisted to the local file system
	MYSQL("MySQLPersistenceStategy"); //data will be persisted to database
	
	private final String description;
	
	public String getDescription()
	{
		return description;
	}

	private ContextType(String description)
	{
		this.description = description;
	}
	
	@Override
    public String toString() {
        return description;
    }
}

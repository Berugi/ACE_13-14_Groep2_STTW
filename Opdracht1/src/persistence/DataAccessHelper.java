package persistence;

import java.io.IOException;

import persistence.baseclasses.AbstractDataAccessHelper;
import persistence.enums.ContextType;

public class DataAccessHelper<T> extends AbstractDataAccessHelper<T> {

	public DataAccessHelper(ContextType contextType) {
		super(contextType);
		// TODO Auto-generated constructor stub
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}

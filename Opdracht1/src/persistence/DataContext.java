package persistence;

import persistence.interfaces.IPersistenceStrategy;;

public class DataContext {
	
	private IPersistenceStrategy dataStrategie = null;
	
	public IPersistenceStrategy getStrategy(){
		return this.dataStrategie;
	}
	
	public void setStrategy(IPersistenceStrategy st){
		this.dataStrategie = st;
	}

}

package model;

import java.util.ArrayList;

public abstract class Catalogus implements Comparable<Catalogus>, Cloneable, Iterable<Catalogus>{
	   
    public ArrayList<Object> catalogus;
   
    //getters and setters
    public ArrayList<Object> getCatalogus() {
		return catalogus;
	}
	public void setCatalogus(ArrayList<Object> catalogus) {
		this.catalogus = catalogus;
	}

	//methods
    public Boolean add(Object item) {
		if(!this.catalogus.contains(item)) {
			this.catalogus.add(item);
			return true;
		}
		return false;
	}
	
	public Boolean remove(Object item) {
		if(this.catalogus.contains(item)) {
			this.catalogus.remove(item);
			return true;
		}
		return false;
	}
   
	//abstracte methods

    abstract Object change(int index);
}

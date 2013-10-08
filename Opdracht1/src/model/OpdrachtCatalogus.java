package model;

import java.util.*;

public class OpdrachtCatalogus extends Catalogus{
	
	//data members
	//Nu in abstracte klasse

	//getters & setters
	//Nu in abstracte klasse
	
	//constructors
	
	public OpdrachtCatalogus() {
		this.catalogus = new ArrayList<Object>();
	}
	
	public OpdrachtCatalogus(ArrayList<Object> catalogus) {
		this.setCatalogus(catalogus);
	}
	
	//methods
	@Override
	Opdracht change(int index) {
		return  (Quiz) catalogus.get(index);
	}
	
	public Boolean addOpdracht(Opdracht o) {
		if(!this.catalogus.contains(o)) {
			this.catalogus.add(o);
			return true;
		}
		return false;
	}
	
	public Boolean removeOpdracht(Opdracht o) {
		if(this.catalogus.contains(o)) {
			this.catalogus.remove(o);
			return true;
		}
		return false;
	}
	
	public Opdracht getOpdracht(Opdracht o) {
		if(this.catalogus.contains(o))
			return o;
		else
			return null;
	}
}

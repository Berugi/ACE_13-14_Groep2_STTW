package model;

import java.util.*;

public class OpdrachtCatalogus {
	
	//data members
	
	private ArrayList<Opdracht> catalogus;
	
	//getters & setters
	
	protected ArrayList<Opdracht> getCatalogus() {
		return this.catalogus;
	}

	private void setCatalogus(ArrayList<Opdracht> catalogus) {
		this.catalogus = new ArrayList<Opdracht>(catalogus);
	}
	
	//constructors
	
	public OpdrachtCatalogus() {
		this.catalogus = new ArrayList<Opdracht>();
	}
	
	public OpdrachtCatalogus(ArrayList<Opdracht> catalogus) {
		setCatalogus(catalogus);
	}
	
	//methods
	
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

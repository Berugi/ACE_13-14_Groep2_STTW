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
	
	public OpdrachtCatalogus(ArrayList<Opdracht> catalogus) {
		this.catalogus = new ArrayList<Object>(catalogus);
	}
	
	//methods
	@Override
	public Opdracht change(int index) {
		return  (Opdracht) catalogus.get(index);
	}
	
	
	public Opdracht getOpdracht(Opdracht o) {
		if(this.catalogus.contains(o))
			return o;
		else
			return null;
	}

	public int compareTo(Catalogus o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<Catalogus> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

package model;

import java.util.ArrayList;
import model.baseclasses.*;
import DatumV1.Datum;
import model.enums.Leraar;


public class OpdrachtCatalogus extends Catalogus{
	
	//data members
	//Nu in abstracte klasse

	//getters & setters
	//Nu in abstracte klasse
	
	//constructors
	
	public OpdrachtCatalogus() {
		this.catalogus=new ArrayList<Object>();
		this.registratiedatum = new Datum();
		this.auteur = Leraar.TBA;
	}
	
	public OpdrachtCatalogus(ArrayList<Opdracht> catalogus, Datum registratiedatum, Leraar auteur) {
		this.catalogus = new ArrayList<Object>(catalogus);
		this.registratiedatum = registratiedatum;
		this.auteur = auteur;
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

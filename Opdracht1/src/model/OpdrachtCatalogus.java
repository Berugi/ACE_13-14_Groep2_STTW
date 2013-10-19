package model;

import java.util.ArrayList;
import model.baseclasses.*;
import DatumV1.Datum;
import model.enums.Leraar;
import java.util.Iterator;


public class OpdrachtCatalogus extends Catalogus{
	
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
	
	public boolean Opdracht_toevoegen(OpdrachtBase opdracht){
		try{
			this.add(opdracht);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * 
	 * Opdracht volledig verwijderen
	 * Constraint: Opdracht mag enkel verwijderd worden als deze nog niet werd uitgevoerd door een leerling
	 * 
	 * @param opdracht
	 * @return true als het verwijderen gelukt is
	 */
	
	public boolean Opdracht_verwijderen(OpdrachtBase opdracht){
		try{
			this.remove(opdracht);
			opdracht = null;
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
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
		
		return null;
	}
}

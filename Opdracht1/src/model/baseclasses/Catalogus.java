package model.baseclasses;

import java.util.ArrayList;
import DatumV1.Datum;
import model.enums.Leraar;

public abstract class Catalogus implements Comparable<Catalogus>, Cloneable, Iterable<Catalogus>{
	   
    public ArrayList<Object> catalogus;
    public Datum registratiedatum;
    public Leraar auteur;
   
	//getters and setters
    
    public Datum getRegistratiedatum() {
		return registratiedatum;
	}
    
	public void setRegistratiedatum(Datum registratiedatum) {
		this.registratiedatum = registratiedatum;
	}
	
	public Leraar getAuteur() {
		return auteur;
	}
	
	public void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}

    public ArrayList<Object> getCatalogus() {
		return catalogus;
	}
    
	public void setCatalogus(ArrayList<Object> catalogus) {
		this.catalogus = catalogus;
	}

	//methods
    public Boolean add(Object item) {
        if (this.catalogus.contains(item))
            return false;
        this.catalogus.add(item);
        return true;
    }
	
	public Boolean remove(Object item) {
		if(this.catalogus.contains(item)) {
			this.catalogus.remove(item);
			return true;
		}
		return false;
	}
   
	//abstract methods

    abstract Object change(int index);
}

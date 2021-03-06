package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.io.*;

import model.baseclasses.*;
import utils.Datum;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;

import java.util.Iterator;

/**
 * 
 * @author 
 * 
 * @version 20131008-01 - Initial version
 * @version 20131021-01 - Sander Van der Borght removed registratiedatum, auteur, check if this exists in opdracht
 * @version 20131226-01 - Tom Vaes - corrected constructor that uses text file.
 * Bevat OpdrachtCatalogues informatie
 */
public class OpdrachtCatalogus implements Comparable<Catalogus>, Cloneable, Iterable<Opdracht>{
	
	private ArrayList<Opdracht> opdrachten;
	//constructors
	
	public OpdrachtCatalogus() {
		this.opdrachten = new ArrayList<Opdracht>();
		//this.registratiedatum = new Datum();
		//this.auteur = Leraar.TBA;
	}
	
	/**
	 * Constructor that uses a txt file
	 * @param bestandsnaam
	 * @throws IOException
	 */
	
	public OpdrachtCatalogus(String bestandsnaam) throws IOException{
		this();
		txtEncoderDecoder decoder = new txtEncoderDecoder(bestandsnaam);
		
		Hashtable<String,ArrayList<String>> opdrachtTabel = decoder.decode();
						
		for(int j = 0; j<opdrachtTabel.get("auteur").size();j++){
			
			this.opdrachten.add(
					new Opdracht(
							opdrachtTabel.get("vraag").get(j), 
							opdrachtTabel.get("juisteAntwoord").get(j) , 
							Integer.parseInt(opdrachtTabel.get("maxAantalPogingen").get(j)),
							Integer.parseInt(opdrachtTabel.get("maxAntwoordTijd").get(j)), 
							Leraar.valueOf(opdrachtTabel.get("auteur").get(j).toUpperCase()), 
							OpdrachtCategorie.valueOf(opdrachtTabel.get("opdrachtCategorie").get(j).toUpperCase()), 
							new Datum(opdrachtTabel.get("datumRegistratie").get(j)), 
							opdrachtTabel.get("antwoordHints").get(j))
			);
		}
		
	}
	
	//getters en setters
	public ArrayList<Opdracht> getCatalogus()
	{
		return this.opdrachten;
	}
	//methods
	
	public boolean add(Opdracht newOpdracht) throws IllegalArgumentException{
		
		Boolean result = true;
		
		if (newOpdracht.getDatumRegistratie() == null || newOpdracht.getAuteur() == null || newOpdracht.getAuteur() == Leraar.TBA)
			throw new IllegalArgumentException("Auteur en/of registratie datum van de opdracht moeten ingevuld zijn");
		
		for(Opdracht existingOpdracht : this.opdrachten)
		{
			if (existingOpdracht.equals(newOpdracht))
				result = false;
		}
		
		if(result) {
			this.opdrachten.add(newOpdracht);
			return result;
		}
		
		return result;
	}
	
	/**
	 * 
	 * Opdracht volledig verwijderen
	 * Constraint: Opdracht mag enkel verwijderd worden als deze nog niet werd uitgevoerd door een leerling
	 * @version 20131020-01 toevoegen constraint Sander Van der Borght
	 * 
	 * @param opdracht
	 * @return true als het verwijderen gelukt is
	 */
	
	public boolean remove(Opdracht opdracht){
		try{
			if (opdracht.getQuizOpdrachten().size()==0){
				if(opdracht.MagGewijzigdWorden()){
					this.opdrachten.remove(opdracht);
					opdracht = null;
					return true;
				}
			}
			return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public Boolean wegschrijvenAlsTekstbestand(String bestand) throws Exception{
		try{
			File file = new File(bestand);
			PrintWriter writer = new PrintWriter(file);
			
			//write headers
			StringBuilder regel = new StringBuilder();
			regel.append("id"+";");
			regel.append("vraag"+";");
			regel.append("juisteAntwoord"+";");
			regel.append("maxAantalPogingen"+";");
			regel.append("maxAntwoordTijd"+";");
			regel.append("auteur"+";");
			regel.append("opdrachtCategorie"+";");
			regel.append("datumRegistratie"+";");
			regel.append("antwoordHints"+";");
			writer.println(regel.toString());
			
			
			for (Opdracht opdracht: opdrachten)
			{
				regel = new StringBuilder();
				regel.append(opdrachten.indexOf(opdracht)+";");
				regel.append(opdracht.getVraag()+";");
				regel.append(opdracht.getJuisteAntwoord()+";");
				regel.append(opdracht.getMaxAantalPogingen()+";");
				regel.append(opdracht.getMaxAntwoordTijd()+";");
				regel.append(opdracht.getAuteur()+";");
				regel.append(opdracht.getOpdrachtCategorie()+";");
				regel.append(opdracht.getDatumRegistratie().toString()+";");
				regel.append(opdracht.getAntwoordHints()+";");
				//nog geen quizopdrachten
				writer.println(regel.toString());
			}
			if (writer !=null)
				writer.close();
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public Opdracht change(int index) {
		return  this.opdrachten.get(index);
	}

	public int compareTo(Catalogus o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<Opdracht> iterator() {
		
		return null;
	}
	
	public int size() {
		return this.opdrachten.size();
	}
	
	/*
	public Object getWaarde(int rij, int kol){
		Object terug = null;
		String[] lijst = new String[size()];
		lijst = opdrachten.toArray(lijst);
		if (rij < size()){
			if (kol < 9){
				terug = lijst[rij].;
			}
		}
		return terug;
	}
	*/
}

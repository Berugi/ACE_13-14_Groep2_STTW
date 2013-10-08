package model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Opdracht {
	
	//data members
	
	private String vraag;
	//private String juisteAntwoord;
	//Dictionary komt in Java overeen met HashMap
	private HashMap<String,Boolean> antwoordenMetJuistFout;
	private int maxAantalPogingen;
	private String[] antwoordHints;
	//private IetsMetTijd ??? maxAntwoordTijd
	private int maxAntwoordTijd;
	private Leraar auteur;
	private OpdrachtCategorie categorie;
	
	//getters & setters
	
	protected String getVraag() {
		return vraag;
	}

	private void setVraag(String vraag) {
		this.vraag = vraag;
	}

	protected String getJuisteAntwoord() {
		for(Map.Entry entry : antwoordenMetJuistFout.entrySet()){
				if((boolean)entry.getValue()){
					return (String) entry.getKey();
				}
		}
		//Exception nodig
		return "Exception: No answer found!";
	}

	private void setJuisteAntwoord(String juisteAntwoord) {
		
		this.antwoordenMetJuistFout.put(juisteAntwoord, true);
		
	}

	protected int getMaxAantalPogingen() {
		return maxAantalPogingen;
	}

	private void setMaxAantalPogingen(int maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}

	protected String[] getAntwoordHints() {
		return antwoordHints;
	}

	private void setAntwoordHints(String[] antwoordHints) {
		this.antwoordHints = antwoordHints;
	}
	
	protected int getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}
	
	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	
	protected Leraar getAuteur() {
		return auteur;
	}
	
	private void setOpdrachtCategorie(OpdrachtCategorie categorie) {
		this.categorie = categorie;
	}
	
	protected OpdrachtCategorie getOpdrachtCategorie() {
		return categorie;
	}
	
	//constructors
	public Opdracht(){
		antwoordenMetJuistFout = new HashMap<String, Boolean>();
	}
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, OpdrachtCategorie categorie,
			String ... antwoordHints) {
		this();
		setVraag(vraag);
		setJuisteAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAantalPogingen(maxAntwoordTijd);
		setAuteur(auteur);
		setOpdrachtCategorie(categorie);
		setAntwoordHints(antwoordHints);
	}
	
	//methods
	
	public Boolean IsJuisteAntwoord(String antwoord) {
		return (antwoord == juisteAntwoord) ? true : false;
	}
	
}

package model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Opdracht {
	
	//data members
	
	private String vraag;
	private int maxAantalPogingen;
	//private IetsMetTijd ??? maxAntwoordTijd
	private int maxAntwoordTijd;
	
	//private String juisteAntwoord;
	//Arraylist om makkelijk antwoorden toe te voegen en te verwijderen.
	private ArrayList<Antwoord> antwoorden;
	private String[] antwoordHints;
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
		for(Antwoord antwoord : antwoorden){
				if(antwoord.isJuist()){
					return ""+antwoord;
				}
		}
		//Exception nodig
		return "Exception: No answer found!";
	}

	private void setJuisteAntwoord(String juisteAntwoord) {
		for(Antwoord antwoord : antwoorden){
			if(antwoord.toString() == juisteAntwoord){
				antwoord.setJuist(true);
				return;
			}
		}
		//als juisteantwoord niet gevonden dan is er geen return en wordt volgende uitgevoerd:
		this.antwoorden.add(new Antwoord(juisteAntwoord, true));
		
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
		for(Antwoord _antwoord : antwoorden){
			if(_antwoord.toString() == antwoord){
				return _antwoord.isJuist();
			}
		}
		return false;
	}
	
}

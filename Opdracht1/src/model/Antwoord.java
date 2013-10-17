package model;

import model.enums.AntwoordCategorie;

public class Antwoord {

	//data members
	
	private String antwoord;
	private boolean juist;
	private AntwoordCategorie categorie;
	
	//getters & setters
		
	public void setJuist(boolean juist){
		this.juist = juist;
	}
	
	public String getAntwoord() {
		return antwoord;
	}
	
	/*
	 * 
	 * Ik ben vrij zeker dat deze delimited string géén goeie oplossing is, 
	 * maar ik laat het zo tot de maker (Sander?) dit even uitlegt.
	 * Tot zolang best geen tests schrijven voor deze methode.
	 * 
	 * */
	private void setAntwoord(String antwoord) throws IllegalArgumentException {
		if(antwoord != null && !antwoord.isEmpty()){
			if(antwoord.contains(";") == false){
				this.antwoord = antwoord;
				categorie = AntwoordCategorie.enigAntwoord;
				this.juist = true;
			}
			else if(antwoord.contains(";") == true){
				this.antwoord += antwoord;
				categorie = AntwoordCategorie.opsomming;
			}
		}
		else throw new IllegalArgumentException("Argument cannot be null or empty.");
	}
	
	public AntwoordCategorie getCategorie(){
		return this.categorie;
	}
	
	//constructors
	
	public Antwoord(){
		
	}
	
	public Antwoord(String antwoord){
		setAntwoord(antwoord);
	}
	
	public Antwoord(String antwoord, boolean juist){
		setAntwoord(antwoord);
		categorie = AntwoordCategorie.meerkeuze;
		this.juist = juist;
	}
	
	public Antwoord(String... antwoordlijst){
		for(String antwoord : antwoordlijst){
			setAntwoord(antwoord);
		}
		categorie = AntwoordCategorie.opsomming;
	}
	
	//methods
	
	public boolean isJuist(){
		return this.juist;
	}
	
	//method overrides
	
	@Override
	public String toString(){
		return this.antwoord;
	}
}

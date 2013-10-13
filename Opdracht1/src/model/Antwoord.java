package model;



public class Antwoord {

	private String antwoord;
	private boolean juist;
	private AntwoordCategorie categorie;
	
	//getters en setters
	public boolean isJuist(){
		return this.juist;
	}	
	public void setJuist(boolean juist){
		this.juist = juist;
	}
	
	public Antwoord(){
		
	}
	public Antwoord(String antwoord){
		this.antwoord = antwoord;
		categorie = AntwoordCategorie.enigAntwoord;
		this.juist = true;
	}
	public Antwoord(String antwoord,boolean juist){
		this.antwoord = antwoord;
		categorie = AntwoordCategorie.meerkeuze;
		this.juist = juist;
	}
	public Antwoord(String... antwoordlijst){
		for(String antwoord : antwoordlijst){
			this.antwoord += antwoord+";";
		}
		categorie = AntwoordCategorie.opsomming;
	}
	

	
	@Override
	public String toString(){
		return this.antwoord;
	}
}

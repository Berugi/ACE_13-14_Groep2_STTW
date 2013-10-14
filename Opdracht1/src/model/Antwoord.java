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
	public AntwoordCategorie getCategorie(){
		return this.categorie;
	}
	
	public Antwoord(){
		
	}
	public Antwoord(String antwoord){
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

package model;

import model.baseclasses.OpdrachtBase;

import java.util.ArrayList;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.interfaces.IValideerbaar;
/**
 * 
 * @author 
 * 
 * @version 20131020-01 - modified by Sander van der Borght
 *
 * Bevat informatie over meerkeuzevragen
 */
public class MeerKeuze extends OpdrachtBase implements IValideerbaar {
	
	private ArrayList<String> keuzes;
	private String valideerTekst = "Er is nog geen validatie gebeurd";

	public MeerKeuze() {
		this.keuzes = null;
	}

	//keuzes in Arraylist<String>
	public MeerKeuze(ArrayList<String> keuzes,String vraag, String juisteAntwoord,
			int maxAantalPogingen, int maxAntwoordTijd, Leraar auteur,
			OpdrachtCategorie categorie, String... antwoordHints) {
		super(vraag, juisteAntwoord, maxAantalPogingen, maxAntwoordTijd,
				auteur, categorie, antwoordHints);
		
		if(!keuzes.contains(juisteAntwoord)){
			throw new IllegalArgumentException("De mogelijke keuzes bevatten niet het juiste antwoord!");
			
		}		
		this.keuzes=keuzes;
	}

	// Getter & Setter	
	public ArrayList<String> getKeuzes(){
		return this.keuzes;
	}
	
	public void setKeuzes(ArrayList<String> keuzes){
		this.keuzes=keuzes;
	}
	
	public String getValideerTekst() {
		return valideerTekst;
	}

	// Methods
	//Keuze van het antwoord
	public boolean isJuisteTekst(String antwoord) {
		if(this.keuzes.contains(antwoord)){
			if(super.getJuisteAntwoord() == antwoord){
				this.valideerTekst = "Het ingegeven antwoord is correct!";
				return true;
			}else{
				this.valideerTekst = "Het ingegeven antwoord is incorrect!";
				return false;
			}			
		}
		else{
			this.valideerTekst = "Het ingegeven antwoord behoort niet tot de mogelijkheden!";
			return false;
		}
	}
	
	//Keuzes van een antwoord aan de hand van de nummers 1,2,3,4,...
	public boolean isJuisteKeuze(String antwoordKeuze){
		return isJuisteKeuze(Integer.parseInt(antwoordKeuze));
	}
	//Keuzes van een antwoord aan de hand van de nummers 1,2,3,4,...
	public boolean isJuisteKeuze(int antwoordKeuze){
		if(this.isValide(antwoordKeuze)){
			if(this.keuzes.get(antwoordKeuze) == super.getJuisteAntwoord()){
				this.valideerTekst = "Het gekozen antwoord is correct!";
				return true;	
			}else{
				this.valideerTekst = "Het gekozen antwoord is incorrect!";
				return false;
			}
		}else{			
			this.valideerTekst = "Het ingegeven cijfer behoort niet tot de mogelijke keuzes";
			throw new IllegalArgumentException("Ongeldige keuze");			
		}
	}

	public boolean isValide(String antwoordKeuze){
		return this.isValide(Integer.parseInt(antwoordKeuze));
	}
	public boolean isValide(int antwoordKeuze){
		if(0<antwoordKeuze && antwoordKeuze <= this.keuzes.size()){
			this.valideerTekst = "Het ingegeven cijfer behoort tot de mogelijke keuzes";
			return true;			
		}else{			
			this.valideerTekst = "Het ingegeven cijfer behoort niet tot de mogelijke keuzes";
			return false;			
		}
	}
}

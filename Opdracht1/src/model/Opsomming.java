package model;

import model.baseclasses.OpdrachtBase;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import utils.Datum;

/**
 * 
 * @author 
 * 
 * @version 20131020-01 - modified by Sander van der Borght
 *
 * Bevat informatie over opsommingsvragen
 */

public class Opsomming  extends OpdrachtBase implements IValideerbaar {

	private String valideerTekst = "Er is nog geen validatie gebeurd";
	
	public Opsomming() {
		
	}

	public Opsomming(Integer opdrachtID,String vraag, String juisteAntwoord,
			int maxAantalPogingen, int maxAntwoordTijd, Leraar auteur,
			OpdrachtCategorie categorie, Datum registratiedatum, String... antwoordHints) {
		super(opdrachtID,vraag, juisteAntwoord, maxAantalPogingen, maxAntwoordTijd,
				auteur, categorie, registratiedatum, antwoordHints);
	}
	
	//getters en setters
	private String[] getAntwoordlijst(){
		return super.getJuisteAntwoord().split(";");
	}

	public String getValideerTekst() {
		return this.valideerTekst;
	}

	// Methods
	//vergelijkt alle antwoorden in de juiste volgorde
	//op het ogenblik dat een antwoord in de opsomming niet overeen komt is return false
	public boolean isJuisteVolgorde(String antwoord){
		String[] naTeKijkenAntwoordLijst = antwoord.split(";");
		String [] juisteLijst = this.getAntwoordlijst();
		if(naTeKijkenAntwoordLijst.length == juisteLijst.length){
			for(int i = 0;i< juisteLijst.length;i++){
				if(naTeKijkenAntwoordLijst[i] != juisteLijst[i]){
					return false;
				}
			}
			//als alle antwoorden in de lijst overlopen zijn en er is geen return door foute waarden
			//dan is de volgorde juist:
			return true;
		}else{
			return false;
		}
	}

	//deze methode kijkt na of alle juiste antwoorden aanwezig zijn
	//de antwoorden staan niet per se in de juiste volgorde
	public boolean isJuist(String antwoord) {
		String[] naTeKijkenAntwoordLijst = antwoord.split(";");
		String [] juisteLijst = this.getAntwoordlijst();
		boolean returnvalue = false;
		
		for(String antwoordNaTeKijken : naTeKijkenAntwoordLijst){
			for(String juisteAntwoord : juisteLijst){
				if(juisteAntwoord == antwoordNaTeKijken){
					returnvalue = true;
					break;
				}
			}
			//als een antwoord uit de na te kijken lijst niet gevonden is
			//dan is de opsomming niet juist
			if(returnvalue != true){
				return false;
			}
			returnvalue = false;
		}
		return true;
	}
	
	//kijkt na of de opsomming het juist aantal elementen bevat, gescheiden door ';'
	public boolean isValide(String antwoord){
		if(this.getAntwoordlijst().length > 1){
			if(!antwoord.contains(";")){
				this.valideerTekst = "Antwoord bevat geen nodige ';' !";
				return false;
			}else if(this.getAntwoordlijst().length < antwoord.split(";").length){
				this.valideerTekst = "Antwoord bevat te veel elementen gescheiden door ';' !";
				return false;
			}else if(this.getAntwoordlijst().length > antwoord.split(";").length){
				this.valideerTekst = "Antwoord bevat niet genoeg elementen gescheiden door ';' !";
				return false;
			}else{
				this.valideerTekst = "Het gegeven antwoord bevat het juiste aantal elementen.";
				return true;
			}
			
		}else{
			if(antwoord.split(";").length > 1){
				this.valideerTekst = "Antwoord bevat te veel waarden gescheiden door ';' !";
				return false;
			}else{
				this.valideerTekst = "Het gegeven antwoord bevat het juiste aantal elementen.";
				return true;
			}
		}
	}
}

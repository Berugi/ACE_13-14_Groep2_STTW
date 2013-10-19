package model;

import model.baseclasses.OpdrachtBase;

import java.util.ArrayList;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.interfaces.IValideerbaar;

public class MeerKeuze extends OpdrachtBase implements IValideerbaar {
	
	private ArrayList<String> keuzes;

	public MeerKeuze() {
		this.keuzes = null;
	}

	public MeerKeuze(ArrayList<String> keuzes,String vraag, String juisteAntwoord,
			int maxAantalPogingen, int maxAntwoordTijd, Leraar auteur,
			OpdrachtCategorie categorie, String... antwoordHints) {
		super(vraag, juisteAntwoord, maxAantalPogingen, maxAntwoordTijd,
				auteur, categorie, antwoordHints);
		this.keuzes=keuzes;
	}

	// Getter & Setter
	
	public ArrayList<String> getKeuzes(){
		return this.keuzes;
	}
	
	public void setKeuzes(ArrayList<String> keuzes){
		this.keuzes=keuzes;
	}

	// Methods
	public boolean isValide(String antwoord) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}
}

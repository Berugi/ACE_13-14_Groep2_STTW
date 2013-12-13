package model;

import java.util.Arrays;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import utils.Datum;

public class Opdracht implements Comparable<Opdracht>, Cloneable{
	
	//data members
	
	private String vraag;
	private int maxAantalPogingen;
	//private IetsMetTijd ??? maxAntwoordTijd
	private int maxAntwoordTijd;
	
	private String juisteAntwoord;
	private String[] antwoordHints;
	private Leraar auteur;
	private OpdrachtCategorie categorie;
	private Datum datumRegistratie;
	
	
	//getters & setters
	
	public String getVraag() {
		return vraag;
	}

	private void setVraag(String vraag) {
		this.vraag = vraag;
	}

	public String getJuisteAntwoord() {
		return this.juisteAntwoord;
	}

	private void setJuisteAntwoord(String juisteAntwoord) {
		
		this.juisteAntwoord = juisteAntwoord;
		
	}

	public int getMaxAantalPogingen() {
		return maxAantalPogingen;
	}

	private void setMaxAantalPogingen(int maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}

	public String[] getAntwoordHints() {
		return antwoordHints;
	}

	private void setAntwoordHints(String[] antwoordHints) {
		this.antwoordHints = antwoordHints;
	}
	
	public int getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}
	
	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	
	public Leraar getAuteur() {
		return auteur;
	}
	
	private void setOpdrachtCategorie(OpdrachtCategorie categorie) {
		this.categorie = categorie;
	}
	
	public OpdrachtCategorie getOpdrachtCategorie() {
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
		return this.juisteAntwoord.equalsIgnoreCase(antwoord);
	}

	public int compareTo(Opdracht opdracht) {
		// TODO Auto-generated method stub
		return this.getVraag().compareTo(opdracht.getVraag());
		//return 0;
			
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(antwoordHints);
		result = prime * result
				+ ((juisteAntwoord == null) ? 0 : juisteAntwoord.hashCode());
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime
				* result
				+ ((datumRegistratie == null) ? 0 : datumRegistratie.hashCode());
		result = prime * result + maxAantalPogingen;
		result = prime * result + maxAntwoordTijd;
		result = prime * result + ((vraag == null) ? 0 : vraag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opdracht other = (Opdracht) obj;
		if (!Arrays.equals(antwoordHints, other.antwoordHints))
			return false;
		if (juisteAntwoord == null) {
			if (other.juisteAntwoord != null)
				return false;
		} else if (!juisteAntwoord.equals(other.juisteAntwoord))
			return false;
		if (auteur != other.auteur)
			return false;
		if (categorie != other.categorie)
			return false;
		if (datumRegistratie == null) {
			if (other.datumRegistratie != null)
				return false;
		} else if (!datumRegistratie.equals(other.datumRegistratie))
			return false;
		if (maxAantalPogingen != other.maxAantalPogingen)
			return false;
		if (maxAntwoordTijd != other.maxAntwoordTijd)
			return false;
		if (vraag == null) {
			if (other.vraag != null)
				return false;
		} else if (!vraag.equals(other.vraag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Opdracht [vraag=" + vraag + ", maxAantalPogingen="
				+ maxAantalPogingen + ", maxAntwoordTijd=" + maxAntwoordTijd
				+ ", juiste antwoord=" + juisteAntwoord + ", antwoordHints="
				+ Arrays.toString(antwoordHints) + ", auteur=" + auteur
				+ ", categorie=" + categorie + ", datumRegistratie="
				+ datumRegistratie + "]";
	}
	
}

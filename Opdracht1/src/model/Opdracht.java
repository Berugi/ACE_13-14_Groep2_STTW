package model;

import java.util.Arrays;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import utils.Datum;

/**
 * Represents an Opdracht
 * 
 * @author Wim Ombelets
 * @version 20131213-01 - initial commit
 *

public class Opdracht implements Comparable<Opdracht>, Cloneable{
	
	//data members
	
	private String vraag;
	private String[] antwoordHints;
	private String juisteAntwoord;
	private int maxAantalPogingen;
	private int maxAntwoordTijd;
	private OpdrachtCategorie opdrachtCategorie;
	private Leraar auteur;
	private Datum datumRegistratie;
	
	//getters & setters
	
	public String getVraag() {
		return vraag;
	}

	private void setVraag(String vraag) {
		this.vraag = vraag;
	}

	public String[] getAntwoordHints() {
		return antwoordHints;
	}

	private void setAntwoordHints(String[] antwoordHints) {
		this.antwoordHints = antwoordHints;
	}

	public String getJuisteAntwoord() {
		return juisteAntwoord;
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

	public int getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}

	private void setMaxAntwoordTijd(int maxAntwoordTijd) {
		this.maxAntwoordTijd = maxAntwoordTijd;
	}

	public OpdrachtCategorie getOpdrachtCategorie() {
		return opdrachtCategorie;
	}

	private void setOpdrachtCategorie(OpdrachtCategorie opdrachtCategorie) {
		this.opdrachtCategorie = opdrachtCategorie;
	}

	public Leraar getAuteur() {
		return auteur;
	}

	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}

	public Datum getDatumRegistratie() {
		return datumRegistratie;
	}

	private void setDatumRegistratie(Datum datumRegistratie) {
		this.datumRegistratie = datumRegistratie;
	}

	//constructors
	public Opdracht(){
		
	}
	
	public Opdracht(String vraag, String[] antwoordHints, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, OpdrachtCategorie categorie, Leraar auteur, Datum datumRegistratie) {
		setVraag(vraag);
		setAntwoordHints(antwoordHints);
		setJuisteAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAntwoordTijd(maxAntwoordTijd);
		setOpdrachtCategorie(categorie);
		setAuteur(auteur);
		setDatumRegistratie(datumRegistratie);
	}
	
	//methods
	
	public Boolean IsJuisteAntwoord(String antwoord) {
		return this.juisteAntwoord.equalsIgnoreCase(antwoord);
	}

	public int compareTo(Opdracht opdracht) {
		return this.getVraag().compareTo(opdracht.getVraag());			
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(antwoordHints);
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime
				* result
				+ ((datumRegistratie == null) ? 0 : datumRegistratie.hashCode());
		result = prime * result
				+ ((juisteAntwoord == null) ? 0 : juisteAntwoord.hashCode());
		result = prime * result + maxAantalPogingen;
		result = prime * result + maxAntwoordTijd;
		result = prime
				* result
				+ ((opdrachtCategorie == null) ? 0 : opdrachtCategorie
						.hashCode());
		result = prime * result + ((vraag == null) ? 0 : vraag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Opdracht)) {
			return false;
		}
		Opdracht other = (Opdracht) obj;
		if (!Arrays.equals(antwoordHints, other.antwoordHints)) {
			return false;
		}
		if (auteur != other.auteur) {
			return false;
		}
		if (datumRegistratie == null) {
			if (other.datumRegistratie != null) {
				return false;
			}
		} else if (!datumRegistratie.equals(other.datumRegistratie)) {
			return false;
		}
		if (juisteAntwoord == null) {
			if (other.juisteAntwoord != null) {
				return false;
			}
		} else if (!juisteAntwoord.equals(other.juisteAntwoord)) {
			return false;
		}
		if (maxAantalPogingen != other.maxAantalPogingen) {
			return false;
		}
		if (maxAntwoordTijd != other.maxAntwoordTijd) {
			return false;
		}
		if (opdrachtCategorie != other.opdrachtCategorie) {
			return false;
		}
		if (vraag == null) {
			if (other.vraag != null) {
				return false;
			}
		} else if (!vraag.equals(other.vraag)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Opdracht [vraag=" + vraag + ", antwoordHints="
				+ Arrays.toString(antwoordHints) + ", juisteAntwoord="
				+ juisteAntwoord + ", maxAantalPogingen=" + maxAantalPogingen
				+ ", maxAntwoordTijd=" + maxAntwoordTijd
				+ ", opdrachtCategorie=" + opdrachtCategorie + ", auteur="
				+ auteur + ", datumRegistratie=" + datumRegistratie + "]";
	}
	
}
*/

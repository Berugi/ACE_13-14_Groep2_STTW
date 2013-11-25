package model.baseclasses;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import model.Opdracht;
import model.QuizOpdracht;
import model.enums.OpdrachtCategorie;
import model.enums.Leraar;
import utils.Datum;

/*********************************
 * 
 * Create a Opdracht object 
 * 
 * @author Sander Van der Borght
 * @version 20131008-01 =  initial
 * @version 20131013-01 = modification done by Tom Scheepers (only 1 answer allowed -> String iso Arraylist)
 * @version 20131023-01 = modification done by Wim Ombelets (Object antwoorden added because it wasn't defined)
 *
 * @
 */

public class OpdrachtBase implements Comparable<Opdracht>, Cloneable {
	
	//data members
	
	private String vraag;
	private int maxAantalPogingen;
	private int maxAntwoordTijd; // in seconden
	private String juisteAntwoord;
	private String[] antwoordHints;
	private Leraar auteur;
	private OpdrachtCategorie categorie;
	private Datum datumRegistratie;
	private Set<QuizOpdracht> quizOpdrachten;
	
	//antwoorden was niet gedefinieerd dus heb
	//heb ik een Object antwoorden bijgemaakt
	//verder uitvissen !!! Wim
	private Object antwoorden;
	
	
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
		this.juisteAntwoord=juisteAntwoord;
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
	
	public void setMaxAntwoordTijd(int maxAntwoordTijd) {
		this.maxAntwoordTijd = maxAntwoordTijd;
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
	
	public Set<QuizOpdracht> getQuizOpdrachten() {
		return quizOpdrachten;
	}

	public void setQuizOpdrachten(Set<QuizOpdracht> quizOpdrachten) {
		this.quizOpdrachten = quizOpdrachten;
	}

	public Datum getDatumRegistratie() {
		return datumRegistratie;
	}

	public void setDatumRegistratie(Datum datumRegistratie) {
		this.datumRegistratie = datumRegistratie;
	}

	//constructors
	
	/**
	 * @param vraag (String) de vraag
	 * @param juisteAntwoord (String) het antwoord
	 * @param antwoordHints (ArrayList) 1 of meer hints
	 * @param maxAantalPogingen (int) het aantal pogingen dat mag gedaan worden - default = 1
	 * @param maxAntwoordTijd (int) tijd in seconden die mag gebruikt worden om een antwoord te geven - 0 = geen tijdslimiet
	 * @param auteur (enum Leraar) de auteur van de vraag
	 * @param categorie (enum OpdrachtCategorie) de categorie van de opdracht
	 * 	
	 */
	
	public OpdrachtBase(){
		this.vraag = "";
		this.juisteAntwoord="";
		this.antwoordHints=null;
		this.maxAantalPogingen=1;
		this.maxAntwoordTijd=0; //0 = unlimited time
		this.auteur=Leraar.TBA;
		this.categorie=OpdrachtCategorie.TBA;
		this.setQuizOpdrachten(new HashSet<QuizOpdracht>());
		this.setDatumRegistratie(new Datum());
	}
	
	public OpdrachtBase(String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, OpdrachtCategorie categorie,
			String... antwoordHints) {
		this();
		setVraag(vraag);
		setJuisteAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAntwoordTijd(maxAntwoordTijd);
		setAuteur(auteur);
		setOpdrachtCategorie(categorie);
		setAntwoordHints(antwoordHints);
	}
	
	public OpdrachtBase(String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, OpdrachtCategorie categorie, Datum datumRegistratie,
			String... antwoordHints) {
		this();
		setVraag(vraag);
		setJuisteAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAntwoordTijd(maxAntwoordTijd);
		setAuteur(auteur);
		setOpdrachtCategorie(categorie);
		setAntwoordHints(antwoordHints);
		setDatumRegistratie(datumRegistratie);
	}
	
	//methods
	

	public Boolean ToevoegenAanQuizOpdrachten(QuizOpdracht qo){
		try{
			quizOpdrachten.add(qo);
			return true;	
		}
		catch (Exception e){
			return false;
		}
	}
	
	public Boolean VerwijderenUitQuizOpdrachten(QuizOpdracht qo){
		try{
			
			quizOpdrachten.remove(qo);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Wijzig de opdracht.
	 * Constraint: Opdracht mag enkel gewijzigd worden als ze nog niet behoort tot een Quiz die door leerlingen al is uitgevoerd
	 * @return true als wijziging succesvol was
	 */
	
	public Boolean Opdracht_wijzigen(String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, OpdrachtCategorie categorie,
			String ... antwoordHints){
		try{
			if (this.MagGewijzigdWorden())
			{
			setVraag(vraag);
			setJuisteAntwoord(juisteAntwoord);
			setMaxAantalPogingen(maxAantalPogingen);
			setMaxAantalPogingen(maxAntwoordTijd);
			setAuteur(auteur);
			setOpdrachtCategorie(categorie);
			setAntwoordHints(antwoordHints);
			return true;
			}
			
			return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Controle of opdracht al eens beantwoord werd
	 * @return true als nog geen enkele maal beantwoord werd
	 */
	
	public Boolean MagGewijzigdWorden(){
		int totaal = 0;
		
		for (QuizOpdracht qo: quizOpdrachten)
		{
			totaal = totaal + qo.AantalMaalBeantwoord();
		}
		if (totaal==0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Controleert het gegeven antwoord op juistheid
	 * @param antwoord
	 * @return
	 */
	
	public Boolean IsJuisteAntwoord(String antwoord) {
		if(this.getJuisteAntwoord().equals(antwoord)){
				return true;
		}
		else{
			return false;
		}
	}

	public int compareTo(Opdracht arg0) {
		// TODO Auto-generated method stub
		return 0;
			
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(antwoordHints);
		
		result = prime * result
				+ ((antwoorden == null) ? 0 : antwoorden.hashCode());
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
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Opdracht other = (Opdracht) obj;
//		if (!Arrays.equals(antwoordHints, other.antwoordHints))
//			return false;
//		if (antwoorden == null) {
//			if (other.antwoorden != null)
//				return false;
//		} else if (!antwoorden.equals(other.antwoorden))
//			return false;
//		if (auteur != other.auteur)
//			return false;
//		if (categorie != other.categorie)
//			return false;
//		if (datumRegistratie == null) {
//			if (other.datumRegistratie != null)
//				return false;
//		} else if (!datumRegistratie.equals(other.datumRegistratie))
//			return false;
//		if (maxAantalPogingen != other.maxAantalPogingen)
//			return false;
//		if (maxAntwoordTijd != other.maxAntwoordTijd)
//			return false;
//		if (vraag == null) {
//			if (other.vraag != null)
//				return false;
//		} else if (!vraag.equals(other.vraag))
//			return false;
		return false;
	}

	@Override
	public String toString() {
		return "Opdracht [vraag=" + vraag + ", maxAantalPogingen="
				+ maxAantalPogingen + ", maxAntwoordTijd=" + maxAntwoordTijd
				+ ", antwoorden=" + antwoorden + ", antwoordHints="
				+ Arrays.toString(antwoordHints) + ", auteur=" + auteur
				+ ", categorie=" + categorie + ", datumRegistratie="
				+ datumRegistratie + "]";
	}
	
	@Override
	public OpdrachtBase clone() throws CloneNotSupportedException{
		return this;
	}
}

package model;

import java.util.Arrays;

import model.enums.QuizStatus;
import utils.Datum;
import model.enums.Leraar;

/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131013-01 - modified by Tom Vaes - added datumRegistratie
 * @version 20131013-02 - modified by Tom Scheepers - added QuizStatus
 * @version 20131020-01 - modified by Tom Vaes - added constructors
 *
 * Bevat Quiz informatie
 */

public class Quiz implements Comparable<Quiz>, Cloneable{
	
	//data members
	private String onderwerp;
	private int[] leerjaren;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private Leraar auteur;
	private Datum datumRegistratie;
	private QuizStatus quizStatus;
	
	//getters & setters

	public String getOnderwerp() {
		return onderwerp;
	}

	
	public void setOnderwerp(String onderwerp) throws IllegalArgumentException {
		if(onderwerp != null && !onderwerp.isEmpty())
			this.onderwerp = onderwerp;
		else throw new IllegalArgumentException("Argument cannot be null or empty");
	}
	
	public int[] getLeerjaren() {
		return this.leerjaren;
	}
	
	//er zijn 6 leerjaren genummerd van 1 tot en met 6
	private void setLeerjaren(int[] leerjaren) throws IllegalArgumentException {
		if(leerjaren.length == 0)
			throw new IllegalArgumentException("Leerjaren must contain at least one element.");
		else{
			this.leerjaren = new int[leerjaren.length];
			for(int i = 0; i < leerjaren.length; i++) {
				this.leerjaren[i] = leerjaren[i];
			}
		}
	}

	public Boolean getIsTest() {
		return this.isTest;
	}

	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}

	public Boolean getIsUniekeDeelname() {
		return this.isUniekeDeelname;
	}

	public void setIsUniekeDeelname(Boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}

	public Leraar getAuteur() {
		return this.auteur;
	}

	public void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	
	public void setDatumRegistratie(Datum datum)
	{
		this.datumRegistratie = datum;
	}
	
	public void setQuizStatus(QuizStatus status)
	{
		this.quizStatus = status;
	}
	
	public QuizStatus getQuizStatus()
	{
		return this.quizStatus;
	}
	
	//constructors

	public Quiz()
	{
		this(" ", null, false, false, null, null, null);		
	}
	
	public Quiz(Leraar auteur)
	{
		this(" ", null, false, false, auteur, null, null);		
	}
		
	public Quiz(String onderwerp)
	{
		this(onderwerp, null, false, false, null, null,null);
	}
		
	public Quiz(String onderwerp, Leraar auteur)
	{
		this (onderwerp, null, false, false, auteur, null,null);
	}
	
	public Quiz(String onderwerp, Leraar auteur, Datum regDatum)
	{
		this (onderwerp, null, false, false, auteur, regDatum,null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Leraar auteur)
	{
		this(onderwerp, leerjaren, false, false, auteur, null,null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Leraar auteur, Datum regDatum)
	{
		this(onderwerp, leerjaren, false, false, auteur, regDatum,null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Boolean isTest,
			Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, QuizStatus status) {
		//super();
		setOnderwerp(onderwerp);
		setLeerjaren(leerjaren);
		setIsTest(isTest);
		setIsUniekeDeelname(isUniekeDeelname);
		setAuteur(auteur);
		setDatumRegistratie(regDatum);
		setQuizStatus(status);
	}

	// Override methodes - standard	
	@Override
	public String toString() {
		return "Quiz [onderwerp=" + onderwerp + ", leerjaren="
				+ Arrays.toString(leerjaren) + ", isTest=" + isTest
				+ ", isUniekeDeelname=" + isUniekeDeelname + ", auteur="
				+ auteur + ", datumRegistratie=" + datumRegistratie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime
				* result
				+ ((datumRegistratie == null) ? 0 : datumRegistratie.hashCode());
		result = prime * result + ((isTest == null) ? 0 : isTest.hashCode());
		result = prime
				* result
				+ ((isUniekeDeelname == null) ? 0 : isUniekeDeelname.hashCode());
		result = prime * result + Arrays.hashCode(leerjaren);
		result = prime * result
				+ ((onderwerp == null) ? 0 : onderwerp.hashCode());
		result = prime * result
				+ ((quizStatus == null) ? 0 : quizStatus.hashCode());
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
		Quiz other = (Quiz) obj;
		if (auteur != other.auteur)
			return false;
		if (datumRegistratie == null) {
			if (other.datumRegistratie != null)
				return false;
		} else if (!datumRegistratie.equals(other.datumRegistratie))
			return false;
		if (isTest == null) {
			if (other.isTest != null)
				return false;
		} else if (!isTest.equals(other.isTest))
			return false;
		if (isUniekeDeelname == null) {
			if (other.isUniekeDeelname != null)
				return false;
		} else if (!isUniekeDeelname.equals(other.isUniekeDeelname))
			return false;
		if (!Arrays.equals(leerjaren, other.leerjaren))
			return false;
		if (onderwerp == null) {
			if (other.onderwerp != null)
				return false;
		} else if (!onderwerp.equals(other.onderwerp))
			return false;
		if (quizStatus != other.quizStatus)
			return false;
		return true;
	}
	
	/*
	 * Bij het vergelijken van de onderwerpnamen houden we geen rekening met hoofdletters, blanco's en leestekens
	 * zoals komma's, vraagtekens,... De woorden 'de, een, het, met, van, in'  worden bij de vergelijking van de 
	 * onderwerpen genegeerd. Volgens deze afspraken is 'hoofdsteden europa' gelijk aan 'De hoofdsteden van Europa'.
	 */
	public String getShortOnderwerp(){
		String delimitors[] = {"van","de","een","het","met","in"};
		//Volgende moet korter kunnen; verwijderen van de, een, het, met, van, in en spaties
		return this.onderwerp.replaceAll("van", "").replaceAll("de", "").replaceAll("een", "").replaceAll("het", "").replaceAll("met", "").replaceAll("in", "").replaceAll(" ", "");
	}
	
	public int compareTo(Quiz o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

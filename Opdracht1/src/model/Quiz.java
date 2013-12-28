package model;

import java.util.Arrays;

import utils.Datum;
import model.baseclasses.OpdrachtBase;
import model.enums.Leraar;
import model.enums.QuizStatus;
import model.interfaces.IQuizStatus;
import model.QuizCatalogus;
import controller.OpstartController;

import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131013-01 - modified by Tom Vaes - added datumRegistratie
 * @version 20131013-02 - modified by Tom Scheepers - added QuizStatus
 * @version 20131020-01 - modified by Tom Vaes - added constructors
 * @version 20131031-01 - modified by Tom Scheepers - added methods to add/remove QuizOpdrachten
 *
 * Bevat Quiz informatie
 */

public class Quiz implements Comparable<Quiz>, Cloneable{
	
	//data members
	private int quizID;
	private String onderwerp;
	private int[] leerjaren;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private Leraar auteur;
	private Datum datumRegistratie;
	//private IQuizStatus quizStatus; -- for state pattern
	private QuizStatus quizStatus;
	private Set<QuizOpdracht> quizOpdrachten;
	
	private static int HoogsteID;
	
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
	public void setLeerjaren(int[] leerjaren) throws IllegalArgumentException {
		/*if(leerjaren.length == 0)
			throw new IllegalArgumentException("Leerjaren must contain at least one element.");
		else{
			this.leerjaren = new int[leerjaren.length];
			for(int i = 0; i < leerjaren.length; i++) {
				this.leerjaren[i] = leerjaren[i];
			}
		}*/
		this.leerjaren = leerjaren;
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
	
	public void setDatumRegistratie(Datum datum) throws IllegalArgumentException
	{
		this.datumRegistratie = datum;
	}
	
	public Datum getDatumRegistratie(){
		return this.datumRegistratie;
	}
	
	public int getQuizID(){
		return this.quizID;
	}
	
	public void setQuizID(int qid) throws Exception{
		try{
		this.quizID = bepaalID(qid);
		}
		catch (Exception e){
			System.out.println("QuizID kon niet worden bepaald!");
			throw e;
		}
	}
	//-- for state pattern
	//public void setQuizStatus(final IQuizStatus nieuweStatus)
	//{
	//	this.quizStatus = nieuweStatus;
	//}
	
	public void setQuizStatus(QuizStatus nieuweStatus)
	{
		this.quizStatus = nieuweStatus;
	}
	
	//-- for state pattern
	//public IQuizStatus getQuizStatus()
	//{
	//	return this.quizStatus;
	//}
	
	public QuizStatus getQuizStatus()
	{
		return this.quizStatus;
	}
	
	
	//constructors
	
	public Quiz() { }
	
	public Quiz(String onderwerp, Leraar auteur, Datum regDatum)
	{
		this (onderwerp, null, false, false, auteur, regDatum,null);
	}
	
	public Quiz(String onderwerp, Leraar auteur, Datum regDatum, QuizStatus status)
	//-- for state pattern
	//public Quiz(String onderwerp, Leraar auteur, Datum regDatum, IQuizStatus status)
	{
		this (onderwerp, null, false, false, auteur, regDatum,status);
	}
	
	
	public Quiz(String onderwerp, int[] leerjaren, Leraar auteur, Datum regDatum)
	{
		this(onderwerp, leerjaren, false, false, auteur, regDatum,null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Boolean isTest, Boolean isUniekeDeelname, Leraar auteur, Datum regDatum)
	{
		this(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur, regDatum,null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Boolean isTest, Boolean isUniekeDeelname, Leraar auteur)
	{
		this(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur, new Datum(),null);
	}
	
	public Quiz(String onderwerp, int[] leerjaren, Boolean isTest,
			Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, QuizStatus status) {
		//-- for state pattern
	//public Quiz(String onderwerp, int[] leerjaren, Boolean isTest,
	//		Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, IQuizStatus status) {
		try{
			HoogsteID=this.getHoogsteOpdrachtID();
			setQuizID(0);
			setOnderwerp(onderwerp);
			setLeerjaren(leerjaren);
			setIsTest(isTest);
			setIsUniekeDeelname(isUniekeDeelname);
			setAuteur(auteur);
			setDatumRegistratie(regDatum);
			setQuizStatus(status); 
			this.quizOpdrachten = new HashSet<QuizOpdracht>();
		} catch (Exception e){
			System.out.println("Quiz kon niet aangemaakt worden!");
		}
	}
	
	public Quiz(Integer quizID,String onderwerp, int[] leerjaren, Boolean isTest,
			Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, QuizStatus status) throws Exception {
		//-- for state pattern
	//public Quiz(String onderwerp, int[] leerjaren, Boolean isTest,
	//		Boolean isUniekeDeelname, Leraar auteur, Datum regDatum, IQuizStatus status) {
		HoogsteID=this.getHoogsteOpdrachtID();
		try{
		quizID=bepaalID(quizID);
		} catch (Exception e){
			throw e;
		}
		setQuizID(quizID);
		setOnderwerp(onderwerp);
		setLeerjaren(leerjaren);
		setIsTest(isTest);
		setIsUniekeDeelname(isUniekeDeelname);
		setAuteur(auteur);
		setDatumRegistratie(regDatum);
		setQuizStatus(status); 
		this.quizOpdrachten = new HashSet<QuizOpdracht>();
	}
	
	// Override methodes - standard	
	@Override
	public String toString() {
		String quizOpdrachten;
		
		return "Quiz [onderwerp=" + onderwerp + ", leerjaren="
				+ Arrays.toString(leerjaren) + ", isTest=" + isTest
				+ ", isUniekeDeelname=" + isUniekeDeelname + ", auteur="
				+ auteur + ", datumRegistratie=" + datumRegistratie + 
				"quizOpdrachten =" +
				
				"]";
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
	
	// class methods
	
	/*
	 * Bij het vergelijken van de onderwerpnamen houden we geen rekening met hoofdletters, blanco's en leestekens
	 * zoals komma's, vraagtekens,... De woorden 'de, een, het, met, van, in'  worden bij de vergelijking van de 
	 * onderwerpen genegeerd. Volgens deze afspraken is 'hoofdsteden europa' gelijk aan 'De hoofdsteden van Europa'.
	 */
	
	private String removeDelimString(String tekst, String[] delim)
	{
		final String[] delimitors = delim;
		String str, input;
		String[] output;
		
		input = tekst.toLowerCase();
		for(int i=0; i<delimitors.length; i++)
		{
			str = delimitors[i];
			output = input.split(str);
			input = "";
			for(String s: output)
			{
				input += s;
			}
		}
		
		return input;
	}
	
	public String getShortOnderwerp(){
		//delimitors kunnen eventueel in de Business intel gestopt worden.
		final String[] delimitors = {"van","de","een","het","met","in","([.,!?:;'\"-]|\\s)+"};
		return removeDelimString(this.getOnderwerp(),delimitors);
	}
	
	public int compareTo(Quiz quiz) {
		return this.getOnderwerp().compareTo(quiz.getOnderwerp());
	}
	
	public Boolean quizOpdrachtToevoegen(QuizOpdracht quizopdracht){
		try{
		quizOpdrachten.add(quizopdracht);
		return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public Boolean quizOpdrachtVerwijderen(QuizOpdracht quizopdracht){
		try{
			quizOpdrachten.remove(quizopdracht);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public int getHoogsteOpdrachtID(){
		int hoogsteID = 0;
		for(Quiz quiz:OpstartController.quizcatalogus.quizen){
			if(quiz.getQuizID()>hoogsteID){
				hoogsteID=quiz.getQuizID();
			}
		}
		return hoogsteID;
	}
	
	public int bepaalID(Integer id) throws Exception {
		//opdrachtid kontroleren/bepalen
		if(id==0){ //maak nieuwe opdrachtID aan dat hoger is dan elke bestaande id
			HoogsteID++;
			id=HoogsteID;
		} else { // Kontroleer of de opgegeven ID al niet bestaat
			if(OpstartController.quizcatalogus.quizen.contains(id)){
				throw new Exception("QuizID moet uniek zijn");
			}
		}
		return id;
	}
}

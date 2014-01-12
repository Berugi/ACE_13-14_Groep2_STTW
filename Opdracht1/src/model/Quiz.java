package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import model.baseclasses.AbstractQuizStatus;
import model.enums.Leraar;
import model.enums.QuizStatus;
import model.state.QuizStatusAfgesloten;
import model.state.QuizStatusAfgewerkt;
import model.state.QuizStatusInConstructie;
import model.state.QuizStatusLaatsteKans;
import model.state.QuizStatusOpengesteld;
import utils.Datum;
import controller.OpstartController;

/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131013-01 - modified by Tom Vaes - added datumRegistratie
 * @version 20131013-02 - modified by Tom Scheepers - added QuizStatus
 * @version 20131020-01 - modified by Tom Vaes - added constructors
 * @version 20131031-01 - modified by Tom Scheepers - added methods to add/remove QuizOpdrachten
 * @version 20131228 01 - modified by Tom Scheepers - added QuizID
 * @version 20140112-01 - modified by Wim Ombelets - refactored state pattern using abstract base class
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
	private AbstractQuizStatus status;
	private Set<QuizOpdracht> quizOpdrachten;
	
	private static int HoogsteID;
	
	//getters & setters
	public Set<QuizOpdracht> getQuizOpdrachten(){
		return this.quizOpdrachten;
	}
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
	
	public String getLeerjarenAsString(){
		String result="";
		for(int lj: this.leerjaren){
			if(result!=""){result=result+",";}
			result=result+Integer.toString(lj);
		}
		return result;
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
	
	public void setQuizStatus(QuizStatus nieuweStatus) throws NullPointerException, IllegalArgumentException {
		
		if(nieuweStatus == null)
			throw new NullPointerException("Status mag niet null zijn.");
		
		switch(nieuweStatus) {
		case AFGEWERKT:
			this.status = new QuizStatusAfgewerkt();
			break;
		case INCONSTRUCTIE:
			this.status = new QuizStatusInConstructie();
			break;
		case LAATSTEKANS:
			this.status = new QuizStatusLaatsteKans();
			break;
		case OPENGESTELD:
			this.status = new QuizStatusOpengesteld();
			break;
		case AFGESLOTEN:
			this.status = new QuizStatusAfgesloten();
		default:
			throw new IllegalArgumentException("Deze status is niet geldig.");
		
		}
		
	}
	
	public QuizStatus getQuizStatus()
	{
		return this.status.getQuizStatus();
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
		try{
			HoogsteID=this.getHoogsteQuizID();
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
		
		HoogsteID=this.getHoogsteQuizID();
		
		try{
			quizID=bepaalID(quizID);
		} 
		catch (Exception e){
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
		
		String quizOpdrachtenstring = "";
		
		for(QuizOpdracht qo : quizOpdrachten){
			quizOpdrachtenstring = quizOpdrachtenstring + qo.toString();
        }
			
		return "Quiz [quizID= "+ quizID +", onderwerp= " + onderwerp + ", leerjaren= "
				+ Arrays.toString(leerjaren) + ", isTest= " + isTest
				+ ", isUniekeDeelname= " + isUniekeDeelname + ", auteur= "
				+ auteur + ", datumRegistratie= " + datumRegistratie + ", quizstatus= " + getQuizStatus() +
				", quizOpdrachten =" + quizOpdrachtenstring +
				
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
				+ ((getQuizStatus() == null) ? 0 : getQuizStatus().hashCode());
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
		if (getQuizStatus() != other.getQuizStatus())
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
	
	public int getHoogsteQuizID(){
		int hoogsteID = 0;
		try{
			for(Quiz quiz:OpstartController.getQuizCatalogus().quizen){
				if(quiz.getQuizID()>hoogsteID){
					hoogsteID=quiz.getQuizID();
				}
		}
		}catch(NullPointerException ex){
			
		}
		return hoogsteID;
	}
	
	public int bepaalID(Integer id) throws Exception {
		//opdrachtid kontroleren/bepalen
		if(id==0){ //maak nieuwe opdrachtID aan dat hoger is dan elke bestaande id
			HoogsteID++;
			id=HoogsteID;
		} else { // Kontroleer of de opgegeven ID al niet bestaat
			if(OpstartController.getQuizCatalogus().quizen.contains(id)){
				throw new Exception("QuizID moet uniek zijn");
			}
		}
		return id;
	}
}

package model;

import model.QuizOpdracht;
import model.QuizDeelname;

/**
 * 
 * @author wim ombelets
 * @version 20131020-01 initial commit
 * @version 20131101-01 added QuizOpdracht, QuizDeelname - Tom Scheepers
 *
 */
public class OpdrachtAntwoord implements Comparable<OpdrachtAntwoord>, Cloneable {

	//data members

	private String laatsteAntwoord;
	private int aantalPogingen;
	private int antwoordTijd; //in seconden
	private QuizOpdracht quizopdracht;
	private QuizDeelname quizdeelname;
	
	
	//getters & setters
	
	public String getLaatsteAntwoord() {
		return laatsteAntwoord;
	}


	private void setLaatsteAntwoord(String laatsteAntwoord) throws IllegalArgumentException {
		if(laatsteAntwoord == null || laatsteAntwoord.isEmpty())
			throw new IllegalArgumentException("String argument cannot be null or empty.");
		this.laatsteAntwoord = laatsteAntwoord;
	}


	public int getAantalPogingen() {
		return aantalPogingen;
	}


	private void setAantalPogingen(int aantalPogingen) throws IllegalArgumentException {
		if(aantalPogingen < 0)
			throw new IllegalArgumentException("Aantal pogingen moet groter zijn dan 0.");
		this.aantalPogingen = aantalPogingen;
	}


	public int getAntwoordTijd() {
		return antwoordTijd;
	}


	private void setAntwoordTijd(int antwoordTijd) throws IllegalArgumentException {
		if(antwoordTijd < 0)
			throw new IllegalArgumentException("Integer argument cannot be negative.");
		this.antwoordTijd = antwoordTijd;
	}

	public QuizOpdracht getQuizopdracht() {
		return quizopdracht;
	}


	public void setQuizopdracht(QuizOpdracht quizopdracht) {
		this.quizopdracht = quizopdracht;
		this.quizopdracht.OpdrachtAntwoordToevoegen(this);
	}
	
	public QuizDeelname getQuizdeelname() {
		return quizdeelname;
	}


	public void setQuizdeelname(QuizDeelname quizdeelname) {
			this.quizdeelname = quizdeelname;
	}

	//constructors
	
	public OpdrachtAntwoord(String laatsteAntwoord, int aantalPogingen, int antwoordTijd, QuizOpdracht quizopdracht, QuizDeelname quizdeelname){
		setLaatsteAntwoord(laatsteAntwoord);
		setAantalPogingen(aantalPogingen);
		setAntwoordTijd(antwoordTijd);
		setQuizopdracht(quizopdracht);
		setQuizdeelname(quizdeelname);
	}
	
	//overrides
	
	/**
	 * @param obj is a non-null OpdrachtAntwoord
	 * @throws NullPointerException if obj is null
	 */
	public boolean equals(OpdrachtAntwoord obj) {
		if(this == obj)
			return true;
		
		if(!(obj instanceof OpdrachtAntwoord))
			return false;
		
		if(this.aantalPogingen == obj.aantalPogingen 
				&& this.antwoordTijd == obj.antwoordTijd
				&& this.laatsteAntwoord == obj.laatsteAntwoord)
			return true;
		
		return false;
	}
	
	/**
	 * @param obj is a non-null OpdrachtAntwoord
	 * @throws NullPointerException if obj is null
	 */
	public int compareTo(OpdrachtAntwoord obj) {
		
		//nog eens goed nadenken op welke key er hier moet vergeleken worden
		
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		
		if(this == obj)
			return EQUAL;
		
		if(this.aantalPogingen < obj.aantalPogingen)
			return BEFORE;
		
		if(this.aantalPogingen > obj.aantalPogingen)
			return AFTER;
		
		if(this.antwoordTijd < obj.antwoordTijd)
			return BEFORE;
		
		if(this.antwoordTijd > obj.antwoordTijd)
			return AFTER;
		
		if(this.laatsteAntwoord.length() < obj.laatsteAntwoord.length())
			return BEFORE;
		
		if(this.laatsteAntwoord.length() > obj.laatsteAntwoord.length())
			return AFTER;
		
		assert this.equals(obj) : "compareTo inconsistent with equals.";
		
		return EQUAL;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return "laatste antwoord: " + this.laatsteAntwoord
				+ " | " + "aantal pogingen: " + this.aantalPogingen
				+ " | " + "antwoordtijd" + this.antwoordTijd;
	}
	
}

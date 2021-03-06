package model;

import utils.Datum;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 
 * 
 * @version 20131020-01 - modified by Sander Van der Borght - Added constructor
 *
 * Bevat QuizCatalogues informatie
 */
public class QuizDeelname implements Comparable<QuizDeelname>, Cloneable {

	private Leerling leerling;
	private Quiz quiz;
	private Set<OpdrachtAntwoord> antwoorden;
	private Datum datumDeelname;
	
	// Setters & Getters
	
	public Leerling getLeerling() {
		return leerling;
	}
	public void setLeerling(Leerling leerling) {
		this.leerling = leerling;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Datum getDatumDeelname() {
		return datumDeelname;
	}
	
	// Constructors
	
	public QuizDeelname(){
		datumDeelname = new Datum();
		leerling=null;
		quiz=null;
		antwoorden = new HashSet<OpdrachtAntwoord>();
		
	}
	public QuizDeelname(Leerling leerling,Quiz quiz){
		this();
		setLeerling(leerling);
		setQuiz(quiz);
	}	
	
	// Methods
	
	public Boolean OpdrachtAntwoordToevoegen(OpdrachtAntwoord opdrachtantwoord){
		try{
			if (opdrachtantwoord!=null){
				antwoorden.add(opdrachtantwoord);
				return true;
			}
			return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public int compareTo(QuizDeelname other) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
		if(this == other)
			return EQUAL;
		
		//Enkel quizdeelnames van dezelfde leerling worden vergeleken
		if(this.getLeerling() == other.getLeerling()) {
			return this.getDatumDeelname().compareTo(other.getDatumDeelname());
		}
		
		if(this.equals(other))
			return EQUAL;
		
		return EQUAL;
	}
	
}

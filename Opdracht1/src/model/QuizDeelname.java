package model;

import utils.Datum;
/**
 * 
 * @author 
 * 
 * @version 20131020-01 - modified by Sander Van der Borght - Added constructor
 *
 * Bevat QuizCatalogues informatie
 */
public class QuizDeelname {

	private Leerling leerling;
	private Quiz quiz;
	private OpdrachtAntwoord[] antwoorden;
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
	public OpdrachtAntwoord[] getAntwoorden() {
		return antwoorden;
	}
	public void setAntwoorden(OpdrachtAntwoord[] antwoorden) {
		this.antwoorden = antwoorden;
	}
	public Datum getDatumDeelname() {
		return datumDeelname;
	}
	
	// Constructors
	
	public QuizDeelname(){
		datumDeelname = new Datum();
	}
	public QuizDeelname(Leerling leerling,Quiz quiz,OpdrachtAntwoord... antwoorden){
		this();
		setLeerling(leerling);
		setQuiz(quiz);
		setAntwoorden(antwoorden);
	}	
}

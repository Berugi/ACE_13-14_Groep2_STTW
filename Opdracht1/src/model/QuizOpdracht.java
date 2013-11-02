package model;

import java.util.*;
import model.baseclasses.*;

/**
 *
 * Lijst van opdrachten per Quiz met hun respectievelijke maxScore 
 * @author ?
 * @version 20131031-01 : Tom Scheepers - Arraylist<Quiz> omgezet naar enkele variabele quiz
 *
 */

public class QuizOpdracht {
	
	//data members

	private int maxScore;
	//private ArrayList<Quiz> quizzes;
	private Quiz quiz;
	private OpdrachtBase opdracht;
	private Set<OpdrachtAntwoord> opdrachtAntwoorden;
	
	//getters & setters
	
	public int getMaxScore() {
		return maxScore;
	}
	
	private void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	/*
	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}
	
	private void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = new ArrayList<Quiz>(quizzes);
	}
	*/
	
	public OpdrachtBase getOpdracht() {
		return opdracht;
	}
	
	private void setOpdracht(OpdrachtBase opdracht) {
		this.opdracht = opdracht;
	}
	
	public Set<OpdrachtAntwoord> getOpdrachtAntwoorden(){
		return opdrachtAntwoorden;
	}
	
	//constructors
	
	public QuizOpdracht(int maxScore, Quiz quiz, OpdrachtBase opdracht) {
		setMaxScore(maxScore);
		setQuiz(quiz);
		setOpdracht(opdracht);
		this.opdrachtAntwoorden = new HashSet<OpdrachtAntwoord>();
		if (opdracht!=null){
			opdracht.ToevoegenAanQuizOpdrachten(this);
		}
	}
	
	//methods
	
	public int AantalMaalBeantwoord(){
		return opdrachtAntwoorden.size();
	}
	
	public void OpdrachtAntwoordToevoegen(OpdrachtAntwoord opdrachtantwoord){
		if (opdrachtantwoord!=null){
			this.opdrachtAntwoorden.add(opdrachtantwoord);
		}
	}
	
	//...
}

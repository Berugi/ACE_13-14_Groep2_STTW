package model;

import java.util.*;

public class QuizOpdracht {
	
	//data members
	
	private int maxScore;
	private ArrayList<Quiz> quizzes;
	private Opdracht opdracht;
	private Set<OpdrachtAntwoord> opdrachtAntwoorden;
	
	//getters & setters
	
	public int getMaxScore() {
		return maxScore;
	}
	
	private void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}
	
	private void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = new ArrayList<Quiz>(quizzes);
	}
	
	public Opdracht getOpdracht() {
		return opdracht;
	}
	
	private void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}
	
	public Set<OpdrachtAntwoord> getOpdrachtAntwoorden(){
		return opdrachtAntwoorden;
	}
	
	//constructors
	
	public QuizOpdracht(int maxScore, ArrayList<Quiz> quizzes, Opdracht opdracht) {
		setMaxScore(maxScore);
		setQuizzes(quizzes);
		setOpdracht(opdracht);
		this.opdrachtAntwoorden = new HashSet<OpdrachtAntwoord>();
	}
	
	//methods
	
	public int AantalMaalBeantwoord(){
		return opdrachtAntwoorden.size();
	}
	
	//...
}

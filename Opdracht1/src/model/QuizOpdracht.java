package model;

import java.util.*;

public class QuizOpdracht {
	
	//data members
	
	private int maxScore;
	private ArrayList<Quiz> quizzes;
	private Opdracht opdracht;
	
	//getters & setters
	
	protected int getMaxScore() {
		return maxScore;
	}
	
	private void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	protected ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}
	
	private void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = new ArrayList<Quiz>(quizzes);
	}
	
	protected Opdracht getOpdracht() {
		return opdracht;
	}
	
	private void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}
	
	//constructors
	
	public QuizOpdracht(int maxScore, ArrayList<Quiz> quizzes, Opdracht opdracht) {
		setMaxScore(maxScore);
		setQuizzes(quizzes);
		setOpdracht(opdracht);
	}
	
	//methods
	
	//...
}

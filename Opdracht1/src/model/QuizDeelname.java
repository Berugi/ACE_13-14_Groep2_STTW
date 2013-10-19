package model;

import java.util.Set;
import java.util.HashSet;

public class QuizDeelname {

	private Leerling leerling;
	private Quiz quiz;
	private Set antwoorden;
	
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
	public Set getAntwoorden() {
		return antwoorden;
	}
	public void setAntwoorden(Set antwoorden) {
		this.antwoorden = antwoorden;
	}
	
	// Constructors
	
	public QuizDeelname(){
		this.setLeerling(null);
		this.setQuiz(null);
		this.setAntwoorden(new HashSet<OpdrachtAntwoord>());
	}
	
	
}

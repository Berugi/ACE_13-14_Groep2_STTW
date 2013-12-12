package model.decorator.baseclasses;

import model.QuizRapport;
import model.interfaces.IQuizRapport;

public abstract class QuizRapportDecorator implements IQuizRapport {
	
	//data members
	private IQuizRapport quizRapport;
	
	//getters & setters
	public IQuizRapport getQuizRapport() {
		return quizRapport;
	}

	public void setQuizRapport(IQuizRapport quizRapport) {
		this.quizRapport = quizRapport;
	}
	
	//constructor
	public QuizRapportDecorator(IQuizRapport quizRapport) {
		this.setQuizRapport(quizRapport);
	}

	public String toonRapport(QuizRapport q) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
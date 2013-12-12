package model.decorator.baseclasses;

import model.QuizRapport;
import model.interfaces.IQuizRapport;

/**
 * Abstract decorator class for QuizRapport
 * 
 * @author Wim Ombelets
 * @version 20131212-01 - initial commit
 *
 */
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

	public String toonRapport() {
		return quizRapport.toString();
	}

	
	
}
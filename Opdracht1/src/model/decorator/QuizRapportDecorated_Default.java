package model.decorator;

import model.QuizRapport;
import model.decorator.baseclasses.QuizRapportDecorator;
import model.interfaces.IQuizRapport;

/**
 * An example of a decorated QuizRapport class
 * 
 * @author Wim Ombelets
 * @version 20131212-01 - initial commit
 *
 */
public class QuizRapportDecorated_Default extends QuizRapportDecorator {
	
	public QuizRapportDecorated_Default(IQuizRapport quizRapport) {
		super(quizRapport);
	}

	@Override
	public String toonRapport(QuizRapport q) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

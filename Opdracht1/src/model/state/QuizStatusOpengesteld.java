package model.state;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import model.Quiz;
import model.interfaces.IQuizStatus;

/**
 * Concrete implementation of the IQuizStatus interface. 
 * Non-applicable statuses should throw NotImplementedException.
 * 
 * @author Wim Ombelets
 * @version 20131212-01 - initial commit
 *
 */
public class QuizStatusOpengesteld implements IQuizStatus {

	public void zetQuizInINCONSTRUCTIE(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusInConstructie());
	}

	public void zetQuizInAFGEWERKT(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusAfgewerkt());
	}

	public void zetQuizInOPENGESTELD(Quiz quizContext) throws NotImplementedException { }

	public void zetQuiqInLAATSTEKANS(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusLaatsteKans());
	}

}

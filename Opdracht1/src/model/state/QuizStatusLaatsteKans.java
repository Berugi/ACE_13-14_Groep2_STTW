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
public class QuizStatusLaatsteKans implements IQuizStatus {

	public void zetQuizInINCONSTRUCTIE(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusInConstructie());
	}

	public void zetQuizInAFGEWERKT(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusAfgewerkt());
	}

	public void zetQuizInOPENGESTELD(Quiz quizContext) {
		quizContext.setQuizStatus(new QuizStatusOpengesteld());
	}

	public void zetQuiqInLAATSTEKANS(Quiz quizContext) throws NotImplementedException { }

}

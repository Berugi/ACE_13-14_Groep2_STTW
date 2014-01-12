package model.state;

import model.baseclasses.AbstractQuizStatus;
import model.enums.QuizStatus;

/**
 * Represents QuizStatusOpengesteld state
 * 
 * @author Wim Ombelets
 * @version 20131212-01 - initial commit
 * @version 20140112-01 - empty class due to future refactor
 * @version 20140112-02 - extends AbstractQuizStatus
 */
public class QuizStatusOpengesteld extends AbstractQuizStatus {

	@Override
	public QuizStatus getQuizStatus() {
		
		return QuizStatus.OPENGESTELD;
		
	}

}

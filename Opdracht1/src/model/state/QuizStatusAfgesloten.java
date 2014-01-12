package model.state;

import model.baseclasses.AbstractQuizStatus;
import model.enums.QuizStatus;

public class QuizStatusAfgesloten extends AbstractQuizStatus {

	@Override
	public QuizStatus getQuizStatus() {
		
		return QuizStatus.AFGESLOTEN;
		
	}

}

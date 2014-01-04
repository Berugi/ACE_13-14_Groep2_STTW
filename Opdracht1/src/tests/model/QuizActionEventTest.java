package tests.model;

import model.Quiz;
import model.QuizActionEvent;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Wim Ombelets
 * @version 20140104-01 - initial commit
 * 
 */
public class QuizActionEventTest {
	
	private Quiz quiz;

	@Before
	public void setUp() throws Exception {

		quiz = new Quiz();

	}

	@Test
	public void test_setEventData_Geslaagd() {

		new QuizActionEvent(this, 0, "bla", quiz);

	}

	@Test(expected = NullPointerException.class)
	public void test_setEventData_NietGeslaagd_NULL_Quiz() {

		new QuizActionEvent(this, 0, "bla", null);

	}

}

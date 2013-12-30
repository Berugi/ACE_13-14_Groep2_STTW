package tests.controller;

import static org.junit.Assert.*;

import model.Quiz;
import model.QuizOpdracht;
import model.baseclasses.Opdracht;
import model.enums.Leraar;

import org.junit.Before;
import org.junit.Test;

import controller.WijzigQuizController;

public class WijzigQuizControllerTest {

	WijzigQuizController controller;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWijzigQuizController() {
		this.controller = new WijzigQuizController();
	}

	@Test
	public void testWijzigen() {
		this.controller = new WijzigQuizController();
		Quiz quiz = new Quiz("onderwerp", new int[]{1,2}, true,true, Leraar.AN);
		Opdracht opdracht = new Opdracht();
		quiz.quizOpdrachtToevoegen(new QuizOpdracht(10, quiz, opdracht));
		
		this.controller.wijzigen(quiz);
	}

	@Test
	public void testShowView() {
		this.controller = new WijzigQuizController();
		this.controller.showView();
	}

	@Test
	public void testHideView() {
		this.controller = new WijzigQuizController();
		this.controller.hideView();
	}

}

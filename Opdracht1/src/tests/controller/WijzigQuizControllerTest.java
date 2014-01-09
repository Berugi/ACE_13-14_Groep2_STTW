package tests.controller;

import model.Quiz;
import model.QuizOpdracht;
import model.baseclasses.Opdracht;
import model.enums.Leraar;

import org.junit.Before;
import org.junit.Test;

import persistence.enums.ContextType;

import controller.CreatieQuizController;
import controller.WijzigQuizController;

public class WijzigQuizControllerTest {

	WijzigQuizController controller;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWijzigQuizController() {
		this.controller = WijzigQuizController.getInstance(ContextType.LOCALFS);
	}

	@Test
	public void testWijzigen() throws Exception {
		this.controller = WijzigQuizController.getInstance(ContextType.LOCALFS);
		Quiz quiz = new Quiz("onderwerp", new int[]{1,2}, true,true, Leraar.AN);
		Opdracht opdracht = new Opdracht();
		quiz.quizOpdrachtToevoegen(new QuizOpdracht(10, quiz, opdracht));
		
		this.controller.wijzigQuiz(quiz);
	}

	@Test
	public void testShowView() {
		this.controller = WijzigQuizController.getInstance(ContextType.LOCALFS);
		this.controller.showView();
	}

	@Test
	public void testHideView() {
		this.controller = WijzigQuizController.getInstance(ContextType.LOCALFS);
		this.controller.hideView();
	}

}

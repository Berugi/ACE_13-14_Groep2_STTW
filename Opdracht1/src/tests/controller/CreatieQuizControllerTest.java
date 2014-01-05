package tests.controller;

import java.awt.event.ActionEvent;

import org.junit.Test;

import persistence.enums.ContextType;
import controller.CreatieQuizController;

/**
 * @author Wim Ombelets
 * @version 20140105-01 - initial commit
 */
public class CreatieQuizControllerTest {
	
	@Test(expected = NullPointerException.class)
	public void test_actionPerformed_NietGeslaagd_NullArgument() {
		
		CreatieQuizController.getInstance(ContextType.LOCALFS).actionPerformed(null);
		
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_actionPerformed_NietGeslaagd_Ongeldig_Command() {
		
		ActionEvent e = new ActionEvent(this, 0, "bloeblabloebla");
		CreatieQuizController.getInstance(ContextType.LOCALFS).actionPerformed(e);
		
	}

}

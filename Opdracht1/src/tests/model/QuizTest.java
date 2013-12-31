package tests.model;

import org.junit.Before;
import org.junit.Test;

import model.enums.*;
import model.Quiz;

public class QuizTest {
	
	private Quiz quiz;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void test_setOnderwerp_Geldige_Waarde(){
		String onderwerp = "test";
		int[] leerjaren = new int[]{1,2,3};
		boolean isTest = true;
		boolean isUniekeDeelname = false;
		Leraar auteur = Leraar.JEAN;
		
		quiz = new Quiz(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_setOnderwerp_Ongeldige_Null_Waarde(){
		String onderwerp = null;
		int[] leerjaren = new int[]{1,2,3};
		boolean isTest = true;
		boolean isUniekeDeelname = false;
		Leraar auteur = Leraar.JEAN;
		
		quiz = new Quiz(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_setOnderwerp_Ongeldige_Empty_Waarde(){
		String onderwerp = "";
		int[] leerjaren = new int[]{1,2,3};
		boolean isTest = true;
		boolean isUniekeDeelname = false;
		Leraar auteur = Leraar.JEAN;
		
		quiz = new Quiz(onderwerp, leerjaren, isTest, isUniekeDeelname, auteur);
	}

}

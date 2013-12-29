package tests.model;

import static org.junit.Assert.*;

import java.util.Random;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;

import utils.Datum;

/**
 * 
 * @author wim
 * @version 20131215 - modified by Tom Vaes - added test routines
 * 
 */
public class QuizCatalogusTest {

	private QuizCatalogus catalogus; 
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		this.catalogus = new QuizCatalogus();
	}

	
	@Test
	public void test_QuizCatalogus_Geslaagd() {
		this.catalogus = new QuizCatalogus();
	}
	
	
	@Test
	public void test_Add_Lege_Quiz_Geslaagd() {
		Quiz QuizTest = new Quiz();
		
		//assertEquals(true,this.quizCatalogus.add(quizTest);
		
	}
	
	@Test
	public void test_wegschrijvenAlsTekstbestand_Geslaagd() throws Exception {
		
		this.catalogus = new QuizCatalogus();
		
		//catalogus wordt gevuld met 60 willekeurige opdrachten
		for(int j = 0;j<60;j++){
			String onderwerp = "";
			for(int i =0;i < generator.nextInt(120);i++){
				onderwerp += Character.toString(((char) (generator.nextInt(20)+98)));
			}
			int[] leerjaren = new int[]{1,2,3};
			
			this.catalogus.add(new Quiz(onderwerp, leerjaren, true,true, Leraar.AN));
						
		}
		
		this.catalogus.wegschrijvenAlsTekstbestand("testquiz.txt");
		
		assertEquals(this.catalogus.change(0).getOnderwerp(),new QuizCatalogus("testquiz.txt").change(0).getOnderwerp());
	}
	
}

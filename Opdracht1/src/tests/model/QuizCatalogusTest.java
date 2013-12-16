package tests.model;

import static org.junit.Assert.*;

import java.util.Random;

import model.Quiz;
import model.QuizCatalogus;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author wim
 *
 */
public class QuizCatalogusTest {

	private QuizCatalogus quizCatalogus; 
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		this.quizCatalogus = new QuizCatalogus();
	}

	
	@Test
	public void test_QuizCatalogus_Geslaagd() {
		this.quizCatalogus = new QuizCatalogus();
	}
	
	
	@Test
	public void test_Add_Lege_Quiz_Geslaagd() {
		assertEquals(true,this.quizCatalogus.add(new Quiz()));
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
}

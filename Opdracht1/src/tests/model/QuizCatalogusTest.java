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
		private Quiz QuizTest = new Quiz();
		
		//assertEquals(true,this.quizCatalogus.add(quizTest);
		
	}
	
	@Test
	public void test_wegschrijvenAlsTekstbestand_Geslaagd() throws Exception {
		
		this.catalogus = new QuizCatalogus();
		
		//catalogus wordt gevuld met 60 willekeurige opdrachten
		for(int j = 0;j<60;j++){
			String vraag = "";
			for(int i =0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) (generator.nextInt(20)+98)));
			}
			String juisteAntwoord = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				juisteAntwoord += Character.toString(((char) (generator.nextInt(20)+98)));
			}
			int maxAantalPogingen = generator.nextInt(120);
			int maxAntwoordTijd = generator.nextInt(120);
			Leraar auteur = Leraar.AN;
			OpdrachtCategorie categorie = OpdrachtCategorie.AARDRIJKSKUNDE;
			String antwoordHints = "";
			for(int i= 0;i < generator.nextInt(120);i++){
				antwoordHints += Character.toString(((char) (generator.nextInt(20)+98)));
			}
			String antwoordHints2 = "";
			for(int i= 0;i < generator.nextInt(120);i++){
				antwoordHints2 += Character.toString(((char) (generator.nextInt(20)+98)));
			}		
			this.catalogus.add(new Quiz(vraag, juisteAntwoord, maxAantalPogingen,maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2));
		}
		
		this.catalogus.wegschrijvenAlsTekstbestand("testquiz.txt");
		
		assertEquals(this.catalogus.change(0).getVraag(),new OpdrachtCatalogus("testquiz.txt").change(0).getVraag());
	}
	
}

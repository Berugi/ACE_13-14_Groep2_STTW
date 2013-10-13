package tests;
import model.OpdrachtCatalogus;
import model.Opdracht;

import static org.junit.Assert.*;

import java.util.Random;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;


public class OpdrachtCatalogusTest {

	private OpdrachtCatalogus catalogus; 
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		this.catalogus = new OpdrachtCatalogus();
	}

	@Test
	public void testOpdrachtCatalogus() {
		fail("Not yet implemented");
	}

	@Test
	public void testOpdrachtCatalogusArrayListOfOpdracht() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOpdracht() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCatalogus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCatalogus() {
		fail("Not yet implemented");
	}

	@Test
	public void test_Add_Lege_Opdracht_Geslaagd() {
		assertEquals(true,this.catalogus.add(new Opdracht()));
		
	}
	@Test
	public void test_Add_Geldige_Opdracht_Geslaagd() {
		for(int j = 0;j<60;j++){
			String vraag = "";
			for(int i =0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) generator.nextInt()));
			}
			String juisteAntwoord = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				juisteAntwoord += Character.toString(((char) generator.nextInt()));
			}
			int maxAantalPogingen = generator.nextInt(120);
			int maxAntwoordTijd = generator.nextInt(120);
			Leraar auteur = Leraar.values()[generator.nextInt(4)];
			OpdrachtCategorie categorie = OpdrachtCategorie.values()[generator.nextInt(4)];
			String antwoordHints = "";
			for(int i= 0;i < generator.nextInt(120);i++){
				antwoordHints += Character.toString(((char) generator.nextInt()));
			}
			String antwoordHints2 = "";
			for(int i= 0;i < generator.nextInt(120);i++){
				antwoordHints2 += Character.toString(((char) generator.nextInt()));
			}
			
			assertEquals(true,this.catalogus.add(new Opdracht(vraag, juisteAntwoord, maxAantalPogingen,	maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2)));
		}
	}
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeInt1() {
		fail("Not yet implemented");
	}

}

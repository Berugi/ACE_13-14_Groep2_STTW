package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.enums.OpdrachtCategorie;

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
	public void test_OpdrachtCatalogus_Geslaagd() {
		this.catalogus = new OpdrachtCatalogus();
	}

	@Test
	public void test_OpdrachtCatalogus_Geldige_ArrayListOfOpdracht_Geslaagd() {
		ArrayList<Opdracht> testCatalogus = new ArrayList<Opdracht>();
		
		//testCatalogus wordt gevuld met 60 willekeurige opdrachten
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
			testCatalogus.add(new Opdracht(vraag, juisteAntwoord, maxAantalPogingen,maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2));
		}
		this.catalogus = new OpdrachtCatalogus(testCatalogus);
	}
	
	@Test
	public void test_Change_Geldige_Int_Geslaagd() {
		this.catalogus = new OpdrachtCatalogus();
		ArrayList<Opdracht> testCatalogus = new ArrayList<Opdracht>();
		
		//testCatalogus wordt gevuld met 60 willekeurige opdrachten
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
			testCatalogus.add(new Opdracht(vraag, juisteAntwoord, maxAantalPogingen,maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2));
		}
		this.catalogus = new OpdrachtCatalogus(testCatalogus);
		int index = generator.nextInt(60);
		assertTrue(testCatalogus.get(index) == this.catalogus.change(index));
	}

	@Test
	public void test_GetOpdracht() {
		fail("Not yet implemented");
	}

	@Test
	public void test_GetCatalogus() {
		fail("Not yet implemented");
	}

	@Test
	public void test_SetCatalogus() {
		fail("Not yet implemented");
	}

	@Test
	public void test_Add_Lege_Opdracht_Geslaagd() {
		assertEquals(true,this.catalogus.add(new Opdracht()));
		
	}
	@Test
	public void test_Add_Geldige_Opdracht_Geslaagd() {
		this.catalogus = new OpdrachtCatalogus();
		//catalogus wordt gevuld met 60 willekeurige opdrachten
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
	public void test_Remove_Geldige_Opdracht_Geslaagd() {
		this.catalogus = new OpdrachtCatalogus();
		
		//catalogus wordt gevuld met 60 willekeurige opdrachten
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
			this.catalogus.add(new Opdracht(vraag, juisteAntwoord, maxAantalPogingen,maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2));
		}
		//willekeurige opdracht wordt verwijderd
		int index = generator.nextInt(60);
		assertEquals(true,this.catalogus.remove(this.catalogus.change(index)));
	}

	@Test
	public void test_Remove_Ongeldige_Opdracht_Niet_Geslaagd() {
		this.catalogus = new OpdrachtCatalogus();
		
		//catalogus wordt gevuld met 60 willekeurige opdrachten
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
			this.catalogus.add(new Opdracht(vraag, juisteAntwoord, maxAantalPogingen,maxAntwoordTijd, auteur, categorie,	antwoordHints,antwoordHints2));
		}
		assertEquals(false,this.catalogus.remove(new Opdracht("testvraag", "testantwoord", 1,1, Leraar.An, OpdrachtCategorie.AlgemeneKennis,	"Hint")));
	}

}

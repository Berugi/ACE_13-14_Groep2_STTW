package tests.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import model.MeerKeuzeOpdracht;
import model.Opsomming;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;

public class OpsommingTest {

	private Opsomming opsomming;
	private Random generator = new Random();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_Opsomming() {
		this.opsomming = new Opsomming();
	}

	@Test
	public void test_Opsomming_Geldige_Waarden_Geslaagd() {
		for(int k = 0;k<10;k++){
			String opsomming = "test";
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				opsomming += ";"+keuze;
			}
			String vraag = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) generator.nextInt()));
			}
			String juisteAntwoord = opsomming;
			int maxAantalPogingen = generator.nextInt(20)+1;
			int maxAntwoordTijd = generator.nextInt(100)+1;
			Leraar auteur = Leraar.values()[generator.nextInt(4)+1];
			OpdrachtCategorie categorie = OpdrachtCategorie.values()[generator.nextInt(4)];
			
			String antwoordHints = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints += Character.toString(((char) generator.nextInt()));
			}
			String antwoordHints2 = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints2 += Character.toString(((char) generator.nextInt()));
			}		
					
			this.opsomming = new Opsomming(vraag, juisteAntwoord,
					maxAantalPogingen, maxAntwoordTijd, auteur,
					categorie, antwoordHints,antwoordHints2);
		}
	}

	@Test
	public void test_GetValideerTekst_Geslaagd() {
		this.opsomming = new Opsomming();
		assertEquals(true,this.opsomming.getValideerTekst().getClass().equals(String.class));
	}

	@Test
	public void test_IsJuisteVolgorde_Geldige_Waarde_Geslaagd() {
		for(int k = 0;k<10;k++){
			String opsomming = "test";
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				opsomming += ";"+keuze;
			}
			String vraag = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) generator.nextInt()));
			}
			String juisteAntwoord = opsomming;
			int maxAantalPogingen = generator.nextInt(20)+1;
			int maxAntwoordTijd = generator.nextInt(100)+1;
			Leraar auteur = Leraar.values()[generator.nextInt(4)+1];
			OpdrachtCategorie categorie = OpdrachtCategorie.values()[generator.nextInt(4)];
			
			String antwoordHints = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints += Character.toString(((char) generator.nextInt()));
			}
			String antwoordHints2 = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints2 += Character.toString(((char) generator.nextInt()));
			}		
					
			this.opsomming = new Opsomming(vraag, juisteAntwoord,
					maxAantalPogingen, maxAntwoordTijd, auteur,
					categorie, antwoordHints,antwoordHints2);
			
			assertEquals(true,this.opsomming.isJuisteVolgorde(juisteAntwoord));
		}
	}

	@Test
	public void test_IsJuist_Geldige_Waarde_Geslaagd() {
		for(int k = 0;k<10;k++){
			String opsomming = "test";
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				opsomming += ";"+keuze;
			}
			String vraag = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) generator.nextInt()));
			}
			String juisteAntwoord = opsomming;
			int maxAantalPogingen = generator.nextInt(20)+1;
			int maxAntwoordTijd = generator.nextInt(100)+1;
			Leraar auteur = Leraar.values()[generator.nextInt(4)+1];
			OpdrachtCategorie categorie = OpdrachtCategorie.values()[generator.nextInt(4)];
			
			String antwoordHints = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints += Character.toString(((char) generator.nextInt()));
			}
			String antwoordHints2 = "";
			for(int i= 0;i < generator.nextInt(120)+1;i++){
				antwoordHints2 += Character.toString(((char) generator.nextInt()));
			}		
					
			this.opsomming = new Opsomming(vraag, juisteAntwoord,
					maxAantalPogingen, maxAntwoordTijd, auteur,
					categorie, antwoordHints,antwoordHints2);
			
			assertEquals(true,this.opsomming.isJuist(juisteAntwoord));
		}
	}

	@Test
	public void test_IsValide_Geldige_Waarde_Geslaagd() {
		for(int k = 0;k<10;k++){
			String opsomming = "test";
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				opsomming += ";"+keuze;
			}
			
						
			String juisteAntwoord = opsomming;
			
			this.opsomming = new Opsomming("", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			
			assertEquals(true,this.opsomming.isValide(juisteAntwoord));
		}
	}

}

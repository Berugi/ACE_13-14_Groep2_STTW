package tests.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import model.MeerKeuze;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Sander van der Borght
 * 
 * Bevat testen voor klasse meerkeuze
 */
public class MeerKeuzeTest {

	private MeerKeuze meerkeuzevraag;
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_MeerKeuze() {
		this.meerkeuzevraag = new MeerKeuze();
	}

	@Test
	public void test_MeerKeuze_Geldige_Waarden_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			String vraag = "";
			for(int i = 0;i < generator.nextInt(120);i++){
				vraag += Character.toString(((char) generator.nextInt()));
			}
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
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
					
			this.meerkeuzevraag = new MeerKeuze(keuzes,vraag, juisteAntwoord,
					maxAantalPogingen, maxAntwoordTijd, auteur,
					categorie, antwoordHints,antwoordHints2);
		}
	}

	@Test
	public void test_GetKeuzes_Geldige_Waarden_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
					
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", "",
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			
			assertEquals(true,keuzes == meerkeuzevraag.getKeuzes());
		}
	}

	@Test
	public void test_SetKeuzes_Geldige_Waarden_Geslaagd() {
		for(int k = 0;k<10;k++){
			this.meerkeuzevraag = new MeerKeuze();
			
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			
			meerkeuzevraag.setKeuzes(keuzes);
			assertEquals(true,keuzes == meerkeuzevraag.getKeuzes());
		}
	}

	@Test
	public void test_GetValideerTekst_Geslaagd() {
		assertEquals(true,meerkeuzevraag.getValideerTekst().getClass().equals(String.class));
	}

	@Test
	public void test_IsJuisteTekst_Geldige_Waarden_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
			
					
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			assertEquals(true,meerkeuzevraag.isJuisteTekst(juisteAntwoord));
		}
	}
	
	@Test
	public void test_IsJuisteTekst_Ongeldige_Waarden_Niet_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
			
			String fouteAntwoord = "";
			do{
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					fouteAntwoord += Character.toString(((char) generator.nextInt()));
				}
			}while(fouteAntwoord == juisteAntwoord);
					
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			assertEquals(false,meerkeuzevraag.isJuisteTekst(fouteAntwoord));
		}
	}

	@Test
	public void test_IsJuisteKeuze_Geldige_Int_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			int keuze = generator.nextInt(keuzes.size())+1;
			String juisteAntwoord = keuzes.get(keuze-1);	
			
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			assertEquals(true,meerkeuzevraag.isJuisteKeuze(keuze));
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_IsJuisteKeuze_Ongeldige_Int_Niet_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			int keuze;
			do{
				keuze = generator.nextInt(1000);
			}while(keuze>0 || keuze < keuzes.size()+1);
			
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
			
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
		}
	}

	@Test
	public void test_IsValide_Geldige_Int_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			int keuze = generator.nextInt(keuzes.size())+1;
						
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
			
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			
			assertEquals(true,meerkeuzevraag.isValide(keuze));
		}
	}

	@Test
	public void test_IsValide_Ongeldige_Int_Niet_Geslaagd() {
		for(int k = 0;k<10;k++){
			ArrayList<String> keuzes = null;
			
			for(int i = 0;i < generator.nextInt(120)+1;i++){
				String keuze = "";
				for(int j = 0;j < generator.nextInt(120)+1;j++){
					keuze += Character.toString(((char) generator.nextInt()));
				}
				keuzes.add(keuze);
			}
			int keuze;
			do{
				keuze = generator.nextInt(1000);
			}while(keuze>0 || keuze < keuzes.size()+1);
						
			String juisteAntwoord = keuzes.get(generator.nextInt(keuzes.size()));
			
			this.meerkeuzevraag = new MeerKeuze(keuzes,"", juisteAntwoord,
					1, 1, Leraar.An,
					OpdrachtCategorie.AlgemeneKennis, "");
			
			assertEquals(false,meerkeuzevraag.isValide(keuze));
		}
	}
}

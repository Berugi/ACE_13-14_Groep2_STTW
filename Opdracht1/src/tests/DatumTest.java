
package tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import utils.Datum;

public class DatumTest {

	private Datum datum;
	private int[] dagenPerMaand = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		datum = new Datum();
	}
	
	@Test
	public void test_Datum_Aanmaken_Geslaagd() {
		datum = new Datum();
	}
	
	@Test
	public void test_DatumIntIntInt_Geldige_Waarden_200_Jaren_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt(3000);
					
					datum = new Datum(j, i, jaar);			
				}
			}
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_DatumIntIntInt_OnGeldige_Waarden_Exception() {
		for(int i = 1; i<=12;i++){
			int dag;
			int maand;
			int jaar;
			
			do{
				dag = generator.nextInt();
			}while(dag >0 && dag<32);
			do{
				maand = generator.nextInt();
			}while(maand > 0 && maand < 13);
			jaar = -(generator.nextInt(3000));
			
			datum = new Datum(dag, maand, jaar);		
		}
	}
	
	@Test
	public void test_DatumDatum_Geldige_Waarden_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt(3000);
					
					datum = new Datum(new Datum(j, i, jaar));			
				}
			}
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_DatumDatum_OnGeldige_Waarden_Exception() {
		for(int i = 0; i<200;i++){
			int dag;
			int maand;
			int jaar;
			
			do{
				dag = generator.nextInt();
			}while(dag >0 && dag<32);
			do{
				maand = generator.nextInt();
			}while(maand > 0 && maand < 13);
			jaar = -generator.nextInt(3000);
			
			datum = new Datum(new Datum(dag, maand, jaar));		
		}
	}

	@Test
	public void test_DatumString_Geldige_Waarden_Aanvaard() throws IllegalArgumentException, ParseException {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					String dag = Integer.toString(j);					
					if(dag.length() == 1){
						dag = "0"+dag;
					}
					String maand = Integer.toString(i);					
					if(maand.length() == 1){
						maand = "0"+maand;
					}
					
					String jaar = Integer.toString(generator.nextInt(3000));
					while(jaar.length() < 4){
						jaar = "0"+jaar;					
					}					
					
					char sign = (char) generator.nextInt();
					
					datum = new Datum(dag +sign+ maand+sign+jaar.substring(0, 4));			
				}
			}
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_DatumString_Ongeldige_Waarden_Exception() throws IllegalArgumentException, ParseException {
		for(int i = 0; i<200;i++){
			int dag;
			int maand;
			int jaar;
			
			do{
				dag = generator.nextInt();
			}while(dag >0 && dag<32);
			do{
				maand = generator.nextInt();
			}while(maand > 0 && maand < 13);
			jaar = -(generator.nextInt(3000));
			
			String sign = Character.toString(((char) generator.nextInt()));
			
			datum = new Datum(dag +sign+ maand+sign+jaar);
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_DatumString_Ongeldige_Lengte_Exception() throws IllegalArgumentException, ParseException {
		for(int i = 0; i<20;i++){
			String string = "";
			do{
				for(int j = generator.nextInt(20);j >1;j--){
					string += (char) generator.nextInt();				
				}	
			}while(string.length() == 10);
			
			datum = new Datum(string);
		}
	}
	
	@Test
	public void test_SetDatum_Geldige_Waarden_Geslaagd() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt(3000);
					
					datum.setDatum(j, i, jaar);			
				}
			}
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_SetDatum_50_Ongeldige_Dagen_Per_Maand_Exception() {
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= 200;j++){
				
				int dag;
				int jaar = generator.nextInt(3000);
				do{
					dag = generator.nextInt();
				}while(dag >0 && dag<32);
				
				datum.setDatum(dag, i, jaar);
			}
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_SetDatum_200_Ongeldige_Maanden_Exception() {
		
		for(int i = 0; i<200;i++){
		
			int dag = generator.nextInt(28)+1;
			int maand;
			int jaar = generator.nextInt(3000);
			
			do{
				maand = generator.nextInt();
			}while(maand > 0 && maand < 13);
			
			datum.setDatum(dag, maand, jaar);
			
		}
	}
	@Test
	public void test_SetDatum_Schrikkeljaren_29_Februari_Geslaagd() {
		
		for(int i = 0; i<200;i++){
		
			int dag = 29;
			int maand = 2;
			int jaar;
			
			do{
				jaar = generator.nextInt(200000)*4;
			}while(jaar % 100 ==0 && jaar % 400 != 0 );
			
			datum.setDatum(dag, maand, jaar);
			
		}
	}
	
	@Test
	public void test_GetDag_Geldige_Waarden_Aanvaard() {
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				int jaar = generator.nextInt(3000);
				
				datum = new Datum(j, i, jaar);
				assertEquals(j,datum.getDag());
			}
		}
	}	

	@Test
	public void test_GetMaand_Geldige_Waarden_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				int jaar = generator.nextInt(3000);
				
				datum = new Datum(j, i, jaar);
				assertEquals(i,datum.getMaand());
			}
		}
	}

	@Test
	public void test_GetJaar_200_Geldige_Waarden_Aanvaard() {
		for(int i = 0;i<200;i++){
			int jaar = generator.nextInt(3000);
			int maand = generator.nextInt(12)+1;
			int dag = generator.nextInt(dagenPerMaand[maand])+1;
			
			datum = new Datum(dag, maand, jaar);
			assertEquals(jaar,datum.getJaar());
		}
	}


	

	@Test
	public void test_GetDatumInAmerikaansFormaat_Geldige_Waarden_Geslaagd() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int dag = j;
					int maand = i;
					int jaar = generator.nextInt(3000);
					
					datum = new Datum(j, i, jaar);	
					String[] string = {"","",""};
					
					if(datum.getDatumInAmerikaansFormaat().contains("/")){
						string = datum.getDatumInAmerikaansFormaat().split("/");
					}else if(datum.getDatumInAmerikaansFormaat().contains("-")){
						string = datum.getDatumInAmerikaansFormaat().split("-");
					}else{
						fail("No char '/' or '-' found!");
					}
					assertEquals(jaar,Integer.parseInt(string[0]));
					assertEquals(maand,Integer.parseInt(string[1]));
					assertEquals(dag,Integer.parseInt(string[2]));
				}
			}
		}
		
	}

	@Test
	public void test_GetDatumInEuropeesFormaat_Geldige_Waarden_Geslaagd() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int dag = j;
					int maand = i;
					int jaar = generator.nextInt(3000);
					
					datum = new Datum(j, i, jaar);	
					String[] string = {"","",""};
					
					if(datum.getDatumInEuropeesFormaat().contains("/")){
						string = datum.getDatumInEuropeesFormaat().split("/");
					}else if(datum.getDatumInEuropeesFormaat().contains("-")){
						string = datum.getDatumInEuropeesFormaat().split("-");
					}else{
						fail("No char '/' or '-' found!");
					}
					assertEquals(dag,Integer.parseInt(string[0]));
					assertEquals(maand,Integer.parseInt(string[1]));
					assertEquals(jaar,Integer.parseInt(string[2]));
				}
			}
		}
	}

	@Test
	public void test_ToString_Geldige_Waarden_Geslaagd() {
		String[] maanden = {"januari","februari","maart","april","mei","juni","juli","augustus","september","oktober","november","december"};
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int dag = j;
					int maand = i;
					int jaar = generator.nextInt(3000);
					
					datum = new Datum(j, i, jaar);	
					
					String [] string = datum.toString().split(" ");
					
					assertEquals(dag,Integer.parseInt(string[0]));
					assertEquals(maanden[maand-1],string[1].toLowerCase());
					assertEquals(jaar,Integer.parseInt(string[2]));
				}
			}
		}
	}

	@Test
	public void test_EqualsObject_Gelijke_Waarden_Geslaagd() {
		Datum datum2 = new Datum();
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt(3000);
					
					datum.setDatum(j, i, jaar);	
					datum2.setDatum(j, i, jaar);
					assertTrue(datum.equals(datum2));
				}
			}
		}	
	}
	@Test
	public void test_EqualsObject_Ongelijke_Waarden_Geslaagd() {
		Datum datum2 = new Datum();
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
			
				int jaar = generator.nextInt(3000);
				
				datum.setDatum(j, i, jaar);
				
				for(int k = 1; k<=12;k++){
					for(int l = 1;l<= dagenPerMaand[k];l++){						
						int jaar2 = generator.nextInt();
						
						if(k!=i || l!=j || jaar!=jaar2){
							datum2.setDatum(l, k, jaar2);
							assertFalse(datum.equals(datum2));
						}
						
						
					}
				}
				
			}
		}
	}
	

	@Test
	public void test_CompareTo_Tweede_Datum_Groter_Geslaagd() {
		Datum datum2 = new Datum();

		
		for(int i = 0; i<50;i++){
						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt(3000);
					
			datum.setDatum(dag, maand, jaar);
							
			int dag2;
			do{
				dag2 = dag + generator.nextInt(27);
			}while(dag2 > 28);
			
			int maand2;
			
			do{
				maand2 = maand + generator.nextInt(11);
			}while(maand2 > 12);

			
			int jaar2 = jaar + generator.nextInt(3000);
						
			if(dag!=dag2 || maand!=maand2 || jaar!=jaar2){
				datum2.setDatum(dag2, maand2, jaar2);
				assertTrue(datum.compareTo(datum2)>0);
			}
		}			
	}
	
	@Test
	public void test_CompareTo_Tweede_Datum_Kleiner_Geslaagd() {
		Datum datum2 = new Datum();
		
		for(int i = 0; i<50;i++){
						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt(3000);
					
			datum.setDatum(dag, maand, jaar);
							
			int dag2;
			do{
				dag2 = dag - generator.nextInt(27);
			}while(dag2 < 1);
			
			int maand2;
			
			do{
				maand2 = maand - generator.nextInt(11);
			}while(maand2 < 1);




			
			int jaar2 = jaar - generator.nextInt(3000);
						
			if(dag!=dag2 || maand!=maand2 || jaar!=jaar2){
				datum2.setDatum(dag2, maand2, jaar2);
				assertTrue(datum.compareTo(datum2)<0);

			}
		}			
	}
	
	@Test
	public void test_CompareTo_Data_Gelijk_Geslaagd() {
		Datum datum2 = new Datum();
		//fail("Takes too long!");
		for(int i = 0; i<50;i++){
						
			int dag = generator.nextInt(27)+1;
			int maand = generator.nextInt(11)+1;
			int jaar = generator.nextInt(3000);
					
			datum.setDatum(dag, maand, jaar);
						
			datum2.setDatum(dag, maand, jaar);
			
			assertTrue(datum.compareTo(datum2)==0);			
		}			
	}

	@Test
	public void test_KleinerDan_Geldige_Waarden_True() {
		Datum datum2 = new Datum();
		
		for(int i = 0; i<20;i++){
						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt(2000);
					
			datum.setDatum(dag, maand, jaar);
			
			int dag2;
			do{
				dag2 = dag + generator.nextInt(27);
			}while(dag2 > 28);
			int maand2;
			do{
				maand2 = maand + generator.nextInt(11);
			}while(maand2 > 12);
			int jaar2;
			do{
				jaar2 = jaar + generator.nextInt(2000);
			}while(jaar2 < jaar);
						
			datum2.setDatum(dag2, maand2, jaar2);



			
			//fail(datum.getDatumInAmerikaansFormaat() +" "+datum2.getDatumInAmerikaansFormaat());
			assertEquals(false,datum.kleinerDan(datum2));

		}			


	}

	@Test
	public void test_KleinerDan_Geldige_Waarden_False() {
		Datum datum2 = new Datum();
		
		for(int i = 0; i<20;i++){
						
			int dag = generator.nextInt(27)+1;
			int maand = generator.nextInt(11)+1;
			int jaar = generator.nextInt(2000);
					
			datum.setDatum(dag, maand, jaar);
			
			int dag2;
			do{
				dag2 = dag - generator.nextInt(27)+1;
			}while(dag2 <1);
			int maand2;
			do{
				maand2 = maand - generator.nextInt(11)+1;
			}while(maand2 < 1 || maand2 > 12);
			int jaar2;
			do{
				jaar2 = jaar - generator.nextInt(2000);
			}while(jaar2 > jaar);
						
			datum2.setDatum(dag2, maand2, jaar2);
			
			//fail(datum.getDatumInAmerikaansFormaat() +" "+datum2.getDatumInAmerikaansFormaat());
			assertEquals(true,datum.kleinerDan(datum2));
			
		}	
	}
	
	@Test
	public void test_VerschilInJaren_Geldige_Waarden_Geslaagd() {
		Datum datum2 = new Datum();

		
		for(int i = 0; i<50;i++){
						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt(3000);
					
			datum.setDatum(dag, maand, jaar);
							
			int dag2;
			int maand2;
			int jaar2;
			do{
				dag2 = generator.nextInt(28)+1;
				maand2 = generator.nextInt(12)+1;
				jaar2 = generator.nextInt(3000);
			}while(jaar==jaar2 && maand==maand2 && jaar==jaar2);
			
			datum2.setDatum(dag2, maand2, jaar2);
			
			int verschilInJaren = (int)(datum2.getDatumInAantalDagen() - datum.getDatumInAantalDagen())/365;
			if(verschilInJaren < 0){
				verschilInJaren = -verschilInJaren;
			}
			assertEquals(verschilInJaren,datum.verschilInJaren(datum2));			
		}		
	}
	
	@Test
	public void test_VerschilInMaanden_Geldige_Waarden_Geslaagd() {
		Datum datum2 = new Datum();
		
		for(int i = 0; i<50;i++){
						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt();
					
			datum.setDatum(dag, maand, jaar);
			
			int dag2;
			int maand2;
			int jaar2;
			do{
				dag2 = generator.nextInt(28)+1;
				maand2 = generator.nextInt(12)+1;
				jaar2 = generator.nextInt();
			}while(jaar==jaar2 && maand==maand2 && jaar==jaar2);
			
			
			datum2.setDatum(dag2, maand2, jaar2);
			
			int verschilInMaanden = (int)((double)(datum2.getDatumInAantalDagen() - datum.getDatumInAantalDagen())/(365/12));
			if(verschilInMaanden < 0){
				verschilInMaanden = -verschilInMaanden;
			}
			assertEquals(verschilInMaanden,datum.verschilInMaanden(datum2));

			
		}		
	}
	
	@Test
	public void test_VerschilInDagen_Geldige_Waarden_Geslaagd() {
		Datum datum2 = new Datum();
		
		for(int i = 0; i<50;i++){

						
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt();
					
			datum.setDatum(dag, maand, jaar);
			
			int dag2;
			int maand2;
			int jaar2;
			
			do{
				dag2 = generator.nextInt(28)+1;
				maand2 = generator.nextInt(12)+1;
				jaar2 = generator.nextInt();
			}while(jaar==jaar2 && maand==maand2 && jaar==jaar2);
			
			

			datum2.setDatum(dag2, maand2, jaar2);
			
			int verschilInDagen = datum2.getDatumInAantalDagen() - datum.getDatumInAantalDagen();
			if(verschilInDagen < 0){
				verschilInDagen = -verschilInDagen;
			}
			assertEquals(verschilInDagen,datum.verschilInDagen(datum2));
		}

	}

	@Test
	public void test_VeranderDatum_Void_Geldige_Waarden_Geslaagd() {
		for(int i = 0; i<50;i++){
			int jaar = generator.nextInt();
			int maand = generator.nextInt(12)+1;
			int dag = generator.nextInt(dagenPerMaand[maand])+1;
							
			datum.setDatum(dag, maand, jaar);
			Datum datum2 = new Datum(dag, maand, jaar);
			
			int aantalDagen = generator.nextInt();
			
			datum.veranderDatum(aantalDagen);
			assertEquals(aantalDagen,datum2.getDatumInAantalDagen()-datum.getDatumInAantalDagen());
		}
	}
	

	@Test
	public void test_VeranderDatum_Datum_Geldige_Waarden_Geslaagd() {
		for(int i = 0; i<50;i++){
			int jaar = generator.nextInt();
			int maand = generator.nextInt(12)+1;
			int dag = generator.nextInt(dagenPerMaand[maand])+1;
					
			datum.setDatum(dag, maand, jaar);
			
			int aantalDagen = generator.nextInt();
			
			Datum datum2 =  datum.veranderDatumObject(aantalDagen);
			
			assertEquals(aantalDagen,datum2.getDatumInAantalDagen()-datum.getDatumInAantalDagen());
		}


	}

}

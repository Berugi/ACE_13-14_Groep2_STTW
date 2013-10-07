package Datum;

import static org.junit.Assert.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class DatumTest {

	private Datum datum;
	private int[] dagenPerMaand = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		datum = new Datum();
	}
	
	@Test
	public void test_Datum() {
		datum = new Datum();
	}
	
	@Test
	public void test_DatumIntIntInt_Geldige_Waarden_200_Jaren_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt();
					
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
			jaar = -(generator.nextInt());
			
			datum = new Datum(dag, maand, jaar);		
		}
	}
	
	@Test
	public void test_DatumDatum_Geldige_Waarden_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				for(int k = 0;k<20;k++){
					int jaar = generator.nextInt();
					
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
			jaar = -generator.nextInt();
			
			datum = new Datum(new Datum(dag, maand, jaar));		
		}
	}

	@Test
	public void test_DatumString_Geldige_Waarden_Aanvaard() {
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
					
					String jaar = Integer.toString(generator.nextInt());
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
	public void test_DatumString_Ongeldige_Waarden_Exception() {
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
			jaar = -(generator.nextInt());
			
			String sign = Character.toString(((char) generator.nextInt()));
			
			datum = new Datum(dag +sign+ maand+sign+jaar);
		}
	}
	@Test (expected = IllegalArgumentException.class)
	public void test_DatumString_Ongeldige_Lengte_Exception() {
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
					int jaar = generator.nextInt();
					
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
				int jaar = generator.nextInt();
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
			int jaar = generator.nextInt();
			
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
				jaar = generator.nextInt()*4;
			}while(jaar % 100 ==0 && jaar % 400 != 0 );
			
			datum.setDatum(dag, maand, jaar);
			
		}
	}
	
	@Test
	public void test_GetDag_Geldige_Waarden_Aanvaard() {
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				int jaar = generator.nextInt();
				
				datum = new Datum(j, i, jaar);
				assertEquals(j,datum.getDag());
			}
		}
	}	

	@Test
	public void test_GetMaand_Geldige_Waarden_Aanvaard() {
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
				int jaar = generator.nextInt();
				
				datum = new Datum(j, i, jaar);
				assertEquals(i,datum.getMaand());
			}
		}
	}

	@Test
	public void test_GetJaar_200_Geldige_Waarden_Aanvaard() {
		for(int i = 0;i<200;i++){
			int dag = generator.nextInt(28)+1;
			int maand = generator.nextInt(12)+1;
			int jaar = generator.nextInt();
			
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
					int jaar = generator.nextInt();
					
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
					int jaar = generator.nextInt();
					
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
					int jaar = generator.nextInt();
					
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
					int jaar = generator.nextInt();
					
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
			
				int jaar = generator.nextInt();
				
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
	public void test_GetDatumInAantalDagen_Geldige_Waarde_Geslaagd() {
		fail("Not yet implemented");
		
		for(int j = 0;j<50;j++){
			int aantalDagen = 0;
			
			do{
				aantalDagen = generator.nextInt();
			}while(aantalDagen < 0);
			
			int toExpect = aantalDagen;
			int dagen = 1;
			int maanden = 1;
			int jaren = 0;
			
			while((aantalDagen / 366 > 0 || (aantalDagen / 365 > 0 && (jaren % 4 != 0 || jaren % 100 ==0 ) && (jaren % 400 != 0 )))){
				jaren += 1;
				if((jaren % 4 == 0 && jaren % 100 !=0 ) || (jaren % 400 == 0 )){
					aantalDagen -= 366;
				}
				else{
					aantalDagen -= 365;
				}
				
			}
			for(int i = 1;i<12 && aantalDagen / dagenPerMaand[i] > 0;i++){
				maanden++;
				aantalDagen -= dagenPerMaand[i];
			}
			
			dagen += aantalDagen;
	
			//fail("jaar is "+jaren+"dag "+dagen+"maand "+maanden+"aantal "+aantalDagen);	
			datum.setDatum(dagen, maanden, jaren);	
			
			assertEquals(toExpect,datum.getDatumInAantalDagen());
		}
	}

	@Test
	public void test_CompareTo_Geldige_Waarde_Geslaagd() {
		fail("Not yet implemented");
		
		Datum datum2 = new Datum();
		
		for(int i = 1; i<=12;i++){
			for(int j = 1;j<= dagenPerMaand[i];j++){
			
				int jaar = generator.nextInt();
				
				datum.setDatum(j, i, jaar);
				
				for(int k = 1; k<=12;k++){
					for(int l = 1;l<= dagenPerMaand[k];l++){						
						int jaar2 = generator.nextInt();
						
						if(k!=i || l!=j || jaar!=jaar2){
							datum2.setDatum(l, k, jaar2);
							assertEquals(0,datum.compareTo(datum2));
						}
					}
				}
				
			}
		}
	}

	@Test
	public void testKleinerDan() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerschilInJaren() {
		fail("Not yet implemented");
	}

}

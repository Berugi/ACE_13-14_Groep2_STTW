package tests.model;

import org.junit.Before;
import org.junit.Test;
import model.Antwoord;

public class AntwoordTest {
	
	@Before
	public void setUp() throws Exception {
		new Antwoord();
	}
	
	@Test
	public void test_setAntwoord_Geldige_Waarde(){
		String antwoordWaarde = "blabla";
		new Antwoord(antwoordWaarde);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_setAntwoord_Ongeldige_Null_Waarde(){
		String antwoordWaarde = null;
		new Antwoord(antwoordWaarde);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_setAntwoord_Ongeldige_EmptyString_Waarde(){
		String antwoordWaarde = "";
		new Antwoord(antwoordWaarde);
	}
}

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import utils.Datum2;

public class DatumTest {

	@Test
	public void test_Constructor_Object_wordt_aangemaakt(){
		Datum2 Dat = new Datum2();
		System.out.println("Default constructor: "+Dat.toString());
	}
	
	@Test
	public void test_ConstructorMetStringArgument_Object_wordt_aangemaakt() throws IllegalArgumentException, ParseException{
		Datum2 Dat = new Datum2("25/02/1971");
		System.out.println("Constructor met correct string argument: "+Dat.toString());
	}

	@Test
	public void test_ConstructorMetStringArgument_error() throws IllegalArgumentException, ParseException{
		Datum2 Dat = new Datum2("25/Februari/1971");
		System.out.println("Constructor met volledige maandnaam in string argument: "+Dat.toString());
	}
	
	@Test
	public void test_ConstructorMetStringArgumentDag1digit_OK() throws IllegalArgumentException, ParseException{
		Datum2 Dat = new Datum2("5/01/1971");
		System.out.println("Constructor met single digit als dag in string argument: "+Dat.toString());
	}
	
	@Test
	public void test_ConstructorMetddMMjjjj_Object_wordt_aangemaakt() {
		Datum2 Dat = new Datum2(22,8,2005);
		System.out.println("Default constructor met dd,mm,jjjj: "+Dat.toString());
	}
	
	@Test
	public void test_ConstructorMetddMMjjjj_Foutieve_datum() {
		Datum2 Dat = new Datum2(31,2,2005);
		System.out.println("Default constructor met dd,mm,jjjj: "+Dat.toString());
	}
}

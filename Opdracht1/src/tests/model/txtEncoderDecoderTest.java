package tests.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import model.txtEncoderDecoder;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Sander Van der Borght
 * 
 * @version 20131112
 *
 */
public class txtEncoderDecoderTest {

	private txtEncoderDecoder testEncoderDecoder;
	private Random generator = new Random();
	
	@Before
	public void setUp() throws Exception {
		testEncoderDecoder = new txtEncoderDecoder();
	}

	@Test
	public void testTxtEncoderDecoder() {
		try{
			for(int k = 0;k<10;k++){
				String pad = "/";
				for(int i = 0;i < generator.nextInt(120);i++){
					pad += Character.toString(((char) generator.nextInt()));
				}
				
				testEncoderDecoder = new txtEncoderDecoder(pad);
			}
		}
		catch(Exception e){
			fail("Exception thrown: "+e.getMessage());
		}
	}

	@Test
	public void testEncode() throws IOException {
		testEncoderDecoder = new txtEncoderDecoder("objects.txt");
		String [][] objectTabel = {{"var1","var2"},{"test11","test12"},{"test21","test22"}};
		
		boolean f = testEncoderDecoder.encode(objectTabel);
		
	}

	@Test
	public void testDecode() throws IOException {
		testEncoderDecoder = new txtEncoderDecoder("objects.txt");
		String [][] objectTabel = {{"var1","var2"},{"test11","test12"},{"test21","test22"}};
		
		boolean f = testEncoderDecoder.encode(objectTabel);
		Hashtable<String,ArrayList<String>> decodedTabel = testEncoderDecoder.decode();
		for(int i = 0;i < objectTabel.length; i++){
			for(int j = 0 ;j<objectTabel[i].length; j++){
				assertEquals(true,objectTabel[1][0].equals(decodedTabel.get("var1").get(0)));
			}
		}		
	}

}

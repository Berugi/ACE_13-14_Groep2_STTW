package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author Sander Van der Borght
 * 
 * @version 20131112
 *
 * Bevat code om een tabel met variabelen in een tekstbestand op te slaan
 */
public class txtEncoderDecoder {

	String bestandspad;
	
	public txtEncoderDecoder(String bestandspad){
		
		this.bestandspad = bestandspad;
	}
	
	public txtEncoderDecoder() {
		// TODO Auto-generated constructor stub
	}

	public boolean encode(String[][] objectTabel) throws IOException{
		File bestand = new File(this.bestandspad);		 
		//tekstbestand aanmaken als het nog niet bestaat
		if (!bestand.exists()) {
			bestand.createNewFile();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.bestandspad));
		try {
			
			for(String[] list : objectTabel){
				for(String item : list){
					writer.write(item+";");
				}
				writer.newLine();
			}	
			writer.close();
			return true;
		 } finally {
			 writer.close();
		    }
	}
	
	public String [][] decode() throws IOException{
		BufferedReader reader  = new BufferedReader(new FileReader(bestandspad));
		ArrayList<String[]> arrayTabel = new ArrayList<String[]>();
		try{
			String line;
			while( (line = reader.readLine()) != null) {
				arrayTabel.add(line.split(";"));
			   }
			reader.close();
			
			String[][] objectTabel = arrayTabel.toArray(new String[arrayTabel.size()][]);;
			
			return objectTabel;
		} finally {
			 reader.close();
	    }
			
	}
}

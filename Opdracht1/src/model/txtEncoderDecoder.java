package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
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
		
	}
    
	//encode method
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
	
	//decode method
	public Hashtable<String,ArrayList<String>> decode() throws IOException{
		BufferedReader reader  = new BufferedReader(new FileReader(bestandspad));
		
		Hashtable<String,ArrayList<String>> tabel = new Hashtable<String,ArrayList<String>>();
		
		
		ArrayList<String[]> arrayTabel = new ArrayList<String[]>();
		try{
			String line;
			while( (line = reader.readLine()) != null) {
				arrayTabel.add(line.split(";"));
			   }
			reader.close();
			
			// lees per veld alle waarden uit
			for(int i = 0;i<arrayTabel.get(0).length;i++){
				// i = fieldcounter
				ArrayList<String> waarden = new ArrayList<String>();
				for(int j = 1;j<arrayTabel.size();j++){
					//j = valuecounter
					waarden.add(arrayTabel.get(j)[i]);
				}
				tabel.put(arrayTabel.get(0)[i],waarden);
			}
							
			return tabel;
		} finally {
			 reader.close();
	    }
			
	}
}

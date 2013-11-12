package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class txtEncoderDecoder {

	String bestandspad;
	
	public txtEncoderDecoder(String bestandspad){
		
		this.bestandspad = bestandspad;
	}
	
	public boolean Encode(String [][] objectTabel) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(bestandspad));
		try {
			File bestand = new File(bestandspad);
			 
			//tekstbestand aanmaken als het nog niet bestaat
			if (!bestand.exists()) {
				bestand.createNewFile();
			}
			
			
					
			for(String[] list : objectTabel){
				for(String item : list){
					writer.write(item+";");
				}
				writer.write("\n");
			}	
			writer.close();
			return true;
		 } finally {
			 writer.close();
		    }
	}
	
	public String [][] Decode() throws IOException{
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

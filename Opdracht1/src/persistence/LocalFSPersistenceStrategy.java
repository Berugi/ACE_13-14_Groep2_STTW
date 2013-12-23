package persistence;

import persistence.interfaces.IPersistenceStrategy;
import model.txtEncoderDecoder;

import java.io.IOException;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;
import config.IniFileManager;
import model.Quiz;
import model.baseclasses.OpdrachtBase;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class LocalFSPersistenceStrategy implements IPersistenceStrategy {

	private txtEncoderDecoder opdrachtenDecoder= new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathopdrachten"));
	private txtEncoderDecoder quizenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizen"));
	private txtEncoderDecoder leerjarenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathleerjaren"));
	
	String str;
	
	public boolean ReadData(){
		try {
			// reading quizen
			Hashtable<String,ArrayList<String>> txtQuizHash = quizenDecoder.decode();
			Hashtable<String,ArrayList<String>> txtLeerjarenHash = leerjarenDecoder.decode();
			Enumeration<String> k = txtQuizHash.keys();
			while(k.hasMoreElements()){
				str = (String)k.nextElement();
				System.out.println(str +" : "+ txtQuizHash.get(str));
				
				//lezen van alle leerjaren 
				int[] lj = null;
				int wijzer = 0;
				for (Map.Entry entry: txtLeerjarenHash.entrySet()){
					if (str.equals(entry.getValue())){
						lj[wijzer]= Integer.parseInt(entry.getKey().toString());
						wijzer++;
					}
				
				}

			}		
			
			//reading opdrachten
			Hashtable<String,ArrayList<String>> txtOpdrachtHash = opdrachtenDecoder.decode();
			k = txtOpdrachtHash.keys();
			while(k.hasMoreElements()){
				str = (String)k.nextElement();
				System.out.println(str +" : "+ txtOpdrachtHash.get(str));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return true;
	}
	
	public boolean WriteData(){
		
		return true;
	}
	
	/*
	public Object readByID(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}

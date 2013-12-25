package persistence;

import persistence.interfaces.IPersistenceStrategy;
import model.txtEncoderDecoder;

import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;

import utils.Datum;
import config.IniFileManager;
import model.Quiz;
import model.baseclasses.OpdrachtBase;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;
import model.QuizCatalogus;
import model.OpdrachtCatalogus;
import model.baseclasses.OpdrachtBase;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class LocalFSPersistenceStrategy implements IPersistenceStrategy {

	private txtEncoderDecoder opdrachtenDecoder= new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathopdrachten"));
	private txtEncoderDecoder quizenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizen"));
	private txtEncoderDecoder leerjarenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathleerjaren"));
	public QuizCatalogus quizcatalogus = new QuizCatalogus();
	public OpdrachtCatalogus opdrachtcatalogus = new OpdrachtCatalogus();
	
	public boolean ReadData(){
		try {
			// lezen quizen
			Hashtable<String,ArrayList<String>> txtQuizHash = quizenDecoder.decode();
			//Hashtable<String,ArrayList<String>> txtLeerjarenHash = leerjarenDecoder.decode();

			
			for(int i=0;i<txtQuizHash.get("QuizID").size();i++){
			
				//Leerjaren van String naar Int[]
				String[] leerjarenString = txtQuizHash.get("Leerjaren").get(i).replace("[", "").replace("]","").split(",");
				int[] leerjaren = new int[leerjarenString.length];;
								
				for(int j=0; j<leerjarenString.length; j++)
				{
					leerjaren[j] = Integer.parseInt(leerjarenString[j]);
				}
				
				/*lezen van alle leerjaren voor deze quiz
				int[] lj = null;
				int wijzer = 0;
				String value = txtQuizHash.get("QuizID").get(i);
				for (Map.Entry entry: txtLeerjarenHash.entrySet()){
					if (value.equals(entry.getValue())){
						lj[wijzer]= Integer.parseInt(entry.getKey().toString());
						wijzer++;
					}
				}
				*/
				
				quizcatalogus.add(new Quiz(
						txtQuizHash.get("Onderwerp").get(i),
						leerjaren,
						Boolean.parseBoolean(txtQuizHash.get("IsTest").get(i)),
						Boolean.parseBoolean(txtQuizHash.get("IsUniekeDeelname").get(i)),
						Leraar.valueOf(txtQuizHash.get("Auteur").get(i)),
						new Datum(txtQuizHash.get("Registratiedatum").get(i)),
						QuizStatus.valueOf(txtQuizHash.get("Status").get(i))
						));
				
			}		
			
			//lezen opdrachten
			
			Hashtable<String,ArrayList<String>> txtOpdrachtHash = opdrachtenDecoder.decode();
			
			for(int i=0;i<txtOpdrachtHash.get("OpdrachtID").size();i++){
				opdrachtcatalogus.add(new OpdrachtBase(
						txtOpdrachtHash.get("Vraag").get(i),
						txtOpdrachtHash.get("JuisteAntwoord").get(i),
						Integer.parseInt(txtOpdrachtHash.get("MaxPogingen").get(i)),
						Integer.parseInt(txtOpdrachtHash.get("MaxAntwoordtijd").get(i)),
						Leraar.valueOf(txtOpdrachtHash.get("Auteur").get(i)),
						OpdrachtCategorie.valueOf(txtOpdrachtHash.get("Categorie").get(i)),
						new Datum(txtOpdrachtHash.get("Registratiedatum").get(i))));
			}
			
			//}
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

package persistence;

import persistence.interfaces.IPersistenceStrategy;
import model.txtEncoderDecoder;

import java.io.IOException;
import java.util.Hashtable;
import java.util.ArrayList;

import utils.Datum;
import config.IniFileManager;
import model.Quiz;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;
import model.QuizCatalogus;
import model.OpdrachtCatalogus;
import model.factory.OpdrachtFactory;
import model.baseclasses.OpdrachtBase;
import model.QuizOpdracht;


/**
 * @author Tom Scheepers
 * 
 * @version 20131225-01: Initial
 * @version 20131227-01: Use of OpdrachtFactory
 * 
 */

public class LocalFSPersistenceStrategy implements IPersistenceStrategy {

	private txtEncoderDecoder opdrachtenDecoder= new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathopdrachten"));
	private txtEncoderDecoder quizenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizen"));
	private txtEncoderDecoder quizenopdrachtenDecoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizopdrachten"));

	public void ReadData(QuizCatalogus quizcatalogus, OpdrachtCatalogus opdrachtcatalogus) throws Exception{
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
				
				quizcatalogus.add(new Quiz(Integer.parseInt(txtQuizHash.get("QuizID").get(i)),
						txtQuizHash.get("Onderwerp").get(i),
						leerjaren,
						Boolean.parseBoolean(txtQuizHash.get("IsTest").get(i)),
						Boolean.parseBoolean(txtQuizHash.get("IsUniekeDeelname").get(i)),
						Leraar.valueOf(txtQuizHash.get("Auteur").get(i)),
						new Datum(txtQuizHash.get("Registratiedatum").get(i)),
						QuizStatus.valueOf(txtQuizHash.get("QuizStatus").get(i))
						));

			}		
		} 
		catch (Exception e) {
			throw e;
		}
		
		
		//lezen opdrachten

		try{
			Hashtable<String,ArrayList<String>> txtOpdrachtHash = opdrachtenDecoder.decode();
			
			for(int i=0;i<txtOpdrachtHash.get("OpdrachtID").size();i++){

				OpdrachtFactory.getOpdrachtFactory().getOpdracht(Integer.parseInt(txtOpdrachtHash.get("OpdrachtID").get(i)),
						txtOpdrachtHash.get("Vraag").get(i), 
						txtOpdrachtHash.get("JuisteAntwoord").get(i), 
						Integer.parseInt(txtOpdrachtHash.get("MaxPogingen").get(i)), 
						Integer.parseInt(txtOpdrachtHash.get("MaxAntwoordtijd").get(i)), 
						Leraar.valueOf(txtOpdrachtHash.get("Auteur").get(i)), 
						OpdrachtCategorie.valueOf(txtOpdrachtHash.get("Categorie").get(i)), 
						new Datum(txtOpdrachtHash.get("Registratiedatum").get(i)), 
						txtOpdrachtHash.get("Meerkeuze").get(i), 
						txtOpdrachtHash.get("Hints").get(i));
			}
		}
		catch (Exception e){
			System.out.println("Opdrachten konden niet gelezen worden!");
			throw e;
		}
		
		//lezen QuizOpdrachten

		try{
			Hashtable<String,ArrayList<String>> txtQuizenOpdrachtenHash = quizenopdrachtenDecoder.decode();
			
			for(int i=0;i<txtQuizenOpdrachtenHash.get("ID").size();i++){
				
				for(Quiz quiz: quizcatalogus.quizen){
					if(quiz.getQuizID()==Integer.parseInt(txtQuizenOpdrachtenHash.get("QuizID").get(i))){
						for(OpdrachtBase opdracht: opdrachtcatalogus.getCatalogus()){
							if(opdracht.getOpdrachtID()==Integer.parseInt(txtQuizenOpdrachtenHash.get("OpdrachtID").get(i))){
								QuizOpdracht quizopdracht = new QuizOpdracht(Integer.parseInt(txtQuizenOpdrachtenHash.get("MaxScore").get(i)),quiz,opdracht);
								quiz.quizOpdrachtToevoegen(quizopdracht);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("QuizOpdrachten konden niet uitgelezen worden!");
		}


	}

	public void WriteData(){

	}

}

package persistence;

import java.util.ArrayList;
import java.util.Hashtable;
import java.io.File;



import model.ObservableOpdrachtCatalogus;
import model.Quiz;
import model.ObservableQuizCatalogus;
import model.QuizOpdracht;
import model.txtEncoderDecoder;
import model.baseclasses.Opdracht;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.enums.QuizStatus;
import model.factory.OpdrachtFactory;
import model.MeerKeuzeOpdracht;
import persistence.interfaces.IPersistenceStrategy;
import utils.Datum;
import config.IniFileManager;


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

	public void ReadData(ObservableQuizCatalogus quizcatalogus, ObservableOpdrachtCatalogus opdrachtcatalogus) throws Exception{
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
						Leraar.getLeraar((txtQuizHash.get("Auteur").get(i))),
						new Datum(txtQuizHash.get("Registratiedatum").get(i)),
						QuizStatus.getStatus(txtQuizHash.get("QuizStatus").get(i))
						));

			}		
		} 
		catch (Exception e) {
			System.out.println("Quizen konden niet gelezen worden!");
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
						Leraar.getLeraar(txtOpdrachtHash.get("Auteur").get(i)), 
						OpdrachtCategorie.getCategorie(txtOpdrachtHash.get("Categorie").get(i)), 
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
						for(Opdracht opdracht: opdrachtcatalogus.getCatalogus()){
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

	public void WriteData(ObservableQuizCatalogus quizcatalogus, ObservableOpdrachtCatalogus opdrachtcatalogus) throws Exception{

		Boolean quizenWegschrijvenOK=false;
		Boolean opdrachtenWegschrijvenOK=false;
		Boolean quizopdrachtenWegschrijvenOK=false;
		//wegschrijven van Quizen
		try {
			txtEncoderDecoder encoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizennew"));
			txtEncoderDecoder encoderqo = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathquizopdrachtennew"));
			//quizdata
			ArrayList<String[]> list = new ArrayList<String[]>();
			String [] VarNamen = {"QuizID","Onderwerp","Leerjaren","IsTest","IsUniekeDeelname","Auteur","Registratiedatum","QuizStatus"};
			list.add(VarNamen);
			//quizantwoord data
			ArrayList<String[]> listqo = new ArrayList<String[]>();
			String [] VarNamenqo = {"ID","QuizID","OpdrachtID","MaxScore"};
			listqo.add(VarNamenqo);
			
			int quizopdrachtenTeller=0;

			for(Quiz quiz : quizcatalogus.quizen){
				String[] quizVars = {Integer.toString(quiz.getQuizID()) ,quiz.getOnderwerp(),quiz.getLeerjarenAsString(),quiz.getIsTest().toString(),
						quiz.getIsUniekeDeelname().toString(),quiz.getAuteur().toString(),quiz.getDatumRegistratie().toString(),quiz.getQuizStatus().toString()};
				list.add(quizVars);
				if(quiz.getQuizOpdrachten()!=null){
					for(QuizOpdracht quizopdracht: quiz.getQuizOpdrachten()){
						String[] quizopdrachtenVars = {Integer.toString(++quizopdrachtenTeller),Integer.toString(quizopdracht.getQuiz().getQuizID()),Integer.toString(quizopdracht.getOpdracht().getOpdrachtID()),Integer.toString(quizopdracht.getMaxScore())};
						listqo.add(quizopdrachtenVars);
					}
				}
			}

			String [][] quizTabel = list.toArray(new String[list.size()][list.get(0).length]);
			String [][] quizopdrachtenTabel = listqo.toArray(new String[listqo.size()][listqo.get(0).length]);

			quizenWegschrijvenOK=encoder.encode(quizTabel);
			quizopdrachtenWegschrijvenOK=encoderqo.encode(quizopdrachtenTabel);
			
		} catch (Exception e) {
			System.out.println("Quizen / QuizOpdrachten konden niet weggeschreven worden!");
			e.printStackTrace();
		}
		
		
		//wegschrijven van Opdrachten
		try {
			txtEncoderDecoder encoder = new txtEncoderDecoder(IniFileManager.getInstance().getProperty("txtpathopdrachtennew"));
			String meerkeuze;
			ArrayList<String[]> list = new ArrayList<String[]>();
			String [] VarNamen = {"OpdrachtID","Vraag","JuisteAntwoord","MaxPogingen","MaxAntwoordtijd","Auteur","Categorie","Registratiedatum","Meerkeuze","Hints"};
			list.add(VarNamen);

			for(Opdracht opdracht : opdrachtcatalogus.getCatalogus()){
				meerkeuze="";
				if(opdracht instanceof MeerKeuzeOpdracht)
				{
					meerkeuze = ((MeerKeuzeOpdracht) opdracht).getKeuzesAsString();
				}
				String[] opdrachtVars = {Integer.toString(opdracht.getOpdrachtID()),opdracht.getVraag(),opdracht.getJuisteAntwoord(),
						Integer.toString(opdracht.getMaxAantalPogingen()), Integer.toString(opdracht.getMaxAntwoordTijd()),opdracht.getAuteur().toString(),opdracht.getOpdrachtCategorie().toString(),opdracht.getDatumRegistratie().toString(),meerkeuze,opdracht.getAntwoordHintsAsString()};
				list.add(opdrachtVars);
			}

			String [][] opdrachtTabel = list.toArray(new String[list.size()][list.get(0).length]);

			opdrachtenWegschrijvenOK=encoder.encode(opdrachtTabel);
			
		} 
		catch (Exception e) {
			System.out.println("Opdrachten konden niet weggeschreven worden!");
			e.printStackTrace();
		}
		
		//Hernoemen van tekstbestanden indien alle 3 de tekstbestanden werden aangemaakt.
		// Gedaan vooral om te voorkomen dat onze testdata wordt overschreven door eventueel foute data
		
		if (quizenWegschrijvenOK && quizopdrachtenWegschrijvenOK && opdrachtenWegschrijvenOK){
		try {
			//de huidige bestanden die worden ingelezen
			File currentQuizen = new File(IniFileManager.getInstance().getProperty("txtpathquizen"));
			File currentOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathopdrachten"));
			File currentQuizenOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathquizopdrachten"));
			
			// de backup
			File oldQuizen = new File(IniFileManager.getInstance().getProperty("txtpathquizen")+"_old");
			File oldOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathopdrachten")+"_old");
			File oldQuizenOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathquizopdrachten")+"_old");
			
			//de nieuw weggeschreven bestanden
			File newQuizen = new File(IniFileManager.getInstance().getProperty("txtpathquizennew"));
			File newOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathopdrachtennew"));
			File newQuizenOpdrachten = new File(IniFileManager.getInstance().getProperty("txtpathquizopdrachtennew"));
			
			if (oldQuizen.exists()){oldQuizen.delete();}
			if (oldOpdrachten.exists()){oldOpdrachten.delete();}
			if (oldQuizenOpdrachten.exists()){oldQuizenOpdrachten.delete();}
			
			currentQuizen.renameTo(oldQuizen);
			currentOpdrachten.renameTo(oldOpdrachten);
			currentQuizenOpdrachten.renameTo(oldQuizenOpdrachten);
			newQuizen.renameTo(currentQuizen);
			newOpdrachten.renameTo(currentOpdrachten);
			newQuizenOpdrachten.renameTo(currentQuizenOpdrachten);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}

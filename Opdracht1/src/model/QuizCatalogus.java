package model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import utils.Datum;
import model.enums.Leraar;
import model.enums.QuizStatus;


/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131020-01 - modified by Tom Vaes - complete redesign.
 *
 * Bevat QuizCatalogues informatie
 */

public class QuizCatalogus implements Comparable<Catalogus>, Cloneable, Iterable<Catalogus>{

	public ArrayList<Quiz> quizen;
	//public Datum registratiedatum;
	//public Leraar auteur;
	
	//constructors
	public QuizCatalogus() {
		this.quizen = new ArrayList<Quiz>();
		//this.registratiedatum = new Datum();
	}
	
	public QuizCatalogus(String bestandsnaam) throws IOException{
		this();
		txtEncoderDecoder decoder = new txtEncoderDecoder(bestandsnaam);
		
		Hashtable<String,ArrayList<String>> quizTabel = decoder.decode();
						
		for(int j = 0; j<quizTabel.get("Auteur").size();j++){
			//Leerjaren van String naar Int[]
			String[] leerjarenString = quizTabel.get("Leerjaren").get(j).replace("[", "").replace("]","").split(",");
			int[] leerjaren = new int[leerjarenString.length];;
							
			for(int i=0; i<leerjarenString.length; i++)
			{
				leerjaren[i] = Integer.parseInt(leerjarenString[i]);
			}
			
			
			this.quizen.add(
					new Quiz(
							quizTabel.get("Onderwerp").get(j), 
							leerjaren , 
							(quizTabel.get("IsTest").get(j)=="True"?true:false),
							(quizTabel.get("IsUniekeDeelname").get(j)=="True"?true:false),
							Leraar.valueOf(quizTabel.get("Auteur").get(j)), 
							new Datum(quizTabel.get("DatumRegistratie").get(j)),
							QuizStatus.valueOf(quizTabel.get("QuizStatus").get(j))
							)
					);
		}
			
	}
	
	//getter
	public ArrayList<Quiz> getCatalogus()
	{
		return this.quizen;
	}
	
	//methods
	
	Quiz change(int index) {
		return  quizen.get(index);
	}

	public int compareTo(Catalogus o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<Catalogus> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	public Boolean add(Quiz newQuiz) throws IllegalArgumentException{
		
		Boolean result = true;
		
		if (newQuiz.getDatumRegistratie() == null || newQuiz.getAuteur() == null || newQuiz.getAuteur() == Leraar.TBA)
			throw new IllegalArgumentException("Auteur en/of registratie datum van de quiz moeten ingevuld zijn");
		
		for(Quiz existingQuiz : this.quizen)
		{
			if (existingQuiz.getShortOnderwerp().equals(newQuiz.getShortOnderwerp()))
				result = false;
		}
		
		if(result) {
			this.quizen.add(newQuiz);
			return result;
		}
		
		return result;
	}
	

	public Boolean remove(Quiz removeQuiz) throws IllegalArgumentException
	{
		if(removeQuiz.getQuizStatus() == QuizStatus.AFGEWERKT || removeQuiz.getQuizStatus() == QuizStatus.INCONSTRUCTIE)
		 throw new IllegalArgumentException (String.format("Quiz kan niet verwijderd worden. Status = %s",removeQuiz.getQuizStatus().getDescription()));
		
		 this.quizen.remove(removeQuiz);
				return true;	
	}
	
	public void wegschrijvenAlsTekstbestand(String bestandsnaam) throws IOException {
		txtEncoderDecoder encoder = new txtEncoderDecoder(bestandsnaam);
		
		ArrayList<String[]> list = null;
		String [] VarNamen = {"Auteur","DatumRegistratie","Leerjaren","Onderwerp","IsTest","QuizStatus","IsUniekeDeelname"};
		list.add(VarNamen);
		
		for(Quiz quiz : this.quizen){
			String[] quizVars = {quiz.getAuteur().toString(),quiz.getDatumRegistratie().toString(),Arrays.toString(quiz.getLeerjaren()),quiz.getOnderwerp(),quiz.getIsTest().toString(),quiz.getQuizStatus().toString(),quiz.getIsUniekeDeelname().toString()};
			list.add(quizVars);
		}
		
		String [][] quizTabel = list.toArray(new String[list.size()][list.get(0).length]);
		
		encoder.encode(quizTabel);
	}
	
	//Main method used only for testing when Junit test van not available
		public static void main(String[] args) 
		{
			Datum d = new Datum();
			Quiz quiz1 = new Quiz("hoofdsteden, europa",Leraar.AN,d,QuizStatus.INCONSTRUCTIE);
			Quiz quiz2 = new Quiz("De hoofdsteden? van Europa!",Leraar.AN,d,QuizStatus.INCONSTRUCTIE);
			QuizCatalogus quizen = new QuizCatalogus();
			
			try
			{
				quizen.add(quiz1);	
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			//System.out.println(quiz1);
//			try
//			{
//				quizen.remove(quiz1);
//			}
//			catch (Exception e)
//			{
//				System.out.println(e);
//			}
			
			try
			{
				if(!quizen.add(quiz2))
					System.out.println("Quiz kon niet toegevoegd worden !");
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			for(Quiz z : quizen.getCatalogus())
			{
				System.out.println(z);
			}
		}
	
}

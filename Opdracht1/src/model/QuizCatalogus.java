package model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import utils.Datum;
import model.baseclasses.Catalogus;
import model.enums.Leraar;
import model.enums.QuizStatus;
//import model.interfaces.IQuizStatus;//-- for state pattern


/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131020-01 - modified by Tom Vaes - complete redesign.
 * @version 20131209-01 - modified by Tom Vaes - small correction add quiz.
 * @version 20131226-01 - modified by Tom Vaes - corrected constructor using text file.
 * Bevat QuizCatalogues informatie
 */

public class QuizCatalogus implements Comparable<Catalogus>, Cloneable, Iterable<Quiz>{

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
							new Datum(quizTabel.get("Registratiedatum").get(j)),
							//IQuizStatus.valueOf(quizTabel.get("IQuizStatus").get(j))//--for state pattern
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quizen == null) ? 0 : quizen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof QuizCatalogus)) {
			return false;
		}
		QuizCatalogus other = (QuizCatalogus) obj;
		if (quizen == null) {
			if (other.quizen != null) {
				return false;
			}
		} else if (!quizen.equals(other.quizen)) {
			return false;
		}
		return true;
	}

	public Iterator<Quiz> iterator() {
		
		return this.quizen.iterator();
		
	}
	
		
	public boolean add(Quiz newQuiz) throws IllegalArgumentException{
		
		Boolean result = true;
		
		if (newQuiz.getDatumRegistratie() == null || newQuiz.getAuteur() == null || newQuiz.getAuteur() == Leraar.TBA)
			throw new IllegalArgumentException("Auteur en/of registratie datum van de quiz moeten ingevuld zijn");
		
		for(Quiz existingQuiz : this.quizen)
		{
			if (existingQuiz.getShortOnderwerp().equals(newQuiz.getShortOnderwerp()))
				throw new IllegalArgumentException("Het onderwerp van de quiz bestaat reeds !");
		}
		
		if(result)
			this.quizen.add(newQuiz);
		
		return result;
	}
	

	public boolean remove(Quiz removeQuiz) throws IllegalArgumentException
	{
		if(removeQuiz.getQuizStatus() == QuizStatus.AFGEWERKT || removeQuiz.getQuizStatus() == QuizStatus.INCONSTRUCTIE)
		 throw new IllegalArgumentException (String.format("Quiz kan niet verwijderd worden. Status = %s",removeQuiz.getQuizStatus().getDescription()));
		
		 this.quizen.remove(removeQuiz);
				return true;	
	}
	
	public void wegschrijvenAlsTekstbestand(String bestandsnaam) throws IOException {
		txtEncoderDecoder encoder = new txtEncoderDecoder(bestandsnaam);
		int i =1;
		ArrayList<String[]> list = new ArrayList<String[]>();
		String [] VarNamen = {"QuizID","Onderwerp","Leerjaren","IsTest","IsUniekeDeelname","Auteur","Registratiedatum","QuizStatus"};
		list.add(VarNamen);
		
		for(Quiz quiz : this.quizen){
			String[] quizVars = {Integer.toString(i),quiz.getOnderwerp(),Arrays.toString(quiz.getLeerjaren()),quiz.getIsTest().toString(),
					quiz.getIsUniekeDeelname().toString(),quiz.getAuteur().toString(),quiz.getDatumRegistratie().toString(),quiz.getQuizStatus().toString()};
			list.add(quizVars);
			i++;
		}
		
		String [][] quizTabel = list.toArray(new String[list.size()][list.get(0).length]);
		
		encoder.encode(quizTabel);
	}
	
	//Main method used only for testing when Junit test van not available
		public static void main(String[] args) 
		{
			Datum d = new Datum();
			Quiz quiz1 = new Quiz("hoofdsteden, europa",Leraar.AN,d,QuizStatus.OPENGESTELD);
			Quiz quiz2 = new Quiz("De steden? van Europa!",Leraar.PIETER,d,QuizStatus.INCONSTRUCTIE);
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

			
			try
			{
				quizen.add(quiz2);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			for(Quiz z : quizen.getCatalogus())
			{
				System.out.println(z);
			}
			
			try
			{
				quizen.remove(quiz1);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			for(Quiz z : quizen.getCatalogus())
			{
				System.out.println(z);
			}
			
			try {
				quizen.wegschrijvenAlsTekstbestand("d:\\myquiz.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

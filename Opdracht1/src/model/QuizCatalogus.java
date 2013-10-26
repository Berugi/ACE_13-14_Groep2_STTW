package model;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	//Main method used only for testing when Junit test van not available
		public static void main(String[] args) 
		{
			Datum d = new Datum();
			Quiz quiz1 = new Quiz("hoofdsteden, europa",Leraar.An,d,QuizStatus.INCONSTRUCTIE);
			Quiz quiz2 = new Quiz("De hoofdsteden? van Europa!",Leraar.An,d,QuizStatus.INCONSTRUCTIE);
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

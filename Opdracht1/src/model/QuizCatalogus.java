package model;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	//constructors
	public QuizCatalogus() {
		this.quizen = new ArrayList<Quiz>();
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
	
	public Boolean add(Quiz newQuiz) {
		for(Quiz quiz : this.quizen) {
			if(newQuiz.getShortOnderwerp().equalsIgnoreCase(quiz.getShortOnderwerp())){
				this.quizen.add(newQuiz);
				return true;
			}
		}
		return false;
	}
	

	public Boolean remove(Quiz removeQuiz)
	{
		QuizStatus status = removeQuiz.getQuizStatus();
				
		if(status == QuizStatus.AFGEWERKT || status == QuizStatus.INCONSTRUCTIE)
			{
				return false;		
			}
			else
			{
				this.quizen.remove(removeQuiz);
				return true;	
			}
	}
}

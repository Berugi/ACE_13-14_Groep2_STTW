package model;

import java.util.*;


/**
 * 
 * @author Sander van der Borght
 * 
 * @version 20131008-01 - Initial version
 * @version 20131020-01 - modified by Tom Vaes - 
 *
 * Bevat QuizCatalogues informatie
 */


public class QuizCatalogus extends Catalogus {

	//constructors
	public QuizCatalogus() {
		this.catalogus = new ArrayList<Object>();
	}
	
	public QuizCatalogus(ArrayList<Quiz> catalogus) {
		this.catalogus = new ArrayList<Object>(catalogus);
	}
	
	//methods
	@Override
	Quiz change(int index) {
		return  (Quiz) catalogus.get(index);
	}

	public int compareTo(Catalogus o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<Catalogus> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean add(Object item) {
		for(Object quiz : this.catalogus) {
			if(((Quiz)item).getShortOnderwerp().equalsIgnoreCase(((Quiz)quiz).getShortOnderwerp())){
				this.catalogus.add(item);
				return true;
			}
		}
		return false;
	}
	
	
}

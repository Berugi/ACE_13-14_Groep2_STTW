package model;

import java.util.*;

public class QuizCatalogus extends Catalogus {
	
	//data members
	//Nu in abstracte klasse

	//getters & setters
	//Nu in abstracte klasse
	
	
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
}

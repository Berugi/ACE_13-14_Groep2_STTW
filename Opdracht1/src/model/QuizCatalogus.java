package model;

import java.util.*;

public class QuizCatalogus {
	
	//data members
	
	private ArrayList<Quiz> catalogus;

	//getters & setters
	
	public ArrayList<Quiz> getCatalogus() {
		return catalogus;
	}

	public void setCatalogus(ArrayList<Quiz> catalogus) {
		this.catalogus = catalogus;
	}
	
	//constructors
	
	public QuizCatalogus() {
		this.catalogus = new ArrayList<Quiz>();
	}
	
	public QuizCatalogus(ArrayList<Quiz> catalogus) {
		this.catalogus = new ArrayList<Quiz>(catalogus);
	}
	
	//methods
	
	public Boolean addQuiz(Quiz q) {
		if(!this.catalogus.contains(q)) {
			this.catalogus.add(q);
			return true;
		}
		return false;
	}
	
	public Boolean removeQuiz(Quiz q) {
		if(this.catalogus.contains(q)) {
			this.catalogus.remove(q);
			return true;
		}
		return false;
	}
}

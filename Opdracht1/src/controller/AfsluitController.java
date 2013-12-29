package controller;

import model.*;

import persistence.DataContext;

/**
 * Deze class zet alle gekende data naar tekstbestanden 
 * 
 * @author Tom Scheepers
 * @version 20131103-01 - Initial version - Tom Scheepers
 */

public class AfsluitController {
	
	private static DataContext datacontext;
	private static ObservableQuizCatalogus quizcatalogus;
	private static ObservableOpdrachtCatalogus opdrachtcatalogus;
	
	public AfsluitController(ObservableQuizCatalogus qc,ObservableOpdrachtCatalogus oc,DataContext dc){
		datacontext=dc;
		opdrachtcatalogus=oc;
		quizcatalogus=qc;
	}
	
	//getters & setters
	
	private void SetDataContext(DataContext dc){
		datacontext=dc;
	}

	public static void Afsluiten() throws Exception{
		datacontext.getStrategy().WriteData(quizcatalogus, opdrachtcatalogus);
	}
	/*
	private int test;
	private String regel;
	
	public Boolean Wegschrijven(QuizCatalogus qc){

		
	return true;
	}
	*/
	
	
	
}

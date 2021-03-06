package controller;

import model.*;

import persistence.DataContext;

/**
 * Deze class zet alle gekende data naar tekstbestanden 
 * 
 * @author Tom Scheepers
 * @version 20131103-01 - Initial version - Tom Scheepers
 * @version 20140110-01 - Tom Scheepers - getInstance
 */

public class AfsluitController {
	
	private static DataContext datacontext;
	private static ObservableQuizCatalogus quizcatalogus;
	private static ObservableOpdrachtCatalogus opdrachtcatalogus;
	private static AfsluitController afsluitcontroller = null;
	
	private AfsluitController(){
		quizcatalogus = OpstartController.getQuizCatalogus();
		opdrachtcatalogus = OpstartController.getOpdrachtCatalogus();
		datacontext = OpstartController.getDataContext();
	}

	//methods
	public static void Afsluiten() throws Exception{
		datacontext.getStrategy().WriteData(quizcatalogus, opdrachtcatalogus);
	}
	
	public static AfsluitController getInstance(){
		if(afsluitcontroller==null){
			afsluitcontroller = new AfsluitController();
		}
		return afsluitcontroller;
	}
	
}

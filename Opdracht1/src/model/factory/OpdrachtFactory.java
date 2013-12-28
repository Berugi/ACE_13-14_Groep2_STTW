package model.factory;

import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import utils.Datum;
import model.baseclasses.Opdracht;
import model.Opsomming;
import model.MeerKeuzeOpdracht;
import model.OpdrachtCatalogus;

import java.util.ArrayList;
import java.util.Arrays;

public class OpdrachtFactory {
	
	protected static int HoogsteID = 0;
	private OpdrachtCatalogus oc;
	private static OpdrachtFactory opdrachtfactory = null;
	
	// Constructor

	private OpdrachtFactory(OpdrachtCatalogus opdrachtcatalogus){
		this.oc = opdrachtcatalogus;
		HoogsteID=this.getHoogsteOpdrachtID(opdrachtcatalogus);
		opdrachtfactory = this;
	}

	// methods
	// als de opdrachtid die wordt meegegeven = 0, dan wordt een ID aangemaakt die hoger is dan de hoogste id in de catalogus
	
	public Opdracht getOpdracht(Integer opdrachtid, String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, OpdrachtCategorie categorie, Datum datumRegistratie, String Keuzes,
			String... antwoordHints) throws Exception{
		
		
		//juisteantwoord opsplitsen -> meer dan 1 juisteantwoord = opsomming
		String[] antwoorden = juisteAntwoord.split(",");
		
		// Bepaal type opdracht
		if(antwoorden.length==1)
		{ // geen opsomming
			if(Keuzes.contains(","))
			{ //meerkeuze
				ArrayList<String> meerkeuzelijst = new ArrayList<String>(Arrays.asList(Keuzes.split(",")));
				if(meerkeuzelijst.size()<2){
					throw new Exception("Meerkeuzelijst bevat minder dan 2 keuzes!");
				} else
				{	
					opdrachtid=bepaalID(opdrachtid);
					Opdracht ob = new MeerKeuzeOpdracht(opdrachtid, meerkeuzelijst, vraag, juisteAntwoord, maxAantalPogingen,
							maxAntwoordTijd, auteur, categorie, datumRegistratie,
							antwoordHints);
					oc.add(ob);
					return ob;
				}
			}
			else
			{ 
				// gewone opdracht
				opdrachtid=bepaalID(opdrachtid);
				Opdracht ob = new Opdracht(opdrachtid, vraag, juisteAntwoord, maxAantalPogingen,
						maxAntwoordTijd, auteur, categorie, datumRegistratie,
						antwoordHints);
				oc.add(ob);
				return ob;
			}
		}
		else 
		{
			//Opsomming
			opdrachtid=bepaalID(opdrachtid);
			Opdracht ob = new Opsomming(opdrachtid, vraag, juisteAntwoord, maxAantalPogingen,
					maxAntwoordTijd, auteur, categorie, datumRegistratie,
					antwoordHints);
			oc.add(ob);
			return ob;
		}

	}
	
	public int getHoogsteOpdrachtID(OpdrachtCatalogus oc){
		int hoogsteID = 0;
		for(Opdracht opdracht:oc.getCatalogus()){
			if(opdracht.getOpdrachtID()>hoogsteID){
				hoogsteID=opdracht.getOpdrachtID();
			}
		}
		return hoogsteID;
	}
	
	public int bepaalID(Integer id) throws Exception {
		//opdrachtid kontroleren/bepalen
		if(id==0){ //maak nieuwe opdrachtID aan dat hoger is dan elke bestaande id
			HoogsteID++;
			id=HoogsteID;
		} else { // Kontroleer of de opgegeven ID al niet bestaat
			if(oc.getCatalogus().contains(id)){
				throw new Exception("OpdrachtID moet uniek zijn");
			}
		}
		return id;
	}
	
	// Singleton pattern
	public static void Initialise(OpdrachtCatalogus oc){
		if(opdrachtfactory==null){
		opdrachtfactory = new OpdrachtFactory(oc);
		}
	}
	
	public static OpdrachtFactory getOpdrachtFactory(){
		return opdrachtfactory;
	}
}

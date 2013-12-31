package model.enums;

/**
 * 
 * @author TBD
 * 
 * @version 20131013-01 - Initial version
 * @version 20131110-01 - modified by Tom VAES - Add methods & variables & Override toString
 *  
 * Bevat QuizCatalogues informatie
 */

public enum Leraar {
	TBA(" "),
	AN("An"),
	PIETER("Pieter"),
	SARAH("Sarah"),
	JEAN("Jean");
	
	private final String naam;

	public String getDescription()
	{
		return naam;
	}

	private Leraar(String naam)
	{
		this.naam = naam;
	}
	
	public static Leraar getLeraar(String auteur){
		for(Leraar l: Leraar.values()){
			if(l.getDescription().equalsIgnoreCase(auteur))
			{return l;}
		}
		return Leraar.TBA;
	}
	
	@Override
    public String toString() {
        return naam;
    }
}

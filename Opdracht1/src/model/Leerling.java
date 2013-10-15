package model;

/**
 * 
 * @author wim
 *
 */
public class Leerling {
	
	//data members
	
	private String naam;
	
	private int leerjaar;

	//getters & setters
	
	protected String getNaam() {
		return naam;
	}

	private void setNaam(String naam) throws IllegalArgumentException {
		if(naam == null || naam.isEmpty())
			throw new IllegalArgumentException("Naam cannot be null or empty.");
		else
			this.naam = naam;
	}

	protected int getLeerjaar() {
		return leerjaar;
	}

	private void setLeerjaar(int leerjaar) throws IllegalArgumentException {
		if(leerjaar < 1 || leerjaar > 6)
			throw new IllegalArgumentException("Leerjaar must be between 1 and 6.");
		else
			this.leerjaar = leerjaar;
	}
	
	//constructors
	
	public Leerling(String naam, int leerjaar){
		setNaam(naam);
		setLeerjaar(leerjaar);
	}
	
}

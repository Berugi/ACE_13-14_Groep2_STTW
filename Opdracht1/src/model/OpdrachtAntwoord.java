package model;

/**
 * 
 * @author wim ombelets
 * @version 20131020-01 initial commit
 *
 */
public class OpdrachtAntwoord implements Comparable<OpdrachtAntwoord>, Cloneable {

	//data members

	private String laatsteAntwoord;
	private int aantalPogingen;
	private int antwoordTijd; //in seconden
	
	
	//getters & setters
	
	public String getLaatsteAntwoord() {
		return laatsteAntwoord;
	}


	private void setLaatsteAntwoord(String laatsteAntwoord) throws IllegalArgumentException {
		if(laatsteAntwoord == null || laatsteAntwoord.isEmpty())
			throw new IllegalArgumentException("String argument cannot be null or empty.");
		this.laatsteAntwoord = laatsteAntwoord;
	}


	public int getAantalPogingen() {
		return aantalPogingen;
	}


	private void setAantalPogingen(int aantalPogingen) throws IllegalArgumentException {
		if(aantalPogingen < 0)
			throw new IllegalArgumentException("Aantal pogingen moet groter zijn dan 0.");
		this.aantalPogingen = aantalPogingen;
	}


	public int getAntwoordTijd() {
		return antwoordTijd;
	}


	private void setAntwoordTijd(int antwoordTijd) throws IllegalArgumentException {
		if(antwoordTijd < 0)
			throw new IllegalArgumentException("Integer argument cannot be negative.");
		this.antwoordTijd = antwoordTijd;
	}

	//constructors

	public OpdrachtAntwoord(String laatsteAntwoord, int aantalPogingen, int antwoordTijd){
		setLaatsteAntwoord(laatsteAntwoord);
		setAantalPogingen(aantalPogingen);
		setAntwoordTijd(antwoordTijd);
	}
	
	//overrides
	
	/**
	 * @param obj is a non-null OpdrachtAntwoord
	 * @throws NullPointerException if obj is null
	 */
	public boolean equals(OpdrachtAntwoord obj) {
		if(this == obj)
			return true;
		
		if(!(obj instanceof OpdrachtAntwoord))
			return false;
		
		if(this.aantalPogingen == obj.aantalPogingen 
				&& this.antwoordTijd == obj.antwoordTijd
				&& this.laatsteAntwoord == obj.laatsteAntwoord)
			return true;
		
		return false;
	}
	
	/**
	 * @param obj is a non-null OpdrachtAntwoord
	 * @throws NullPointerException if obj is null
	 */
	@Override public int compareTo(OpdrachtAntwoord obj) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		
		if(this == obj)
			return EQUAL;
		
		if(this.aantalPogingen < obj.aantalPogingen)
			return BEFORE;
		
		if(this.aantalPogingen > obj.aantalPogingen)
			return AFTER;
		
		if(this.antwoordTijd < obj.antwoordTijd)
			return BEFORE;
		
		if(this.antwoordTijd > obj.antwoordTijd)
			return AFTER;
		
		if(this.laatsteAntwoord.length() < obj.laatsteAntwoord.length())
			return BEFORE;
		
		if(this.laatsteAntwoord.length() > obj.laatsteAntwoord.length())
			return AFTER;
		
		assert this.equals(obj) : "compareTo inconsistent with equals.";
		
		return EQUAL;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return "laatste antwoord: " + this.laatsteAntwoord
				+ " | " + "aantal pogingen: " + this.aantalPogingen
				+ " | " + "antwoordtijd" + this.antwoordTijd;
	}
	
}

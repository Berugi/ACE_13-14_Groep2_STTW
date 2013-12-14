package DatumV2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*********************************
 * 
 * Create a Date object based on a Gregorian Calendar
 * 
 * @author Tom Scheepers
 * @version initial 20131005-01
 * Ook in deze Datum versie is de datum uiteindelijk omgevormd naar dag - maan- jaar in overeenstemming met de eerste versie van Datum.
 * Normaal gezien was dit niet nodig geweest en hadden we de datum zo kunnen gebruiken
 */

public class Datum implements Comparable<Datum> {

	// Declaratie
	
	private int dag;
	private int maand;
	private int jaar;
	
	//  Setters

	private void setDag(int dag) {
		this.dag = dag;
	}


	private void setMaand(int maand) {
		this.maand = maand;
	}


	private void setJaar(int jaar) {
		this.jaar = jaar;
	}
	
	public int getDag() {
		return dag;
	}


	public int getMaand() {
		return maand;
	}


	public int getJaar() {
		return jaar;
	}
	
	// Constructors
	
	public Datum() {
		// Set date = system date
		try{
		GregorianCalendar Cal = new GregorianCalendar();
		setJaar(Cal.get(Calendar.YEAR));
		setMaand(Cal.get(Calendar.MONTH)+1); //+1 omdat 0=januari
		setDag(Cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Datum aangemaakt: "+ this.toString());
		}
		catch (Exception e){
			System.out.println("Exception"+ e.getMessage());
		}
	}
	
	public Datum(int dd, int mm, int yyyy) {
		try{
			if ((dd>=1 && dd<=31) && (mm>=1 && mm<=12) && (yyyy>0))
			{
				if (setDatum(dd,mm,yyyy)==true) {
					System.out.println("Datum set gelukt : " + this.toString());
				}
			}
			else
			{
				throw new IllegalArgumentException("Foutieve datum, datum kan niet aangemaakt worden!");
			}
			
		}
		catch (IllegalArgumentException i){
			System.out.println("Datum is niet aangemaakt! Er zijn foutieve parameters gegeven.");
		}
		catch (Exception e) {
			System.out.println("Exception"+ e.getMessage());
		}
	}
	
	public Datum(Datum dat) {
		try{
			setJaar(dat.jaar);
			setMaand(dat.maand);
			setDag(dat.dag);
		}
		catch(Exception i){
			System.out.println(i.toString());
		}
	}
	
	public Datum(String datum_als_tekst) throws IllegalArgumentException, ParseException {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Calendar NewDate = Calendar.getInstance();
		NewDate.setTime(sdf.parse(datum_als_tekst));
		setDag(NewDate.get(Calendar.DAY_OF_MONTH));
		setMaand(NewDate.get(Calendar.MONTH+1));
		setJaar(NewDate.get(Calendar.YEAR));
		}
		catch (ParseException e){
			System.out.println("Datum werd niet in het juiste formaat ingegeven (dd/mm/jjjj): " + e.toString());
		}
		catch(Exception i){
			System.out.println(i.toString());
		}
	}
	
	// methods
	
	/**
	 * Set instantievariabelen jaar, maand en dag 
	 * 
	 * @param dag
	 * @param maand
	 * @param jaar
	 * @return boolean 
	 */
	
	public boolean setDatum(int dag, int maand, int jaar) {
		try{
			if ((dag>=1 && dag<=31) && (maand>=1 && maand<=12) && (jaar>0))
			{
				//parameters zijn ok
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				Calendar NewDate = Calendar.getInstance();
				
				// Controle of de opgegeven datum werkelijk bestaat

				NewDate.setTime(sdf.parse(Integer.toString(dag)+"/"+Integer.toString((maand))+"/"+Integer.toString(jaar) ));
				
				// Als de Parse gelukt is, set jaar, maand en dag, anders ParseException
				
				setJaar(jaar);
				setMaand(maand);
				setDag(dag);
				System.out.println(NewDate.getTime());
				return true;
			}
			else
			{
				// Foutieve parameters ontvangen
				
				throw new IllegalArgumentException();
			}	

		}
		catch (IllegalArgumentException e){
			System.out.println("Datum bestaat niet !");
			return false;
		}
		catch (ParseException e){
			System.out.println("Parameters kunnen niet naar een bestaande datum omgezet worden !");
			return false;
		}
	}

	/**
	 * Geef de datum in Amerikaans formaat terug (jjjj/MM/dd)
	 * @return String als jjjj/MM/dd
	 */
	
	public String getDatumInAmerikaansFormaat(){
		return Integer.toString(this.jaar) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.dag);
	}
	
	/**
	 * Geef de datum in Europees formaat terug (dd/MM/jjjj)
	 * @return String als dd/MM/jjjj
	 */
	
	public String getDatumInEuropeesFormaat(){
		return Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar);
	}
	
	/**
	 * Omschrijft object als "dag maand-als-tekst jaar"
	 */
	
	@Override
	public String toString() {
		return Integer.toString(this.dag) + " " + new DateFormatSymbols().getMonths()[this.maand-1] + " " + Integer.toString(this.jaar);
	}

	/**
	 * Vergelijkt datum2 objecten
	 * @param dateToCompare
	 * @return integer (-1 = kleiner dan / 0 = gelijk of fout / +1 = groter dan)
	 */
	
	public int compareTo(Datum dateToCompare) {
		// Parse naar Date en vergelijk
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		GregorianCalendar thisDate = new GregorianCalendar();
		GregorianCalendar otherDate = new GregorianCalendar();
		try {
			thisDate.setTime(sdf.parse(Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar)));
			otherDate.setTime(sdf.parse(Integer.toString(dateToCompare.dag) + "/" + Integer.toString(dateToCompare.maand) + "/" + Integer.toString(dateToCompare.jaar)));
			return thisDate.compareTo(otherDate);
		} 
		catch (ParseException e) {
			System.out.println("Probleem met het omzetten naar een werkelijke datum: " + e.toString());
			return 0;
		}
		catch (Exception e) {
			System.out.println("Probleem met het vergelijken van de twee datums: " + e.toString());
			return 0;
		}
	}
	
	/**
	 * Controleert of datum gelijk is met dateToCompare
	 * 
	 * @param dateToCompare
	 * @return boolean true=gelijk / false=verschillend
	 */
	
	public boolean equals(Datum dateToCompare) {
		if ((this.jaar==dateToCompare.jaar) && (this.maand==dateToCompare.maand) && (this.dag==dateToCompare.dag)) 
		{return true;}
		else
		{return false;}
	}
	
	/**
	 * Controleert of de datum kleiner is dan de dateToCompare
	 * @param dateToCompare
	 * @return
	 */
	
	public boolean kleinerDan (Datum dateToCompare) {
		if (this.compareTo(dateToCompare)>0) {
		return true;
		}
		else
		{return false;}
	}
	
	/**
	 * Geeft het verschil in milliseconden tussen datum en vergelijkingsdatum
	 * Wordt enkel intern gebruikt
	 * @param d1
	 * @return long
	 */
	
	private long verschilInMilliseconden(Datum d1){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			GregorianCalendar thisDate = new GregorianCalendar();
			GregorianCalendar otherDate = new GregorianCalendar();
			thisDate.setTime(sdf.parse(Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar)));
			otherDate.setTime(sdf.parse(Integer.toString(d1.dag) + "/" + Integer.toString(d1.maand) + "/" + Integer.toString(d1.jaar)));
			return thisDate.getTimeInMillis()-otherDate.getTimeInMillis();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Geeft het verschil in jaren tussen datum en dateToCompare
	 * @param dateToCompare
	 * @return integer als aantal jaren verschil
	 */
	
	public int verschilInJaren(Datum dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (365 * 24 * 60 * 60 * 1000L ));
	}
	
	/**
	 * Geeft het verschil in maanden tussen datum en dateToCompare
	 * @param dateToCompare
	 * @return integer als aantal maanden verschil
	 */
	
	public int verschilInMaanden(Datum dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (30 * 24 * 60 * 60 * 1000L ));
	}
	
	/**
	 * Geeft het verschil in dagen tussen datum en dateToCompare
	 * @param dateToCompare
	 * @return integer als aantal dagen verschil
	 */
	
	public int verschilInDagen(Datum dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (24 * 60 * 60 * 1000L ));
	}
	
	/**
	 * voeg dagen toe bij de datum
	 * 
	 * @param aantalDagen
	 */
	
	public void veranderDatum(int aantalDagen){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			GregorianCalendar thisDate = new GregorianCalendar();
			thisDate.setTime(sdf.parse(Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar)));
			thisDate.add(Calendar.DAY_OF_WEEK, aantalDagen);
			setDag(thisDate.get(Calendar.DAY_OF_MONTH));
			setMaand(thisDate.get(Calendar.MONTH)+1);
			setJaar(thisDate.get(Calendar.YEAR));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * copy datum en voeg dagen toe
	 * @param aantalDagen
	 * @return
	 */
	
	public Datum nieuweDatum(int aantalDagen){
		Datum newDate = new Datum(this);
		newDate.veranderDatum(aantalDagen);
		return newDate;
	}
	
}

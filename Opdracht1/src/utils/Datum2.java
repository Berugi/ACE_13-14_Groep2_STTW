package utils;

import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.Long;

public class Datum2 implements Comparable<Datum2> {

	// Declaratie
	
	private int dag;
	private int maand;
	private int jaar;
	
	// Getters & Setters

	private void setDag(int dag) {
		this.dag = dag;
	}


	private void setMaand(int maand) {
		this.maand = maand;
	}


	private void setJaar(int jaar) {
		this.jaar = jaar;
	}
	
	// te verwijderen - Getters
	
	
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
	
	public Datum2() {
		// Set date = system date
		try{
		GregorianCalendar Cal = new GregorianCalendar();
		setJaar(Cal.get(GregorianCalendar.YEAR));
		setMaand(Cal.get(GregorianCalendar.MONTH)+1); //+1 omdat 0=januari
		setDag(Cal.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println("Datum aangemaakt: "+ this.toString());
		}
		catch (Exception e){
			System.out.println("Exception"+ e.getMessage());
		}
	}
	
	public Datum2(int dd, int mm, int yyyy) {
		try{
			if ((dd>=1 && dd<=31) && (mm>=1 && mm<=12) && (yyyy>0))
			{
				if (SetDatum(dd,mm,yyyy)==true) {
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
		catch (Exception e) {}
	}
	
	public Datum2(Datum2 dat) throws IllegalArgumentException {
		try{
			setJaar(dat.jaar);
			setMaand(dat.maand);
			setDag(dat.dag);
		}
		catch(IllegalArgumentException i){
			System.out.println(i.toString());
		}
	}
	
	public Datum2(String datum_als_tekst) throws IllegalArgumentException, ParseException {
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
	}
	
	// methods
	
	public boolean SetDatum(int dag, int maand, int jaar) {
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
				
				throw new IllegalArgumentException("Foutieve datum");
			}	

		}
		catch (IllegalArgumentException iae){
			System.out.println("Datum bestaat niet !");
			return false;
		}
		catch (ParseException pe){
			System.out.println("Parameters kunnen niet naar een datum omgezet worden !");
			return false;
		}
	}

	public String getDatumInAmerikaansFormaat(){
		return Integer.toString(this.jaar) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.dag);
	}
	
	public String getDatumInEuropeesFormaat(){
		return Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar);
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.dag) + " " + new DateFormatSymbols().getMonths()[this.maand-1] + " " + Integer.toString(this.jaar);
	}

	@Override
	public int compareTo(Datum2 dateToCompare) {
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
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean equals(Datum2 dateToCompare) {
		if ((this.jaar==dateToCompare.jaar) && (this.maand==dateToCompare.maand) && (this.dag==dateToCompare.dag)) 
		{return true;}
		else
		{return false;}
	}
	
	public boolean kleinerDan (Datum2 dateToCompare) {
		if (this.compareTo(dateToCompare)>0) {
		return true;
		}
		else
		{return false;}
	}
	
	public long verschilInMilliseconden(Datum2 d1){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		GregorianCalendar thisDate = new GregorianCalendar();
		GregorianCalendar otherDate = new GregorianCalendar();
		try {
			
			thisDate.setTime(sdf.parse(Integer.toString(this.dag) + "/" + Integer.toString(maand) + "/" + Integer.toString(this.jaar)));
			otherDate.setTime(sdf.parse(Integer.toString(d1.dag) + "/" + Integer.toString(d1.maand) + "/" + Integer.toString(d1.jaar)));
			return thisDate.getTimeInMillis()-otherDate.getTimeInMillis();
		} 
		catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int verschilInJaren(Datum2 dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (365 * 24 * 60 * 60 * 1000L ));
	}
	
	public int verschilInMaanden(Datum2 dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (30 * 24 * 60 * 60 * 1000L ));
	}
	
	public int verschilInDagen(Datum2 dateToCompare){
		return (int)(this.verschilInMilliseconden(dateToCompare) / (24 * 60 * 60 * 1000L ));
	}
	
	public void veranderDatum(int aantalDagen){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		GregorianCalendar thisDate = new GregorianCalendar();
		try {
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
	
	public Datum2 nieuweDatum(int aantalDagen){
		Datum2 newDate = new Datum2(this);
		newDate.veranderDatum(aantalDagen);
		return newDate;
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Datum2 newDate = new Datum2(this);
		GregorianCalendar tempCal = new GregorianCalendar();
		try {
			tempCal.setTime(sdf.parse(Integer.toString(newDate.dag) + "/" + Integer.toString(newDate.maand) + "/" + Integer.toString(newDate.jaar)));
			tempCal.add(Calendar.DAY_OF_WEEK, aantalDagen);
			setDag(thisDate.get(Calendar.DAY_OF_MONTH));
			setMaand(thisDate.get(Calendar.MONTH)+1);
			setJaar(thisDate.get(Calendar.YEAR));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static void main(String[] args) {

		Datum2 testje, testje2 = null;
		try {
			testje = new Datum2("03/01/2007");
			if (testje!=null)
			{
				System.out.println("Testje: "+ testje.toString());
				System.out.println(testje.dag);
				System.out.println(testje.maand);
				System.out.println(testje.jaar);
				testje.veranderDatum(5);
				System.out.println("Testje: "+ testje.toString());
				System.out.println(testje.dag);
				System.out.println(testje.maand);
				System.out.println(testje.jaar);
				Datum2 nieuweDatum = testje.nieuweDatum(17);
				System.out.println("Nieuwe datum: "+ nieuweDatum.toString());
				System.out.println(nieuweDatum.dag);
				System.out.println(nieuweDatum.maand);
				System.out.println(nieuweDatum.jaar);
			}
		} catch (IllegalArgumentException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testje2 = new Datum2(3,1,2009);
		
		/*
		testje2 = testje;

		testje.veranderDatum(5);
		if (testje!=null)
		{
		System.out.println("Testje: "+ testje.toString());
		System.out.println(testje.dag);
		System.out.println(testje.maand);
		System.out.println(testje.jaar);
		}
		if (testje2!=null)
		{
			System.out.println("Testje 2: "+ testje.toString());
			System.out.println(testje2.dag);
			System.out.println(testje2.maand);
			System.out.println(testje2.jaar);
		}
		System.out.println(testje.compareTo(testje2));
		System.out.println(testje.equals(testje2));
		System.out.println(testje.kleinerDan(testje2));

		System.out.println(testje.verschilInJaren(testje2));
		System.out.println(testje.verschilInMaanden(testje2));
		System.out.println(testje.verschilInDagen(testje2));
*/
	}
	
}

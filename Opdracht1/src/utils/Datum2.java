package utils;

import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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


	private void getDatumInAmerikaansFormaat(){
		SimpleDateFormat AmericanStyle = new SimpleDateFormat("yyyy/MM/dd");
		
	}
	
	private void getDatumInEuropeesFormaat(){
		SimpleDateFormat EuropeanStyle = new SimpleDateFormat("dd/MM/yyyy");
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
		catch(IllegalArgumentException i){}
	}
	
	public Datum2(String datum_als_tekst) throws IllegalArgumentException, ParseException {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Calendar NewDate = Calendar.getInstance();
		NewDate.setTime(sdf.parse(datum_als_tekst));
		setDag(NewDate.get(Calendar.DAY_OF_MONTH));
		setMaand(NewDate.get(Calendar.MONTH));
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

	@Override
	public String toString() {
		return Integer.toString(this.dag) + " " + new DateFormatSymbols().getMonths()[this.maand-1] + " " + Integer.toString(this.jaar);
	}

	@Override
	public int compareTo(Datum2 DateToCompare) {
		return 0;
	}
	
	public static void main(String[] args) {

		Datum2 testje = null;
		testje = new Datum2(7,2,1971);
		if (testje!=null)
				{
		System.out.println("Testje: "+ testje.toString());
		System.out.println(testje.dag);
		System.out.println(testje.maand);
		System.out.println(testje.jaar);
				}
	}
	
}

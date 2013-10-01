package utils;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
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
	
	private void getDatumInAmerikaansFormaat(){
		SimpleDateFormat AmericanStyle = new SimpleDateFormat("yyyy/MM/dd");
		
	}
	
	private void getDatumInEuropeesFormaat(){
		SimpleDateFormat EuropeanStyle = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	// Constructors
	
	public Datum2() {
		try{
		Calendar Cal = Calendar.getInstance();
		setJaar(Cal.get(Calendar.YEAR));
		setMaand(Cal.get(Calendar.MONTH));
		setDag(Cal.get(Calendar.DAY_OF_MONTH));
		}
		catch (Exception e){}
	}
	
	public Datum2(int dd, int mm, int yyyy) throws IllegalArgumentException {
		try{
			
		}
		catch(IllegalArgumentException i){
			
		}
	}
	
	public Datum2(Datum2 dat) throws IllegalArgumentException {
		try{
			this.dag=dat.dag;
			this.maand = dat.maand;
			this.jaar = dat.jaar;
		}
		catch(IllegalArgumentException i){}
	}
	
	public Datum2(String datum_als_tekst) throws IllegalArgumentException, ParseException {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar NewDate = Calendar.getInstance();
		NewDate.setTime(sdf.parse(datum_als_tekst));
		setDag(NewDate.get(Calendar.DAY_OF_MONTH));
		setMaand(NewDate.get(Calendar.MONTH));
		setJaar(NewDate.get(Calendar.YEAR));
		}
		catch (ParseException e){
			System.out.println(e.toString());
		}
	}
	
	// methods
	
	public boolean SetDatum(int dag, int maand, int jaar){
		
		return true;
	}

	@Override
	public String toString() {
		return Integer.toString(this.dag) + " " + new DateFormatSymbols().getMonths()[this.maand] + " " + Integer.toString(this.jaar);
	}

	@Override
	public int compareTo(Datum2 arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

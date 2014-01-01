package utils;
import java.util.Date;

/**
 * 
 * @author Tom Vaes
 * 
 * @version 20131004-01 - Initial version
 * @version 20131013-01 - modified by Tom Vaes - updated several methods
 * @version 20131020-01 - modified by Tom Vaes - added Java text
 * 
 * Bevat Datum class from scratch
 */

public class Datum implements Comparable<Datum>
{

	/**
	 * Private Variabelen
	 * 
	 * int dag, maand, jaar
	 * int[] DAGEN_PER_MAAND
	 * String[] MAANDEN_NAAR_TEKST
	 */
	
	private int dag, maand, jaar;
	private static final int[] DAGEN_PER_MAAND = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private static final String[] MAANDEN_NAAR_TEKST = {
		"ongeldige maand",
		"januari", "februari", "maart",	"april",
		"mei", "juni", "juli", "augustus",
		"september", "oktober", "november", "december"
		};
		
	/**
	 * 
	 * Getters and setters
	 */
	public int getDag() 
	{
		return dag;
	}

	
	public int getMaand() 
	{
		return maand;
	}

	
	public int getJaar() 
	{
		return jaar;
	}

	private boolean isSchrikkeljaar(int jaar)
	{
		if ((jaar % 4 == 0 && jaar % 100 !=0 ) || (jaar % 400 == 0 ))
			return true;
	
		return false;
	}
	
	public void setDatum(int dag, int maand, int jaar) throws IllegalArgumentException
	{
		
		if(maand < 1 || maand > 12)
			throw new IllegalArgumentException("Maand moet tussen 1 en 12 zijn !!");
		
		if(isSchrikkeljaar(jaar))
		{
			if (maand == 2)
			{
				if(dag > 29)
					throw new IllegalArgumentException("Dag moet tussen 1 en 29 zijn !!");
			}
		}
		else
		{
			if(dag < 1 || dag > DAGEN_PER_MAAND[maand])
				throw new IllegalArgumentException(String.format("Dag moet tussen 1 en %d zijn !!", DAGEN_PER_MAAND[maand]));
		}

		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
		
	}
	
	/**
	 * Constructors
	 * 
	 * Datum() : Sets the date to system date
	 * 
	 * Datum(Datum datum) : Sets the date using a Datum object
	 * 
	 * Datum(int dag, int maand, int jaar) : Sets the date using 3 integers for day, month and year
	 * 
	 * Datum(String datum) : Sets the date using a string format dd/mm/yyyy separated with a /
	 * 
	 */

	public Datum() throws IllegalArgumentException
	{
		Date systeemDatum = new Date();
		setDatum(systeemDatum.getDate(),systeemDatum.getMonth()+1,1900 + systeemDatum.getYear());
	}
	
	public Datum(Datum datum) throws IllegalArgumentException
	{
		setDatum(datum.dag, datum.maand, datum.jaar);
		
	}
	
	public Datum(int dag, int maand, int jaar) throws IllegalArgumentException
	{
		setDatum(dag, maand, jaar);
	}
	
	public Datum(String datum) throws IllegalArgumentException
	{
		//if (datum.length() != 10)
		//	throw new IllegalArgumentException("Datum moet in formaat dd/mm/jjjj zijn met /-teken !");
		
		String[] datumtekst= datum.split("/");
		if (datumtekst.length!=3){
			throw new IllegalArgumentException("Datum moet in formaat dd/mm/jjjj zijn met /-teken !");
		}
		
		setDatum(Integer.parseInt(datumtekst[0]),Integer.parseInt(datumtekst[1]),Integer.parseInt(datumtekst[2]));
		//setDatum(Integer.parseInt(datum.substring(0,2)),
		//		Integer.parseInt(datum.substring(3,5)), 
		//		Integer.parseInt(datum.substring(6,10)));
	}
	
	/**
	 * Other methods
	 */
	
	public String getDatumInAmerikaansFormaat()
	{
		return jaar + "/" + maand + "/" + dag;
	}
	
	public String getDatumInEuropeesFormaat()
	{
		return dag + "/" + maand + "/" + jaar;
	}
		
	@Override
	public String toString() 
	{
		return dag+"/"+maand+"/"+jaar;
	}
	
	public String toLongString(){
		return dag + " " + MAANDEN_NAAR_TEKST[maand] + " "+ jaar;		
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) //vergelijken van geheugen adressen van de objecten
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj; //object casten
		if (dag != other.dag)
			return false;
		if (maand != other.maand)
			return false;
		if (jaar != other.jaar)
			return false;
		return true;
		// TODO Auto-generated method stub
		//return super.equals(arg0);
	}

	public int getDatumInAantalDagen()
	{
		
		int resultaat = 0;
				
		for(int i=0; i<=jaar-1; i++)
		{
			if(isSchrikkeljaar(jaar))
				resultaat += 366;
			else
				resultaat += 365;
		}

		for(int i=1; i<=maand-1;i++)
		{
			resultaat += DAGEN_PER_MAAND[i];
		}
		resultaat += dag;
		
		return resultaat;
	}
	
	public int compareTo(Datum datum) 
	{
		return datum.getDatumInAantalDagen() - this.getDatumInAantalDagen();
	}
	
	public boolean kleinerDan(Datum d)
	{
		if (this.compareTo(d) < 0)
			return true;
		else
			return false;
	}
	
	public int verschilInJaren(Datum d)
	{
		if (this.compareTo(d) < 0)
			return (-this.compareTo(d))/365;
		else			
			return this.compareTo(d)/365; 
	}
	
	public int verschilInMaanden(Datum d)
	{			
		if (this.compareTo(d) < 0)
			return -this.compareTo(d)/(365/12);
		else			
			return this.compareTo(d)/(365/12);
	}
	
	public int verschilInDagen(Datum d)
	{		
		if (this.compareTo(d) < 0)
			return -this.compareTo(d);
		else			
			return this.compareTo(d); 
	}
	
	
	//Needs some finetunig, doesn't work correctly
	public void veranderDatum(int aantalDagen)
	{
		
		if (aantalDagen > 0)
		{
			for (int i=1; i<=aantalDagen; i++)
			{
				dag++;
				
				if(dag > DAGEN_PER_MAAND[maand]){
					dag = 1;
					maand++;
					
					if(maand == 13){
						maand = 1;
						dag = 1;
						jaar++;
					}
					
				}
			}	
		}
		else
		{
			for (int i=-1; i>=aantalDagen; i--)
			{
				if(dag == 1){
					maand--;
					if(maand == 0){
						maand = 12;
						dag = 31;
						jaar--;
					}
					dag = DAGEN_PER_MAAND[maand];
				}
				else{
					dag--;
				}
			}	
		}
	}
	
	public Datum veranderDatumObject(int aantalDagen)
	{
		Datum newDate = new Datum(this);
		newDate.veranderDatum(aantalDagen);
		
		return newDate;
	}
	
	//Main method used only for testing when Junit test van not available
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Datum d = new Datum("19/02/2014");
		Datum d1 = new Datum(19,2,2014);
		Datum d3 = new Datum();
		System.out.println(d3);
//		System.out.println(d);
//		System.out.println(d.getDatumInAmerikaansFormaat());
//		System.out.println(d.getDatumInEuropeesFormaat());
//		System.out.println(d.getDatumInAantalDagen());
//		System.out.println(d1.getDatumInAantalDagen());
//		System.out.println(d.kleinerDan(d1));
//		System.out.println(d.verschilInJaren(d1));
//		System.out.println(d.verschilInMaanden(d1));
//		d1.veranderDatum(1200);
//		System.out.println(d1);
//		System.out.println(d.getDatumInAantalDagen());
//		System.out.println(d1.getDatumInAantalDagen());
//		System.out.println(d1.verschilInDagen(d));
//		Datum d2 = d.veranderDatumObject(10);
//		System.out.println(d2);
	}

}

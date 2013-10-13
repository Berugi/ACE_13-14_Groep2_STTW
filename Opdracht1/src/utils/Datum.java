package utils;
import java.util.Date;

//import domain.Tijd;


public class Datum implements Comparable<Datum>
{

	/**
	 * Variabelen
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

	/*public void setDag(int dag) throws IllegalArgumentException
	{
		if(dag < 1 || dag > 31)
			throw new IllegalArgumentException("Dag moet tussen 1 en 31 zijn !!");
		
		this.dag = dag;
	}*/

	public int getMaand() 
	{
		return maand;
	}

	/*public void setMaand(int maand) throws IllegalArgumentException
	{
		if(maand < 1 || maand > 12)
			throw new IllegalArgumentException("Maand moet tussen 1 en 12 zijn !!");
		this.maand = maand;
	}*/

	public int getJaar() 
	{
		return jaar;
	}

	/*public void setJaar(int jaar) 
	{
		this.jaar = jaar;
	}*/

	private boolean isSchrikkeljaar(int jaar)
	{
		if ((jaar % 4 == 0 && jaar % 100 !=0 ) || (jaar % 400 == 0 ))
			return true;
	
		return false;
	}
	
	public void setDatum(int dag, int maand, int jaar) throws IllegalArgumentException
	{
		//boolean result = false;
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
		//result = true;
		
		//return result;
	}
	/**
	 * Constructors
	 */

	public Datum() throws IllegalArgumentException
	{
		Date systeemDatum = new Date();
		setDatum(systeemDatum.getDate(),systeemDatum.getMonth(),1900 + systeemDatum.getYear());
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
		if (datum.length() != 10)
			throw new IllegalArgumentException("Datum moet in formaat dd/mm/jjjj zijn met /-teken !");
		
		setDatum(Integer.parseInt(datum.substring(0,2)),
				Integer.parseInt(datum.substring(3,5)), 
				Integer.parseInt(datum.substring(6,10)));
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
		
		resultaat += dag;
		
		for(int i=1; i<=maand-1;i++)
		{
			resultaat += DAGEN_PER_MAAND[maand];
		}
		
		for(int i=1; i <= jaar; i++)
		{
			if(isSchrikkeljaar(jaar))
				resultaat += 366;
			else
				resultaat += 365;
		}
		
		return resultaat;
	}
	
	@Override
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
	
	
	
	/**
	 * 
	 * Main method
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Datum d = new Datum("19/01/2001");
		Datum d1 = new Datum(19,1,2014);
		System.out.println(d);
		System.out.println(d.getDatumInAmerikaansFormaat());
		System.out.println(d.getDatumInEuropeesFormaat());
		System.out.println(d.getDatumInAantalDagen());
		System.out.println(d1.getDatumInAantalDagen());
		System.out.println(d.kleinerDan(d1));
		System.out.println(d.verschilInJaren(d1));
	}

}

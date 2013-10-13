package model;

import java.util.Arrays;

import utils.Datum;

public class Quiz implements Comparable<Opdracht>, Cloneable{
	
	//data members
	private String onderwerp;
	private int[] leerjaren;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private Leraar auteur;
	private Datum datumRegistratie;
	
	//getters & setters

	protected String getOnderwerp() {
		return onderwerp;
	}

	private void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	
	protected int[] getLeerjaren() {
		return leerjaren;
	}
	
	private void setLeerjaren(int[] leerjaren) {
		this.leerjaren = new int[leerjaren.length];
		for(int i = 0; i < leerjaren.length; i++) {
			this.leerjaren[i] = leerjaren[i];
		}
	}

	protected Boolean getIsTest() {
		return isTest;
	}

	private void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}

	protected Boolean getIsUniekeDeelname() {
		return isUniekeDeelname;
	}

	private void setIsUniekeDeelname(Boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}

	protected Leraar getAuteur() {
		return auteur;
	}

	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	
	
	//constructors


	public Quiz(String onderwerp, int[] leerjaren, Boolean isTest,
			Boolean isUniekeDeelname, Leraar auteur) {
		super();
		setOnderwerp(onderwerp);
		setLeerjaren(leerjaren);
		setIsTest(isTest);
		setIsUniekeDeelname(isUniekeDeelname);
		setAuteur(auteur);
	}

	// Override methodes - standard	
	@Override
	public String toString() {
		return "Quiz [onderwerp=" + onderwerp + ", leerjaren="
				+ Arrays.toString(leerjaren) + ", isTest=" + isTest
				+ ", isUniekeDeelname=" + isUniekeDeelname + ", auteur="
				+ auteur + ", datumRegistratie=" + datumRegistratie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime
				* result
				+ ((datumRegistratie == null) ? 0 : datumRegistratie.hashCode());
		result = prime * result + ((isTest == null) ? 0 : isTest.hashCode());
		result = prime
				* result
				+ ((isUniekeDeelname == null) ? 0 : isUniekeDeelname.hashCode());
		result = prime * result + Arrays.hashCode(leerjaren);
		result = prime * result
				+ ((onderwerp == null) ? 0 : onderwerp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (auteur != other.auteur)
			return false;
		if (datumRegistratie == null) {
			if (other.datumRegistratie != null)
				return false;
		} else if (!datumRegistratie.equals(other.datumRegistratie))
			return false;
		if (isTest == null) {
			if (other.isTest != null)
				return false;
		} else if (!isTest.equals(other.isTest))
			return false;
		if (isUniekeDeelname == null) {
			if (other.isUniekeDeelname != null)
				return false;
		} else if (!isUniekeDeelname.equals(other.isUniekeDeelname))
			return false;
		if (!Arrays.equals(leerjaren, other.leerjaren))
			return false;
		if (onderwerp == null) {
			if (other.onderwerp != null)
				return false;
		} else if (!onderwerp.equals(other.onderwerp))
			return false;
		return true;
	}
	
	
	public int compareTo(Opdracht o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

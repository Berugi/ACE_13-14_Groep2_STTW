package model;

public class Quiz {
	
	//data members
	private String onderwerp;
	private int[] leerjaren;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private Leraar auteur;
	
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
}

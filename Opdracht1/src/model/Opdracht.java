package model;

public class Opdracht {
	
	//data members
	
	private String vraag;
	private String juisteAntwoord;
	private int maxAantalPogingen;
	private String[] antwoordHints;
	//private IetsMetTijd ??? maxAntwoordTijd
	private int maxAntwoordTijd;
	private Leraar auteur;
	
	//getters & setters
	
	protected String getVraag() {
		return vraag;
	}

	private void setVraag(String vraag) {
		this.vraag = vraag;
	}

	protected String getJuisteAntwoord() {
		return juisteAntwoord;
	}

	private void setJuisteAntwoord(String juisteAntwoord) {
		this.juisteAntwoord = juisteAntwoord;
	}

	protected int getMaxAantalPogingen() {
		return maxAantalPogingen;
	}

	private void setMaxAantalPogingen(int maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}

	protected String[] getAntwoordHints() {
		return antwoordHints;
	}

	private void setAntwoordHints(String[] antwoordHints) {
		this.antwoordHints = antwoordHints;
	}
	
	protected int getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}
	
	private void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	
	protected Leraar getAuteur() {
		return auteur;
	}
	
	//constructors
	
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen,
			int maxAntwoordTijd, Leraar auteur, String ... antwoordHints) {
		setVraag(vraag);
		setJuisteAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAantalPogingen(maxAntwoordTijd);
		setAuteur(auteur);
		setAntwoordHints(antwoordHints);
	}
	
	//methods
	
	public Boolean IsJuisteAntwoord(String antwoord) {
		return (antwoord == juisteAntwoord) ? true : false;
	}
	
}

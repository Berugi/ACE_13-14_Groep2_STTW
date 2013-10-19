package model;

import model.baseclasses.OpdrachtBase;
import model.enums.Leraar;
import model.enums.OpdrachtCategorie;
import model.interfaces.IValideerbaar;

public class Opsomming  extends OpdrachtBase implements IValideerbaar {

	public Opsomming() {
		// TODO Auto-generated constructor stub
	}

	public Opsomming(String vraag, String juisteAntwoord,
			int maxAantalPogingen, int maxAntwoordTijd, Leraar auteur,
			OpdrachtCategorie categorie, String... antwoordHints) {
		super(vraag, juisteAntwoord, maxAantalPogingen, maxAntwoordTijd,
				auteur, categorie, antwoordHints);
		// TODO Auto-generated constructor stub
	}

	public boolean isValide(String antwoord) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}

	// Methods
	
	
}

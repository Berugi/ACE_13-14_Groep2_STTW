package persistence.interfaces;

import model.QuizCatalogus;
import model.OpdrachtCatalogus;

public interface IPersistenceStrategy {
	
	//Object readByID(Object o);
	
	// Alle bewerkingen (insert, update, delete) worden gedaan in het programma. Het is de initiële dataset die wordt ingelezen bij het opstarten
	// en het finale resultaat dat wordt weggeschreven bij het afsluiten.
	
	public boolean ReadData(QuizCatalogus qc,OpdrachtCatalogus oc);
	public boolean WriteData();
	
}

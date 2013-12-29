package persistence.interfaces;

import model.ObservableQuizCatalogus;
import model.ObservableOpdrachtCatalogus;

public interface IPersistenceStrategy {
	
	//Object readByID(Object o);
	
	// Alle bewerkingen (insert, update, delete) worden gedaan in het programma. Het is de initiële dataset die wordt ingelezen bij het opstarten
	// en het finale resultaat dat wordt weggeschreven bij het afsluiten.
	
	public void ReadData(ObservableQuizCatalogus qc,ObservableOpdrachtCatalogus oc) throws Exception;
	public void WriteData() throws Exception;
	
}

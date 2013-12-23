package persistence.interfaces;

public interface IPersistenceStrategy {
	
	//Object readByID(Object o);
	
	// Alle bewerkingen (insert, update, delete) worden gedaan in het programma. Het is de initiële dataset die wordt ingelezen bij het opstarten
	// en het finale resultaat dat wordt weggeschreven bij het afsluiten.
	
	public boolean ReadData();
	public boolean WriteData();
	
}

package model.enums;

/**
 * 
 * @author Tom Vaes
 * 
 * @version 20131013-01 - Initial version
 * @version 20131020-01 - modified by Tom Vaes - Added methods and variable
 * @version 20131026-01 - modified by Wim Ombelets - changed naming to be a little clearer
 *
 * Bevat QuizCatalogues informatie
 */

public enum QuizStatus {
	INCONSTRUCTIE("In Constructie"),
	AFGEWERKT("Afgewerkt"),
	OPENGESTELD("Opengesteld"),
	LAATSTEKANS("Laatste Kans");


	private final String description;

	public String getDescription()
	{
		return description;
	}

	private QuizStatus(String description)
	{
		this.description = description;
	}
}

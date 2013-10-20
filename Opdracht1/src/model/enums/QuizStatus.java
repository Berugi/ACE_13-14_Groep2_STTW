package model.enums;

/**
 * 
 * @author Tom Vaes
 * 
 * @version 20131013-01 - Initial version
 * @version 20131020-01 - modified by Tom Vaes - Added methods and variable
 *
 * Bevat QuizCatalogues informatie
 */

public enum QuizStatus {
	INCONSTRUCTIE("In Constructie"),
	AFGEWERKT("Afgewerkt"),
	OPENGESTELD("Opengesteld"),
	LAATSTEKANS("Laatste Kans");
	
	private final String statusVanQuiz;
	
	public String getStatusVanQuiz()
	{
		return statusVanQuiz;
	}
	
	QuizStatus(String statusVanQuiz)
	{
		this.statusVanQuiz = statusVanQuiz;
	}
}

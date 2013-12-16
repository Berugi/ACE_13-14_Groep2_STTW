package model.interfaces;

/**
 * 
 * @author wim ombelets
 * @version 20131014-01 initial commit
 *
 */
public interface IValideerbaar {
	public boolean isValide(String antwoord);
	public String getValideerTekst();
}

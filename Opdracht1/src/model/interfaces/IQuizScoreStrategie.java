package model.interfaces;

import model.Quiz;

/**
 * Mechanisme om Quiz scores te berekenen
 * 
 * @author Wim Ombelets
 * @version 20140112-01 - initial commit
 *
 */
public interface IQuizScoreStrategie {

	int berekenScore(Quiz q);
	
}

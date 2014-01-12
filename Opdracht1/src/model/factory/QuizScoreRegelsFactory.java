package model.factory;

import model.interfaces.IQuizScoreStrategie;
import model.strategy.QuizScoreStrategieGemakkelijk;
import model.strategy.QuizScoreStrategieMoeilijk;
import model.strategy.QuizScoreStrategieNormaal;

/**
 * Een factory om score regels te produceren.
 * 
 * @author Wim Ombelets
 * @version 20140112-01 - initial commit
 *
 */
public class QuizScoreRegelsFactory {

	private static QuizScoreRegelsFactory instance = null;
	
	private QuizScoreRegelsFactory() { }
	
	public QuizScoreRegelsFactory getInstance() {
		
		if(instance == null)
			instance = new QuizScoreRegelsFactory();
		return instance;
		
	}
	
	public IQuizScoreStrategie getQuizScoreStrategie(String choice) throws NullPointerException, IllegalArgumentException {
		
		if(choice == null || choice.isEmpty())
			throw new NullPointerException("Choice cannot be null or empty.");
		
		String c = choice.toLowerCase().trim();
		
		switch(c) {
		case "gemakkelijk":
			return new QuizScoreStrategieGemakkelijk();
		case "normaal":
			return new QuizScoreStrategieNormaal();
		case "moeilijk":
			return new QuizScoreStrategieMoeilijk();
		default:
			throw new IllegalArgumentException("Invalid choice.");	
		}
		
	}
}

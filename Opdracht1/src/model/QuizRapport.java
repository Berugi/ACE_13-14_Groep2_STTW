package model;

import model.interfaces.IQuizRapport;

/**
 * Represents a QuizRapport
 * 
 * @author Wim Ombelets
 * @version 20131212-01 - initial commit
 *
 */
public class QuizRapport implements IQuizRapport, Comparable<QuizRapport>, Cloneable {

	//data members
	private QuizDeelname quizDeelname;
	
	//getters & setters
	public QuizDeelname getQuizDeelname() {
		return quizDeelname;
	}

	private void setQuizDeelname(QuizDeelname quizDeelname) {
		this.quizDeelname = quizDeelname;
	}

	public String toonRapport() {
		return this.toString();
	}
	
	//constructor
	public QuizRapport(final QuizDeelname quizDeelname) {
		if(quizDeelname != null)
			setQuizDeelname(quizDeelname);
	}

	//methods
	public int compareTo(QuizRapport other) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
		
	    if(this == other)
	    	return EQUAL;
	    
	    //QuizRapport wordt vergeleken op basis van QuizDeelname
	    if(this.getQuizDeelname().getLeerling() == other.getQuizDeelname().getLeerling()) {
	    	return this.getQuizDeelname().getDatumDeelname().compareTo(other.getQuizDeelname().getDatumDeelname());
	    }
	    
	    return EQUAL;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((quizDeelname == null) ? 0 : quizDeelname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof QuizRapport)) {
			return false;
		}
		QuizRapport other = (QuizRapport) obj;
		if (quizDeelname == null) {
			if (other.quizDeelname != null) {
				return false;
			}
		} else if (!quizDeelname.equals(other.quizDeelname)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

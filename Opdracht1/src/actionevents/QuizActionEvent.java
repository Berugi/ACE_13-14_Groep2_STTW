package actionevents;

import java.awt.event.ActionEvent;

import model.enums.Leraar;
import model.enums.QuizStatus;
import utils.Datum;
import model.Quiz;

/**
 * 
 * @author Tom Scheepers / Wim Ombelets
 *
 */

public class QuizActionEvent extends ActionEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Quiz quiz;
	
	public void setActionData(Quiz q){
		if (q!=null){
		this.quiz=q;}
	}
	
	public Quiz getActionData(){
		return this.quiz;
	}
	
	public QuizActionEvent(Object source, int id,String command,Quiz q){
		super(source,id,command);
		this.setActionData(q);
	}

	@Override
	public String getActionCommand() {

		return super.getActionCommand();

	}
	
	@Override
	public Object getSource() {

		return super.getSource();

	}
}

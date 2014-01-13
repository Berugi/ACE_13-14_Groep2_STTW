package actionevents;

import java.awt.event.ActionEvent;

import model.Quiz;

/**
 * ActionEvent dat ook de relevante Quiz data van dat event meeneemt. 
 * 
 * @author Wim Ombelets
 * @version 20131231-01 - initial commit
 * @version 20140111-01 - modified by Tom Scheepers - gemigreerd naar eigen package
 *
 */

public class QuizActionEvent extends ActionEvent {
	
	private static final long serialVersionUID = 1L;
	
	private Quiz quiz;
	
	public void setActionData(Quiz q){
		
		if (q!=null)
			this.quiz=q;
		
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

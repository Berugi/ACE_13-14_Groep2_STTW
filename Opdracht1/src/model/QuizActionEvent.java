package model;

import java.awt.event.ActionEvent;

/**
 * An ActionEvent that can also carry a Quiz Object, related to that event
 * 
 * @author Wim Ombelets
 * @version 20140104-01 - initial commit
 * 
 */
public class QuizActionEvent extends ActionEvent {

	private static final long serialVersionUID = 1L;
	private Quiz eventData;

	public Quiz getEventData() {

		return eventData;

	}

	private void setEventData(Quiz eventData) {

		if (eventData != null)
			this.eventData = eventData;

	}

	public QuizActionEvent(Object source, int id, String command, Quiz eventData) {

		super(source, id, command);
		setEventData(eventData);

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

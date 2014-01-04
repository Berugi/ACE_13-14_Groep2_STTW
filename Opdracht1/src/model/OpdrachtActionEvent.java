package model;

import java.awt.event.ActionEvent;

import model.baseclasses.Opdracht;

/**
 * An ActionEvent that can also carry an Opdracht Object, related to that event
 * 
 * @author Wim Ombelets
 * @version 20140104-01 - initial commit
 * 
 */
public class OpdrachtActionEvent extends ActionEvent {

	private static final long serialVersionUID = 1L;
	private Opdracht eventData;

	public Opdracht getEventData() {

		return eventData;

	}

	private void setEventData(Opdracht eventData) throws NullPointerException {

		if (eventData == null)
			throw new NullPointerException();
		else
			this.eventData = eventData;

	}

	public OpdrachtActionEvent(Object source, int id, String command, Opdracht eventData) {

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

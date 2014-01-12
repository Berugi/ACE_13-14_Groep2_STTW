package model;

import java.util.Set;

import model.baseclasses.Opdracht;

import javax.swing.table.AbstractTableModel;

public class GeselecteerdeOpdrachtTableModel extends AbstractTableModel {

	private Set<QuizOpdracht> quizopdrachtlijst;
	private String[] columnNames = {"opdracht","MaxScore"};
	
	public GeselecteerdeOpdrachtTableModel(Set<QuizOpdracht> quizopdrachten){
		this.quizopdrachtlijst=quizopdrachten;
	}
	
	public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return quizopdrachtlijst.size();
    }

    public String getColumnName(int col) {
    	return columnNames[col];
       
    }

    public Object getValueAt(int row, int col) {
    	QuizOpdracht quizopdracht = (QuizOpdracht) quizopdrachtlijst.toArray()[row];
    	Object value = null;
    	switch(col){
    	case 0:
    		value = quizopdracht.getOpdracht();
    		break;
    	case 1:
    		value = quizopdracht.getMaxScore();
    		break;
    	}
    	return value;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}

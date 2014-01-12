package model;

import model.baseclasses.Opdracht;

import javax.swing.table.AbstractTableModel;

public class OpdrachtTableModel extends AbstractTableModel {

	private ObservableOpdrachtCatalogus opdrachtlijst;
	private String[] columnNames = {"opdrachtID","vraag","maxAantalPogingen","maxAntwoordTijd","auteur","categorie"};
	
	public OpdrachtTableModel(ObservableOpdrachtCatalogus oc){
		this.opdrachtlijst=oc;
	}
	
	public int getColumnCount() {
        return 6;
    }

    public int getRowCount() {
        return opdrachtlijst.size();
    }

    public String getColumnName(int col) {
    	return columnNames[col];
       
    }

    public Object getValueAt(int row, int col) {
    	Opdracht opdracht = opdrachtlijst.getCatalogus().get(row);
    	Object value = null;
    	switch(col){
    	case 0: 
    		value = opdracht.getOpdrachtID();
    		break;
    	case 1:
    		value = opdracht.getVraag();
    		break;
    	case 2:
    		value = opdracht.getMaxAantalPogingen();
    		break;
    	case 3:
    		value = opdracht.getMaxAntwoordTijd();
    		break;
    	case 4:
    		value = opdracht.getAuteur();
    		break;
    	case 5:
    		value = opdracht.getOpdrachtCategorie();
    		break;
    	}
    	return value;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}

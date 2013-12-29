package utils;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Tom Vaes
 * @version 20131228-01 - Initial version
 *
 */

public abstract class GenericTableModel extends AbstractTableModel {

	private String[] columnNames;
	private Object[][] data;

	public GenericTableModel(int[] columnWidth){ 
		setTableModel(columnWidth);
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	
	public Object[][] getData() {
		return data;
	}
	
	public void setData(Object[][] data) {
		this.data = data;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return (data == null ? 0 : data.length);
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void setValue(Object value, int row, int col){
		data[row][col] = value;
	}
	
	public Class getColumnClass(int c) {
		Object object = getValueAt(0, c);
		if (object == null)
			return null;
		return object.getClass();
	}
		
	
	public abstract boolean isCellEditable(int row, int col);

	public abstract void setValueAt(Object value, int row, int col);

	public abstract void setTableModel(int[] columnWidth);

	public abstract void updateLineTotal(int row);
	
}

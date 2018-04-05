package fr.ocr.model;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import voiture.option.Option;

public class TableModelOption extends AbstractTableModel implements DefaultTableModel {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<Option> options = new ArrayList<Option>();
	    private String[] columnNames = { "ID", "NOM", "PRIX"};

	    public TableModelOption(List<Option> _options){
	         this.options = _options;
	      
	    }
	    
	    public Option getItem(int index){
	         return options.get(index);
	    }
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }
	    public int getRowCount() {
	       return this.options.size();
	    }  
	    public int getColumnCount() {
	       return this.columnNames.length;
	    }
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Option si = options.get(rowIndex);
	        switch (columnIndex) {
	            case 0: 
	                return si.getId();
	            case 1:
	                return si.getNom();
	            case 2:
	                return si.getPrix() + "€";
	           }
	           return null;
	   }
	   public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0:
	               return String.class;
	             case 1:
	               return String.class;
	             case 2:
	               return String.class;
	             }
	             return null;
	      }
	   @Override
	   public void addRow(Object row){
		   	options.add((Option)row);
	        fireTableDataChanged();
	    }
	   @Override
	   public void removeRow(int row){
		   	options.remove(row);
	        fireTableDataChanged();
	    }
	   public boolean isCellEditable(int row, int col){
		      return true;
	}
}

package fr.ocr.model;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import voiture.Marque;
import voiture.moteur.Moteur;
import voiture.option.Option;

public class TableModelMarque extends AbstractTableModel implements DefaultTableModel {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<Marque> marques = new ArrayList<Marque>();
	    private String[] columnNames = { "ID", "NOM"};

	    public TableModelMarque(List<Marque> _marques){
	         this.marques = _marques;
	      
	    }
	    
	    public Marque getItem(int index){
	         return marques.get(index);
	    }
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }
	    public int getRowCount() {
	       return this.marques.size();
	    }  
	    public int getColumnCount() {
	       return this.columnNames.length;
	    }
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Marque si = marques.get(rowIndex);
	        switch (columnIndex) {
	            case 0: 
	                return si.getId();
	            case 1:
	                return si.getNom();
	           }
	           return null;
	   }
	   public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0:
	               return String.class;
	             case 1:
	               return String.class;
	             }
	             return null;
	      }
	   @Override
	   public void addRow(Object row){
		   	marques.add((Marque)row);
	        fireTableDataChanged();
	    }
	   @Override
	   public void removeRow(int row){
		   	marques.remove(row);
	        fireTableDataChanged();
	    }
	   public boolean isCellEditable(int row, int col){
		      return true;
	}
}

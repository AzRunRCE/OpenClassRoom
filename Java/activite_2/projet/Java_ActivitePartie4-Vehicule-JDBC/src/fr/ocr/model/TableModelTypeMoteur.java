package fr.ocr.model;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import voiture.moteur.TypeMoteur;
import voiture.option.Option;

public class TableModelTypeMoteur extends AbstractTableModel implements DefaultTableModel {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<TypeMoteur> typeMoteurs = new ArrayList<TypeMoteur>();
	    private String[] columnNames = { "ID", "NOM"};

	    public TableModelTypeMoteur(List<TypeMoteur> _typeMoteurs){
	         this.typeMoteurs = _typeMoteurs;     
	    }
	    
	    public TypeMoteur getItem(int index){
	         return typeMoteurs.get(index);
	    }
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }
	    public int getRowCount() {
	       return this.typeMoteurs.size();
	    }  
	    public int getColumnCount() {
	       return this.columnNames.length;
	    }
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	TypeMoteur si = typeMoteurs.get(rowIndex);
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
		   typeMoteurs.add((TypeMoteur)row);
	        fireTableDataChanged();
	    }
	   @Override
	   public void removeRow(int row){
		   typeMoteurs.remove(row);
	        fireTableDataChanged();
	    }
	   public boolean isCellEditable(int row, int col){
		      return true;
	}
}

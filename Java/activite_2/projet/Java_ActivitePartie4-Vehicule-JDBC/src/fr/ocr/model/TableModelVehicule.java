package fr.ocr.model;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import voiture.Vehicule;

public class TableModelVehicule extends AbstractTableModel implements DefaultTableModel {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<Vehicule> vehicules = new ArrayList<Vehicule>();
	    private String[] columnNames = { "MARQUE", "MOTEUR", "PRIX",
	                "NOM", "ID", "ACTION", "DETAIL"};

	    public TableModelVehicule(List<Vehicule> _vehicules){
	         this.vehicules = _vehicules;
	      
	    }
	    
	    public Vehicule getItem(int index){
	         return vehicules.get(index);
	    }
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }
	    public int getRowCount() {
	       return this.vehicules.size();
	    }  
	    public int getColumnCount() {
	       return this.columnNames.length;
	    }
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Vehicule si = vehicules.get(rowIndex);
	        switch (columnIndex) {
	        	case 0:
	        		return si.getMarque();
	           
	            case 1:
	                return si.getMoteur();
	            case 2:
	                return si.getPrix() + "€";
	            case 3:
	                return si.getNom() ;
	            case 4: 
	                return si.getId();
	            case 5:
	                return "SUPPRIMER";
	            case 6:
	                return "DETAIL";
	        
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
	             case 3:
	               return String.class;
	             case 4:
	               return String.class;
	             case 5:
	               return String.class;
	             case 6:
	               return String.class;
	             }
	             return null;
	      }
	   @Override
	   public void addRow(Object row){
		   	vehicules.add((Vehicule)row);
	        fireTableDataChanged();
	    }
	   @Override
	   public void removeRow(int row){
		   	vehicules.remove(row);
	        fireTableDataChanged();
	    }
	   public boolean isCellEditable(int row, int col){
		      return true;
		   }
}

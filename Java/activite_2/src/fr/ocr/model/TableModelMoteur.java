package fr.ocr.model;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import voiture.moteur.Moteur;
import voiture.option.Option;

public class TableModelMoteur extends AbstractTableModel implements DefaultTableModel {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<Moteur> moteurs = new ArrayList<Moteur>();
	    private String[] columnNames = { "ID", "NOM", "CARBURANT"};

	    public TableModelMoteur(List<Moteur> _moteurs){
	         this.moteurs = _moteurs;
	      
	    }
	    
	    public Moteur getItem(int index){
	         return moteurs.get(index);
	    }
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }
	    public int getRowCount() {
	       return this.moteurs.size();
	    }  
	    public int getColumnCount() {
	       return this.columnNames.length;
	    }
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Moteur si = moteurs.get(rowIndex);
	        switch (columnIndex) {
	            case 0: 
	                return si.getId();
	            case 1:
	                return si.getCylindre();
	            case 2:
	                return si.getType().toString();
	            case 3:
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
	             case 3:
	               return String.class;
	             }
	             return null;
	      }
	   @Override
	   public void addRow(Object row){
		   	moteurs.add((Moteur)row);
	        fireTableDataChanged();
	    }
	   @Override
	   public void removeRow(int row){
		   	moteurs.remove(row);
	        fireTableDataChanged();
	    }
	   public boolean isCellEditable(int row, int col){
		      return true;
	}
}

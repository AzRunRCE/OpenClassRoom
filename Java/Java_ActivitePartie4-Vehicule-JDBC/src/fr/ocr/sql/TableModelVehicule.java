package fr.ocr.sql;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import voiture.Vehicule;

public class TableModelVehicule extends AbstractTableModel implements TableModel {
	 	private List<Vehicule> li = new ArrayList<Vehicule>();
	    private String[] columnNames = { "MARQUE", "MOTEUR", "PRIX",
	                "NOM", "ID", "ACTION", "DETAIL"};

	    public TableModelVehicule(List<Vehicule> list){
	         this.li = list;
	      
	    }

	    @Override
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }

	    @Override     
	    public int getRowCount() {
	        return li.size();
	    }

	    @Override        
	    public int getColumnCount() {
	        return 7; 
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Vehicule si = li.get(rowIndex);
	        switch (columnIndex) {
	            case 0: 
	                return si.getMarque();
	            case 1:
	                return si.getMoteur();
	            case 2:
	                return si.getPrix();
	            case 3:
	                return si.getNom();
	            case 4:
	                return si.getId();
	        
	           }
	           return null;
	   }

	   @Override
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
	   public void addRow(Vehicule row){
	        li.add(row);
	        fireTableDataChanged();
	    }
	   public void removeRow(Integer row){
		   	li.remove(row);
	        fireTableDataChanged();
	    }
}

package fr.ocr.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ButtonListener implements ActionListener{

	  private int column, row;
	  private JTable table;
	  private int nbre = 0;
	  private JButton button;

	  public void setColumn(int col){this.column = col;}
	  public void setRow(int row){this.row = row;}
	  public void setTable(JTable table){this.table = table;}

	  public JButton getButton(){return this.button;}

	  public void actionPerformed(ActionEvent event) {
	    System.out.println("coucou du bouton : " + ((JButton)event.getSource()).getText());
	    //On affecte un nouveau libell� � une celulle de la ligne
	    ((AbstractTableModel)table.getModel()).setValueAt("New Value " + (++nbre), this.row, (this.column -1));   
	    //Permet de dire � notre tableau qu'une valeur a chang� � l'emplacement d�termin� par les valeurs pass�es en param�tres
	    ((AbstractTableModel)table.getModel()).fireTableCellUpdated(this.row, this.column - 1);
	    this.button = ((JButton)event.getSource());
	  }
	}
package fr.ocr.ihm.listener;

import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JTable;

import fr.ocr.controler.DetailVehiculeControler;
import fr.ocr.ihm.DetailVehiculeView;
import fr.ocr.model.DefaultTableModel;
import voiture.Vehicule;
public class ViewDetailVehiculeListener extends ButtonListener {

	
	private int row;
    private JTable table;
    private JButton button;
    public void setColumn(int col){}
    public void setRow(int row){this.row = row;}
    public void setTable(JTable table){this.table = table;}
    public JButton getButton(){return this.button;}
	
	public void actionPerformed(ActionEvent e) {		
		Vehicule vehiculeModel =(Vehicule)((DefaultTableModel)table.getModel()).getItem(this.row);
		DetailVehiculeView newVehiculeView = new DetailVehiculeView(null, "Detail du véhcule - " + vehiculeModel.getNom().toString(), true,vehiculeModel);
		DetailVehiculeControler detailVehiculeControler  = new DetailVehiculeControler(vehiculeModel,newVehiculeView);
		newVehiculeView.setVisible(true);	
	}
}

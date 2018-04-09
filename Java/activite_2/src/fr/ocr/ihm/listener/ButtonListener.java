package fr.ocr.ihm.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

import fr.ocr.model.DefaultTableModel;
import fr.ocr.sql.DAO;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Vehicule;

public class ButtonListener implements ActionListener {
    
    private int row;
    private JTable table;
    private JButton button;
     
    public void setColumn(int col){}
    public void setRow(int row){this.row = row;}
    public void setTable(JTable table){this.table = table;}
    public JButton getButton(){return this.button;}
     
    public void actionPerformed(ActionEvent event) {
    	Vehicule vehiculeModel = (Vehicule)((DefaultTableModel)table.getModel()).getItem(this.row);
    	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
    	DAO<Vehicule> vehiculeDAO =	adf.getVehiculeDAO();
    	vehiculeDAO.delete(vehiculeModel);
    	((DefaultTableModel)table.getModel()).removeRow(this.row);
    }
}

package fr.ocr.ihm.listener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import fr.ocr.controler.NewVehiculeControler;
import fr.ocr.ihm.NewVehiculeView;
import fr.ocr.model.DefaultTableModel;
import fr.ocr.model.TableModelVehicule;
import fr.ocr.sql.DAO;
import fr.ocr.sql.DAOException;
import fr.ocr.sql.DAOTableFactory;
import fr.ocr.sql.DatabaseTable;
import fr.ocr.sql.HsqldbConnection;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Vehicule;


public class NewVehiculeListener extends ButtonListener {

		JFrame frame;

		public NewVehiculeListener(JFrame f) {
		
			frame = f;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Vehicule vehiculeModel = new Vehicule();
				NewVehiculeView newVehiculeView = new NewVehiculeView(null, "Add a new vehicule", true,vehiculeModel);
				NewVehiculeControler newVehiculeControler  = new NewVehiculeControler(vehiculeModel,newVehiculeView);
				newVehiculeView.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				new DAOException(e1.getMessage());
			}
			frame.getContentPane().removeAll();
			frame.getContentPane().add(
					new JScrollPane(DAOTableFactory.getTable(
							HsqldbConnection.getInstance(), DatabaseTable.VEHICULE)),
					BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		}
		
		
}

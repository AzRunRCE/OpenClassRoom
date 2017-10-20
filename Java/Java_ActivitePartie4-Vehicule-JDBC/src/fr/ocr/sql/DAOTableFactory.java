package fr.ocr.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import fr.ocr.ihm.ButtonEditor;
import fr.ocr.ihm.ButtonRenderer;
import fr.ocr.ihm.listener.ViewDetailVehiculeListener;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Vehicule;

/**
 * Classe permettant de créer l'objet JTable en fonction de la table que nous
 * souhaitons afficher
 * 
 * @author cysboy
 */
public class DAOTableFactory {

	public static JTable getTable(Connection conn, DatabaseTable table) {
		JTable tab = new JTable();

		try {

		

			/**
			 * On affiche les boutons uniquement pour la table véhicule
			 */
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			DAO<Vehicule> vehiculeDAO =  adf.getVehiculeDAO();
			List<Vehicule> Vehicules = vehiculeDAO.getAll();
			tab.setModel(new TableModelVehicule(Vehicules));
			tab.setRowHeight(30);
				tab.getColumn("ACTION").setCellRenderer(
						new ButtonRenderer("SUPPRIMER"));
				tab.getColumn("ACTION").setCellEditor(
						new ButtonEditor(new JCheckBox(), "SUPPRIMER"));
				tab.getColumn("DETAIL").setCellRenderer(
						new ButtonRenderer("DETAIL"));
				tab.getColumn("DETAIL").setCellEditor(
						new ButtonEditor(new JCheckBox(), "DETAIL",
								new ViewDetailVehiculeListener()));
			
			tab.setRowHeight(30);
		} catch (Exception e) {
			new DAOException(e.getMessage());
		}

		return tab;
	}

}

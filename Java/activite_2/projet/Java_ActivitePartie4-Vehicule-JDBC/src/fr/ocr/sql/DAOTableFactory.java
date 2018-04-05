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
import fr.ocr.ihm.listener.ButtonListener;
import fr.ocr.ihm.listener.ViewDetailVehiculeListener;
import fr.ocr.model.TableModelMarque;
import fr.ocr.model.TableModelMoteur;
import fr.ocr.model.TableModelOption;
import fr.ocr.model.TableModelTypeMoteur;
import fr.ocr.model.TableModelVehicule;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.moteur.TypeMoteur;
import voiture.option.Option;

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
			
			tab = new JTable();

			/**
			 * On affiche les boutons uniquement pour la table véhicule
			 */
			if (table.equals(DatabaseTable.VEHICULE)) {
					AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
					DAO<Vehicule> vehiculeDAO = adf.getVehiculeDAO();
					List<Vehicule> Vehicules = vehiculeDAO.getAll();
					tab.setModel(new TableModelVehicule(Vehicules));
					tab.getColumn("ACTION").setCellRenderer(new ButtonRenderer("SUPPRIMER"));
					tab.getColumn("ACTION").setCellEditor(new ButtonEditor(new JCheckBox("SUPPRIMER"), new ButtonListener()));
					tab.getColumn("DETAIL").setCellRenderer(new ButtonRenderer("DETAIL"));
					tab.getColumn("DETAIL").setCellEditor(new ButtonEditor(new JCheckBox("DETAIL"), new ViewDetailVehiculeListener()));
			}
			
			if (table.equals(DatabaseTable.MOTEUR)) {
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Moteur> moteurDAO = adf.getMoteurDAO();
				List<Moteur> moteurs = moteurDAO.getAll();
				tab.setModel(new TableModelMoteur(moteurs));
			}
			
			if (table.equals(DatabaseTable.OPTION)) {
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Option> optionDAO = adf.getOptionDAO();
				List<Option> Options = optionDAO.getAll();
				tab.setModel(new TableModelOption(Options));
			
			}
			
			if (table.equals(DatabaseTable.TYPEMOTEUR)) {
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<TypeMoteur> typeMoteurDAO = adf.getTypeMoteurDAO();
				List<TypeMoteur> typeMoteurs = typeMoteurDAO.getAll();
				tab.setModel(new TableModelTypeMoteur(typeMoteurs));
			}
			
			if (table.equals(DatabaseTable.MARQUE)) {
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Marque> MarqueDAO = adf.getMarqueDAO();
				List<Marque> Marques = MarqueDAO.getAll();
				tab.setModel(new TableModelMarque(Marques));
			}
			tab.setRowHeight(30);
		} catch (Exception e) {
			new DAOException(e.getMessage());
		}

		return tab;
	}

}

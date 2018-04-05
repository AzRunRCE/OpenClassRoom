package fr.ocr.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.ocr.ihm.NewVehiculeView;
import fr.ocr.sql.DAO;
import fr.ocr.sql.DAOException;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Marque;
import voiture.Vehicule;
import voiture.VehiculeDAO;
import voiture.moteur.Moteur;
import voiture.option.Option;

public class NewVehiculeControler {
	
	private Vehicule m_model;
	private NewVehiculeView  m_view;
	public NewVehiculeControler (Vehicule vehiculeModel, NewVehiculeView newVehiculeView)
	{
		m_model = vehiculeModel;
		m_view = newVehiculeView;
		m_view.addCloseEditionListener(new CloseEditionListener());
		m_view.addCancelEditionListener(new CancelEditionListener());
		
	}
	class CloseEditionListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        
	        	if (m_view.getPrix() <= 0) 	{
					JOptionPane.showMessageDialog(null, "Le champ 'prix' est obligatoire", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					return;
	        	}
	         	if (m_view.getNom() == null || m_view.getNom().isEmpty()) 	{
					JOptionPane.showMessageDialog(null, "Le champ 'nom' est obligatoire", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					return;
	        	}
	        	try {
					m_view.setVisible(false);
					AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
					DAO<Vehicule> vehiculeDAO =	adf.getVehiculeDAO();
					Vehicule vehicule = new Vehicule(0, m_view.getNom(), m_view.getMarque(), m_view.getMoteur(), m_view.getPrix());
					for (Option opt : m_view.getOptions())
						vehicule.addOption(opt);
					vehiculeDAO.create(vehicule);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Le vehicule n'a pas pu être sauvegardé", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
	        }
	 }
	 class CancelEditionListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	m_view.setVisible(false);
	        }
	 }
}

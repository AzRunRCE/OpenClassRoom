package fr.ocr.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.ocr.ihm.DetailVehiculeView;
import voiture.Vehicule;


public class DetailVehiculeControler {
	private Vehicule m_model;
	private DetailVehiculeView  m_view;
	
	public DetailVehiculeControler (Vehicule vehiculeModel, DetailVehiculeView detailVehiculeView)
	{
		m_model = vehiculeModel;
		m_view = detailVehiculeView;
		m_view.addCloseEditionListener(new CloseEditionListener());
	}
	
	class CloseEditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	m_view.setVisible(false);
        }
	}
}

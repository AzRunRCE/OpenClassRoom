package fr.ocr.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import voiture.Vehicule;

public class DetailVehiculeView extends JDialog {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nomLabel, marqueLabel,typeMoteurLabel,prixLabel,optionsLabel,panTotalLabel;
	private JButton closeEdition;
	private Vehicule vehicule;
	
	public DetailVehiculeView(JFrame parent, String title, boolean modal, Vehicule _vehicule){
		super(parent, title, modal);
		this.setSize(600, 390);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		vehicule = _vehicule;
		this.initComponent();
	}
	
	private void initComponent(){

	    //Le nom
	    JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(220, 60));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom du véhicule"));
	    nomLabel = new JLabel(vehicule.getNom());
	    panNom.add(nomLabel);
	 
	
	    //La Marque
	    JPanel panMarque = new JPanel();
	    panMarque.setBackground(Color.white);
	    panMarque.setPreferredSize(new Dimension(220, 60));
	    panMarque.setBorder(BorderFactory.createTitledBorder("Marque du véhicule"));
	  
	    marqueLabel = new JLabel(vehicule.getMarque().toString());
	    panMarque.add(marqueLabel);
	
	    //Le Type de Moteur
	    JPanel panTypeMoteur = new JPanel();
	    panTypeMoteur.setBackground(Color.white);
	    panTypeMoteur.setBorder(BorderFactory.createTitledBorder("Type de moteur du véhicule"));
	    panTypeMoteur.setPreferredSize(new Dimension(440, 60));
	    typeMoteurLabel = new JLabel(vehicule.getMoteur().toString() );
	    panTypeMoteur.add(typeMoteurLabel);
	
	    
	    //Le Prix
	    JPanel panPrix= new JPanel();
	    panPrix.setBackground(Color.white);
	    panPrix.setBorder(BorderFactory.createTitledBorder("Prix du véhicule"));
	    panPrix.setPreferredSize(new Dimension(240, 60));
	    prixLabel = new JLabel("Prix sans option : " + vehicule.getPrix().toString() + "€");
	    panPrix.add(prixLabel);
	    
	    //Les Options Disponibles
	    JPanel panOptions= new JPanel();
	    panOptions.setBackground(Color.white);
	    panOptions.setBorder(BorderFactory.createTitledBorder("Options Disponibles"));
	    panOptions.setPreferredSize(new Dimension(580, 60));
	    optionsLabel = new JLabel(vehicule.GetOptionsString() );
	    panOptions.add(optionsLabel);
	    
	    //Le Prix Total
	    JPanel panTotalPrix= new JPanel();
	    panTotalPrix.setBackground(Color.white);
	    panTotalPrix.setBorder(BorderFactory.createTitledBorder("Prix TOTAL du véhicule"));
	    panTotalPrix.setBackground(Color.GREEN);
	    panTotalPrix.setPreferredSize(new Dimension(580, 60));
	    panTotalLabel = new JLabel(vehicule.getPrixTotal().toString() + "€");
	    panTotalPrix.add(panTotalLabel);
	
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panNom);
	    content.add(panMarque);
	    content.add(panTypeMoteur);
	    content.add(panPrix);
	    content.add(panOptions);
	    content.add(panTotalPrix);
	    closeEdition = new JButton("OK");
	    content.add(closeEdition);
	    this.getContentPane().add(content, BorderLayout.CENTER);   
	}  
	
	public void addCloseEditionListener(ActionListener mal) {
		closeEdition.addActionListener(mal);
	}
}
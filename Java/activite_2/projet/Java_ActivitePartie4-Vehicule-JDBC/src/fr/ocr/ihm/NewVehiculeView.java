package fr.ocr.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import fr.ocr.sql.DAO;
import fr.ocr.sql.factory.AbstractDAOFactory;
import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.moteur.MoteurDAO;
import voiture.moteur.TypeMoteur;
import voiture.option.Option;

public class NewVehiculeView extends JDialog {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nomLabel, marqueLabel,typeMoteurLabel,prixLabel,optionsLabel,panTotalLabel;
	private JTextField nom;
	private JFormattedTextField prix;
	private JComboBox<Marque> JComboMarque;
	private JComboBox<Moteur> JComboMoteur;
	private AbstractDAOFactory adf;
	private JButton closeEdition;
	private JButton cancelEdition;
	private Vehicule vehicule;
	DAO<Marque> marqueDAO;
	DAO<Moteur> moteurDAO;
	JCheckBox rbBarreDeToit;
	JCheckBox rbClim;
	JCheckBox rbSiegeChauffant;
	JCheckBox rbGPS;
	JCheckBox rbToitOuvrant;
	
	public NewVehiculeView(JFrame parent, String title, boolean modal, Vehicule _vehicule){
	    super(parent, title, modal);
	    adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	    this.setSize(600, 330);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	    vehicule = _vehicule;
	    this.initComponent();   
	}
	
	public String getNom()
	{
		return nom.getText();
	}
	
	public Marque getMarque()
	{
		return (Marque)JComboMarque.getSelectedItem();
	}
	
	public Moteur getMoteur()
	{
		return (Moteur)JComboMoteur.getSelectedItem();
	}
	
	public double getPrix()
	{
		if (prix.getValue() == null)
			return -1;
		return ((Number) prix.getValue()).doubleValue();
	}
	
	public List<Option> getOptions()
	{
		List<Option> options = new  ArrayList<Option>();
		if (rbToitOuvrant.isSelected())
			options.add(new Option(0,"Toit ouvrant",456));
		if (rbClim.isSelected())
			options.add(new Option(1,"Climatisation",846));
		if (rbSiegeChauffant.isSelected())
			options.add(new Option(3,"Sièges chauffants",2589));
		if (rbGPS.isSelected())
			options.add(new Option(2,"GPS",1599));
		if (rbBarreDeToit.isSelected())
			options.add(new Option(4,"Barres de toit",123));
		return options;
	}
	
	
	private void initComponent(){

		marqueDAO = adf.getMarqueDAO();
		moteurDAO = adf.getMoteurDAO();
		 
	    JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(220, 60));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom du véhicule"));
	    nomLabel = new JLabel("Nom:");
	    nom = new JTextField();
	    nom.setPreferredSize(new Dimension(100, 25));
	    panNom.add(nomLabel);
	    panNom.add(nom);
    
	    JPanel panMarque = new JPanel();
	    panMarque.setBackground(Color.white);
	    panMarque.setPreferredSize(new Dimension(220, 60));
	    panMarque.setBorder(BorderFactory.createTitledBorder("Marque du véhicule"));
	    JComboMarque = new JComboBox<Marque>();
	    for(Marque marqueItm : marqueDAO.getAll())
	    	JComboMarque.addItem(marqueItm);

	    marqueLabel = new JLabel("Marque:");
	    panMarque.add(marqueLabel);
	    panMarque.add(JComboMarque);
	    
	    JPanel panTypeMoteur = new JPanel();
	    panTypeMoteur.setBackground(Color.white);
	    panTypeMoteur.setBorder(BorderFactory.createTitledBorder("Type de moteur du véhicule"));
	    panTypeMoteur.setPreferredSize(new Dimension(440, 60));
	    JComboMoteur = new JComboBox<Moteur>();
	    for( Moteur MoteurItm : moteurDAO.getAll())
	    	JComboMoteur.addItem(MoteurItm);
	    typeMoteurLabel = new JLabel("Moteur: ");
	    
	    panTypeMoteur.add(typeMoteurLabel);
	    panTypeMoteur.add(JComboMoteur);
	    
	    JPanel panPrix= new JPanel();
	    panPrix.setBackground(Color.white);
	    panPrix.setBorder(BorderFactory.createTitledBorder("Prix du véhicule"));
	    panPrix.setPreferredSize(new Dimension(240, 60));
	    prixLabel = new JLabel("Prix: ");
	    prix = new JFormattedTextField(NumberFormat.getNumberInstance());

	    prix.setPreferredSize(new Dimension(100, 25));
	    panPrix.add(prixLabel);
	    panPrix.add(prix);
	    
	    JPanel panOptions= new JPanel();
	    panOptions.setBackground(Color.white);
	    panOptions.setBorder(BorderFactory.createTitledBorder("Options Disponibles"));
	    panOptions.setPreferredSize(new Dimension(580, 60));
	    rbBarreDeToit = new JCheckBox("Barre de toit");
	    rbClim = new JCheckBox("Climatisation");
	    rbGPS = new JCheckBox("GPS");
	    rbSiegeChauffant = new JCheckBox("Sièges chauffants");
	    rbToitOuvrant = new JCheckBox("Toit Ouvrant");
	    panOptions.add(rbBarreDeToit);
	    panOptions.add(rbClim);
	    panOptions.add(rbGPS);
	    panOptions.add(rbSiegeChauffant);
	    panOptions.add(rbToitOuvrant);
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panNom);
	    content.add(panMarque);
	    content.add(panTypeMoteur);
	    content.add(panPrix);
	    content.add(panOptions);
	
	    closeEdition = new JButton("OK");
	    cancelEdition =  new JButton("Cancel");
	    content.add(closeEdition);
	    content.add(cancelEdition);
	    
	    this.getContentPane().add(content, BorderLayout.CENTER);
	   
	}  
	
	public void addCloseEditionListener(ActionListener mal) {
		closeEdition.addActionListener(mal);
    }
    
	public void addCancelEditionListener(ActionListener cal) {
    	cancelEdition.addActionListener(cal);
    }
}
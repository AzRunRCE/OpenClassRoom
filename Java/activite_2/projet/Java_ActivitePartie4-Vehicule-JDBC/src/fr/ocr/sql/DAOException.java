package fr.ocr.sql;

import javax.swing.JOptionPane;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String mess) {
		super(mess);
		
		JOptionPane.showMessageDialog(null, mess, "Erreur de recherche dans le DAO",
				JOptionPane.ERROR_MESSAGE);
	}

}

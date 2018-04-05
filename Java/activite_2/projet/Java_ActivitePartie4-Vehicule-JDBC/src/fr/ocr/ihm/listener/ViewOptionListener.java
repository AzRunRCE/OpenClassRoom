package fr.ocr.ihm.listener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fr.ocr.sql.DAOException;
import fr.ocr.sql.DAOTableFactory;
import fr.ocr.sql.DatabaseTable;
import fr.ocr.sql.HsqldbConnection;

public class ViewOptionListener implements ActionListener {
	
	JFrame frame;
	public ViewOptionListener(JFrame f) {	
		frame = f;
	}
	public void actionPerformed(ActionEvent e) {

		try {
			frame.getContentPane().removeAll();
			frame.getContentPane().add(
					new JScrollPane(DAOTableFactory.getTable(
							HsqldbConnection.getInstance(),DatabaseTable.OPTION)),
					BorderLayout.CENTER);
			frame.getContentPane().revalidate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			new DAOException(e1.getMessage());
		}
	}
}

package voiture;
import voiture.moteur.*;
import voiture.Vehicule;
import voiture.Marque;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.*;
import fr.ocr.sql.factory.*;

public class VehiculeDAO extends DAO<Vehicule> {

public VehiculeDAO(Connection conn) {
  super(conn); 
}

public ArrayList<String> getColumn() {
	ArrayList<String> col = new ArrayList<String>();
	 try {
		  	ResultSet result = this.connect.createStatement(
		  	ResultSet.TYPE_SCROLL_INSENSITIVE,
	    	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM VEHICULE LIMIT 1" );
			ResultSetMetaData resultMeta = result.getMetaData();
			int nbreColumn = resultMeta.getColumnCount();
			for (int i = 0; i < nbreColumn; i++)
				col.add(resultMeta.getColumnName(i + 1).toUpperCase());
	} catch (SQLException e) {
	  e.printStackTrace();
	}
	 return col;
}

public boolean create(Vehicule obj) {
  return false;
}

public boolean delete(Vehicule obj) {
  return false;
}
 
public boolean update(Vehicule obj) {
  return false;
}

public Vehicule find(int id) {
	Vehicule vehicule = new Vehicule();       
	
  try {
    ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM VEHICULE WHERE ID = " + id);
    if(result.first()) {
    	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		@SuppressWarnings("unchecked")
		DAO<Moteur> moteurDao = adf.getMoteurDAO();
		@SuppressWarnings("unchecked")
		DAO<Marque> marqueDao = adf.getMarqueDAO();
    	vehicule = new Vehicule(
        id, result.getString("NOM"),
        marqueDao.find(result.getInt("MARQUE")),
        moteurDao.find(result.getInt("MOTEUR")),
        Double.parseDouble(result.getString("PRIX"))
        );  
              
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return vehicule;
}

@Override
public List<Vehicule> getAll() {
	List<Vehicule> Vehicules = new ArrayList<Vehicule>();  
	try {
		 ResultSet result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM VEHICULE");
		  while(result.next()){   
			  AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				@SuppressWarnings("unchecked")
				DAO<Moteur> moteurDao = adf.getMoteurDAO();
				@SuppressWarnings("unchecked")
				DAO<Marque> marqueDao = adf.getMarqueDAO();
				Vehicule vehicule = new Vehicule(
				result.getInt("ID"), result.getString("NOM"),
		        marqueDao.find(result.getInt("MARQUE")),
		        moteurDao.find(result.getInt("MOTEUR")),
		        Double.parseDouble(result.getString("PRIX"))
		        );  
				Vehicules.add(vehicule);
		  }
		  

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return Vehicules;
}
}

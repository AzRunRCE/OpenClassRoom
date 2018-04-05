package voiture;
import voiture.moteur.*;
import voiture.option.Option;
import voiture.option.VehiculeOption;
import voiture.Vehicule;
import voiture.Marque;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
	 } catch (Exception e) {
			new DAOException(e.getMessage());
		}
	 return col;
}

public boolean create(Vehicule vehicule) {
	 try {
		 	Statement statement = connect.createStatement();
		 	ResultSet nextID = connect.prepareStatement("CALL NEXT VALUE FOR seq_vehicule_id").executeQuery();
			int ID = 0;
		 	if (nextID.next()) {ID = nextID.getInt(1);}
		 	statement.executeUpdate(String.format("INSERT INTO VEHICULE VALUES (%s,%s,%s,'%s',%s)" , 
		 			vehicule.getMarque().getId(),
		    		vehicule.getMoteur().getId(),
		    		vehicule.getPrix(),
		    		vehicule.getNom(),	
		    		ID));
			for(Option opt : vehicule.getOptions())
		 	{
			 	statement.executeUpdate( String.format("INSERT INTO VEHICULE_OPTION VALUES (%s,%s)" , ID, opt.getId()));
		 	}
			return true;

		  } catch (SQLException e) {
		    e.printStackTrace();
		    return false;
		  }
}

public boolean delete(Vehicule vehicule) {
	 try {
		 	Statement statement = connect.createStatement();
		
		 	String reqOption = String.format("DELETE FROM VEHICULE_OPTION WHERE ID_VEHICULE = %s" , vehicule.getId());
			statement.executeUpdate(reqOption);
		 	
			String req = String.format("DELETE FROM VEHICULE WHERE ID = %s" , vehicule.getId());  	
		 	statement.executeUpdate(req);
		    	
			return true;
		  }
	 catch (Exception e) {
		 new DAOException(e.getMessage());
		  return false;
	 }
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
				DAO<Moteur> moteurDao = adf.getMoteurDAO();
				DAO<Marque> marqueDao = adf.getMarqueDAO();
				DAO<Option> optionsDao =adf.getOptionDAO();
		    	vehicule = new Vehicule(
		        id, result.getString("NOM"),
		        marqueDao.find(result.getInt("MARQUE")),
		        moteurDao.find(result.getInt("MOTEUR")),
		        Double.parseDouble(result.getString("PRIX"))
		        );         
		    }
		} catch (Exception e) {
		new DAOException(e.getMessage());
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
				DAO<Moteur> moteurDao = (DAO<Moteur>) adf.getMoteurDAO();
				DAO<Marque> marqueDao = (DAO<Marque>) adf.getMarqueDAO();
				DAO<VehiculeOption> VehiculeOptionDAO = (DAO<VehiculeOption>) adf.getVehiculeOptionDAO();
		    	DAO<Option> OptionDAO = (DAO<Option>) adf.getOptionDAO();
				
		    	System.out.println(result.getInt("ID"));
		    	Vehicule vehicule = new Vehicule(			
		    			result.getInt("ID"), result.getString("NOM"),
		    			marqueDao.find(result.getInt("MARQUE")),
		    			moteurDao.find(result.getInt("MOTEUR")),
		    			Double.parseDouble(result.getString("PRIX")));
		    	
		    	for (VehiculeOption vOption: VehiculeOptionDAO.getAll())
		    	{
		    		if (vOption.getVehiculeId() == vehicule.getId())
		    			vehicule.addOption(OptionDAO.find(vOption.getoptionId()));
		    	}
		     
				Vehicules.add(vehicule);
		  }
		  

	 } catch (Exception e) {
			new DAOException(e.getMessage());
		}
	  return Vehicules;
}
}

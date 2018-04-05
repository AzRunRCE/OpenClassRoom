package voiture.option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.DAO;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.moteur.TypeMoteur;
public class VehiculeOptionDAO extends DAO<VehiculeOption> {
public VehiculeOptionDAO(Connection conn) {
  super(conn);
}

public boolean create(VehiculeOption obj) {
  return false;
}

public boolean delete(VehiculeOption obj) {
  return false;
}
 
public boolean update(VehiculeOption obj) {
  return false;
}
 

public List<VehiculeOption> getAll() {
	List<VehiculeOption> VehiculeOptions = new ArrayList<VehiculeOption>();  
	try {
			ResultSet result = this.connect.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM VEHICULE_OPTION");
		  while(result.next()){   
			  VehiculeOptions.add(new VehiculeOption(result.getInt("ID_VEHICULE"), result.getInt("ID_OPTION")));
		  }
		  

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return VehiculeOptions;
}


public VehiculeOption find(int id) {
	VehiculeOption vehiculeOption = null;      
	try {
		ResultSet result = this.connect.createStatement(
	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM VEHICULE_OPTION WHERE ID_VEHICULE = " + id);
		if(result.first()) {    	
			
			vehiculeOption =new VehiculeOption(result.getInt("ID_OPTION"), result.getInt("ID_VEHICULE"));
		}
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return vehiculeOption;
}
}

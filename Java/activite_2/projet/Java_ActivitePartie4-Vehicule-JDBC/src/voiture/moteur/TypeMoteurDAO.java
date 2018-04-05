package voiture.moteur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.DAO;
public class TypeMoteurDAO extends DAO<TypeMoteur> {
public TypeMoteurDAO(Connection conn) {
  super(conn);
}

public boolean create(TypeMoteur obj) {
  return false;
}

public boolean delete(TypeMoteur obj) {
  return false;
}
 
public boolean update(TypeMoteur obj) {
  return false;
}
 

public List<TypeMoteur> getAll() {
	List<TypeMoteur> typeMoteurs = new ArrayList<TypeMoteur>();  
	try {
		ResultSet result = this.connect.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM TYPE_MOTEUR");
		  while(result.next()){   
			  typeMoteurs.add(new TypeMoteur(result.getInt("ID"), result.getString("DESCRIPTION")));
		  }
		  

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return typeMoteurs;
}
 

public TypeMoteur find(int id) {
	TypeMoteur typeMoteur = new TypeMoteur();      
	try {
		ResultSet result = this.connect.createStatement(
	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM TYPE_MOTEUR WHERE ID = " + id);
		if(result.first()) {    	
		    	typeMoteur = new TypeMoteur(id, result.getString("DESCRIPTION"));               
		}
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return typeMoteur;
}
}

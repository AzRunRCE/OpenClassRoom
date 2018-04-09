package voiture;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.DAO;
public class MarqueDAO extends DAO<Marque> {
public MarqueDAO(Connection conn) {
  super(conn);
}

public boolean create(Marque obj) {
  return false;
}

public boolean delete(Marque obj) {
  return false;
}
 
public boolean update(Marque obj) {
  return false;
}
 
public List<Marque> getAll() {
	List<Marque> Marques = new ArrayList<Marque>();  
	try {
		  ResultSet result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM MARQUE");
		  while(result.next()){   
			  
			
			  Marques.add( new Marque(result.getInt("ID"), result.getString("NOM")));
		  }
		  

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return Marques;
}
 

public Marque find(int id) {
	Marque marque = new Marque();      
	
  try {
	  ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM MARQUE WHERE ID = " + id);
    if(result.first()) {
    	marque = new Marque(id, result.getString("NOM"));               
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return marque;
}
}

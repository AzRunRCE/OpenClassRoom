package voiture.moteur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.DAO;
import fr.ocr.sql.factory.AbstractDAOFactory;
public class MoteurDAO extends DAO<Moteur>{	
	public MoteurDAO(Connection conn) {
  super(conn);
  
}

public ArrayList<String> getColumn() {
	ArrayList<String> col = new ArrayList<String>();
	try {
	  	ResultSet result = this.connect.createStatement(
	  	ResultSet.TYPE_SCROLL_INSENSITIVE,
      	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM MOTEUR LIMIT 1" );
		ResultSetMetaData resultMeta = result.getMetaData();
		int nbreColumn = resultMeta.getColumnCount();
		for (int i = 0; i < nbreColumn; i++)
			col.add(resultMeta.getColumnName(i + 1).toUpperCase());
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return col;
}
	
public boolean create(Moteur obj) {
  return false;
}

public boolean delete(Moteur obj) {
  return false;
}
 
public boolean update(Moteur obj) {
  return false;
}
 


public Moteur find(int id) {
	Moteur moteur = new Moteur();      
	
  try {
	  ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM MOTEUR WHERE ID = " + id);
    if(result.first()) {
    	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		@SuppressWarnings("unchecked")
    	DAO<TypeMoteur> typeMoteurDao =adf.getTypeMoteurDAO();
    	moteur = new Moteur(id, typeMoteurDao.find(result.getInt("MOTEUR")),result.getString("CYLINDRE"),result.getDouble("PRIX"));               
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return moteur;
}

@Override
public List<Moteur> getAll() {
	List<Moteur> moteurs = new ArrayList<Moteur>();  
	try {
		  ResultSet result = this.connect.createStatement(
	      ResultSet.TYPE_SCROLL_INSENSITIVE,
	      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM MOTEUR");
		  while(result.next()){   
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				@SuppressWarnings("unchecked")
		    	DAO<TypeMoteur> typeMoteurDao =adf.getTypeMoteurDAO();
		    	Moteur moteur = new Moteur(result.getInt("ID"), typeMoteurDao.find(result.getInt("MOTEUR")),result.getString("CYLINDRE"),result.getDouble("PRIX"));               
		    	moteurs.add(moteur);
		  }

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return moteurs;
}


}

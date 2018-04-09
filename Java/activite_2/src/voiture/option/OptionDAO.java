package voiture.option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ocr.sql.DAO;
public class OptionDAO extends DAO<Option> {
public OptionDAO(Connection conn) {
  super(conn);
}

public boolean create(Option obj) {
  return false;
}

public boolean delete(Option obj) {
  return false;
}
 
public boolean update(Option obj) {
  return false;
}
 
public List<Option> getAll() {
	List<Option> Options = new ArrayList<Option>();  
	try {
		ResultSet result = this.connect.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM OPTION");
		  while(result.next()){   
			  Options.add(new Option(result.getInt("ID"), result.getString("DESCRIPTION"), result.getDouble("PRIX")));
		  }
		  

	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return Options;
}


public Option find(int id) {
	Option Options =null;  
	try {
		ResultSet result = this.connect.createStatement(
	    ResultSet.TYPE_SCROLL_INSENSITIVE,
	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM OPTION WHERE ID = " + id);
		if(result.first()) {    	
			Options =new Option(result.getInt("ID"), result.getString("DESCRIPTION"), result.getDouble("PRIX"));
		}
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return Options;
}
}

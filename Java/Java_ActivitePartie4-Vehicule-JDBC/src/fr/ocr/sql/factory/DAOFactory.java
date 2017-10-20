package fr.ocr.sql.factory;
import java.sql.Connection;

import fr.ocr.sql.DAO;
import fr.ocr.sql.HsqldbConnection;
import voiture.*;
import voiture.moteur.*;

public class DAOFactory  extends AbstractDAOFactory{
	
	  protected static final Connection conn = HsqldbConnection.getInstance();   

	  public  DAO getMarqueDAO(){
	    return new MarqueDAO(conn);
	  }

	  public DAO getMoteurDAO(){
	    return new MoteurDAO(conn);
	  }

	  public DAO getVehiculeDAO(){
	    return new VehiculeDAO(conn);
	  }

	  public DAO getTypeMoteurDAO(){
	    return new TypeMoteurDAO(conn);
	  }   

}


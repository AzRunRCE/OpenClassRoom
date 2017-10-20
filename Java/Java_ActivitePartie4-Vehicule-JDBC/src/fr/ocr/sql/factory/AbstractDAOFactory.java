package fr.ocr.sql.factory;

import fr.ocr.sql.DAO;
public abstract class AbstractDAOFactory {
	 public static final int DAO_FACTORY = 0;
	 public abstract  DAO getMarqueDAO();
	 public abstract  DAO getMoteurDAO();
	 public abstract  DAO getVehiculeDAO();
	 public abstract  DAO getTypeMoteurDAO();
  	 public static AbstractDAOFactory getFactory(int type){
		    switch(type){
		      case DAO_FACTORY:
		        return new DAOFactory();
		      default:
		        return null;
		    }
  	 }
}

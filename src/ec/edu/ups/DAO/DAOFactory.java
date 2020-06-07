package ec.edu.ups.DAO;

import ec.edu.ups.JPA.JPADAOFactory;
import ec.edu.ups.DAO.DAOFactory;


public  abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getDaoFactory() {
		return factory;
	}

	public abstract void createTables();
	
	public abstract LibroDAO getLibroDAO();
	
	public abstract CapituloDAO getcapCapituloDAO();
	
	public abstract AutorDAO getauAutorDAO();
}

package ec.edu.ups.JPA;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.DAO.CapituloDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return new JPALibro();
	}

	@Override
	public CapituloDAO getcapCapituloDAO() {
		// TODO Auto-generated method stub
		return new JPACapitulo();
	}

	@Override
	public AutorDAO getauAutorDAO() {
		// TODO Auto-generated method stub
		return new JPAAutor();
	}

	

}

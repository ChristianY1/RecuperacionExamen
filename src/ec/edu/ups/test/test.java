package ec.edu.ups.test;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.DAO.CapituloDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Autor;
import ec.edu.ups.Entidades.Capitulo;
import ec.edu.ups.Entidades.Libro;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibroDAO lib = DAOFactory.getDaoFactory().getLibroDAO();
		
		CapituloDAO cap = DAOFactory.getDaoFactory().getcapCapituloDAO();
		AutorDAO au = DAOFactory.getDaoFactory().getauAutorDAO();
		
		Libro l = new Libro("el principito", "6", 701);
		
		Autor a  = new Autor("antuan", "frances");
		
		Capitulo c = new Capitulo(34, "el depredador", l, a);
		
		
		
		l.addCapitulos(c);
		
		lib.create(l);
		
		
		
		
		

	}

}

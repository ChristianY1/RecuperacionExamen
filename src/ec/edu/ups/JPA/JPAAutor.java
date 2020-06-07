package ec.edu.ups.JPA;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.Entidades.Autor;

public class JPAAutor extends JPAGenericDAO<Autor, Integer> implements AutorDAO{

	public JPAAutor() {
		super(Autor.class);
		// TODO Auto-generated constructor stub
	}

}

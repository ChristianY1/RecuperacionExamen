package ec.edu.ups.JPA;

import ec.edu.ups.DAO.CapituloDAO;
import ec.edu.ups.Entidades.Capitulo;

public class JPACapitulo extends JPAGenericDAO<Capitulo, Integer> implements CapituloDAO{

	public JPACapitulo() {
		super(Capitulo.class);
		// TODO Auto-generated constructor stub
	}

}

package ec.edu.ups.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		AutorDAO autorDao = DAOFactory.getDaoFactory().getauAutorDAO();
		
		Libro l = new Libro("el principito", "6", 701);
		
		Autor a  = new Autor("antuan", "frances");
		
		Capitulo c = new Capitulo(45, "el depredador", l, a);
		Capitulo c2 = new Capitulo(35, "el depredador", l, a);
		
		
		l.addCapitulos(c);
		lib.create(l);
		cap.create(c2);

//		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
//		String jpql = "SELECT C FROM Capitulo c, Autor a WHERE a.codigo = c.codigo AND a.nombre = '"+ a.getNombre() +"'";
//		Capitulo cap1 = new Capitulo();
//		List<Capitulo> res = (List<Capitulo>) em.createQuery(jpql, Capitulo.class).getResultList();
//		int num = 0;
//		while (res != null) {
//			
//			cap1.setNumero(res.get(num).getNumero());
//			cap1.setLibro(res.get(num).getLibro());
//			cap1.setAutor(res.get(num).getAutor());
//			System.out.println("cpaitulo:" + cap1.getNumero() + cap1.getLibro() + cap1.getAutor());
//			num +=1;
//		}
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		String jpql = "SELECT C FROM Capitulo c, Autor a WHERE c.titulo = '"+ "el depredador" +"'";
		Capitulo cap1 = new Capitulo();
		List<Capitulo> res = (List<Capitulo>) em.createQuery(jpql, Capitulo.class).getResultList();
		System.out.println(res);
			
			
		
		
		
//		Libro l2 = new Libro("la abominacion", "6", 120);
//		
//		Autor a2  = new Autor("richi", "ingles");
//		
//		Capitulo c2 = new Capitulo(34, "el son", l2, a2);
//		
//		l2.addCapitulos(c2);
//		lib.create(l2);
		
//		Autor a1  = new Autor("Romero Tullet", "frances");
//		Autor a2  = new Autor("Rick Jhonson", "ingles");
//		Autor a3  = new Autor("Gabriel Garcia Marquez", "Colombiano");
//		autorDao.create(a1);
//		autorDao.create(a2);
//		autorDao.create(a3);
//		
//		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
//		
//		Autor autor = new Autor();
//		Query query2 = em.createQuery("SELECT a from Autor a WHERE a.codigo = " + 1 + "");
//		List<Autor> list = (List<Autor>) query2.getResultList();
//		try {
//			for (Autor e : list) {
//				autor.setCodigo(list.get(0).getCodigo());
//				autor.setNombre(list.get(0).getNombre());
//				autor.setNacionalidad(list.get(0).getNacionalidad());
//			}
//			System.out.println(autor);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("no hay autor");
//		}
//		
//	}
//		
		
		

	
	}
}

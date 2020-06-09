package ec.edu.ups.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.DAO.GenericDAO;
import ec.edu.ups.Entidades.Autor;
import ec.edu.ups.Entidades.Capitulo;








public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
	this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
    }


	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.persist(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		
	    }
		
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
		    em.merge(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			if (!em.contains(entity)) {
				entity = em.merge(entity);
			}
		    em.remove(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteByID(ID id) {
		// TODO Auto-generated method stub
		T entity = this.read(id);
		if (entity != null)
		    this.delete(entity);
		
	}
	 @SuppressWarnings("unchecked")
	    @Override
	    public List<T> find(String[] attributes, String[] values, String order, int index, int size) {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
					    // // Se configuran los predicados,
					    // combinados por AND
		Predicate predicate = criteriaBuilder.conjunction();
		for (int i = 0; i < attributes.length; i++) {
		    Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
		    // Predicate sig =
		    // criteriaBuilder.like(root.get(attributes[i]).as(String.class),
		    // values[i]);
		    predicate = criteriaBuilder.and(predicate, sig);
		}
		// Se establece el WHERE
		criteriaQuery.where(predicate);
		// Se establece el orden
		if (order != null)
		    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order))); // Se
										 // crea
										 // el
										 // resultado
		if (index >= 0 && size > 0) {
		    TypedQuery<T> tq = em.createQuery(criteriaQuery);
		    tq.setFirstResult(index);
		    tq.setMaxResults(size); // Se realiza la query
		    return tq.getResultList();
		} else {
		    // Se realiza la query
		    Query query = em.createQuery(criteriaQuery);
		    return query.getResultList();
		}

	    }


	@Override
	public Autor buscarAutor(int id) {
		// TODO Auto-generated method stub
		Autor autor = new Autor();
		Query query2 = em.createQuery("SELECT a from Autor a WHERE a.codigo = " + id + "");
		List<Autor> list = (List<Autor>) query2.getResultList();
		try {
			for (Autor e : list) {
				autor.setCodigo(list.get(0).getCodigo());
				autor.setNombre(list.get(0).getNombre());
				autor.setNacionalidad(list.get(0).getNacionalidad());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no hay autor");
		}
		return autor;
	}


	@Override
	public List<Capitulo> buscarNB(String nombre) {
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		String jpql = "SELECT C FROM Capitulo c, Autor a WHERE a.codigo = c.codigo AND a.nombre = '"+ nombre +"'";
		Capitulo cap1 = new Capitulo();
		List<Capitulo> res = (List<Capitulo>) em.createQuery(jpql, Capitulo.class).getResultList();	
		System.out.println(res);
		return res;
	}


	@Override
	public List<Capitulo> buscarTC(String capitulo) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		String jpql = "SELECT C FROM Capitulo c, Autor a WHERE a.codigo = c.codigo AND c.titulo = '"+ capitulo +"'";
		Capitulo cap1 = new Capitulo();
		List<Capitulo> res = (List<Capitulo>) em.createQuery(jpql, Capitulo.class).getResultList();	
		
		return res;
	}


	
	
	

	
	
	

}

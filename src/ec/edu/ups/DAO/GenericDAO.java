package ec.edu.ups.DAO;

import java.util.List;

import ec.edu.ups.Entidades.Autor;

public interface GenericDAO <T,ID> {

	public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByID(ID id);
    
    public Autor buscarAutor(int id);
    
    public List buscarNB(String nombre);
    
    public List buscarTC(String capitulo);

	List<T> find(String[] attributes, String[] values, String order, int index, int size);

	
}

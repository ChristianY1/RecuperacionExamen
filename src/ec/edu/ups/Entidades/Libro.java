package ec.edu.ups.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity

public class Libro implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "NOMBREL")
	private String nombre;
	private String ISBN;
	private int numPaginas;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
	private Set<Capitulo> capitulos = new HashSet<Capitulo>();
	
	public Libro() {
	
	}

	public Libro(String nombre, String iSBN, int numPaginas) {
		
		this.nombre = nombre;
		this.ISBN = iSBN;
		this.numPaginas = numPaginas;
		this.capitulos = capitulos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Set<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Set<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	public void addCapitulos(Capitulo capitulo) {
		this.capitulos.add(capitulo);
	}
	
	public void removeTelefono(Capitulo capitulo) {
		this.capitulos.remove(capitulo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
//	@Override
//	public String toString() {
//		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", ISBN=" + ISBN + ", numPaginas=" + numPaginas
//				+ ", capitulos=" + capitulos + "]";
//	}
	
   
}

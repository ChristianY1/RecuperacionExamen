package ec.edu.ups.Controladores;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Autor;
import ec.edu.ups.Entidades.Capitulo;
import ec.edu.ups.Entidades.Libro;

/**
 * Servlet implementation class AgregarLibroController
 */
@WebServlet("/AgregarLibroController")
public class AgregarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private Libro libro;
	private Capitulo capitulo;
	private Autor autor;
	private AutorDAO autorDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarLibroController() {
       libroDao = DAOFactory.getDaoFactory().getLibroDAO();
       autorDao = DAOFactory.getDaoFactory().getauAutorDAO();
       //libro = new Libro();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = null;
		int num1 = 0;
		try {
		

				Autor a1  = new Autor("Romero Tullet", "frances");
				Autor a2  = new Autor("Rick Jhonson", "ingles");
				Autor a3  = new Autor("Gabriel Garcia Marquez", "Colombiano");
				autorDao.create(a1);
				autorDao.create(a2);
				autorDao.create(a3);
			
				System.out.println("autores hechos");
				
					libro = new Libro();
			
					libro.setNombre(request.getParameter("nombre"));
					libro.setISBN(request.getParameter("ISBN"));
					libro.setNumPaginas(Integer.parseInt(request.getParameter("num")));
					
					capitulo = new Capitulo();
					capitulo.setNumero(Integer.parseInt(request.getParameter("numcap")));
					capitulo.setTitulo(request.getParameter("titulo"));
					capitulo.setLibro(libro);
					
					EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
					//Autor post = em.getReference(Autor.class,Integer.parseInt(request.getParameter("cautor")));
					capitulo.setAutor(em.getReference(Autor.class,Integer.parseInt(request.getParameter("cautor"))));
					
					
					libro.addCapitulos(capitulo);
					libroDao.create(libro);
					
					System.out.println("hecho !");
					libro = null;
					libroDao =  DAOFactory.getDaoFactory().getLibroDAO();
					url = "/JSPs/index.jsp";
		
				
				
				
			
			request.getRequestDispatcher(url).forward(request, response);
			
			
			//url = "InsertarAutorController";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

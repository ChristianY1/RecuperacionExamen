package ec.edu.ups.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Autor;
import ec.edu.ups.Entidades.Capitulo;
import ec.edu.ups.Entidades.Libro;

/**
 * Servlet implementation class InsertarAutorController
 */
@WebServlet("/InsertarAutorController")
public class InsertarAutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private Libro libro;
	private Capitulo capitulo;
	private AutorDAO autorDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAutorController() {
    	libroDao = DAOFactory.getDaoFactory().getLibroDAO();
    	autorDao = DAOFactory.getDaoFactory().getauAutorDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		int num = 0;
		HttpSession session = request.getSession(true);
		if (session.isNew()) {
			Autor a1  = new Autor("Romero Tullet", "frances");
			Autor a2  = new Autor("Rick Jhonson", "ingles");
			Autor a3  = new Autor("Gabriel Garcia Marquez", "Colombiano");
			autorDao.create(a1);
			autorDao.create(a2);
			autorDao.create(a3);
			session.setAttribute("accesos", 1);
			System.out.println("autores insertados actualizar");
			url = "/JSPs/index.jsp";
				
		} else {
			libro = new Libro();
			libro.setNombre(request.getParameter("nombre"));
			libro.setISBN(request.getParameter("ISBN"));
			libro.setNumPaginas(Integer.parseInt(request.getParameter("num")));
			
			
			
			
			
			
			
			libro.addCapitulos(capitulo);
			libroDao.create(libro);
			System.out.println("autores hechos");
			System.out.println("hecho !");
			libro = null;
			libroDao =  DAOFactory.getDaoFactory().getLibroDAO();
			
		
			url = "/JSPs/index.jsp";
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		
		//request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ec.edu.ups.Controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.AutorDAO;
import ec.edu.ups.DAO.CapituloDAO;
import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Autor;
import ec.edu.ups.Entidades.Capitulo;
import ec.edu.ups.Entidades.Libro;
import ec.edu.ups.JPA.JPAGenericDAO;

/**
 * Servlet implementation class Listar
 * @param <T>
 */
@WebServlet("/Listar")
public class Listar<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private CapituloDAO capituloDao;
	private AutorDAO autorDao;
	private Libro libro;
	private Capitulo capitulo;
	private Autor autor;
	private T llamar;
	
	private List<T> listas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        autorDao = DAOFactory.getDaoFactory().getauAutorDAO();
        autor = new Autor();
        
        libroDao = DAOFactory.getDaoFactory().getLibroDAO();
        libro = new Libro();
        
        capituloDao = DAOFactory.getDaoFactory().getcapCapituloDAO();
        capitulo = new Capitulo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			String nombre = request.getParameter("search");
			listas = capituloDao.buscarNB(nombre);
			request.setAttribute("listasT", listas);
			url = "JSPs/vista2.jsp";
			request.getRequestDispatcher(url).forward(request, response);
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

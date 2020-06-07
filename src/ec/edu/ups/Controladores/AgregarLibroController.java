package ec.edu.ups.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Libro;

/**
 * Servlet implementation class AgregarLibroController
 */
@WebServlet("/AgregarLibroController")
public class AgregarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private Libro libro;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarLibroController() {
       libroDao = DAOFactory.getDaoFactory().getLibroDAO();
       libro = new Libro();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

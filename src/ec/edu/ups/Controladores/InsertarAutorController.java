package ec.edu.ups.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.LibroDAO;
import ec.edu.ups.Entidades.Libro;

/**
 * Servlet implementation class InsertarAutorController
 */
@WebServlet("/InsertarAutorController")
public class InsertarAutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private Libro libro;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAutorController() {
//    	String url = null;
//		try {
//			libro.setNombre(request.getParameter("nombre"));
//			libro.setISBN(request.getParameter("ISBN"));
//			libro.setNumPaginas(Integer.parseInt(request.getParameter("num")));
//			
//			libroDao.create(libro);
//			
//			System.out.println("hecho!");
//			url = "/JSPs/index.jsp";
//		}catch (Exception e) {
//				// TODO: handle exception
//			}
//			request.getRequestDispatcher(url).forward(request, response);
        // TODO Auto-generated constructor stub
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

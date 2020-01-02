package fr.dawan.tileee.servlet;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.GenericDao;
import fr.dawan.tileee.dao.UserDao;

/**
 * Servlet implementation class Parametres
 */
@WebServlet("/Parametres")
public class Parametres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parametres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
    	HttpSession session = request.getSession();
    	if(action == "supprimercompte") {
    		System.out.println("réussi!");
    		try {
	    		UserDao usr = new UserDao("tileee");
	    		usr.delete((User)session.getAttribute("user"), true);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
		request.getRequestDispatcher("WEB-INF/views/parametres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/parametres.jsp").forward(request, response);
	}

}

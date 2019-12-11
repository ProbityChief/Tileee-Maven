package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.dao.CardDao;
import fr.dawan.tileee.dao.ConnectionDB;

/**
 * Servlet implementation class CreationStacks
 */
@WebServlet("/CreationStacks")
public class CreationStacks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationStacks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "1";
		}
		
		request.setAttribute("validation", action);
		
		request.getRequestDispatcher("WEB-INF/views/creationstacks.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		Card carteAAjouter = new Card();
		carteAAjouter.setMotATraduire(request.getParameter("motinitial"));
		carteAAjouter.setMotTraduit(request.getParameter("mottraduit"));
		carteAAjouter.setLangueInitiale(request.getParameter("langueinitiale"));
		carteAAjouter.setLangueTraduite(request.getParameter("langueatraduire"));
		carteAAjouter.setTag1(request.getParameter("tagaajouter"));
		
//		carteAAjouter.setTag2(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag3(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag4(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag5(request.getParameter("langueinitiale"));

		try {
			cnx = ConnectionDB.getConnection();
			CardDao.insertCard(carteAAjouter, cnx, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}

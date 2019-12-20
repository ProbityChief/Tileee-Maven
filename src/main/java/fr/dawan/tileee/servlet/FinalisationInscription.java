package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.ConnectionDB;
import fr.dawan.tileee.dao.GenericDAO;
import fr.dawan.tileee.dao.UserDao;

/**
 * Servlet implementation class FinalisationInscription
 */
@WebServlet("/FinalisationInscription")
public class FinalisationInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalisationInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String rand = request.getParameter("rand");
    	System.out.println("RAND = " + rand);
    	Connection cnx = null;
    	
    	try {
    	cnx = ConnectionDB.getConnection();
    	User utilisateur = UserDao.findByRand(rand, cnx , false);

        if(utilisateur.isValidation() == false){
                System.out.println(utilisateur.getMail() + " " + utilisateur.getLogin());
                utilisateur.setValidation(true);
                
    			UserDao userdao = new UserDao(GenericDAO.createEntityManager("tileee"));
    			userdao.update(utilisateur, true);
                HttpSession session = request.getSession();
                session.setAttribute("name", utilisateur.getLogin());
                request.setAttribute( "userMessage" , "Votre compte a �t� valid�! Merci."); 
            } else {
                request.setAttribute( "userMessage" , "Votre compte a d�ja �t� valid�! Merci."); 
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    	
		request.getRequestDispatcher("WEB-INF/views/finalisationinscription.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

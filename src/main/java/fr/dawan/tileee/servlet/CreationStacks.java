package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.CardDao;
import fr.dawan.tileee.dao.ConnectionDB;
import fr.dawan.tileee.dao.GenericDao;
import fr.dawan.tileee.dao.UserDao;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Card card = new Card();
		card.setUser(user);
		card.setWord(request.getParameter("motinitial"));
		card.setTranslation(request.getParameter("mottraduit"));
		card.setStarting_language(request.getParameter("langueinitiale"));
		card.setEnding_language(request.getParameter("langueatraduire"));
		
//		carteAAjouter.setTag2(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag3(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag4(request.getParameter("langueinitiale"));
//		carteAAjouter.setTag5(request.getParameter("langueinitiale"));

		try {
			CardDao carddao = new CardDao(GenericDao.createEntityManager("tileee"));
			carddao.insert(card, true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

	Tag tag = new Tag();
	tag.setTag(request.getParameter("tagaajouter"));
	tag.setUser_Id();
	tag.setCard_Id();
}

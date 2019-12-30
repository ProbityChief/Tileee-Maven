package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.GenericDAO;
import fr.dawan.tileee.dao.InvitationDAO;
import fr.dawan.tileee.dao.TagsDAO;
import fr.dawan.tileee.dao.UserDao;

/**
 * Servlet implementation class Invitation
 */
@WebServlet("/Invitation")
public class Invitation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invitation() {
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

		request.setAttribute("choix", action);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		InvitationDAO invitationdao = new InvitationDAO();
		List<fr.dawan.tileee.bean.Invitation> listInvitation = null;
		listInvitation = invitationdao.findInvitation(user.getId(), true);
		System.out.println(listInvitation.toString());
		session.setAttribute("listInvitation", listInvitation);
		request.getRequestDispatcher("WEB-INF/views/invitation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rand = request.getParameter("rand");
		TagsDAO tagsdao = new TagsDAO();
		tagsdao.cloneTagLib(rand);
		String tagName = getTagNameByRand(rand);
		request.setAttribute("tagName", tagName);
		doGet(request, response);
	}

}

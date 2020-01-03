package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;
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
//		if (action == "2") {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			TagsDAO tagsdao = new TagsDAO("tileee");
			Set<Tag> tagsList= tagsdao.findTags(user, true);
			Set<String> tags = new HashSet<String>();
			for(Tag T : tagsList) {
				tags.add(T.getTag_name());
			}
			request.setAttribute("lTag", tags);
//		}
		request.getRequestDispatcher("WEB-INF/views/invitation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rand = request.getParameter("rand");
		TagsDAO tagsdao = new TagsDAO("tileee");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		tagsdao.CloneTags(rand, user, false);
		Tag tag = tagsdao.findTagNameByRand(rand, true);
		String tagName = tag.getTag_name();
		request.setAttribute("tagName", tagName);
		doGet(request, response);
	}

}

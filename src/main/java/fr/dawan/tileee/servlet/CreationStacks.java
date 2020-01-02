package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import fr.dawan.tileee.dao.TagsDAO;
import fr.dawan.tileee.dao.UserDao;
import fr.dawan.tileee.validator.UserValidator;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		TagsDAO tagsdao = new TagsDAO("tileee");
		Set<Tag> tagsList= tagsdao.findTags(user, true);
		List<Tag> tagslist = new ArrayList<Tag>(tagsList);
		request.setAttribute("lTag", tagslist);
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
		System.out.println(user.getId());
		card.setWord(request.getParameter("motinitial"));
		card.setTranslation(request.getParameter("mottraduit"));
		card.setStarting_language(request.getParameter("langueinitiale"));
		card.setEnding_language(request.getParameter("langueatraduire"));
		String tagaajouter = new String(request.getParameter("tagaajouter"));
//		String tagacompleter1 = new String(request.getParameter("tagacompleter1"));
//		String tagacompleter2 = new String(request.getParameter("tagacompleter2"));
//		String tagacompleter3 = new String(request.getParameter("tagacompleter3"));
//		String tagacompleter4 = new String(request.getParameter("tagacompleter4"));
		
		TagsDAO tagdao = new TagsDAO("tileee");
		CardDao carddao = new CardDao("tileee");
		Tag tag = null;
		if (tagaajouter != null && !tagdao.tagExist(tagaajouter, true)) {
			tag = new Tag();
			tag.setTag_name(tagaajouter);
			String rand = UserValidator.hash(user.getLogin() + "_" + tagaajouter);
			tag.setRand(rand);
			tagdao.insert(tag, false);
			tag.addCard(card);
			tagdao.update(tag, false);
		} else if (tagaajouter != null && tagdao.tagExist(tagaajouter, true)) {
			tag = tagdao.findTagByTagname(tagaajouter, true);
		} else {
			request.getRequestDispatcher("WEB-INF/views/creationstacks.jsp").forward(request,response);	
		}

		card.addTag(tag);
		tag.addCard(card);
		carddao.insert(card, true);
		tagdao.update(tag, true);
		

			
		
//		Tag tag1 = null;
//		if (tagacompleter1 != null) {
//			TagsDAO tagdao1 = new TagsDAO("tileee");
//			tag1 = tagdao1.findTagByTagname(tagacompleter1, true);
//			tag1.addCard(card);
//		}
//		
//		Tag tag2 = null;
//		if (tagacompleter2 != null) {
//			TagsDAO tagdao2 = new TagsDAO("tileee");
//			tag2 = tagdao2.findTagByTagname(tagacompleter2, true);
//			tag2.addCard(card);
//		}
//		
//		Tag tag3 = null;
//		if (tagacompleter3 != null) {
//			TagsDAO tagdao3 = new TagsDAO("tileee");
//			tag3 = tagdao3.findTagByTagname(tagacompleter3, true);
//			tag3.addCard(card);
//		}
//		
//		Tag tag4 = null;
//		if (tagacompleter4 != null) {
//			TagsDAO tagdao4 = new TagsDAO("tileee");
//			tag4 = tagdao4.findTagByTagname(tagacompleter4, true);
//			tag4.addCard(card);
//		}
	
//	carteAAjouter.setTag2(request.getParameter("langueinitiale"));
//	carteAAjouter.setTag3(request.getParameter("langueinitiale"));
//	carteAAjouter.setTag4(request.getParameter("langueinitiale"));
//	carteAAjouter.setTag5(request.getParameter("langueinitiale"));

//	try {
//		CardDao carddao = new CardDao();
//		carddao.insert(card, true);
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	doGet(request, response);
//}
//
	
//		CardDao carddao = new CardDao("tileee");
//	carddao.insert(card, true);
//	if (!tagExist) {
//		TagsDAO Tagdao = new TagsDAO("tileee");
//		Tagdao.insert(tag, true);
//	}
	
	
	doGet(request, response);
	}
}

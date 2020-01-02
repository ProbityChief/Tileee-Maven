package fr.dawan.tileee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.UserDao;
import fr.dawan.tileee.validator.UserValidator;

/**
 * Servlet implementation class ReinitialisationMDP
 */
@WebServlet("/ReinitialisationMDP")
public class ReinitialisationMDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReinitialisationMDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDao("tileee");
		User user = userdao.findByRand(request.getParameter("rand"), true);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/views/reinitialisationmdp.jsp").forward(request,response);
//		try {
//			wait(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("nouveaumdp").equals(request.getParameter("confirmationnouveaumdp"))
				&& !("null").equals(request.getParameter("nouveaumdp"))) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			user.setPassword(UserValidator.hashPassword(request.getParameter("nouveaumdp")));
			UserDao userdao = new UserDao("tileee");
			userdao.update(user, true);
			session.invalidate();
			String mess = "Votre mot de passe à bien été réinitialisé. Vous pouvez vous connecter";
			request.setAttribute("message", mess);
			request.getRequestDispatcher("WEB-INF/views/mdpreinitialise.jsp").forward(request,response);
			return;
		} else {
			String mess = "Problème lors du choix du nouveau mot de passe. Vérifier que les mot de passe concordent"
					+ "et ne sont pas nul";
			request.setAttribute("message", mess);
			String rand = (String) request.getAttribute("rand");
			request.setAttribute("rand", rand);
		request.getRequestDispatcher("WEB-INF/views/reinitialisationmdp.jsp").forward(request,response);
		}
	}

}

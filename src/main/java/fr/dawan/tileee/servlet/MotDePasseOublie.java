package fr.dawan.tileee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.UserDao;
import fr.dawan.tileee.validator.UserValidator;

/**
 * Servlet implementation class MotDePassOublie
 */
@WebServlet("/MotDePasseOublie")
public class MotDePasseOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotDePasseOublie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/views/motdepasseoublie.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDao("tileee");
		User user = userdao.findByMail((String) request.getParameter("email"), true);
		System.out.println(user.getRand());

		try {
			UserValidator.sendEmail("Tileee <dawan-test@gmail.com>", user.getMail(),
					"Votre compte sur Tileee",
					"<h1>Demande de nouveau mot de passe sur Tileee</h1><p><br /><br />"
							+ ", <br /></p><br />Bonjour " + user.getLogin() + ", clique <a href=http://localhost:8181/tileee/ReinitialisationMDP?rand="
							+ user.getRand()
							+ ">ici</a> pour red&eacute;finir un nouveau mot de passe sur Tileee.<p><p>Cordialement,</p><p>L'&eacute;quipe Tileee</p>",
					null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("userMessage", "Un mail de redéfinition de mot de passe vous a été envoyé");
		doGet(request, response);
		return;
	}

}

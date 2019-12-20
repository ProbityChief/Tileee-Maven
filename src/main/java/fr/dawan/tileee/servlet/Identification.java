package fr.dawan.tileee.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.ConnectionDB;
import fr.dawan.tileee.dao.UserDao;
import fr.dawan.tileee.validator.UserValidator;

/**
 * Servlet implementation class Identification
 */
@SuppressWarnings("serial")
@WebServlet("/Identification")
public class Identification extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "1";
		}

		request.setAttribute("choix", action);

		request.getRequestDispatcher("WEB-INF/views/identification.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");

		switch (request.getParameter("validation")) {
		case "inscription":

			User user = new User(name, password, email);

			String userValidator = UserValidator.userValidator(user, password1);

			if (!userValidator.equals("")) {
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				if (userValidator.contains("forename"))
					request.setAttribute("forenameMessage", "Le champ pr�nom est obligatoire");
				if (userValidator.contains("emailNotNull"))
					request.setAttribute("messageEmail", "Le champ ne peut pas �tre vide");
				if (userValidator.contains("invalidEmail"))
					request.setAttribute("messageEmail", "Format incorrect de l'adresse e-mail");
				if (userValidator.contains("password"))
					request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
				if (userValidator.contains("errorPasswordConfirmation"))
					request.setAttribute("messagePassword1", "Les deux mots de passe ne correspondent pas");
				if (userValidator.contains("alreadyExistMail"))
					request.setAttribute("messageEmail", "Cet e-mail est d�j� enregistr� dans la base de donn�es !");
				request.setAttribute("choix", "1");
				// request.setAttribute("title", UserDao.attributeTitle("Sign Up"));
				doGet(request, response);
				return;
			} else {
				try {
					connection = ConnectionDB.getConnection();
					String rand = UserDao.hash(user.getLogin() + "_" + user.getMail());
					UserDao.sendEmail("Tileee <dawan-test@gmail.com>", user.getMail(),
							"Votre compte sur Tileee",
							"<h1>Bienvenu sur Tileee</h1><p><br /><br />" + user.getLogin()
									+ ", <br /></p><br />Bienvenu sur Tileee, veuillez cliquer <a href=http://localhost:8181/tileee/FinalisationInscription?rand="
									+ rand
									+ ">ici</a> pour activer votre compte.<p><p>Cordialement,</p><p>L'&eacute;quipe Tileee</p>",
							null, null, null);
					UserDao.insert(user, connection, false);
					request.setAttribute("userMessage", "Votre inscription n'est pas termin�e. Ouvrez votre bo�te "
							+ user.getMail() + " et cliquez sur le lien pour finaliser votre inscription.");
					// request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request,
					// response);
					doGet(request, response);
					return;
				} catch (Exception e) {
				}
			}
			break;
		case "login":
			User login = new User(name, password, email);
			try {
				login = UserDao.findByName(name, ConnectionDB.getConnection(), false);
				userValidator = UserValidator.userValidator(email, password, login.isValidation());
				if (!userValidator.equals("")) {
					request.setAttribute("password", password);
					request.setAttribute("email", email);
					if (userValidator.contains("emailNotNull"))
						request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
					if (userValidator.contains("invalidEmail"))
						request.setAttribute("messageEmail", "Format incorrect de l'adresse e-mail");
					if (userValidator.contains("password"))
						request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
					if (userValidator.contains("EmailAndPasswordNotCorrespondant")) {
						request.setAttribute("messagePassword", "Mot de passe incorrect");
						request.setAttribute("password", "");
					}

					if (userValidator.contains("noValidationForThisUser"))
						request.setAttribute("messageEmail",
								"Pour valider votre compte, ouvrez votre email et cliquez sur le lien 'ici'<br />");

					doGet(request, response);
					return;
				}
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (login.getLogin() != null) {

					HttpSession session = request.getSession();

					session.setAttribute("name", login.getLogin());
					response.sendRedirect(request.getContextPath() + "/PageAcceuil"); // request.getContextPath()
					return;

				} else {
					request.setAttribute("error", "1");
					doGet(request, response);
					return;
				}
			} catch (Exception e) {
				System.out.println("Login non trouv�");
				e.printStackTrace();
			}

//			request.setAttribute("title", UserDao.attributeTitle(""));
//
//			String idProduct = (String) request.getParameter("idProduct");
//
//			if (!"".equals(idProduct)) {
//				request.setAttribute("idProduct", idProduct);
//			} else {
//			}
//			response.sendRedirect(request.getContextPath() + "/"); // request.getContextPath()
			break;
		default:

			break;
		}

//		String nameError = "";
//		String emailError = "";
//		String passError = "";
//		boolean returnError = false;
//
//		if (request.getParameter("name").equals("")) {
//			nameError = "Login incorrect";
//			returnError = true;
//		}
//		if (request.getParameter("email").equals("")) {
//			emailError = "Email incorrect";
//			returnError = true;
//		}
//		if (request.getParameter("password").equals("")
//				|| !request.getParameter("password").equals(request.getParameter("secPassword"))) {
//			passError = "Mot de passe incorrect";
//			returnError = true;
//		}
//
//		if (!returnError)
//			request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
//
//		request.setAttribute("nameError", nameError);
//		request.setAttribute("emailError", emailError);
//		request.setAttribute("passError", passError);
//		request.getRequestDispatcher("WEB-INF/views/identification.jsp").forward(request, response);
	}

}

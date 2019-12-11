package fr.dawan.tileee.dao;



import fr.dawan.tileee.bean.NewUser;
import fr.dawan.tileee.tool.StringFunctions;
import fr.dawan.tileee.bean.NewUser;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//imports email
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class UserDao {

	
	
	
	/**
	 * Teste la validit� du format de l'adresse email envoy�e par l'utilisateur
	 * @param email
	 * Une adresse email, de la forme utilisateur@domain.ext
	 * @return
	 * true si l'adresse email fournie respecte le format d�fini par l'expression r�guli�re
	 */
	public static boolean isEmailAddress(String email){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(email.toUpperCase());
		return m.matches();
	}
	
	
	/**
	 * Configure un serveur d'envoi de courriel avec pi�ce jointe)
	 * @param email
	 * Objet Java MultiPartEmail qui permet d'envoyer des courriels avec pi�ce jointe
	 * @param subject
	 * Sujet de l'email
	 * @param htmlContent
	 * Corps de l'email
	 * @param to
	 * Adresse email du destinataire de l'email
	 * @return
	 * Un objet MultiPartEmail
	 * @throws Exception
	 */
	private static MultiPartEmail configureIMAP( MultiPartEmail email, Object subject, Object htmlContent, String to ) throws Exception {
		email.setCharset( "utf-8" );
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort( 465 );
		email.setAuthenticator(new DefaultAuthenticator("poefrancetest@gmail.com", "Madagascar75014@"));
		email.setSSLOnConnect(true);
		email.setFrom( "DAWAN <hrabesiaka@gmail.com>" );
		email.setSubject( subject.toString() );
		email.setMsg( htmlContent.toString() );
		email.addTo( to );
		return email;
	}
	
	/**
	 * Configure un serveur d'envoi de courriel sans pi�ce jointe)
	 * @param email
	 * Objet Java MultiPartEmail qui permet d'envoyer des courriels avec pi�ce jointe
	 * @param subject
	 * Sujet de l'email
	 * @param htmlContent
	 * Corps de l'email
	 * @param to
	 * Adresse email du destinataire de l'email
	 * @return
	 * Un objet MultiPartEmail
	 * @throws Exception
	 */
	private static Email configureIMAP( Email email, Object subject, Object htmlContent, String to ) throws Exception {
		email.setCharset( "utf-8" );
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort( 465 );
		email.setAuthenticator(new DefaultAuthenticator("poefrancetest@gmail.com", "Madagascar75014@"));
		email.setSSLOnConnect(true);
		email.setFrom( "DAWAN <hrabesiaka@gmail.com>" );
		email.setContent("Content-Type", "text/html; charset=UTF-8");
		email.setSubject( subject.toString() );
		email.setMsg( htmlContent.toString() );
		email.addTo( to );
		return email;
	}
	
	
	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	private static String hashPassword(String password) {
		String hexHashedPassword = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] psw = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
			hexHashedPassword = bytesToHex(psw);
		} catch (Exception e) {

		}
		return hexHashedPassword;
	}

//	public static String attributeTitle(String pageTitle) {
//		String result = pageTitle;
//		Properties p = new Properties();
//		try {
//			p.load(Thread.currentThread().getContextClassLoader()
//					.getResourceAsStream("resources/application.properties"));
//			String dawanTitle = p.getProperty("title");
//			if (!"".equals(pageTitle))
//				result = LibraryDao.reduce(pageTitle, 20) + " - " + dawanTitle;
//			else
//				result = dawanTitle;
//		} catch (Exception e) {
//
//		}
//		return result;
//	}

	public static Boolean pswAndLoginMatche(String email, String typedPassword, Connection cnx,
			boolean willConnectionClosed) throws Exception {
		Boolean result = true;
		PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM utilisateur WHERE email = ?");
		stmt.setString(1, email);
		ResultSet resultSet = stmt.executeQuery();
		while (resultSet.next()) {
			String oldPassword = resultSet.getString("mdpMD5");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] psw1 = messageDigest.digest(typedPassword.getBytes(StandardCharsets.UTF_8));
			String oldHexHashedPassword1 = bytesToHex(psw1);
			if (!oldPassword.equals(oldHexHashedPassword1)) {
				result = false;
			}
		}
		return result;
	}

	public static List<NewUser> findAll(Connection connection, boolean willBeClosed) throws Exception {
		List<NewUser> list = new ArrayList<>();
		String mySql = "SELECT * FROM utilisateur";

		PreparedStatement stmt = connection.prepareStatement(mySql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			NewUser u = new NewUser();
			u.setName(rs.getString("login"));
			u.setMail(rs.getString("email"));
			u.setPassword(rs.getString("mdpMD5"));
			u.setValidation(rs.getBoolean("validation"));
			list.add(u);

		}
		rs.close();
		if (willBeClosed)
			connection.close();

		return list;
	}

	public static NewUser findByName(String name, Connection cnx, boolean closeCnx) throws Exception {
		NewUser u = new NewUser();
		PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM users WHERE name = ?");
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			u.setName(rs.getString("name"));
			u.setMail(rs.getString("mail"));
			u.setPassword(rs.getString("pass"));
			u.setValidation(rs.getBoolean("validation"));
		}
		rs.close();
		if (closeCnx)
			cnx.close();

		return u;
	}

	public static Boolean doesEmailExist(String email, Connection cnx, boolean willConnectionClosed) throws Exception {
		Boolean result = false;
		int nb = 0;
		PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM utilisateur WHERE email = ?");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			nb = rs.getInt(1);
		}
		if (nb > 0)
			result = true;
		if (willConnectionClosed)
			cnx.close();
		return result;
	}

	public static int insert(NewUser user, Connection cnx, boolean willConnectionClosed) throws Exception {
		String password = user.getPassword();
		Date now = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(now);
		password = hashPassword(password);
		PreparedStatement stmt = cnx.prepareStatement(
				"INSERT INTO users (name, pass, mail, dateinscription, validation) "
				+ "VALUES(?,?,?,?,?)");
		stmt.setString(1, user.getName().trim());
		stmt.setString(2, password);
		stmt.setString(3, user.getMail().trim());
		stmt.setString(4, date);
		stmt.setBoolean(5, false);
		int resultSet = stmt.executeUpdate();
		if (willConnectionClosed)
			cnx.close();
		return resultSet;
	}

	public static int delete(Integer id, Connection connection, Boolean willBeClosed) throws Exception {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM utilisateur WHERE id=?");
		ps.setInt(1, id);
		int resultSet = ps.executeUpdate();
		if (willBeClosed)
			connection.close();
		return resultSet;
	}

	public static int update(Integer id, Integer role, Connection connection, Boolean willBeClosed) throws Exception {
		PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET role=? WHERE id=?");
		ps.setInt(1, role);
		ps.setInt(2, id);
		int resultSet = ps.executeUpdate();

		if (willBeClosed)
			connection.close();
		return resultSet;
	}

	public static int update(NewUser user, Connection connection, Boolean willBeClosed) throws Exception {
		PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET validation=? WHERE login=?");
		ps.setBoolean(1, true);
		ps.setString(2, user.getName());
		int resultSet = ps.executeUpdate();

		if (willBeClosed)
			connection.close();
		return resultSet;
	}

	public static String hash(String word) {

		// Cryptage du mot de passe
		String hash = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			hash += Integer.toString((byte) ((int) word.charAt(i) / 16 * 10 + (int) word.charAt(i) % 16));
		}
		return hash;
	}

	public static void sendEmail(String from, String to, String subject, String htmlContent, String attachmentUrl,
			String name, String description) throws Exception {

		attachmentUrl = "";
		
		// pi�ce jointe : attachmentUrl
		try {

			if (!attachmentUrl.equals("")) {
				// Avec pi�ce jointe
				MultiPartEmail email = new MultiPartEmail();
				configureIMAP(email, StringFunctions.utf8Encode(subject), StringFunctions.utf8Encode(htmlContent), to);
				EmailAttachment attachement = new EmailAttachment(); // Objet Java pi�ce jointe
				attachement.setPath(attachmentUrl); // Chemin et nom du fichier
				attachement.setDisposition(EmailAttachment.ATTACHMENT);
				attachement.setDescription(description); // description de l'image
				email.addHeader("Content-Type", "text/html; charset=UTF-8"); // Pour que les balises HTML soient ex�cut�es mais pas affich�es
				attachement.setName(name); // le nom du fichier quand le destinataire enregistre la pi�ce
				email.attach(attachement); // attacher la pi�ce � l'email
				email.send();
			} else {
				// Sans pi�ce jointe
				Email email = new SimpleEmail();
				configureIMAP(email, StringFunctions.utf8Encode(subject.toString()),
						StringFunctions.utf8Encode(htmlContent.toString()), to);
				email.addHeader("Content-Type", "text/html; charset=UTF-8"); // Pour que les balises soient ex�cut�es mais pas affich�es
				email.setFrom("DAWAN <hrabesiaka@gmail.com>");
				email.send();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	

}

package fr.dawan.tileee.dao;

import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.tool.StringFunctions;
import fr.dawan.tileee.bean.User;

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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDao extends GenericDAO<User> {

	// /**
//	 * Teste la validit� du format de l'adresse email envoy�e par l'utilisateur
//	 * @param email
//	 * Une adresse email, de la forme utilisateur@domain.ext
//	 * @return
//	 * true si l'adresse email fournie respecte le format d�fini par l'expression r�guli�re
//	 */
//	public static List<User> findAll(Connection connection, boolean willBeClosed) throws Exception {
//		List<User> list = new ArrayList<>();
//		String mySql = "SELECT * FROM utilisateur";
//
//		PreparedStatement stmt = connection.prepareStatement(mySql);
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			User u = new User();
//			u.setName(rs.getString("login"));
//			u.setMail(rs.getString("email"));
//			u.setPassword(rs.getString("mdpMD5"));
//			u.setValidation(rs.getBoolean("validation"));
//			list.add(u);
//
//		}
//		rs.close();
//		if (willBeClosed)
//			connection.close();
//
//		return list;
//	}
//	
	public User findByName(String login, boolean closeCnx) {
		String requete = String.format("SELECT f FROM %s f WHERE f.login = %s", User.class.getName(), login);
		
		TypedQuery<User> query = em.createQuery(requete, User.class);
		User user = query.getSingleResult();
		
		if (closeCnx)
			em.close();

		return user;
	}
	
	public static User findByRand(String rand, Connection cnx, boolean closeCnx) throws Exception {
		User u = new User();
		PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM users WHERE hashcode = ?");
		stmt.setString(1, rand);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			u.setLogin(rs.getString("name"));
			u.setMail(rs.getString("mail"));
			u.setPassword(rs.getString("pass"));
			u.setValidation(rs.getBoolean("validation"));
		}
		rs.close();
		if (closeCnx)
			cnx.close();

		return u;
	}
//
//	public static int insert(User user, Connection cnx, boolean willConnectionClosed) throws Exception {
//		String password = user.getPassword();
//		Date now = new java.util.Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String date = sdf.format(now);
//		password = hashPassword(password);
//		PreparedStatement stmt = cnx.prepareStatement(
//				"INSERT INTO users (name, pass, mail, dateinscription, validation, hashcode) "
//				+ "VALUES(?,?,?,?,?,?)");
//		stmt.setString(1, user.getName().trim());
//		stmt.setString(2, password);
//		stmt.setString(3, user.getMail().trim());
//		stmt.setString(4, date);
//		stmt.setBoolean(5, false);
//		stmt.setString(6, user.getRand());
//		int resultSet = stmt.executeUpdate();
//		if (willConnectionClosed)
//			cnx.close();
//		return resultSet;
//	}
//
//	public static int delete(Integer id, Connection connection, Boolean willBeClosed) throws Exception {
//		PreparedStatement ps = connection.prepareStatement("DELETE FROM utilisateur WHERE id=?");
//		ps.setInt(1, id);
//		int resultSet = ps.executeUpdate();
//		if (willBeClosed)
//			connection.close();
//		return resultSet;
//	}
//
//	public static int update(Integer id, Integer role, Connection connection, Boolean willBeClosed) throws Exception {
//		PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET role=? WHERE id=?");
//		ps.setInt(1, role);
//		ps.setInt(2, id);
//		int resultSet = ps.executeUpdate();
//
//		if (willBeClosed)
//			connection.close();
//		return resultSet;
//	}
//
	public void update(User user, Boolean close) {
		String requete = String.format("UPDATE %s f SET validation=1 WHERE f.id=%d", User.class.getName(), user.getId());
		
		TypedQuery<User> query = em.createQuery(requete, User.class);
		query.executeUpdate();
		
		if (close)
			em.close();
	}
}

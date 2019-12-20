package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Invitation;
import fr.dawan.tileee.bean.User;

public class InvitationDAO extends GenericDao<Invitation> {

	public InvitationDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Invitation> findInvitation(String login, boolean close) {
		String requete = String.format("SELECT f FROM %s f WHERE f.duree = %d", 
				Invitation.class.getName(), login);
		
		TypedQuery<Invitation> query = em.createQuery(requete,
				Invitation.class);
		List<Invitation> resultat = query.getResultList();

		//Le fait de faire un appel au set de formateurs de la formation
		//va charger les formatteur dans la formation
		//Hibernate se charge de récupére les données de la table t_formation_formation
		
		if (close)
			em.close();
		return resultat;
	}

	
//	public static ArrayList<Invitation> findInvitation(Connection cnx, Boolean Closecnx, String name) {
//		ArrayList<Invitation> listInvit = new ArrayList<Invitation>();
//		
//		try {
//			cnx = ConnectionDB.getConnection();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String mySql = "SELECT * FROM invitations WHERE id_guest=?";
//		
//		try {
//		PreparedStatement stmt = cnx.prepareStatement(mySql);
//		stmt.setString(1, name);
//		ResultSet rs = stmt.executeQuery();
//		if (rs==null) {
//			listInvit = null;
//		} else {
//		while (rs.next()) {
//			Invitation I = new Invitation();
//			I.setIdGiver(rs.getInt("id_giver"));
//			I.setTag(rs.getString("tag"));
//			listInvit.add(I);
//		}
//
//		}
//		rs.close();
//		if (Closecnx)
//			cnx.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return listInvit;
//		
//	}
}

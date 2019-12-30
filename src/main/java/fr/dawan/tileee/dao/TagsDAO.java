package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;

//public class TagsDAO extends GenericDao<Tag>{
//	
//	public TagsDAO(EntityManager em) {
//		super(em);
//		// TODO Auto-generated constructor stub
//	}

//	public static ArrayList<String> findTags(Connection cnx, boolean CloseConnection) {
//		ArrayList<String> tagsList = new ArrayList<>();
//		PreparedStatement st;
//		try {
//			st = cnx.prepareStatement("SELECT tag1, tag2, tag3, tag4, tag5 from cards;");
//			ResultSet res = st.executeQuery();
//			while (res.next()) {
//				if ("null".equals(res.getString("tag1")) || tagsList.contains(res.getString("tag1"))) {
//					continue;
//				}
//				else {
//					tagsList.add(res.getString("tag1"));
//					System.out.println("ajout d'un tag");
//				}
//				if ("null".equals(res.getString("tag2")) || !tagsList.contains(res.getString("tag2"))) {
//					continue;
//				}
//				else {
//					tagsList.add(res.getString("tag2"));
//					System.out.println("ajout d'un tag");
//				}
//				if ("null".equals(res.getString("tag3")) || !tagsList.contains(res.getString("tag3"))) {
//					continue;
//				}
//				else {
//					tagsList.add(res.getString("tag3"));
//					System.out.println("ajout d'un tag");
//				}
//				if ("null".equals(res.getString("tag4")) || !tagsList.contains(res.getString("tag4"))) {
//					continue;
//				}
//				else {
//					tagsList.add(res.getString("tag4"));
//					System.out.println("ajout d'un tag");
//				}
//				if ("null".equals(res.getString("tag5")) || !tagsList.contains(res.getString("tag5"))) {
//					continue;
//				}
//				else {
//					tagsList.add(res.getString("tag5"));
//					System.out.println("ajout d'un tag");
//				}
//			}
//			if (CloseConnection) {
//				cnx.close();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return tagsList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.dawan.tileee.bean.Tag;

public class TagsDAO extends GenericDAO<Tag>{


	// Fait comprendre à spring que j'utilise la persistence de JPA
	// Objet EntityManager avec les infos de connexion à la base


	// recherche des tags par mot clé
	public Set<Tag> findTags(User user, boolean close)
	{   
		em = createEntityManager();
		transaction = em.getTransaction();
		
        List<Tag> resultat = null;

		String requete = String.format("SELECT f.tag_name FROM %s f INNER JOIN WHERE f.id = ("
				+ "SELECT t.id FROM %s t WHERE t.user = %b" + ")", Tag.class.getName(),  Card.class.getName(), user);
		
		TypedQuery<Tag> query = em.createQuery(requete, Tag.class);
		resultat = query.getResultList();
		Set<Tag> result = new HashSet<>(resultat);
		
		if (close)
			em.close();

		return result;
	}
	
	
	
	
	

}

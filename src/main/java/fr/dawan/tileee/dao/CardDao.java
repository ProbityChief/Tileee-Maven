package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;

public class CardDao extends GenericDao<Card>{

//		public static int insertCard(Card carte, Connection cnx, boolean closeConnection) throws SQLException {
//			PreparedStatement ps = cnx.prepareStatement("INSERT INTO cards (word, translate, lang1, lang2, tag1, id_user) VALUES(?,?,?,?,?,?);");
//			ps.setString(1, carte.getMotATraduire().trim());
//			ps.setString(2, carte.getMotTraduit().trim());
//			ps.setString(3, carte.getLangueInitiale().trim());
//			ps.setString(4, carte.getLangueTraduite().trim());
//			ps.setString(5, carte.getTag1().trim());
//			ps.setInt(6, 1);
////			ps.setString(6, carte.getTag2().trim());
////			ps.setString(7, carte.getTag3().trim());
////			ps.setString(8, carte.getTag4().trim());
////			ps.setString(9, carte.getTag5().trim());
//			int resultSet = ps.executeUpdate();
//			if (closeConnection == true) {
//				cnx.close();
//			}
//			return resultSet;
//		}

	@PersistenceContext
	private EntityManager em;	
	
	// recherche des tags par id
		public List<Card> findByTag(long id, String tag, boolean close) 
		{  
			em = createEntityManager();
			transaction = em.getTransaction();

			
	        List<Card> resultat = null;

			String requete = "SELECT * "
					+ "FROM cards "
					+ "INNER JOIN tags_cards ON cards.id = tags_cards.cards_id "
					+ "INNER JOIN tags ON tags_cards.tags_id = tags.id "
					+ "WHERE cards.user_id = " + id
					+ " AND tags.tag_name = " + " \""+tag+" \"";
			resultat = em.createNativeQuery(requete, Tag.class).getResultList();

			
			if (close)
				em.close();

			return resultat;
		}
}

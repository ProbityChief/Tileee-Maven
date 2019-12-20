package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;

public class CardDao{
	@PersistenceContext
	private EntityManager em;	
	
	// recherche des tags par id
		public List<Card> findById(long id) 
		{  
			return em.createQuery("From Card WHERE id =:id")
			.setParameter("id", id).getResultList();
		}

}

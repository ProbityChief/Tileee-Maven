package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.dawan.tileee.bean.Tag;

public class TagsDAO extends GenericDAO<Tag>{


	// Fait comprendre à spring que j'utilise la persistence de JPA
	// Objet EntityManager avec les infos de connexion à la base
	

	public TagsDAO(EntityManager em) {
		super(em);
	}



	// recherche des tags par mot clé
	public List<Tag> findByKey(String key,  long userid)
	{   
		
        List<Tag> resultat = null;
		
		
		// Builder de requête
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		
		// Initialisation de la requête
		CriteriaQuery<Tag> query = criteriaBuilder.createQuery(Tag.class);
		
		// création du "FROM"
		Root<Tag> entity = query.from(Tag.class);
		
		
		
		Predicate idutilisateur = criteriaBuilder.equal(entity.get("user_id"), userid );
		Predicate lettretapees = criteriaBuilder.like(entity.get("tag_name"), key );
		
		
		// création du "WHERE", dans lequel on insère le "Like"
		query = query.select(entity).where(criteriaBuilder.and(idutilisateur,lettretapees));
		
		
		// on récupère le résultat
		resultat = em.createQuery(query).getResultList();

		
		em.close();
		return resultat;
	}
	
	
	
	
	

}

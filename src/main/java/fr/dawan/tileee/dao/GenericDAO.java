package fr.dawan.tileee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import fr.dawan.tileee.bean.DbObject;

public class GenericDAO<T> {
	EntityManager em;
	EntityTransaction transaction;

	public  <T extends DbObject> void insert(T entity, boolean close) {
		if (entity != null && entity.getId() == 0) {
			em = createEntityManager();
			transaction = em.getTransaction();
	
			try {
				// début de la transaction
				transaction.begin();

				// On insère la formation dans la BDD
				em.persist(entity);

				// on commit tout ce qui s'est fait dans la transaction
				transaction.commit();
			} catch (Exception ex) {
				// en cas d'erreur, on effectue un rollback
				transaction.rollback();
				ex.printStackTrace();
			} finally {
				if(close) {
				em.close();
				}
			}
		}
	}

	public  <T extends DbObject> T findById(Class<T> clazz, long id, boolean close) {

		T entity = null;

		try {
			// On charge la formation depuis la BDD, selon son ID
			entity = em.find(clazz, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(close == true)
				em.close();
		}

		return entity;
	}

	public  <T extends DbObject> void update(T entity, boolean close) {
		if (entity.getId() > 0) {
			
			try {
				// début de la transaction
				transaction.begin();

				// On met à jour la formation
				em.merge(entity);

				// on commit tout ce qui s'est fait dans la transaction
				transaction.commit();
			} catch (Exception ex) {
				// en cas d'erreur, on effectue un rollback
				transaction.rollback();
				ex.printStackTrace();
			} finally {
				if(close == true)
					em.close();
			}
		}
	}

	public  <T extends DbObject> void delete( Class<T> clazz, long id, boolean close) {
		

		try {
			// début de la transaction
			transaction.begin();

			T entity = em.find(clazz, id);
			em.remove(entity);

			// on commit tout ce qui s'est fait dans la transaction
			transaction.commit();
		} catch (Exception ex) {
			// en cas d'erreur, on effectue un rollback
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			if(close == true)
				em.close();
		}
	}


	
	public  <T extends DbObject> List<T> findAll(Class<T> clazz, long userId, boolean close) {		
		List<T> resultat = null;
		
		
		// Builder de requête
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		// Initialisation de la requête
		CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
		
		// création du "FROM"
		Root<T> entity = query.from(clazz);
		
		// création du "WHERE", dans lequel on insère le "Like"
		query = query.where(criteriaBuilder.equal(entity.get("user_id"), userId ));
		
		// on récupère le résultat
		resultat = em.createQuery(query).getResultList();

		if(close == true)
			em.close();
		return resultat;
	}
	


	public static EntityManager createEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dawantileee");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}
}
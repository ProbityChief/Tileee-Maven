package fr.dawan.tileee.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dawan.tileee.bean.DbObject;

public class GenericDao<T extends DbObject> {
	
	protected EntityManager em;
	//Si le this ne sert à rien, ne pas mettre de code inutile.

	public GenericDao(EntityManager em) {
		this.em = em;
	}

	public int insert(T entite, boolean fermerEntityManager) {
		// TODO Auto-generated method stub
		// on a besoin d'une transaction: annulation de l'opératin de la base de donné
		// en cas d'érreur, avec rollback
		EntityTransaction tx = em.getTransaction();
		// On démarre la transaction

		try {
			tx.begin();
			// On persiste la formation (on la sauvegarde en base de données)
			if (entite.getId() == 0) {
			this.em.persist(entite); // la formation est sauvegarder en base
			}
			// On valide la transaction (= on la valide)
			tx.commit(); // la formation est sauvegarder en base
			// en cas d'erreur, on rollback
			// on n'oublie pas de fermer l'intiti manager
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return (-1);
		}
		//
		
		if (fermerEntityManager) {
			this.em.close();
		}
		return (int) (entite.getId());
	}
	
	public T findByID(long id, Class<T> entityClass, boolean close) {
		T result = this.em.find(entityClass, id);
		
		if (close) {
			this.em.close();
		}
		
		return result;
	}
	
	public void deleteByID(long id, Class<T> entityClass, boolean close) {
		// TODO Auto-generated method stub
		// on a besoin d'une transaction: annulation de l'opératin de la base de donné
		// en cas d'érreur, avec rollback
		EntityTransaction tx = this.em.getTransaction();
		// On démarre la transaction

		try {
			tx.begin();
			
			T entite = this.em.find(entityClass,  id);
			// On persiste la formation (on la sauvegarde en base de données)
			if (entite != null) this.em.remove(entite);
			
			tx.commit(); // la formation est supprimée en base
			// en cas d'erreur, on rollback
			// on n'oublie pas de fermer l'intiti manager
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		//
		
		if (close) {
			this.em.close();
		}
	}
	
	public void update(T entite, boolean fermerEntityManager) {
		// TODO Auto-generated method stub
		// on a besoin d'une transaction: annulation de l'opératin de la base de donné
		// en cas d'érreur, avec rollback
		EntityTransaction tx = em.getTransaction();
		// On démarre la transaction

		try {
			tx.begin();
			// On persiste la formation (on la sauvegarde en base de données)
			
			if (entite.getId() > 0) {
			this.em.merge(entite); // la formation est sauvegarder en base
			}
			// On valide la transaction (= on la valide)
			tx.commit(); // la formation est sauvegarder en base
			// en cas d'erreur, on rollback
			// on n'oublie pas de fermer l'intiti manager
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		//
		
		if (fermerEntityManager) {
			this.em.close();
		}
	}
	
	public Set<T> findAll(Class<T> entityClass, boolean close) {
		Set<T> result = null;
		
		// Requête JPQL
		//Select f from formation f -> toutes les formations
		//from formation f -> toutes les formations
		//Select f.nom FROM Formation f -> tous les noms des formations
		//Select f.nom FROM Formation f where f.id > 10 -> tous les noms des formations
								//Dont l'id ets supérieur à 10
		TypedQuery<T> query = em.createQuery(String.format("SELECT entity FROM %s entity",
											entityClass.getName()), entityClass);
		
		List<T> resultat = query.getResultList();
		result = new HashSet<>(resultat);
		
		if (close) em.close();
		return result;
	}
	
	public static EntityManager createEntityManager(String persistanceUnitName) {
		// Création d'une fabrique d'entity manager
		// à partir de la configuration du persistence.xml
		//par le nom du persistence-unit
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistanceUnitName);
		
		//La création de l'entity manager va mettre à jour le schéma de la BDD
		return factory.createEntityManager();
	}
}
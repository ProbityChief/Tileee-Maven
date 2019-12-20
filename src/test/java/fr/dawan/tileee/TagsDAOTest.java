package fr.dawan.tileee;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.dao.GenericDAO;
import fr.dawan.tileee.dao.TagsDAO;


public class TagsDAOTest {
    
	
	private EntityManager em;

	@Before
	public void setUpBeforeClass() throws Exception {																									// avec la BDD
// La création de l'entitymanager, va mettre à jour le schéma
// de la BDD, si on est en mode update ou create (ou create-drop)
		em = TagsDAO.createEntityManager("tileee");
		
	}
	
	
	
	@Test
	public void TagTest() {
        
		TagsDAO tagsDao = new TagsDAO(em);
		
		Tag tag1 = new Tag();
		tag1.setTag_name("tagtesttagsDAO1");
		tag1.setUser_id(200);
		
		tagsDao.create( tag1, false );
		
		
		Tag tag2 = new Tag();
		tag2.setTag_name("tagtesttagsDAO2");
		tag2.setUser_id(200);
		
		tagsDao.create( tag2, false );		
		

		assertTrue(tagsDao.findByKey("tagtesttagsDA", tag1.getUser_id()).size() > 1);
	
	  }
	

}
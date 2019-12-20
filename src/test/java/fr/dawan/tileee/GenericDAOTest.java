package fr.dawan.tileee;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.dao.GenericDAO;

public class GenericDAOTest {
    
	
	
	private EntityManager em;

	@Before
	public void setUpBeforeClass() throws Exception {																									// avec la BDD
// La création de l'entitymanager, va mettre à jour le schéma
// de la BDD, si on est en mode update ou create (ou create-drop)
		em = GenericDAO.createEntityManager("tileee");
	}
	
	
	
	@Test
	public void TagTest() {
        
		GenericDAO genericDao = new GenericDAO(em);
		
		Tag tag1 = new Tag();
		tag1.setTag_name("tagtest1");
		tag1.setUser_id(200);
		
		
		genericDao.create( tag1, false );
		
		
		assertNotEquals(0, tag1.getId());
		
		
		Tag tag2 = new Tag();
		tag2.setTag_name("tagtest2");
		tag2.setUser_id(300);
		
		Tag tag3 = new Tag();
		tag3.setTag_name("tagtest3");
		tag3.setUser_id(300);
		
		genericDao.create( tag2, false );
		genericDao.create( tag3, false );
		
		
		assertNotNull(genericDao.findAll(Tag.class,300,false));
		assertTrue(genericDao.findAll(Tag.class,300,false).size() > 1);
		
		genericDao.create( tag2, false );
		genericDao.create( tag3, false );
		
		
		assertNotNull(genericDao.findById(Tag.class, tag2.getId(),false));
		
		
		tag2.setTag_name("tagtest2bis");
		genericDao.update(tag2, false);
		
		assertEquals("tagtest2bis", tag2.getTag_name());
		
		genericDao.delete(Tag.class, tag2.getId(),true);
		
		assertNull(genericDao.findById(Tag.class, tag2.getId(),false));
	
	}
	

}

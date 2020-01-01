//package fr.dawan.tileee;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import fr.dawan.tileee.bean.Card;
//import fr.dawan.tileee.bean.Tag;
//import fr.dawan.tileee.bean.User;
//import fr.dawan.tileee.dao.CardDao;
//import fr.dawan.tileee.dao.TagsDAO;
//import fr.dawan.tileee.dao.UserDao;
//import fr.dawan.tileee.validator.UserValidator;
//
//
//public class TagsDAOTest {
//
//	private EntityManager em;
//
//	@Before
//	public void setUpBeforeClass() throws Exception {
//		UserDao userdao = new UserDao("tileeetest");// avec la BDD
//		User user1 = new User();
//		user1.setLogin("OK");
//		user1.setMail("ok1@gmail.com");
//		userdao.insert(user1, false);
//		String rand = UserValidator.hash(user1.getLogin() + "_" + user1.getMail());
//		user1.setRand(rand);
//		userdao.update(user1, false);
//		
//		User user2 = new User();
//		user2.setLogin("OK2");
//		user2.setMail("ok2@gmail.com");
//		userdao.insert(user1, false);
//		String rand2 = UserValidator.hash(user2.getLogin() + "_" + user2.getMail());
//		user2.setRand(rand2);
//		userdao.update(user1, false);
//
//	}
////	
////	@Test
////	public void TagTest() {
////        
////		TagsDAO tagsDao = new TagsDAO();
////		
////		Tag tag1 = new Tag();
////		tag1.setTag_name("tagtesttagsDAO");
////		tag1.setUser_id(200);
////		
////		tagsDao.insert( tag1, true );	
////		
////
////		assertTrue(tagsDao.findByKey("tagtesttagsDA", tag1.getUser_id()).size() > 1);
////	
////	  }
////	
//	@Test
//	public void TagCopyTest() {
//        
//		TagsDAO tagsdao = new TagsDAO("tileeetest");
//		tagsdao.CloneStack(rand, user, true);
//
//		CardDao carddao = new CardDao("tileeetest");
//		List<Card> l1 = tagsdao.findByRand(rand);
//		List<Card> l2 = tagsdao.findByRand(rand2);
//		for(int i =0; i==l1.size(); i++) {
//			assertEquals(l1.get(i).getStarting_language(), l2.get(i).getStarting_language());			
//			assertEquals(l1.get(i).getEnding_language(), l2.get(i).getEnding_language());
//			assertEquals(l1.get(i).getWord(), l2.get(i).getWord());
//			assertEquals(l1.get(i).getTranslation(), l2.get(i).getTranslation());
//			assertEquals(l2.get(i).getValue(), 0,5);
//			assertEquals(l2.get(i).getUser(), user2);
//			assertEquals(l1.get(i).getEnding_language(), l2.get(i).getEnding_language());
//		}
//	  }
//	
//
//}
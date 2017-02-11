//package com.lb.jwitter;
//
//import java.util.Iterator;
//import java.util.List;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.Assert;
//import org.junit.Test;
//import org.unitils.UnitilsJUnit4;
//import org.unitils.spring.annotation.SpringApplicationContext;
//import org.unitils.spring.annotation.SpringBean;
//
//import com.lb.jwitter.hibernate.UserHibernateDao;
//
//@SpringApplicationContext("classpath:applicationContext-persistence-files-test.xml")
//public class UserDaoTest extends UnitilsJUnit4 {
//
//	private Log log = LogFactory.getLog(UserDaoTest.class);
//	
//	@SpringBean("userHibernateDao")
//	private UserHibernateDao userHibernateDao;
//	
//	//SpringBean("userService")
//	//private UserService userService;	
//
//	
//	@Test
//	public void testSaveAndDelete() {
//
//		User test1 = new User();
//		test1.setId(new Long("123"));
//		test1.setMaNV("test1");
//		
//		User test2 = new User();
////		test2.setId(new Long("122222"));
//		test2.setMaNV("test2");
//		
//		User test3 = new User();
//		test3.setId(new Long("123333333"));
//		test3.setMaNV("test3");
//		
//		Long id1 = this.userHibernateDao.save(test1);
//		this.userHibernateDao.saveOrUpdate(test2);
//		Long id3 = this.userHibernateDao.save(test3);
//		
//		Assert.assertNotNull(this.userHibernateDao.findByMaNV("test1"));
//		
//		this.userHibernateDao.delete(id1);
//		Assert.assertNull(this.userHibernateDao.findByMaNV("test1"));
//		
//		this.userHibernateDao.delete(test2);
//		Assert.assertNull(this.userHibernateDao.findByMaNV("test2"));
//		
//		User user3 = this.userHibernateDao.load(id3);
//		Assert.assertNotNull(user3);
//		Assert.assertEquals("test3", user3.getMaNV());
//		
//		User user3bis = this.userHibernateDao.get(id3);
//		Assert.assertNotNull(user3bis);
//		Assert.assertEquals("test3", user3bis.getMaNV());
//		
//		
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void testSaveAlreadyExists() {
//		
//
//		User test1 = new User();
//		test1.setId(new Long("123"));
//		test1.setMaNV("test1");
//		
//		User test2 = new User();
//		test2.setId(new Long("122222"));
//		test2.setMaNV("test1");
//		
//		this.userHibernateDao.save(test1);
//		this.userHibernateDao.save(test1);
//		
//		Assert.assertNotNull(this.userHibernateDao.findByMaNV("test1"));
//	}
//
//	@Test
//	public void testFindAll() {
//		
//		List<User> result = this.userHibernateDao.findAll();
//		Iterator<User> it = result.iterator();
//		
//		log.info("Nombre de resultat dans la liste:: "+result.size());
//		
//		while (it.hasNext()) {
//			User type = (User) it.next();
//			Assert.assertNotNull(this.userHibernateDao.get(type.getId()));
//			Assert.assertTrue(this.userHibernateDao.exists(type.getId()));
//			Assert.assertTrue(this.userHibernateDao.exists(type.getMaNV()));
//		}
//	}
//	
//	@Test
//	public void testGetType() {
//		Assert.assertEquals(User.class, userHibernateDao.getType());
//		userHibernateDao.getType();
//	}
//	
//	@Test
//	public void testUpdate() {
//
//		User test1 = new User();
//		//test1.setId(new Long("123"));
//		test1.setMaNV("testUpdate");
//		
//		Long id1 = this.userHibernateDao.save(test1);
//		Assert.assertNotNull(test1);
//	
//		User saved1 = userHibernateDao.get(id1);
//		saved1.setMaNV("updatedUsername");
//		userHibernateDao.update(saved1);
//		
//		Assert.assertEquals("updatedUsername", userHibernateDao.get(id1).getMaNV());
//		
//	}
//	
//}

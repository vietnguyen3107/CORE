//package com.lb.jwitter;
//
//import java.util.Iterator;
//import java.util.List;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.Query;
//import org.junit.Assert;
//import org.junit.Test;
//import org.unitils.UnitilsJUnit4;
//import org.unitils.spring.annotation.SpringApplicationContext;
//import org.unitils.spring.annotation.SpringBean;
//
//import com.lb.jwitter.hibernate.tbl_DM_KhoaDAO;
//
//
//@SpringApplicationContext("classpath:applicationContext-persistence-files-test.xml")
//public class UserDaoTest extends UnitilsJUnit4 {
//
//	private Log log = LogFactory.getLog(UserDaoTest.class);
//	
//	@SpringBean("tbl_DM_KhoaDAO")
//	private tbl_DM_KhoaDAO khoaDao;
//	
//	//SpringBean("userService")
//	//private UserService userService;	
//
//	
//	@Test
//	public void testSaveAndDelete() {
//		tbl_DM_Khoa_Report_Condition con = new tbl_DM_Khoa_Report_Condition();
//		con.setId(new Long(1));
//		Query q = khoaDao.find_tbl_DM_Khoa_ByReportCondition(con);
//		String result = "<table>";
//		for (Iterator it = q.iterate(); it.hasNext();) {
//			result += "<tr>";
//			Object [] row = (Object []) it.next();
//			
//			for(Object col : row){
//				result += "<td>" + col + " </td>";
//			}
//			
//			result += "</tr>";
//
//		}
//		
//		result += "</table>";
//
//	}
//
////	@Test(expected=IllegalArgumentException.class)
////	public void testSaveAlreadyExists() {
////		
////
////		Employee test1 = new Employee();
////		test1.setId(new Long("123"));
////		test1.setMaNV("test1");
////		
////		Employee test2 = new Employee();
////		test2.setId(new Long("122222"));
////		test2.setMaNV("test1");
////		
////		this.employeeHibernateDao.save(test1);
////		this.employeeHibernateDao.save(test1);
////		
////		Assert.assertNotNull(this.employeeHibernateDao.findByMaNV("test1"));
////	}
////
////	@Test
////	public void testFindAll() {
////		
////		List<Employee> result = this.employeeHibernateDao.findAll(10,1);
////		Iterator<Employee> it = result.iterator();
////		
////		log.info("Nombre de resultat dans la liste:: "+result.size());
////		
////		while (it.hasNext()) {
////			Employee type = (Employee) it.next();
////			Assert.assertNotNull(this.employeeHibernateDao.get(type.getId()));
////			Assert.assertTrue(this.employeeHibernateDao.exists(type.getId()));
////			Assert.assertTrue(this.employeeHibernateDao.exists(type.getMaNV()));
////		}
////	}
////	
////	@Test
////	public void testGetType() {
////		Assert.assertEquals(Employee.class, employeeHibernateDao.getType());
////		employeeHibernateDao.getType();
////	}
////	
////	@Test
////	public void testUpdate() {
////
////		Employee test1 = new Employee();
////		//test1.setId(new Long("123"));
////		test1.setMaNV("testUpdate");
////		
////		Long id1 = this.employeeHibernateDao.save(test1);
////		Assert.assertNotNull(test1);
////	
////		Employee saved1 = employeeHibernateDao.get(id1);
////		saved1.setMaNV("updatedUsername");
////		employeeHibernateDao.update(saved1);
////		
////		Assert.assertEquals("updatedUsername", employeeHibernateDao.get(id1).getMaNV());
////		
////	}
////	
//}

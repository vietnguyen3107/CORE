//package com.lb.jwitter;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.unitils.UnitilsJUnit4;
//import org.unitils.spring.annotation.SpringApplicationContext;
//import org.unitils.spring.annotation.SpringBean;
//
//import com.lb.jwitter.service.DepartmentService;
//import com.lb.jwitter.service.EmployeeService;
//
//@SpringApplicationContext("classpath:applicationContext-persistence-files-test.xml")
//public class UserServiceImplTest extends UnitilsJUnit4{
//
//	@SpringBean("userService")
//	private EmployeeService employeeService;
//	@SpringBean("departmentService")
//	private DepartmentService departmentService;
//
//	@Test(expected=IllegalArgumentException.class)
//	public void testExistNull() {
//		this.employeeService.exist(null);
//		Assert.fail("Should have failed");
//	}
//	
//
//	@Test
//	public void testCreateUser() {
//		assertTrue(this.employeeService.findAllEmployee(10,1).size()>=5);
//	}
//
////	@Test(expected=IllegalArgumentException.class)
////	public void testCreateUserAlreadyExist() {
////		
////		this.userService.findByUsername("t1");
////		userService.createUser("t1");
////		userService.createUser("t1");
////	}
//
//
//	@Test(expected=IllegalArgumentException.class)
//	public void testFindByUsernameNull() {
//		this.employeeService.findByMaNV(null);
//		Assert.fail("Should have failed");
//	}
//	
//}
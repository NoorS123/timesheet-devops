package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserServiceImplTest {

	@Autowired
	IUserService us;
	
	@Test 
	@Order(1)
	public void testRetrieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}
	/*
	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		
	}
	
	@Test
	@Order(3)
	public void testUpdateUser() {
		
	}
	
	@Test
	@Order(4)
	public void testDeleteUser() {
		
	}
	*/
	
	
	private static final Logger L = LogManager.getLogger(UserServiceImplTest.class);
	
	
	/*@Test
	public void testAll() {
		try{
			L.info("In testAll()");
			testRetrieveAllUsers();
			testAddUser();
			testModifyUser();
			testDeleteUser();
			testRetrieveUser();
			L.info("Out of testAll()");
		} catch (Exception e) {
			L.error("Out of testAll() with Errors : " + e);
		}
	}*/
}

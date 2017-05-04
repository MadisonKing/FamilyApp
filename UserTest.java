/**
 * 
 */
package com.familyApp.FamilyApp;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Madison King
 *
 */
public class UserTest {

	/**
	 * Test method for {@link com.familyApp.FamilyApp.User#User()}.
	 */
	@Test
	public void testUser() {
		User user = new User();
		assertEquals("", user.getEmail());
		assertEquals("", user.getFirstName());
		assertEquals("" , user.getLastName());
	}

	/**
	 * Test method for {@link com.familyApp.FamilyApp.User#User(java.lang.String)}.
	 */
	@Test
	public void testUserEmail() {
		User user = new User("madisontking@yahoo.com");
		assertEquals("madisontking@yahoo.com", user.getEmail());
		assertEquals("", user.getFirstName());
		assertEquals("", user.getLastName());
	}

	/**
	 * Test method for {@link com.familyApp.FamilyApp.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUserEmailFirstLast() {
		User user = new User("madisontking@yahoo.com", "Madison", "King");
		assertEquals("madisontking@yahoo.com", user.getEmail());
		assertEquals("Madison", user.getFirstName());
		assertEquals("King", user.getLastName());
	}

}

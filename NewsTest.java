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
public class NewsTest {

	/**
	 * Test method for {@link com.familyApp.FamilyApp.News#News(java.lang.String, com.familyApp.FamilyApp.User)}.
	 */
	@Test
	public void testNewsContentUser() {
		User owner = new User("madisontking@ou.edu");
		News news = new News("Hello", owner);
		assertEquals(owner, news.getOwner());
		assertEquals("Hello", news.getContent());
		
	}

	/**
	 * Test method for {@link com.familyApp.FamilyApp.News#News()}.
	 */
	@Test
	public void testNews() {
		News news = new News();
//		assertEquals("", news.getOwner().getEmail());
	//	assertEquals("", news.getOwner().getFirstName());
		//assertEquals("", news.getOwner().getLastName());
		assertEquals("", news.getContent());
	}

}

package com.familyApp.FamilyApp;
/**
 * This class represents a news object and has an owner (what user posted the news) and the content of the post
 * @author Madison King
 *
 */
public class News {
	/**content of the news post */
	private String content;
	
	/**User that posted the news content */
	private User owner;

	/**
	 * @param content
	 * @param owner
	 */
	public News(String content, User owner) {
		super();
		this.content = content;
		this.owner = owner;
	}

	/**
	 * @param content
	 */
	public News() {
		super();
		this.content = "";
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	
	
	
}

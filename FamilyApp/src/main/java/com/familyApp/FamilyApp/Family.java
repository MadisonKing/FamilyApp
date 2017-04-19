package com.familyApp.FamilyApp;

import java.util.ArrayList;

import com.vaadin.ui.Image;
/**
 * This class represents a family object
 * @author Madison King
 *
 */
public class Family {

	/**Name of family */
	private String name; 
	
	/** List of users in family (family members) */
	private ArrayList<User> users;// = new ArrayList<User>();
	
	/** Pin number associated to each family*/
	private Pin pin;
	
	/**image on family's profile */
	private Image profileImg;
	
	
	
	/**
	 * Empty constructor
	 */
	public Family() {
		super();
	//	this.pin = (int) Math.random();
		this.name = "";
		this.users = new ArrayList<User>();
		this.profileImg = new Image();
	}

	/**
	 * @param pin
	*/
	public Family(Pin pin) {
		super();
		this.pin = pin;
		this.name = "";
		this.users = new ArrayList<User> ();
	}

	/**
	 * @param name
	 * @param pin
	 */
	public Family(String name, Pin pin) {
		super();
		this.name = name;
		this.pin = pin;
		this.users = new ArrayList<User>();
	}



	/**
	 * @param name
	 * @param users
	 * @param pin
	 */
	public Family(String name, ArrayList<User> users, Pin pin) {
		super();
		this.name = name;
		this.users = users;
		this.pin = pin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * @return the pin
	 */
	public Pin getPin() {
		return pin;
	}

	/**
	 * 
	 */
	public void setPin(Pin pin) {
		this.pin = pin;
	}

	/**
	 * @return the profileImg
	 */
	public Image getProfileImg() {
		return profileImg;
	}

	/**
	 * @param profileImg the profileImg to set
	 */
	public void setProfileImg(Image profileImg) {
		this.profileImg = profileImg;
	}
	
	public void display(){
		System.out.println(name);
	}
	
	
	
}

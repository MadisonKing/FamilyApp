package com.familyApp.FamilyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a user object
 * @author Madison King
 *
 */
public class User {

	
	/**email of user */
	private String email;
	
	/** first name of user */
	private String firstName;
	
	/**last name of user */
	private String lastName;
	
	/** List of families that user belongs to */
	protected ArrayList<Pin> families = new ArrayList<Pin>();
	
	
	protected ArrayList<Family> familys= new ArrayList<Family>();
	
	
	/**
	 * Empty constructor
	 */
	public User() {
		super();
		this.email = "";
		this.firstName = "";
		this.lastName = "";
	}


	/**
	 * @param email
	 */
	public User(String email) {
		super();
		this.email = email;
		this.firstName = "";
		this.lastName = "";
	}


	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public User(String email, String firstName, String lastName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}





	/**
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param families
	 */
	public User(String email, String firstName, String lastName, ArrayList<Pin> families) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.families = families;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the families
	 */
	public ArrayList<Pin> getFamilies() {
		return families;
	}

	public ArrayList<Family> getFamilys(){
		return familys;
	}



	/**
	 * @param families the families to set
	 */
	public void setFamilies(ArrayList<Pin> families) {
		this.families = families;
	}
	
	public void display(){
		System.out.println(email + '\n' + firstName + '\n' + lastName);
	}


	

}
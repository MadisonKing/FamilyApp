package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the popup that gives the user the first options when opening the web application
 * @author Madison King
 *
 */
public class WelcomeWindow extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 261880888518763935L;
	public Button returningUser = new Button("Returning User");
	private Button newUser; //= new Button("New User");


	private VerticalLayout subWindowContent = new VerticalLayout();

	public WelcomeWindow() {
		super("Welcome");
		this.newUser = new Button("New User");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		center();
		
		setClosable(false);
		subWindowContent.addComponents(newUser,returningUser);
		setContent(subWindowContent);
		newUser.setDescription("Create a new account");
	    returningUser.setDescription("Login");
	}
	
	/**
	 * @return the returningUser
	 */
	public Button getReturningUserBtn() {
		return returningUser;
	}
	
	public Button getNewUserBtn(){
		return newUser;
	}
	
}
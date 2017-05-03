package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * This class represents the layout for the menu that will be on both the user and family profile layouts
 * @author Madison King
 *
 */
public class MenuLayout extends VerticalLayout {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 94586195668717659L;

	private Button help = new Button("Help");
	
	private Button logout = new Button("Logout");
	
	private Label label = new Label("Menu");
	
	private Button userProfile = new Button("My Profile");
	
	private Button families = new Button("Families");
	
	private Button blog= new Button("Blog");
	
	private Button settings = new Button("Settings");
	
	public MenuLayout(){
		addComponents(label, userProfile, blog, families, settings, help, logout);
		
	}



	/**
	 * @return the logout
	 */
	public Button getLogout() {
		return logout;
	}

	/**
	 * @return the help
	 */
	public Button getHelp() {
		return help;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @return the userProfile
	 */
	public Button getUserProfile() {
		return userProfile;
	}
	
	/**
	 * 
	 * @return the blog
	 */
	public Button getBlog(){
		return blog;
	}

	/**
	 * @return the families
	 */
	public Button getFamilies() {
		return families;
	}

	/**
	 * @return the settings
	 */
	public Button getSettings() {
		return settings;
	}
	


}

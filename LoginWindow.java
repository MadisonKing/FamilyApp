package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the subwindow that allows user to login to their existing account
 * @author Madison King
 *
 */
public class LoginWindow extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9198873156227993074L;
	
	/** text field for email*/
	TextField email = new TextField("Please enter your email address");

	/** Confirms logging into account */
	Button login = new Button("Login");
	
	/**button to go back if user desires to exit the current window */
	Button back = new Button("Back");
	
	VerticalLayout layout = new VerticalLayout();
	
	public LoginWindow() {
		super("Please login");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		center();
		setClosable(false);
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(login, back);
		layout.addComponents(email, buttons);
		setContent(layout);
		
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the email
	 */
	public TextField getEmail() {
		return email;
	}

	/**
	 * @return the login
	 */
	public Button getLogin() {
		return login;
	}

	/**
	 * @return the back
	 */
	public Button getBack() {
		return back;
	}

	/**
	 * @return the layout
	 */
	public VerticalLayout getLayout() {
		return layout;
	}
	
	public void resetValues(){
		email.setValue("");
		
	}
}
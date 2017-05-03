package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the subwindow that allows user to create a user object
 * @author Madison King
 *
 */
public class CreateUserWindow extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8311388298794186166L;
	
	/** text field for first name */
	TextField first = new TextField("Please enter your first name");
	
	/** text field for last name */
	TextField last = new TextField("Please enter your last name");
	
	/** text field for email*/
	TextField email = new TextField("Please enter your email address");
	
	/** Confirms creation of account */
	Button create = new Button("Create account");
	
	/**button to go back if user desires to exit the current window */
	Button back = new Button("Back");
	
	VerticalLayout layout = new VerticalLayout();

	/**
	 * 
	 */
	public CreateUserWindow() {
		super("Create User Profile");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		setSizeUndefined();
		center();
		setClosable(false);
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(create, back);
		layout.addComponents(first, last, email, buttons);
		setContent(layout);
		
	}

	/**
	 * @return the first
	 */
	public TextField getFirst() {
		return first;
	}

	/**
	 * @return the last
	 */
	public TextField getLast() {
		return last;
	}

	/**
	 * @return the email
	 */
	public TextField getEmail() {
		return email;
	}

	/**
	 * @return the create
	 */
	public Button getCreate() {
		return create;
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
		last.setValue("");
		first.setValue("");
		
	}
	
	
	

}
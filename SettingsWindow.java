package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the popup window that allows user to edit their user profile information (or other account information)
 * @author Madison King
 *
 */
public class SettingsWindow extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6290099842445420344L;

	/** text field for editing first name */
	private TextField editFirst = new TextField("Edit first name");
	
	/** text field for editing last name */
	private TextField editLast = new TextField("Edit last name");
	
	/** text field for editing email*/
	private TextField editEmail = new TextField("Edit email address");
	
	/** Confirms changes of account */
	private Button save = new Button("Save Changes");
	
	/**button to go back if user desires to exit the current window */
	private Button back = new Button("Back");
	
	private VerticalLayout layout = new VerticalLayout();
	
	private User user = new User();
	
	
	public SettingsWindow(User user) {
		super("Account Settings");
		this.user = user;
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		center();
		setClosable(false);
		editFirst.setValue(user.getFirstName());
		editLast.setValue(user.getLastName());
		editEmail.setValue(user.getEmail());
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(save, back);
		//save.addClickListener(new SaveChangesBtnListener());
		layout.addComponents(editFirst,editLast,editEmail, buttons);
		setContent(layout);
		
	}

	/**
	 * @return the editFirst
	 */
	public TextField getEditFirst() {
		return editFirst;
	}
	

	/**
	 * @return the editLast
	 */
	public TextField getEditLast() {
		return editLast;
	}

	/**
	 * @return the editEmail
	 */
	public TextField getEditEmail() {
		return editEmail;
	}

	/**
	 * @return the save
	 */
	public Button getSave() {
		return save;
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

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return the User
	 */
	public User getUser(){
		return user;
	}
	

	

}
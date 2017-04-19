package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the subwindow that allows user to create a family object
 * @author Madison King
 *
 */
public class CreateFamilyWindow extends Window{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**text field for family's name */
	TextField familyName = new TextField("Please enter the name of the family");
	
	/** Confirms creation of account */
	Button create = new Button("Create account");
	
	/**button to go back if user desires to exit the current window */
	Button back = new Button("Back");
	
	// Layout for the window
	VerticalLayout layout = new VerticalLayout();
	
	Label pinReveal;
	
	public CreateFamilyWindow() {
		super("Create Family Profile");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		center();
		setClosable(false);
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(create, back);
		layout.addComponents(familyName, buttons);
		setContent(layout);
		
	}

	/**
	 * @return the familyName
	 */
	public TextField getFamilyName() {
		return familyName;
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

	/**
	 * @return the pinReveal
	 */
	public Label getPinReveal() {
		return pinReveal;
	}
	

	public void resetValues(){
		familyName.setValue("");
		pinReveal.setValue("");
		
	}
	
}

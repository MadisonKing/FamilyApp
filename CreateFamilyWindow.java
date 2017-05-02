package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
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
public class CreateFamilyWindow extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**text field for family's name */
	TextField familyName = new TextField("Please enter the name of the family");
	
	/** Confirms creation of account */
	Button create = new Button("Create family");
	
	UserProfileLayout layout;
	
	User user;
	
	Family family;	
	
	
	
	Label pinReveal;
	
	public CreateFamilyWindow(User user, UserProfileLayout layout) {
		this.user=user;
		this.layout=layout;
		initLayout();
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(create);
		addComponents(familyName, buttons);
		create.addClickListener(new CreateBtnListener());
		
		
		//Pin pin= new Pin(familyName.getValue());
		//pinReveal.setCaption(Integer.toString(pin.getPinNumber()));
		
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
	
	public Family getFamily(){
		return family;
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
	
	public class CreateBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Pin pin= new Pin(familyName.getValue());
			family= new Family(familyName.getValue(), pin);
			layout.addFam(family);
			layout.setGrid(layout.getFams());
		}
		
	}
	
}
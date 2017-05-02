package com.familyApp.FamilyApp;


import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class FamilyForm extends VerticalLayout{
	
	
	

	private TextField familyName= new TextField("Enter family name");
	
	private TextField familyPin= new TextField("Enter family pin");
	
	
	private Button confirm= new Button("Join");
	
	
	private Button back = new Button("Back");
	
	
	
	private User user;
	
	
	public FamilyForm(){
		initLayout();
	}
	
	private void initLayout(){
		setSizeUndefined();
		HorizontalLayout buttons= new HorizontalLayout();
		buttons.addComponents(confirm, back);
		addComponents(familyName, familyPin, buttons);
	}
	
	
	public TextField getFamilyName(){
		return familyName;
	}
	
	public int getFamilyPin(){
		String temp=familyPin.getValue();
		return Integer.parseInt(temp);
	}
	
	public Button getConfirm(){
		return confirm;
	}
	
	public Button getBack(){
		return back;
	}
	
	
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void resetValues(){
		familyName.setValue("");
	}
	

	
	
	
	
}

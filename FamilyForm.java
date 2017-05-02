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
	
	
		
	private TextField familyPin= new TextField("Enter family pin");
	
	private Button confirm= new Button("Join");
	
	Family family=new Family();
	

	
	
	
	private User user;
	
	
	public FamilyForm(User user){
		this.user=user;
		initLayout();
	}
	
	private void initLayout(){
		setSizeUndefined();
		HorizontalLayout buttons= new HorizontalLayout();
		buttons.addComponents(confirm);
		addComponents( familyPin, buttons);
		confirm.addClickListener(new AddConfirmBtnListener());
	}
	

	public int getFamilyPin(){
		String temp=familyPin.getValue();
		return Integer.parseInt(temp);
	}
	
	public Button getConfirm(){
		return confirm;
	}
	
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void resetValues(){
		familyPin.setValue("");
	}
	

	
	public class AddConfirmBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			if(user.getFamilies().contains(familyPin)){
				family.addUser(user);
				familyPin.setValue("Added to family");
			}
			else{
				familyPin.setValue("Family pin not found");
			}
			
			
		}
		
	}
	
	
	
	
}

package com.familyApp.FamilyApp;


import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class DuplicateWindow extends Window {

	private Button confirm= new Button("Continue");
	
	private Button cancel= new Button("Cancel");
	
	private Label message= new Label("Hit continue to save family if not a duplicate.");
	
	VerticalLayout layout= new VerticalLayout();
	
	
	
	public DuplicateWindow(){
		super("  ");
		initUI();
	}
	
	public void initUI(){
		setSizeUndefined();
		center();
		setClosable(false);
		HorizontalLayout buttons= new HorizontalLayout();
		buttons.addComponents(confirm, cancel);
		layout.addComponents(message, buttons);
		setContent(layout);
	}
	
	
	public Button getConfirm(){
		return confirm;
	}
	
	
	public Button getCancel(){
		return cancel;
	}
	
	
	public Label getMessage(){
		return message;
	}
	
	
	public VerticalLayout getLayout(){
		return layout;
	}
}

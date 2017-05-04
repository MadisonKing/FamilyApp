package com.familyApp.FamilyApp;

import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the subwindow that allows user to get help documentation
 * @author Madison King
 *
 */
public class HelpWindow extends Window{

	TextArea about = new TextArea();
	
	VerticalLayout layout = new VerticalLayout();
	
	public HelpWindow(){
		super("Help");
		setHeight("200px");
		setWidth("400px");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		about.setVisible(true);
		about.setValue("To add families, click on 'View Families', then click 'Add Family' " + '\n' 
		+ "To join a family, click on Join Family. Make sure you have the provided pin number. "	 
		+ '\n' + "To make changes to your profile, click 'Settings' ");
	    about.setWordWrap(true);
		layout.addComponent(about);
		setContent(layout);
	}
	
	
	
}
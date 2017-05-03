package com.familyApp.FamilyApp;

import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class represents the subwindow that allows user to get help documentation
 * @author Madison King
 *
 */
public class HelpWindow extends Window{

	private TextArea about = new TextArea();
	
	VerticalLayout layout = new VerticalLayout();
	
	public HelpWindow(){
		super("Help");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		about.setValue("This will contain help documentation");
		about.setWordWrap(true);
		layout.addComponent(about);
	}
}
package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * This class represents the layout for the user profile
 * @author Madison King
 *
 */
public class UserProfileLayout extends HorizontalLayout {

	private MenuLayout menu = new MenuLayout();
	
	private Label userName = new Label();
	
	private User user;
	
	private Button families = new Button("View Families");
	
	private Grid<Family> familiesGrid = new Grid<>(Family.class);
	
	private Button addFamily = new Button("Add Family");
	
	private Button hideFamily = new Button("Hide Families");
	
	VerticalLayout layout = new VerticalLayout();
	
	
	public UserProfileLayout(User user){
		this.user = user;
		initLayout();
		
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(families, hideFamily, addFamily);
		hideFamily.setVisible(false);
		addFamily.setVisible(false);
		layout.addComponents(userName, buttons, familiesGrid);
		userName.setValue(user.getFirstName() + '\n' + user.getLastName() + '\n' + user.getEmail());
		addComponents(menu, layout);
		familiesGrid.setVisible(false);
		familiesGrid.setData(user.getFamilies());
		families.addClickListener(new FamiliesBtnListener());
		hideFamily.addClickListener(new HideFamiliesBtnListener());
		
	}
	
	public void resetFields() {
		familiesGrid.setVisible(false);
		hideFamily.setVisible(false);
		addFamily.setVisible(false);
	}
	
	
	
	/**
	 * @return the addFamily
	 */
	public Button getAddFamilyBtn() {
		return addFamily;
	}

	


	/**
	 * @return the menu
	 */
	public MenuLayout getMenu() {
		return menu;
	}




	public class FamiliesBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			familiesGrid.setVisible(true);
			hideFamily.setVisible(true);
			addFamily.setVisible(true);
		}
		
	}
	
	public class HideFamiliesBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			resetFields();
		}
		
	}
	

	
}

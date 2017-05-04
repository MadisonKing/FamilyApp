package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * This class represents the layout for the family's profile
 * @author Madison King
 *
 */
public class FamilyProfileLayout extends HorizontalLayout{
	
	private MenuLayout menu = new MenuLayout();
	
	private Label familyName = new Label();
	
	private Pin family;
	
	private Button members = new Button("View family members");
	
	private Button hideMembers = new Button("Hide members");
	
	private Grid<User> membersGrid = new Grid<>(User.class);
	
	private NewsBoard newsBoard = new NewsBoard();
	
	
	VerticalLayout layout = new VerticalLayout();
	
	public FamilyProfileLayout(Pin pin){
		this.family = pin;
		initLayout();
		
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(members, hideMembers);
		newsBoard.setSizeFull();
		hideMembers.setVisible(false);
		layout.addComponents(familyName, buttons, membersGrid, newsBoard);
		membersGrid.setData(family.getFamily().getUsers());
		membersGrid.setColumnOrder("firstName", "lastName", "email");
		membersGrid.getColumn("families").setHidden(true);
		membersGrid.setVisible(false);
		familyName.setValue(family.getFamily().getName() + " (Pin: " + family.getPinNumber() + ") ");
		addComponents(menu, layout);
		members.addClickListener(new MembersBtnListener());
		hideMembers.addClickListener(new HideMembersBtnListener());
	}
	
	public void resetFields(){
		hideMembers.setVisible(false);
		members.setVisible(true);
		membersGrid.setVisible(false);
	}
	

	/**
	 * @return the menu
	 */
	public MenuLayout getMenu() {
		return menu;
	}

	
	public class MembersBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			membersGrid.setVisible(true);
			members.setVisible(false);
			hideMembers.setVisible(true);
		}
		
		
	}
	
	public class HideMembersBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			resetFields();
			
		}
		
		
	}
}
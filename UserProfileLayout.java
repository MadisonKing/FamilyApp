package com.familyApp.FamilyApp;



import java.util.ArrayList;
import java.util.List;

import com.familyApp.FamilyApp.MyUI.BackBtnListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


/**
 * This class represents the layout for the user profile
 * @author Madison King
 *
 */
public class UserProfileLayout extends HorizontalLayout {

	private MenuLayout menu = new MenuLayout();
	

	private Label userName = new Label();

	private User user;
	
	
	protected Button families = new Button("View Families");

	protected Grid<Family> familiesGrid = new Grid<>(Family.class);

	protected Button addFamily = new Button("Add Family");
	
	protected Button joinFamily= new Button("Join Family");

	protected Button hideFamily = new Button("Hide Families");

	VerticalLayout layout = new VerticalLayout();
	
	CreateFamilyWindow newFamilyWindow= new CreateFamilyWindow(user);
	
	FamilyForm newFamilyForm= new FamilyForm(user);



	public UserProfileLayout(User user){
		this.user = user;
		initLayout();

	}

	private void initLayout() {
		// TODO Auto-generated method stub
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(families, hideFamily, addFamily, joinFamily);
		hideFamily.setVisible(false);
		addFamily.setVisible(false);
		joinFamily.setVisible(false);
		layout.addComponents(userName, buttons, familiesGrid, newFamilyWindow, newFamilyForm);
		userName.setValue(user.getFirstName() + '\n' + user.getLastName() + '\n' + user.getEmail());
		addComponents(menu, layout);
		familiesGrid.setVisible(false);
		newFamilyWindow.setVisible(false);
		newFamilyForm.setVisible(false);
		familiesGrid.setData(user.getFamilies());
		families.addClickListener(new FamiliesBtnListener());
		addFamily.addClickListener(new AddFamilyBtnListener());
		joinFamily.addClickListener(new JoinFamilyBtnListener());
		hideFamily.addClickListener(new HideFamiliesBtnListener());


	}

	public void resetFields() {
		familiesGrid.setVisible(false);
		hideFamily.setVisible(false);
		addFamily.setVisible(false);
		joinFamily.setVisible(false);
		newFamilyWindow.setVisible(false);
		newFamilyForm.setVisible(false);
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

	
	public void setGrid(List<Family> list){
		familiesGrid.setItems(list);
	}
	
	public void setFamiliesBtnSelected(){
		newFamilyWindow.setVisible(false);
		newFamilyForm.setVisible(false);
		familiesGrid.setVisible(true);
		hideFamily.setVisible(true);
		addFamily.setVisible(true);
		joinFamily.setVisible(true);
	}



	public class FamiliesBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			newFamilyWindow.setVisible(false);
			newFamilyForm.setVisible(false);
			familiesGrid.setVisible(true);
			hideFamily.setVisible(true);
			addFamily.setVisible(true);
			joinFamily.setVisible(true);
			familiesGrid.setItems(user.getFamilys());
		}

	}

	public class AddFamilyBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			newFamilyForm.setVisible(false);
			familiesGrid.setVisible(false);
			newFamilyWindow.setVisible(true);


			

		}

	}
	
	public class JoinFamilyBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			newFamilyWindow.setVisible(false);
			familiesGrid.setVisible(false);
			newFamilyForm.setVisible(true);
			//int fampin=Integer.parseInt(newFamilyWindow.getPinReveal().getCaption());
			
			
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
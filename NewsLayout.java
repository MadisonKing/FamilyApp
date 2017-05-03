package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class NewsLayout extends VerticalLayout {

	
	protected News news;
	
	protected User user;
	
	protected Button post= new Button("Post");
	
	protected Button cancel= new Button("Cancel");
	
	//VerticalLayout layout= new VerticalLayout();
	
	protected Grid<News> grid= new Grid<>(News.class);
	
	
	public NewsLayout(User user){
		this.user=user;
		initLayout();
	}
	
	private void initLayout(){
		HorizontalLayout buttons= new HorizontalLayout();
		buttons.addComponents(post, cancel);
		addComponents(grid, buttons);
	}
	
}

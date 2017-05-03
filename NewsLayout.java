package com.familyApp.FamilyApp;

import java.util.ArrayList;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class NewsLayout extends VerticalLayout {

		
	protected User user;
	
	ArrayList<News> posts= new ArrayList<News>();
	
	protected TextField text= new TextField("Enter post here");
	
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
		addComponents(grid,text, buttons);
		post.addClickListener(new PostBtnListener());
	}
	
	
	public class PostBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			News news= new News(text.getValue(), user);
			posts.add(news);
			grid.setItems(posts);
			
		}
		
	}
}

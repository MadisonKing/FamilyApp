package com.familyApp.FamilyApp;

import java.util.ArrayList;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

/**
 * This class represents the whole Grid of news posting on a family's profile
 * @author Madison King
 *
 */
public class NewsBoard extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6912266703956383028L;

	/**component that will show the layout of news posted */
	private Grid<News> news = new Grid<>(News.class);
	
	/**button to post to news board */
	private Button add = new Button("New post");
	
	private ArrayList<News> newsList = new ArrayList<News>();
	
	/**
	 * @param news
	 */
	public NewsBoard(Grid<News> news) {
		super();
		this.news = news;
		initNewsBoard();
		
	}
	
	public NewsBoard(ArrayList<News> newsList)
	{
		super();
		this.newsList = newsList;
		initNewsBoard();
	}
	
	

	private void initNewsBoard() {
		// TODO Auto-generated method stub
		news.setData(newsList);
		addComponents(news, add);
	}



	/**
	 * @param add
	 */
	public NewsBoard() {
		super();
		initNewsBoard();
		
	}



	/**
	 * @return the news
	 */
	public Grid<News> getNews() {
		return news;
	}

	/**
	 * @param news the news to set
	 */
	public void setNews(Grid<News> news) {
		this.news = news;
	}

	/**
	 * @return the add
	 */
	public Button getAdd() {
		return add;
	}

	/**
	 * @param add the add to set
	 */
	public void setAdd(Button add) {
		this.add = add;
	}
	
	
	

}
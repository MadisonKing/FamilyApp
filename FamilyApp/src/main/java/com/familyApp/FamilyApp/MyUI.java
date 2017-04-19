package com.familyApp.FamilyApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;


import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	/*
	 * 
	 * This comment block is my test to see if my changes have been made in GitHub
	 */
	WelcomeWindow welcomeWindow = new WelcomeWindow();
	CreateUserWindow newUserWindow = new CreateUserWindow();
	LoginWindow loginWindow = new LoginWindow();
	BackWindow backWindow = new BackWindow();
	HelpWindow helpWindow = new HelpWindow();
	Window currentWindow; // This value is to keep track of our current window that is open
	Window previousWindow; // This value is to keep track of the previous window that we would want to go back to 
	ArrayList<User> users = new ArrayList<User>();
	//UserProfileLayout userProfile;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final GridLayout layout = new GridLayout();
        currentWindow = welcomeWindow;
        users = readUserDataBase("users.csv");
        addWindow(welcomeWindow);
        welcomeWindow.getNewUserBtn().addClickListener(new NewUserBtnListener());
        welcomeWindow.getReturningUserBtn().addClickListener(new ReturningUserBtnListener());
        backWindow.getCancel().addClickListener(new CancelBtnListener());
        backWindow.getConfirm().addClickListener(new ConfirmBtnListener());
        newUserWindow.getBack().addClickListener(new BackBtnListener());
        loginWindow.getBack().addClickListener(new BackBtnListener());
        loginWindow.getLogin().addClickListener(new LoginBtnListener());
        newUserWindow.getCreate().addClickListener(new CreateAccountBtnListener());
        
        
        
        // TEST: layout.addComponent(new NewsBoard()); (passed)
        // TEST: layout.addComponent(new MenuLayout()); (passed)
        // TEST:  User tempUser = new User("madisontking@yahoo.com", "Madison", "King"); (passed)
        // TEST: tempUser.display(); (passed)
        // TEST: layout.addComponent(new UserProfileLayout(tempUser)); // (passed)
        // TEST: Pin tempPin = new Pin("King"); // passed
        // TEST: layout.addComponent(new FamilyProfileLayout(tempPin)); // passed
        // TEST: tempPin.display(); // passed
        setContent(layout);
    }
    
    public ArrayList<Pin> parseFamilies(String string)
    {
    	ArrayList<Pin> tempFamilies = new ArrayList<Pin>();
    	return tempFamilies;
    }
    public void updateUserDataBase(User tempUser) {
    	String filename = "users.csv";
    	users.add(tempUser);
    	//grid.setItems(cds);    	
    	// TODO Also needs to write to CDCatalog1.csv later
    	try {
			FileWriter fw = new FileWriter(filename, true);
			
			fw.write(tempUser.getEmail());
			fw.write(",");
			fw.write(tempUser.getFirstName());
			fw.write(",");
			fw.write(tempUser.getLastName());
			for(int i = 0; i < tempUser.getFamilies().size(); ++i)
			{
				fw.write(tempUser.getFamilies().get(i).getPinNumber());
				fw.write("/");
			}
			fw.write('\n');
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public ArrayList<User> readUserDataBase(String filename)
    {
    	ArrayList<User> temp_users = new ArrayList<User>();
    	 // Temp variables to keep track of imported cd's title, artist, and genre
        String first = ""; 
        String last = "";
        String email = "";
        String families = "";
        
    	try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			 String line = br.readLine();
		        line = br.readLine();
		        String temp = "";
		        int numCommas = 0;
		        while(line != null)
		        {
		        	first = "";
		        	last = "";
		        	email = "";
		        	families = "";
		        	temp = "";
		        	numCommas = 0;
		        	//System.out.println(line);
		        	for(int i = 0; i < line.length(); ++i)
		        	{       		

		        		if(line.charAt(i) != ',')
		        		{
		        			temp+=line.charAt(i);
		        		}
		        		else if(line.charAt(i) == ',')
		        		{
		        			++numCommas;
		        			if(numCommas == 1)
		        			{
		        				email = temp;
		        			}
		        			else if (numCommas == 2)
		        			{
		        				first = temp;
		        			}
		        			else if(numCommas == 3){
		        				last = temp;
		        				families = line.substring(i + 1, line.length());
		        			}
		        			temp = "";
		        		}

		        	}
		        	
		        	User user = new User(email, first, last, parseFamilies(families));
		        	temp_users.add(user);
		        	line = br.readLine();
		        }
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
    	return temp_users;
    }
    
    public ArrayList<Integer> readFamilyDataBase(String filename)
    {
    	ArrayList<Integer> temp_pinNums = new ArrayList<Integer>();
    	 // Temp variables to keep track of imported cd's title, artist, and genre
        String pin = "";
        int pinNumber = 0;
    	try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			 String line = br.readLine();
		        line = br.readLine();
		        String temp = "";
		        int numCommas = 0;
		        while(line != null)
		        {
		        	pin = "";
		        	temp = "";
		        	numCommas = 0;
		        	pinNumber = 0;
		        	//System.out.println(line);
		        	for(int i = 0; i < line.length(); ++i)
		        	{       		

		        		if(line.charAt(i) != ',')
		        		{
		        			temp+=line.charAt(i);
		        		}
		        		else if(line.charAt(i) == ',')
		        		{
		        			++numCommas;
		        			if(numCommas == 1)
		        			{
		        				pin = temp;
		        			}
		        			temp = "";
		        		}

		        	}
		        	
		        	pinNumber = Integer.parseInt(pin); 
		        	temp_pinNums.add(pinNumber);
		        	line = br.readLine();
		        }
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
    	return temp_pinNums;
    }
    
    public void initNewUserWindow(){
    	addWindow(newUserWindow);
    	newUserWindow.resetValues();
    	previousWindow = currentWindow;
    	currentWindow = newUserWindow;
    }
    
    public void initLoginWindow(){
    	addWindow(loginWindow);
    	loginWindow.resetValues();
    	previousWindow = currentWindow;
    	currentWindow = loginWindow;
    }
    
    public int findUser(String string)
    {
    	int index = -1;
    	for(int i = 0; i < users.size(); ++i)
    	{
    		if(users.get(i).getEmail().equalsIgnoreCase(string))	index = i;
    		
    	}
    	
    	return index;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    public class ConfirmBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			backWindow.close();
			currentWindow.close();
			currentWindow = previousWindow;
			if(previousWindow.equals(newUserWindow) || previousWindow.equals(loginWindow))
			{
				previousWindow = welcomeWindow;
			}
			addWindow(previousWindow);
			
		}
    	
    }
    
    public class CreateAccountBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			String email = newUserWindow.getEmail().getValue();
			
			if(findUser(email) != -1)
			{
				newUserWindow.getEmail().setValue("An account with this email already exists");
			}
			else {
				// Create account
				User user = new User(newUserWindow.getEmail().getValue(), newUserWindow.getFirst().getValue(), newUserWindow.getLast().getValue());
				updateUserDataBase(user);
			}
		}
    	
    }
    
    public class LoginBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			// First decide if user was found

			// Then load the user profile
			String email = loginWindow.getEmail().getValue();
			if(findUser(email) != -1) {
				// TEST: loginWindow.getEmail().setValue("Found");
				UserProfileLayout userProfile = new UserProfileLayout(users.get(findUser(email)));
				currentWindow.close();
				setContent(userProfile);
				//layout.addComponent(userProfile);
			}
			else {
				loginWindow.getEmail().setValue("Email not found");
					
			}



		}

    }
    
    public class CancelBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			backWindow.close();
		}
    	
    }
    
    public class NewUserBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			welcomeWindow.close();
			initNewUserWindow();
			
		}
    	
    }

    public class ReturningUserBtnListener implements ClickListener {

    	@Override
    	public void buttonClick(ClickEvent event) {
    		welcomeWindow.close();
    		initLoginWindow();
    	}

    }
    
    public class BackBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			addWindow(backWindow);
			//currentWindow = backWindow;
		}
    	
    }

}

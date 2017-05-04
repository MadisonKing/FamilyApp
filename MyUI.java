package com.familyApp.FamilyApp;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

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
	 * This comment is the 2nd block to see if my changes have been made in GitHub
	 */
	
	WelcomeWindow welcomeWindow = new WelcomeWindow();
	CreateUserWindow newUserWindow = new CreateUserWindow();
	LoginWindow loginWindow = new LoginWindow();
	BackWindow backWindow = new BackWindow();
	
	User currentUser = new User();
	Window currentWindow; // This value is to keep track of our current window that is open
	Window previousWindow; // This value is to keep track of the previous window that we would want to go back to 
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Pin> familyDatabase = new ArrayList<Pin>();
	SettingsWindow settingsWindow = new SettingsWindow(currentUser);
	ArrayList<Integer> pinNumbers = new ArrayList<Integer>();
	CreateFamilyWindow createFamilyWindow = new CreateFamilyWindow(currentUser);
	UserProfileLayout userProfile;
	int userIndex;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final GridLayout layout = new GridLayout();
        currentWindow = welcomeWindow;
        familyDatabase = readFamilyDataBase("familypins.csv");
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
        createFamilyWindow.getCreate().addClickListener(new CreateFamilyBtnListener());
        
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
    
    public void addFamilyToDataBase(Pin pin){
    	String filename = "familypins.csv";
    	familyDatabase.add(pin);
    	//grid.setItems(cds);    	
    	// TODO Also needs to write to CDCatalog1.csv later
    	try {
			FileWriter fw = new FileWriter(filename, true);
			
			fw.write(Integer.toString(pin.getPinNumber()));
			fw.write(",");
			fw.write(pin.getFamily().getName());
			//fw.write(",");
			//fw.write(pin.getLastName());
		/*	for(int i = 0; i < tempUser.getFamilies().size(); ++i)
			{
				fw.write(tempUser.getFamilies().get(i).getPinNumber());
				fw.write("/");
			}*/
			fw.write('\n');
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    /**
     * Generate a new pin number for a new family
     * @return int pinNumber
     */
    public int newPin(){
    	int pin = generatePinNum();
		while(pinNumbers.contains(pin)){
			//System.out.println("newPin() called: " + pin);
			pin = generatePinNum();
		}
		pinNumbers.add(pin);
		return pin;
    	
    }
    
    public int generatePinNum(){
    	int pinNum = (int) ((Math.random() + 2) * 1234);
    	return pinNum;
    }
    
    
    public ArrayList<Pin> parseFamilies(String string)
    {
    	
    	String temp = "";
    	ArrayList<Pin> tempFamilies = new ArrayList<Pin>();
    	for(int i = 0; i < string.length(); ++i){
    		if(string.charAt(i) != '/'){
    			temp += string.charAt(i);
    		}
    		else{
    			Pin tempPin = familyDatabase.get(findPin(Integer.parseInt(temp)));
    			tempFamilies.add(tempPin);
    			temp = "";
    		}
    	}
    	
    	return tempFamilies;
    }
    
    public int findPin(int pinNumber){
    	
    	int index = -1;
    	for(int i = 0; i < familyDatabase.size(); ++i){
    		if(familyDatabase.get(i).getPinNumber() == pinNumber){
    			index = i;
    		}
    	}
    	 return index;
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
    public void editUserEntry(User user)
    {
    	users.set(userIndex, currentUser);
    	String temp;
    	ArrayList<String> usersToFile = new ArrayList<String>();
    	for(int i = 0; i < users.size(); ++i)
    	{
    		temp = users.get(i).toString();
    		usersToFile.add(temp);
    	}
    	
    	
    	try {
			FileWriter fw = new FileWriter("users.csv",false);
			fw.write("Email");
			fw.write(',');
			fw.write("First");
			fw.write(',');
			fw.write("Last");
			fw.write(',');
			fw.write("Families");
			fw.write('\n');
			
			for(int i = 0; i < usersToFile.size(); ++i){
			//	System.out.println(usersToFile.get(i));
				fw.write(usersToFile.get(i));
			}
			
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
		        				System.out.println(families);
		        			}
		        			temp = "";
		        		}

		        	}
		        	
		        	User user = new User(email, first, last, parseFamilies(families));
		        	user.display();
		        	if(user.getFamilies().isEmpty()) System.out.println("No families");
		        	temp_users.add(user);
		        	line = br.readLine();
		        }
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
    	return temp_users;
    }
    
    public ArrayList<Pin> readFamilyDataBase(String filename)
    {
    	ArrayList<Pin> pins = new ArrayList<Pin>();
    	ArrayList<Integer> temp_pins = new ArrayList<Integer>();
    	ArrayList<String> temp_names = new ArrayList<String>();
   
    	
   	 // Temp variables to keep track of imported cd's title, artist, and genre
       String pinNumber = ""; 
       String familyName = "";
       String user = "";
     
       
   	try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			 String line = br.readLine();
		        line = br.readLine();
		        String temp = "";
		        int numCommas = 0;
		        while(line != null)
		        {
		    //    	ArrayList<String> userNames = new ArrayList<String>();
		        	pinNumber = "";
		        	familyName = "";
		        	user = "";
		        	temp = "";
		        	numCommas = 0;
		        	
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
		        				pinNumber = temp;
		        			}
		        			else if (numCommas == 2)
		        			{
		        				familyName = temp;
		        			}
		        			else if(numCommas == 3){
		        				familyName = temp;
		        				//user = line.substring(i + 1, line.length());
		        			}
		        			temp = "";
		        		}

		        	}
		        	
		        	temp_names.add(familyName);
		        	temp_pins.add(Integer.parseInt(pinNumber));

		        	line = br.readLine();
		        }
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

   	pinNumbers = temp_pins;
   	if(!temp_names.isEmpty()){
   		
   		for(int i = 0; i < temp_names.size(); ++i){
   			Family temp_family = new Family(temp_names.get(i));
   			Pin temp_pin = new Pin(temp_pins.get(i), temp_family);
   			
   			pins.add(temp_pin);
   		}
   		

   	}
   	return pins;
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
    
    public void addUserProfileListeners(UserProfileLayout userProfile)
    {
    	createFamilyWindow.setVisible(false);
    	userProfile.getLayout().addComponent(createFamilyWindow);
    	
    	//userProfile.getMenu().getHelp().addClickListener(new HelpBtnListener());
    	userProfile.getMenu().getSettings().addClickListener(new SettingsBtnListener());
    	userProfile.getMenu().getUserProfile().addClickListener(new MyProfileBtnListener());
    	userProfile.getMenu().getLogout().addClickListener(new LogoutBtnListener());
    	userProfile.getMenu().getFamilies().addClickListener(new FamiliesBtnListener());
    	userProfile.getMenu().getHelp().addClickListener(new HelpBtnListener());
    	userProfile.getMenu().getBlog().addClickListener(new BlogBtnListener());
    	userProfile.getAddFamilyBtn().addClickListener(new AddFamilyBtnListener());
    }
    
    public void addSettingsWindowListeners(SettingsWindow settingsWindow)
    {
    	settingsWindow.getBack().addClickListener(new SettingsBackBtnListener());
        settingsWindow.getSave().addClickListener(new SaveChangesBtnListener());
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
			getContent().setEnabled(true);
			if(!currentWindow.equals(settingsWindow)) {


				currentWindow = previousWindow;
				if(previousWindow.equals(newUserWindow) || previousWindow.equals(loginWindow))
				{
					previousWindow = welcomeWindow;
				}

				addWindow(previousWindow);
			}
		}
    	
    }
    
    public class AddFamilyBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//CreateFamilyWindow newFamilyWindow = new CreateFamilyWindow(currentUser);
			//newFamilyForm.setVisible(false);
			//familiesGrid.setVisible(false);
			//newFamilyWindow.setVisible(true);
			createFamilyWindow.setVisible(true);
			

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
				newUserWindow.resetValues();
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
				userProfile = new UserProfileLayout(users.get(findUser(email)));
				addUserProfileListeners(userProfile);
				currentWindow.close();
				setContent(userProfile);
				addUserProfileListeners(userProfile);
				currentUser = users.get(findUser(email));
				userIndex = findUser(email);
				loginWindow.resetValues();
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
			getContent().setEnabled(false);
			//currentWindow = backWindow;
		}
    	
    }
    
    public class LogoutBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			currentWindow.close();
			addWindow(welcomeWindow);
			currentWindow = welcomeWindow;
			setContent(new VerticalLayout());
		}
    	
    }
    
    public class MyProfileBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			userProfile = new UserProfileLayout(currentUser);
			addUserProfileListeners(userProfile);
			setContent(userProfile);
			
		}
    }
    
    public class SettingsBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			settingsWindow = new SettingsWindow(currentUser);
			currentWindow = settingsWindow;
			getContent().setEnabled(false);
			addSettingsWindowListeners(settingsWindow);
			addWindow(settingsWindow);
		}
    	
    }
    
    public class SaveChangesBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			
			if(!settingsWindow.getEditEmail().getValue().equalsIgnoreCase(currentUser.getEmail()))
			{
				currentUser.setEmail(settingsWindow.getEditEmail().getValue());
			}
			if(!settingsWindow.getEditFirst().getValue().equalsIgnoreCase(currentUser.getFirstName())){
				currentUser.setFirstName(settingsWindow.getEditFirst().getValue());
			}
			if(!settingsWindow.getEditLast().getValue().equalsIgnoreCase(currentUser.getLastName())){
				currentUser.setLastName(settingsWindow.getEditLast().getValue());
			}
			// TODO Auto-generated method stub
			//currentUser = settingsWindow.getUser();
			//addUserProfileListeners(userProfile);
			settingsWindow.close();
			editUserEntry(currentUser);
			getContent().setEnabled(true);
		}
    	
    }
    
	public class SettingsBackBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//addWindow(backWindow);
			addWindow(backWindow);
			//settingsWindow.close();
			getContent().setEnabled(true);
		}
		
	}

	
	public class HelpBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			//currentWindow = helpWindow;
			HelpWindow helpWindow = new HelpWindow();
			addWindow(helpWindow);
		  //  getContent().setEnabled(true);
		}
		
	}
    
	
	public class FamiliesBtnListener implements ClickListener{
		
		@Override
		public void buttonClick(ClickEvent event){
			userProfile = new UserProfileLayout(currentUser);
			addUserProfileListeners(userProfile);
			setContent(userProfile);
			userProfile.setFamiliesBtnSelected();

		}
	}
	
	public class BlogBtnListener implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			UserProfileLayout userProfile= new UserProfileLayout(currentUser);
			addUserProfileListeners(userProfile);
			setContent(userProfile);
			userProfile.setBlogBtnSelected();
			
		}
		
	}
	
	public class CreateFamilyBtnListener implements ClickListener {

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			int pinNum = newPin();
			/*for(int i = 0; i < pinNumbers.size(); ++i){
				System.out.println(i + ": " + pinNumbers.get(i));
			}*/
			System.out.println("Pin number generated for new family: " + pinNum);
			Pin pin = new Pin(pinNum, createFamilyWindow.getFamilyName().getValue());
			System.out.println(pin.getPinNumber());
			currentUser.getFamilies().add(pin);
			for(int i = 0; i < currentUser.getFamilies().size(); ++i){
				System.out.println("user family " + i + ": " + currentUser.getFamilies().get(i).getPinNumber());
			}
			currentUser.getFamilys().add(pin.getFamily());
			//System.out.println(currentUser.familiesToString());
			userProfile.getGrid().setItems(currentUser.getFamilys());
			addFamilyToDataBase(pin);
			createFamilyWindow.setVisible(false);
			editUserEntry(currentUser);
			
			
		}
		
	}
    

}
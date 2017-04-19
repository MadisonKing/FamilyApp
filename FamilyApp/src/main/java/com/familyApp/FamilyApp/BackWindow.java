package com.familyApp.FamilyApp;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class is the popup window to alert the user that their changes will not be saved
 * It gives them two opens, two cancel or continue
 * @author Madison King
 *
 */
public class BackWindow extends Window {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5062683833007314682L;

	/**Button to confirm going back and not saving any changes made */
	private Button confirm = new Button("Continue");
	
	/**Button to cancel and return to previous window */
	private Button cancel = new Button("Cancel");
	
	/**Label to notify user that their changes will not be saved*/
	private Label message = new Label("Hit OK to exit. Note that your changes will not be saved.");
	
	VerticalLayout layout = new VerticalLayout();

	/**
	 * 
	 */
	public BackWindow() {
		super(" ");
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		setSizeUndefined();
		center();
		setClosable(false);
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.addComponents(confirm, cancel);
		layout.addComponents(message, buttons);
		setContent(layout);
		
	}

	/**
	 * @return the confirm
	 */
	public Button getConfirm() {
		return confirm;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @return the layout
	 */
	public VerticalLayout getLayout() {
		return layout;
	}

	
	
}

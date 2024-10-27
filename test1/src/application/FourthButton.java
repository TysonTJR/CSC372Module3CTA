package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;


public class FourthButton {    //this represents the fourth button in the menu
	private CustomMenuItem thirdMenuOption;
	private Menu mainMenu;                  //class attributes

	 
	public FourthButton( Menu mainMenu) {   //parameterized constructor that passes a Menu object from UserInterface
	
		this.mainMenu = mainMenu; //this assigns the mainMenu attribute to the mainMenu parameter
		
		this.thirdMenuOption = new CustomMenuItem(new Button("Exit Application")); //this creates a menu item that is a button
		
		thirdMenuOption.setOnAction(new EventHandler<ActionEvent>() { //this code starts code that handles a button press
			
			@Override
			public void handle(ActionEvent arg0) {    //this executes when a button is pressed
				System.exit(0);  //this closes the program
		
			}
		});
		
		
	}
	public void addButton() {   //this adds the button to the main menu in UserInterface
		mainMenu.getItems().add(thirdMenuOption);

	}
}

package application;


import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;

public class ThirdButton {    //this class represents the third button in the menu
	private CustomMenuItem thirdMenuOption;
	private Menu mainMenu;                     //class attributes

	 
	public ThirdButton(GridPane gridPane, Menu mainMenu) {   //parameterized constructor that passes a gridPane and menu from main 
	
		this.mainMenu = mainMenu;    //assigns the mainMenu attribute to the mainMenu parameter
		
		this.thirdMenuOption = new CustomMenuItem(new Button("Change Frame Background"));  //creates a menu item that is a button
		
		thirdMenuOption.setOnAction(new EventHandler<ActionEvent>() {  //this is the start of handling a button press
			
			@Override
			public void handle(ActionEvent arg0) {   //this is code that executes when button is pressed
				String[] colorArray = new String[5];   //creates a string array of differnet CSS background colors
				colorArray[0] = "-fx-background-color:#808000";
				colorArray[1] = "-fx-background-color:#608000";
				colorArray[2] = "-fx-background-color:#408000";
				colorArray[3] = "-fx-background-color:#208000";
				colorArray[4] = "-fx-background-color:#008000";
				
				Random randomnum = new Random();   //this creats a new Random object
				int randomInt = randomnum.nextInt(5);   //this creates a int variable that assigns itself to a random int 0-4
				gridPane.setStyle(colorArray[randomInt]);  //this sets the background color of the frame to a random color in colorArray
		
			}
		});
		
		
	}
	
	public void addButton() {   //this adds the button to the mainMenu
		mainMenu.getItems().add(thirdMenuOption);

	}
	
}

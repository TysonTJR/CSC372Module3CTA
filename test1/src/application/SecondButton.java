package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;

public class SecondButton {                       //this class represents the secondbutton in the main menu
	private CustomMenuItem secondMenuOption;
	private Menu mainMenu;                         //class attributes 

	 
	public SecondButton(Menu mainMenu, FirstButton firstMenuOption) {   //parameterized constructor that passes a menu and firstbutton object
	
		this.mainMenu = mainMenu;   //assigns the mainMenu attribute to the mainMenu parameter
		
		this.secondMenuOption = new CustomMenuItem(new Button("Write contents to file")); //creates a menu item that is a button
		
		secondMenuOption.setOnAction(new EventHandler<ActionEvent>() {  //this code handles the event when a button is pressed
			
			@Override
			public void handle(ActionEvent arg0) {   //this handles code for when a button is pressed
				String filePath = System.getProperty("user.dir");  //gets current user directory of user
				String fileName = "log.txt";   //creating a file name
				File newFile = new File(filePath + fileName);   //creating a new file with filepath and name
				FileWriter fileWriter;   //declaring a filewriter that can write to newFile
				
				if(newFile.exists()) {   //checks to see if newFile exists in system. code executes when returns true
				 try {   //encapsulate the code in a try-catch block
				  fileWriter = new FileWriter(newFile);  //creates a new fileWriter object and passes newFile 
				  fileWriter.write(firstMenuOption.getString());   //this writes to the file the date and time 
				  fileWriter.close();  //this closes the filewriter resource
				 }catch (IOException e) {  //this catches any io exception and prints the stacktrace if exception occurs
				
					 e.printStackTrace();
				 }
					
					}else {   //this executes when newFile.exists() returns false
						try {
							newFile.createNewFile();  //this creates newFile on system
							fileWriter = new FileWriter(newFile);
							fileWriter.write(firstMenuOption.getString());
							fileWriter.close();
						}catch (IOException e) {
							e.printStackTrace();
						}
				
					}
			}
		});
		
		
	}
	
	public void addButton() {   //this adds the button to the mainMenu
		mainMenu.getItems().add(secondMenuOption);

	}
	
	
	
}

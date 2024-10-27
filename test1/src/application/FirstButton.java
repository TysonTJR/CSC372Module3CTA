package application;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class FirstButton {            //first button class that represents a button on a menu
	private CustomMenuItem firstMenuOption;
	private LocalDateTime currTime;
	private DateTimeFormatter timeFormatter;     //attributes of the firstbutton
	private String convertedString;
	private Menu mainMenu;
	private GridPane gridPane;
	
	public FirstButton(String convertedTimeString, GridPane gridPane, Menu mainMenu) {   //parameterized firstbutton constructor
		this.gridPane = gridPane;
		this.mainMenu = mainMenu;                     //assigning firstbutton attributes to constructor parameters
		this.convertedString = convertedTimeString;
		
		this.firstMenuOption = new CustomMenuItem(new Button("Print Time and Date"));  //creates a menu item that is a button
		
		firstMenuOption.setOnAction(new EventHandler<ActionEvent>() {  // this handles when the firstbutton is pressed
			@Override
			public void handle(ActionEvent arg0) {   //method that is overrided from eventhandler class
				currTime = LocalDateTime.now();     //gets the current date and time and assigns it to currTime
				timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  //creates a formatter that formats the time to a string
				convertedString = currTime.format(timeFormatter);   //converts the date and time to a string
				TextField dateTextField = new TextField();    //creats a new TextField
				dateTextField.setPrefColumnCount(10);
				dateTextField.setText(convertedString);
				dateTextField.setEditable(false);
				dateTextField.setPadding(new Insets(10, 10, 10, 10));
				gridPane.setVgap(10);
				gridPane.add(dateTextField, 0, 2);
		
			}
		});
		
		
	}
	public void addButton() {    //this method adds the first button to the main menu
		mainMenu.getItems().add(firstMenuOption);

	}
	
	public String getString() {   //this method returns the converted date and time to a string 
		return convertedString;
	}
	
}

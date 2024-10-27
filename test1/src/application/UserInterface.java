package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;              //importing all required classes for application
import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class UserInterface extends Application {       //class that represents the GUI that inherits from the Application class
	private GridPane gridPane;
	private Scene mainScene;
	private Menu mainMenu;                //all private attributes of the UserInterface class
	private MenuBar menuBar;
	private VBox vbox;
	private String convertedTimeString;
	
	@Override
	public void start(Stage applicationStage) throws Exception {     //entry point into Javafx application
		
		applicationStage.setHeight(500);  //setting the height of the frame
		applicationStage.setWidth(500);   //setting the width of the frame

		this.gridPane = new GridPane();    //assigning the griPane class attribute to a new gridPane object
		this.mainScene = new Scene(gridPane);    //creates a new scene for the window and adds the gridPane to it
		gridPane.setStyle("-fx-background-color:#000000");   //sets the color of the frame background
		

		this.mainMenu = new Menu("Menu");   //creates a new menu and titles it "menu"
	
		this.menuBar = new MenuBar(mainMenu);     //assigns the attribute menuBar to a new MenuBar object named mainMenu
		menuBar.setMinWidth(63);   //setting the width of the menuBar in the gridPane
		
		FirstButton firstMenuOption = new FirstButton(convertedTimeString, gridPane, mainMenu ); /*Instantiates a FirstButton object 
		that contains the first button named "print date and time" and the handling when the button is pressed*/
		firstMenuOption.addButton();  //adds the button to the menu
	
		SecondButton secondMenuOption = new SecondButton(this.mainMenu, firstMenuOption); /*Instantiates a SecondButton object 
		that contains the second button named "Write contents to file" and the handling when the button is pressed*/
		
		secondMenuOption.addButton();  //adds the button to the menu
			
		ThirdButton thirdMenuOption = new ThirdButton(gridPane, mainMenu);   /*Instantiates a ThirdButton object 
		that contains the third button named "Change Frame Background" and the handling when the button is pressed*/
		
		thirdMenuOption.addButton();  //adds the button to the menu
		
		FourthButton fourthMenuOption = new FourthButton(mainMenu);  /*Instantiates a FourthButton object 
		that contains the fourth button named "Exit Application" and the handling when the button is pressed*/
		 
		fourthMenuOption.addButton();  //adds the button to the menu

		
		this.vbox = new VBox(menuBar);     //creates a layout named vbox that list items vertically, passing in the menuBar object
		
		gridPane.getChildren().add(vbox);
		
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		vbox.setPrefWidth(5);
		vbox.setMaxWidth(5);
		vbox.setMinWidth(5);
		
		
		applicationStage.setScene(mainScene);    // Set window's scene  
		applicationStage.setTitle("User Interface"); // Set window's title
		applicationStage.show();             // Display window
		
	}
	
	public static void main(String [] args) {
			launch(args);

	}

}



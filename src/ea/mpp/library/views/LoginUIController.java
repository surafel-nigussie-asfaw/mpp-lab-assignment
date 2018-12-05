package ea.mpp.library.views;

import javafx.event.ActionEvent;

import java.io.IOException;

import ea.mpp.library.controllers.*;
import ea.mpp.library.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginUIController {
	private Stage primaryStage;
	
	@FXML
	Button login;
	
	@FXML
	TextField username;
	
	@FXML
	TextField password;
	
	@FXML
	Label errorMessage;
	
	
	private UserController userController = UserController.getInstance();
	
	@FXML
	private void onLoginAction(ActionEvent event) {
		User user = userController.login(username.getText(), password.getText());
		if(user != null) {
			//route
			System.out.println("Success");
		}else {
			errorMessage.setText("Wrong Credentials");
		}
	}
	
	public void initSearchBook() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Search.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			//root.setCenter(ap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package ea.mpp.library.views;

import javafx.event.ActionEvent;
import ea.mpp.library.controllers.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginUIController {
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
		boolean loggedIn = userController.login(username.getText(), password.getText());
		if(loggedIn) {
			System.out.println("Success");
		}else {
			errorMessage.setText("Wrong Credentials");
		}
	}
}

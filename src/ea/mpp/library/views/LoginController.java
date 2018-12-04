package ea.mpp.library.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	Button login;
	
	@FXML
	TextField username;
	
	@FXML
	TextField password;
	
	@FXML
	private void onLoginAction(ActionEvent event) {
		System.out.print("login");
	}
}

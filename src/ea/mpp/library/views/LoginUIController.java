package ea.mpp.library.views;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;

import ea.mpp.library.controllers.*;
import ea.mpp.library.data.Constants;
import ea.mpp.library.entities.Role;
import ea.mpp.library.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginUIController {
		
	@FXML
	Button login;
	
	@FXML
	TextField username;
	
	@FXML
	PasswordField password;
	
	@FXML
	Label errorMessage;
	
	private UserController userController = UserController.getInstance();
	
	@FXML
	private void onLoginAction(ActionEvent event) {
		User user = userController.login(username.getText(), password.getText());
		if(user != null) {
			//route
			System.out.println("Success");
			if(checkRole(user.getRoles(), new Role(Constants.Roles.LIBRARIAN.name()))) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource("Librerian.fxml"));
					AnchorPane ap = (AnchorPane)loader.load();
					Scene scene = new Scene(ap);
					
					Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
					window.setScene(scene);
					
					
					LibrerianUIController lc = loader.<LibrerianUIController>getController();
					lc.setUserData(user);
					
					window.show();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(checkRole(user.getRoles(), new Role(Constants.Roles.ADMINSTRATOR.name()))) {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource("Admin.fxml"));
					AnchorPane ap = (AnchorPane)loader.load();
					Scene scene = new Scene(ap);
					
					Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
					window.setScene(scene);
					
					AdminUIController lc = loader.<AdminUIController>getController();
					lc.setUserData(user);
					
					window.show();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}else {
			errorMessage.setText("Wrong Credentials");
		}
	}
	
	public boolean checkRole(List<Role> roles, Role role) {
		for (Role _role : roles) {
			if(_role.getName().equals(role.getName())) {
				return true;
			}
		}
		return false;
	}
	
}

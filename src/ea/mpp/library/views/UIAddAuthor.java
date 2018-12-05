package ea.mpp.library.views;

import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ea.mpp.library.controllers.*;
import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;



public class UIAddAuthor extends Stage {

	@FXML
	ComboBox credentialsCombo;
	
	@FXML
	TextField firstNameField;
	
	@FXML
	TextField lastNameField;
	
	@FXML
	TextField phoneNumberField;
	
	@FXML
	TextField streetField;
	
	@FXML
	TextField stateField;
	
	@FXML
	TextField cityField;
	
	@FXML
	TextField zipCodeField;
	
	@FXML
	TextArea biographpyField;
	
	@FXML
	Button nextButton;
	
	@FXML
	Button addButton;
	
	@FXML
	ListView selectedAuthorsView;
	
	BookInfo bookInfo;
	
	Stage parentStage;
	
	
	AdminController adminController;
	
	
	public UIAddAuthor() {
		
	}
	
	public UIAddAuthor(Stage parentStage,BookInfo bookInfo) {
		
		this.parentStage=parentStage;
		this.bookInfo=bookInfo;
		
	}
	
	
	public void nextAction() {
		
		
		
	}
	
	
	public void addAction() {
		
		
		
	}
	
	private void addAuthor() {
		
		adminController=new AdminController();
		
		Address address=new Address(streetField.getText(), cityField.getText(), stateField.getText(), zipCodeField.getText());
		
		Person person =new Person(firstNameField.getText(),lastNameField.getText(),phoneNumberField.getText(),address);
		
		Author author=new Author(credentialsCombo.getValue().toString(),biographpyField.getText(),person);
		
		adminController.addAuthor(author);
		
		selectedAuthorsView.getItems().add(author.getPerson().getFirstName()+" "+author.getPerson().getLastName());
		
	}
}

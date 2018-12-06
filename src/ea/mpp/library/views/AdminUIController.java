package ea.mpp.library.views;

import java.awt.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ea.mpp.library.controllers.*;
import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminUIController {

	@FXML
	TextField titleField;
	
	@FXML
	TextField ISBNField;
	
	@FXML 
	TextField leasedaysField;
	
	@FXML
	TextField copiesField;
	
	@FXML 
	Button addButton;
	
	@FXML
	Button createButton;
	
	@FXML
	Button cancelButton;
	
	
	BookInfo bookInfo;
	
	
	
	public void addAuthorClick() {
		
		
		bookInfo=new BookInfo(Integer.parseInt(leasedaysField.getText()),titleField.getText(),ISBNField.getText(),null,generateBookNumbers(Integer.parseInt(copiesField.getText())));
		
//		UIAddAuthor addAuthor=new UIAddAuthor(this, bookInfo);
		
		//addAuthor.show();
		
		//this.hide();
	}
	
	public void createButtonClick() {
		
		
	}
	
	private List<BookCopy> generateBookNumbers(int copies) {
		
		Random random=new Random();
		BookCopy copy;
		List<BookCopy> bookCopies=new ArrayList<>();
		
		int count=0;
		
		while(count<copies) {
			
			copy=new BookCopy(random.nextInt(1000),bookInfo);
			
			bookCopies.add(copy);
			
			count++;
			
		}
		
		return bookCopies;
	}
	
	@FXML
	private void Logout(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Login.fxml"));
			
			AnchorPane ap = (AnchorPane)loader.load();
			Scene scene = new Scene(ap);
			
			Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

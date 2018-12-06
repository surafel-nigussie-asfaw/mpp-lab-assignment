package ea.mpp.library.views;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ea.mpp.library.controllers.*;
import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.Person;


public class BookUIController {

	
	AdminController admin;
	
	@FXML
	TextField titleField;
	
	@FXML
	TextField ISBNField;
	
	@FXML 
	ComboBox leasedaysCombo;
	
	@FXML
	TextField copiesField;
	
	@FXML 
	Button addButton;
	
	@FXML
	Button createButton;
	
	@FXML
	Button cancelButton;
	
	@FXML
	ComboBox authorCombo;
	
	BookInfo bookInfo;
	

	
	public BookUIController() {
		
		
		
	}
	
	
	@FXML
	public void createButtonClick() {
		

		Author author = (Author)authorCombo.getValue();
	
		List <Author> authors=new ArrayList<Author>();
		
		authors.add(author);	
		

		try
		{
		
		boolean result=admin.addBook(titleField.getText(),ISBNField.getText(),Integer.parseInt(leasedaysCombo.getValue().toString()),authors,generateBookNumbers(Integer.parseInt(copiesField.getText())));
	
		
		System.out.println(result);
		System.out.println(admin.getBook(titleField.getText()).getTitle() + admin.getBooksCount());
		
		}
		catch(Exception ex) {
			
			System.out.println("Please fill in the information in the fields.");
		}
	}
	
	@FXML
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

	public void onAuthorSelect() {
		
		
		Author author = (Author)authorCombo.getValue();
	
		List <Author> authors=new ArrayList<Author>();
		
		authors.add(author);	
		
		
		
	}
	
	@FXML
	private void initialize() {
		
	
		admin=new AdminController();
		
		for(Author author: admin.getAuthors()) {
			
			authorCombo.getItems().add(author);
			
		}
		
		leasedaysCombo.getItems().add(7);
		leasedaysCombo.getItems().add(21);
		
	}
	
}

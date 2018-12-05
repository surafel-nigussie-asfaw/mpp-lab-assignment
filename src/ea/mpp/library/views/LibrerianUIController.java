package ea.mpp.library.views;

import java.net.URL;
import java.util.ResourceBundle;

import ea.mpp.library.controllers.LibrarianController;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.CheckOutRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LibrerianUIController implements Initializable  {

	
	@FXML
	TextField memberID;
	
	@FXML
	TextField ISBN;
	
	@FXML
	AnchorPane bookInfoAnchorPane;
	
	@FXML
	Label bookInfo;
	
	@FXML
	Button checkout;
	
	@FXML
	Label errorMessage;
	
	@FXML
	Label success;
	
	
	private LibrarianController lc = LibrarianController.getInstance();
			
	@FXML
	public void getBookInfo(ActionEvent event) {
		success.setText("");
		bookInfo.setText("");
		BookInfo bookInfoObj = lc.getBookInfo(Integer.valueOf(memberID.getText()), ISBN.getText());
		
		if(bookInfoObj.getErrorMessage() != null) {
			bookInfo.setVisible(false);
			checkout.setVisible(false);
			errorMessage.setText(bookInfoObj.getErrorMessage());
		}else {
			bookInfo.setVisible(true);
			checkout.setVisible(true);
			errorMessage.setText("");
			bookInfo.setText("Title: " + bookInfoObj.getTitle() + 
					"\n" + "ISBN: " + bookInfoObj.getISBN()+
					"\n" + "Max Lease Days: "+ bookInfoObj.getMaxLeaseDays() +
					"\n" + "# Copies Available: "+ bookInfoObj.getNumberOfBooksAvailable());
		}
		
	}
	
	@FXML
	public void checkOutClicked(ActionEvent event) {
		CheckOutRecord record = lc.checkOut(Integer.valueOf(memberID.getText()), ISBN.getText());
		bookInfo.setVisible(false);
		checkout.setVisible(false);
		success.setText(record.getErrorMessage());
	}
	
	public LibrerianUIController(){
		
	}
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
	}
}

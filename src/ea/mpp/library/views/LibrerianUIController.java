package ea.mpp.library.views;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import ea.mpp.library.controllers.LibrarianController;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.CheckOutEntry;
import ea.mpp.library.entities.CheckOutRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class LibrerianUIController implements Initializable  {

	
	@FXML
	TextField memberID;
	
	@FXML
	TextField ISBN;
	
	
	
	@FXML
	TextField memberID2, ISBN2, copyID2;
	
	@FXML
	AnchorPane bookInfoAnchorPane;
	
	@FXML
	Label bookInfo;

	
	@FXML
	Button checkout;
	
	@FXML
	Label errorMessage, errorMessage2;
	
	@FXML
	Label success, success2;
	
	@FXML
	TableView<CheckOutEntry> table;
	
	@FXML 
	TableColumn<CheckOutEntry, Date> dateOfCheckOut;
	 	
	@FXML 
	TableColumn<CheckOutEntry, Integer> bookCopy;
	
	@FXML 
	TableColumn<CheckOutEntry, Date> dueDate;
	
	@FXML
	TableView<CheckOutEntry> table2;
	
	@FXML 
	TableColumn<CheckOutEntry, Date> dateOfCheckOut2;
	 	
	@FXML 
	TableColumn<CheckOutEntry, Integer> bookCopy2;
	
	@FXML 
	TableColumn<CheckOutEntry, Date> dueDate2;
	
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
		
		
		ObservableList<CheckOutEntry> data =  FXCollections.observableArrayList (record.getCheckOutEntries());
		table.setItems(data);
		dueDate.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Date>("dueDate")
				);
		dateOfCheckOut.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Date>("dateOfCheckOut")
				);
		bookCopy.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Integer>("copyId")
				);
		
	}
	
	@FXML
	public void checkinClicked(ActionEvent event) {
		CheckOutRecord record = lc.checkOut(Integer.valueOf(memberID.getText()), ISBN.getText());
		
		success.setText(record.getErrorMessage());
		

		ObservableList<CheckOutEntry> data =  FXCollections.observableArrayList (record.getCheckOutEntries());
		table2.setItems(data);
		dueDate2.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Date>("dueDate")
				);
		dateOfCheckOut2.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Date>("dateOfCheckOut")
				);
		bookCopy2.setCellValueFactory(
			    new PropertyValueFactory<CheckOutEntry, Integer>("copyId")
				);
		
	}
	
	public LibrerianUIController(){
		
	}
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
	}
}

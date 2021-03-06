package ea.mpp.library.views;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import ea.mpp.library.controllers.LibrarianController;
import ea.mpp.library.controllers.UserController;
import ea.mpp.library.data.Constants;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookDisplay;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.CheckOutEntry;
import ea.mpp.library.entities.CheckOutRecord;
import ea.mpp.library.entities.Role;
import ea.mpp.library.entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LibrerianUIController implements Initializable  {


	@FXML
	User userData;
	
	public User getUserData() {
		return userData;
	}

	public void setUserData(User userData) {
		this.userData = userData;
		welcome.setText("Welcome " + userData.getPerson().getFirstName() + "!");
		if(checkOtherRole()) {
			goToAdmin.setVisible(true);
		}
		
	}
	
	@FXML
	private ListView<BookDisplay> bookListView;
	
	@FXML
	TextField memberID, ISBN;
	
	@FXML
	TextField memberID2, ISBN2, copyID2, searchTextField;
	
	@FXML
	AnchorPane bookInfoAnchorPane;
	
	@FXML
	Label bookInfo, user, success, success2, errorMessage, errorMessage2, welcome, infoLabel;

	
	@FXML
	Button checkout, goToAdmin, searchButton;
	

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
	private UserController uc = UserController.getInstance();
	
	private ObservableList<BookDisplay> observable = FXCollections.observableArrayList();
			
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
		CheckOutRecord record = lc.checkIn(Integer.valueOf(memberID.getText()), ISBN.getText(), Integer.valueOf(copyID2.getText()));
		if(!record.isHasError()) {
			errorMessage2.setText("");
			success2.setText(record.getErrorMessage());
			

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
			
		}else {
			success2.setText("");
			table2.setItems(null);
			errorMessage2.setText(record.getErrorMessage());
		}
		
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
	
	@FXML
	public void goToAdmin(ActionEvent event){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Admin.fxml"));
			
			AnchorPane ap = (AnchorPane)loader.load();
			Scene scene = new Scene(ap);
			
			Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			
			AdminUIController lc = loader.<AdminUIController>getController();
			lc.setUserData(this.userData);
			window.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public boolean checkOtherRole() {
		for (Role _role : this.userData.getRoles()) {
			if(_role.getName().equals("ADMINSTRATOR")) {
				return true;
			}
		}
		return false;
	}
	

	@FXML
    private void onSearchAction(ActionEvent event) {
        String searchText = searchTextField.getText();

        if (searchText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter title to search");
            alert.showAndWait();
        }
        else {
            searchBookByTitle(searchText);
        }
    }

    @FXML
    private void onCheckoutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EA Library System");
        alert.setContentText("On we go to checkout book");
        alert.showAndWait();
    }

    /**
     * Search for book(s) matching the given title
     * 
     * @param titleText Title text to search
     */
    private void searchBookByTitle(String titleText) {
        List<BookDisplay> books = LibrarianController.getInstance()
                .searchBookByTitle(titleText);

        displaySearchResults(books);
    }

    /**
     * Display book search results
     * 
     * @param results A {@linkplain List} of {@link BookDisplay}
     */
    private void displaySearchResults(List<BookDisplay> results) {
        observable.clear();
        
        if (results.isEmpty()) {
            infoLabel.setText("No matches found!");
        }
        else {
            infoLabel.setText("");
            observable.addAll(results);
        }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bookListView.setItems(observable);
        bookListView.getSelectionModel()
        .selectedItemProperty()
        .addListener((__, ___, item) -> {
            infoLabel.setText(item.getDisplayText());
        });

        searchTextField.textProperty()
        .addListener((__, ___, title) -> {
            searchBookByTitle(title); 
        });
		
	}
	
}

package ea.mpp.library.views;

import ea.mpp.library.entities.BookInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchUIController {

	@FXML
	Button searchButton;
	
	@FXML
	Button closeButton;
	
	@FXML
	Button checkOutButton;
	
	@FXML
	TextField searchTextField;
	
	@FXML
	ListView<BookInfo> bookListView;
	
	@FXML
	private void onSearchAction(ActionEvent event) {
		System.out.print("Searching for a book :D");
	}
	
	@FXML
	private void onCloseAction(ActionEvent event) {
		System.out.print("Closing screen");
	}
	
	@FXML
	private void onCheckoutAction(ActionEvent event) {
		System.out.print("Checkout the selected book");
	}
	
}

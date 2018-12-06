package ea.mpp.library.views;

import java.util.List;

import ea.mpp.library.controllers.LibrarianController;
import ea.mpp.library.entities.BookDisplay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchUIController {

	@FXML
	private Button searchButton;

	@FXML
	private Button checkOutButton;

	@FXML
	private TextField searchTextField;

	@FXML
	private Label infoLabel;

	@FXML
	private ListView<BookDisplay> bookListView;

	private ObservableList<BookDisplay> observable = FXCollections.observableArrayList();

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
		System.out.println("Checkout the selected book");
	}

	@FXML
	private void initialize() {
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
			observable.addAll(results);
		}
	}

}

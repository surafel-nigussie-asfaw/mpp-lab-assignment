package ea.mpp.library.views;

import java.util.List;
import java.util.stream.Collectors;

import ea.mpp.library.controllers.LibrarianController;
import ea.mpp.library.entities.BookInfo;
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
		searchForBooks();
	}

	@FXML
	private void onCheckoutAction(ActionEvent event) {
		System.out.println("Checkout the selected book");
	}

	@FXML
	private void initialize() {
		bookListView.setItems(observable);
		bookListView.getSelectionModel().selectedItemProperty().addListener((a, b, item) -> {
			infoLabel.setText(item.getDisplayText());
		});
		searchTextField.textProperty().addListener((a, b, text) -> {
			searchForBooks();
		});
	}

	private void searchForBooks() {
		String searchText = searchTextField.getText();

		if (searchText.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Enter a valid search text");
			alert.showAndWait();
		} else {
			LibrarianController controller = LibrarianController.getInstance();
			List<BookDisplay> books = controller.searchBookByTitle(searchText)
					.stream()
					.map(info -> { 
						return new BookDisplay(info);
					}).collect(Collectors.toList());

			observable.clear();
			observable.addAll(books);
		}
	}

	private class BookDisplay {

		private BookInfo bookInfo;

		BookDisplay(BookInfo bookInfo) {
			this.bookInfo = bookInfo;
		}

		public String getDisplayText() {
			return bookInfo.toString();
		}

		@Override
		public String toString() {
			return bookInfo.getTitle();
		}
	}

}

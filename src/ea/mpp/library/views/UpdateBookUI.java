package ea.mpp.library.views;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import ea.mpp.library.controllers.AdminController;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class UpdateBookUI {

	AdminController admin = new AdminController();
	BookInfo bookInfo;

	@FXML
	TextField titleField2;

	@FXML
	TextField ISBNField2;

	@FXML
	ComboBox leasedaysCombo2;

	@FXML
	TextField copiesField2;

	
	@FXML
	Button updateButton;


	@FXML
	ComboBox authorCombo2;

	@FXML
	TableView booksView;

	@FXML
	TableColumn dataTitleColumn2;

	@FXML
	public void initialize() {

		populateListView();

		booksView.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onBookSelected();
			}
		});

	}

	public void onBookSelected() {

		if (booksView.getSelectionModel().getSelectedItem() != null) {

			BookInfo bookInfo = (BookInfo) booksView.getSelectionModel().getSelectedItem();

			titleField2.setText(bookInfo.getTitle());
			ISBNField2.setText(bookInfo.getISBN());
			ISBNField2.setEditable(false);

			leasedaysCombo2.getItems().clear();
			authorCombo2.getItems().clear();

			leasedaysCombo2.getItems().add(7);
			leasedaysCombo2.getItems().add(21);

			leasedaysCombo2.setValue(bookInfo.getMaxLeaseDays());

			for (Author author : admin.getAuthors()) {

				authorCombo2.getItems().add(author);
			}

			if (bookInfo.getAuthors().size() > 0) {
				authorCombo2.setValue(bookInfo.getAuthors().get(0));

			}

			copiesField2.setText(String.valueOf(bookInfo.getCopies()));

		}

	}

	/**
	 * Produce a list of Books and their attributes
	 * 
	 */
	private void populateListView() {

		booksView.getItems().clear();

		ObservableList<BookInfo> bookList = FXCollections.observableArrayList();

		for (BookInfo bookInfo : admin.getBooks()) {

			bookList.add(bookInfo);

		}

		((TableColumn) booksView.getColumns().get(0)).setCellValueFactory(new Callback<CellDataFeatures<BookInfo, String>,ObservableValue<String>>() {
			  @Override public ObservableValue<String> call(CellDataFeatures<BookInfo, String> p) {
				    return new ReadOnlyObjectWrapper(booksView.getItems().indexOf(p.getValue()) + 1);
				  }
				});   
		
		((TableColumn) booksView.getColumns().get(1))
				.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("title"));
		((TableColumn) booksView.getColumns().get(2))
				.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("ISBN"));
		((TableColumn) booksView.getColumns().get(3))
		.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("copies"));
		
		booksView.setItems(bookList);
		
		

	}

	@FXML
	public void onAuthorSelect() {

	}

	/**
	 * 
	 * update information within a single book
	 */

	@FXML
	public void updateBook() {

		Author author = (Author) authorCombo2.getValue();

		List<Author> authors = new ArrayList<Author>();

		authors.add(author);

		try {

			boolean result = admin.editBook(titleField2.getText(), ISBNField2.getText(),
					Integer.parseInt(leasedaysCombo2.getValue().toString()), authors,
					generateBookNumbers(Integer.parseInt(copiesField2.getText())));

			if (result) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("EA Library System");
				alert.setContentText("Success");
				alert.showAndWait();
			}

			populateListView();

		} catch (Exception ex) {

			System.out.println(ex.getMessage());
		}
	}

	/**
	 * generate a set of unique numbers to be used by the Book Copies
	 */
	@FXML
	private List<BookCopy> generateBookNumbers(int copies) {

		Random random = new Random();
		BookCopy copy;
		List<BookCopy> bookCopies = new ArrayList<>();

		int count = 0;

		while (count < copies) {

			copy = new BookCopy(random.nextInt(1000), bookInfo);

			bookCopies.add(copy);

			count++;

		}

		return bookCopies;
	}
}

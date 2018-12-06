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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UpdateBookUI {

	AdminController admin= new AdminController();
	BookInfo bookInfo;

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
	Button updateButton;

	@FXML
	Button cancelButton;

	@FXML
	ComboBox authorCombo;

	@FXML
	TableView booksView;

	@FXML
	TableColumn dataTitleColumn;

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

			titleField.setText(bookInfo.getTitle());
			ISBNField.setText(bookInfo.getISBN());
			ISBNField.setEditable(false);

			leasedaysCombo.getItems().clear();
			authorCombo.getItems().clear();

			leasedaysCombo.getItems().add(7);
			leasedaysCombo.getItems().add(21);

			leasedaysCombo.setValue(bookInfo.getMaxLeaseDays());

			for (Author author : admin.getAuthors()) {

				authorCombo.getItems().add(author);
			}

			if (bookInfo.getAuthors().size() > 0) {
				authorCombo.setValue(bookInfo.getAuthors().get(0));

			}

			copiesField.setText(String.valueOf(bookInfo.getCopies()));

		}

	}

	private void populateListView() {

		booksView.getItems().clear();

		ObservableList<BookInfo> bookList = FXCollections.observableArrayList();

		for (BookInfo bookInfo : admin.getBooks()) {

			bookList.add(bookInfo);
		}

		((TableColumn) booksView.getColumns().get(1))
				.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("title"));
		((TableColumn) booksView.getColumns().get(2))
				.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("ISBN"));

		booksView.setItems(bookList);
		
	}

	@FXML
	public void onAuthorSelect() {

	}

	@FXML
	public void updateBook() {

		Author author = (Author) authorCombo.getValue();

		List<Author> authors = new ArrayList<Author>();

		authors.add(author);

		try {

			boolean result = admin.editBook(titleField.getText(), ISBNField.getText(),
					Integer.parseInt(leasedaysCombo.getValue().toString()), authors,
					generateBookNumbers(Integer.parseInt(copiesField.getText())));

			
			populateListView();
			
			System.out.println(result);


		} catch (Exception ex) {

			System.out.println(ex.getMessage());
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
}

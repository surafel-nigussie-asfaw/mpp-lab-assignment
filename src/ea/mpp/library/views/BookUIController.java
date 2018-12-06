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

	/***
	 * Event for Creating a new book
	 */
	@FXML
	public void createButtonClick() {

		Author author = (Author) authorCombo.getValue();

		List<Author> authors = new ArrayList<Author>();

		authors.add(author);

		try {

			if (titleField.getText().isEmpty() || ISBNField.getText().isEmpty() || leasedaysCombo.getValue() == null
					|| copiesField.getText().isEmpty()) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("EA Library System");
				alert.setContentText("You may be missing some information");
				alert.showAndWait();
			}

			else {

				boolean result = admin.addBook(titleField.getText(), ISBNField.getText(),
						Integer.parseInt(leasedaysCombo.getValue().toString()), authors,
						generateBookNumbers(Integer.parseInt(copiesField.getText())));

				if (result) {
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("EA Library System");
					alert.setContentText("Success");
					alert.showAndWait();
				}

			}
		} catch (Exception ex) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("EA Library System");
			alert.setContentText("Error: " + "Must have atleast one book copy.");
			alert.showAndWait();
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

	public void onAuthorSelect() {

		Author author = (Author) authorCombo.getValue();

		List<Author> authors = new ArrayList<Author>();

		authors.add(author);

	}

	@FXML
	private void initialize() {

		admin = new AdminController();

		for (Author author : admin.getAuthors()) {

			authorCombo.getItems().add(author);

		}

		leasedaysCombo.getItems().add(7);
		leasedaysCombo.getItems().add(21);

	}

}

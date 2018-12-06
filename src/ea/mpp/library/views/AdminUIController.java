package ea.mpp.library.views;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import ea.mpp.library.controllers.*;
import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.BookCopy;
import ea.mpp.library.entities.BookInfo;
import ea.mpp.library.entities.LibraryMember;
import ea.mpp.library.entities.Person;
import ea.mpp.library.entities.Role;
import ea.mpp.library.entities.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminUIController implements Initializable {

	@FXML
	User userData;

	public User getUserData() {
		return userData;
	}

	public void setUserData(User userData) {
		this.userData = userData;
		welcome.setText("Welcome " + userData.getPerson().getFirstName() + "!");
		if (checkOtherRole()) {
			goToLibButon.setVisible(true);
		}

	}

	@FXML
	Label welcome;

	@FXML
	TextField titleField;

	@FXML
	TextField ISBNField;

	@FXML
	TextField leasedaysField;

	@FXML
	TextField copiesField;

	@FXML
	Button addButton, goToLibButon;

	@FXML
	Button createButton;

	@FXML
	Button cancelButton;

	BookInfo bookInfo;

	public void addAuthorClick() {

		bookInfo = new BookInfo(Integer.parseInt(leasedaysField.getText()), titleField.getText(), ISBNField.getText(),
				null, generateBookNumbers(Integer.parseInt(copiesField.getText())));

//		UIAddAuthor addAuthor=new UIAddAuthor(this, bookInfo);

		// addAuthor.show();

		// this.hide();
	}

	public void createButtonClick() {

	}

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

	@FXML
	private TextField lastName;

	@FXML
	private TextField zipCode;

	@FXML
	private TableColumn<LibraryMember, String> colLastName;

	@FXML
	private TextField city;

	@FXML
	private TableColumn<LibraryMember, String> colState;

	@FXML
	private TableColumn<LibraryMember, String> colFirstName;

	@FXML
	private TableColumn<LibraryMember, String> colCity;

	@FXML
	private Button btnPrimary;

	@FXML
	private TextField firstName;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField street;

	@FXML
	private TableColumn<LibraryMember, String> colStreet;

	@FXML
	private TableColumn<LibraryMember, String> colMemberId;

	@FXML
	private TextField state;

	@FXML
	private TableColumn<LibraryMember, String> colZip;

	@FXML
	private TableView<LibraryMember> tblLibraryMembers;

	@FXML
	private Button btnCreateMember;

	private ObservableList<LibraryMember> observable = FXCollections.observableArrayList();

	private LibraryMember currentMember;

	private static AdminController gateway = new AdminController();

	@FXML
	private void Logout(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Login.fxml"));

			AnchorPane ap = (AnchorPane) loader.load();
			Scene scene = new Scene(ap);

			Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void goToLib(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Librerian.fxml"));

			AnchorPane ap = (AnchorPane) loader.load();
			Scene scene = new Scene(ap);

			Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);

			LibrerianUIController lc = loader.<LibrerianUIController>getController();
			lc.setUserData(this.userData);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		intializeTable();
	}

	public boolean checkOtherRole() {
		for (Role _role : this.userData.getRoles()) {
			if (_role.getName().equals("LIBRARIAN")) {
				return true;
			}
		}
		return false;
	}

	private void intializeTable() {
		tblLibraryMembers.setItems(observable);

		colMemberId
				.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
						String memberId = Integer.toString(member.getValue().getLibraryMemberId());

						return (new SimpleStringProperty(memberId));

					}
				});

		colFirstName
				.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
						return member.getValue().getPerson().firstNameProperty();

					}
				});

		colLastName
				.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
						return member.getValue().getPerson().lastNameProperty();
					}
				});

//			colPhoneNumber.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
//			      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
//			    	  return member.getValue().getPerson().phoneNumberProperty();
//			      }
//			   });

		colStreet.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
				return member.getValue().getPerson().getAddress().streetProperty();
			}
		});

		colCity.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
				return member.getValue().getPerson().getAddress().cityProperty();
			}
		});

		colState.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
				return member.getValue().getPerson().getAddress().stateProperty();
			}
		});

		colZip.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
				return member.getValue().getPerson().getAddress().zipCodeProperty();
			}
		});

		Map<Integer, LibraryMember> hMembers = gateway.getLibraryMembers();

		if (hMembers != null) {
			List<LibraryMember> members = new ArrayList<LibraryMember>(hMembers.values());
			observable.addAll(members);
		}
	}

	@FXML
	private void onCreateMemberAction(ActionEvent event) {
		btnPrimary.setText("Save");

		resetLibraryMemberForm();
		firstName.requestFocus();

		currentMember = null;
	}

	@FXML
	private void onSaveMemberAction(ActionEvent event) {
		if (currentMember == null) {
			createLibraryMember();
			resetLibraryMemberForm();
		} else
			updateLibraryMember(currentMember);

	}

	@FXML
	private void onMemberDetailsChangedAction(KeyEvent event) {
		if (btnPrimary.isDisabled()) {
			if (isFormValid())
				togglePrimaryButton();
		}
	}

	private void togglePrimaryButton() {
		btnPrimary.setDisable(!btnPrimary.isDisabled());
	}

	private void resetLibraryMemberForm() {
		firstName.setText("");
		lastName.setText("");
		phoneNumber.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zipCode.setText("");

		firstName.requestFocus();
		btnPrimary.setDisable(true);
	}

	private boolean isFormValid() {
		String emptyString = "";

		if (firstName.getText().equals(emptyString))
			return false;
		if (lastName.getText().equals(emptyString))
			return false;
		if (phoneNumber.getText().equals(emptyString))
			return false;
		if (street.getText().equals(emptyString))
			return false;
		if (city.getText().equals(emptyString))
			return false;
		if (state.getText().equals(emptyString))
			return false;
		if (zipCode.getText().equals(emptyString))
			return false;
		if (currentMember != null && currentMember.getLibraryMemberId() == 0)
			return false;

		return true;
	}

	private void createLibraryMember() {
		Address address = new Address(street.getText(), city.getText(), state.getText(), zipCode.getText());
		Person person = new Person(firstName.getText(), lastName.getText(), phoneNumber.getText());

		person.setAddress(address);

		LibraryMember member = gateway.addLibraryMember(person);

		observable.add(member);
	}

	private void updateLibraryMember(LibraryMember member) {
		Person person = member.getPerson();
		Address address = person.getAddress();

		person.setFirstName(firstName.getText());
		person.setLastName(lastName.getText());
		person.setPhoneNumber(phoneNumber.getText());
		address.setStreet(street.getText());
		address.setCity(city.getText());
		address.setState(state.getText());
		address.setZipCode(zipCode.getText());

		gateway.editLibraryMember(member);

//			observable.remove(0);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			observable.add(0, member);
		btnPrimary.setDisable(true);
	}

	private void setCurrentMember(LibraryMember member) {
		Person person = member.getPerson();
		Address address = person.getAddress();

		firstName.setText(person.getFirstName());
		lastName.setText(person.getLastName());
		phoneNumber.setText(person.getPhoneNumber());
		street.setText(address.getStreet());
		city.setText(address.getCity());
		state.setText(address.getState());
		zipCode.setText(address.getZipCode());

		btnPrimary.setText("Update");
		btnPrimary.setDisable(true);

		currentMember = member;
	}

	@FXML
	private void onLibraryMemberSelected(InputEvent event) {
		LibraryMember member = tblLibraryMembers.getSelectionModel().getSelectedItem();

		setCurrentMember(member);
	}
}

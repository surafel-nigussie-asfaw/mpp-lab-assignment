package ea.mpp.library.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ea.mpp.library.controllers.AdminController;
import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.LibraryMember;
import ea.mpp.library.entities.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class LibraryMemberController {

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
	private void initialize() {
		intializeTable();
	}
	
	private void intializeTable() {
		tblLibraryMembers.setItems(observable);
		
		colMemberId.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  String memberId = Integer.toString(member.getValue().getLibraryMemberId());
		    	  
		          return (new SimpleStringProperty(memberId));
		    	  
		      }
		   });
		
		colFirstName.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  return member.getValue().getPerson().firstNameProperty();
		    	  
		      }
		   });
		
		colLastName.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  return member.getValue().getPerson().lastNameProperty();
		      }
		   });
		
//		colPhoneNumber.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
//		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
//		    	  return member.getValue().getPerson().phoneNumberProperty();
//		      }
//		   });
		
		colStreet.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  String val = member.getValue().getPerson().getAddress().getStreet();
		    	  
		          return (new SimpleStringProperty(val));
		    	  
		      }
		   });
		
		colCity.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  String val = member.getValue().getPerson().getAddress().getCity();
		    	  
		          return (new SimpleStringProperty(val));
		    	  
		      }
		   });
		
		colState.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  String val = member.getValue().getPerson().getAddress().getState();
		    	  
		          return (new SimpleStringProperty(val));
		    	  
		      }
		   });
		
		colZip.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		      public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> member) {
		    	  String val = member.getValue().getPerson().getAddress().getZipCode();
		    	  
		          return (new SimpleStringProperty(val));
		    	  
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
		}else
			updateLibraryMember(currentMember);
				
	}

	@FXML
	private void onMemberDetailsChangedAction(KeyEvent event) {
		if (btnPrimary.isDisabled()) {
			if(isFormValid())
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
		
//		observable.remove(0);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		observable.add(0, member);
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
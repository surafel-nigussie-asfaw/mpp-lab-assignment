package ea.mpp.library.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class LibraryMemberController {

    @FXML
    private TextField lastName;

    @FXML
    private TextField zipCode;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TextField city;

    @FXML
    private TableColumn<?, ?> colState;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private Button btnPrimary;

    @FXML
    private TextField firstName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField street;

    @FXML
    private TableColumn<?, ?> colStreet;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private TextField state;

    @FXML
    private TableColumn<?, ?> colZip;
    
    @FXML
    private TableView<?> tblLibraryMembers;
    
    @FXML
    private Button btnCreateMember;
    
	@FXML
	private void onCreateMemberAction(ActionEvent event) {
		System.out.print("creating new member");
	}
	
	@FXML
	private void onSaveMemberAction(ActionEvent event) {
		System.out.print("saving member details");
	}

	@FXML
	private void onMemberDetailsChangedAction(ActionEvent event) {
		System.out.print("saving member details");
	}
	
}
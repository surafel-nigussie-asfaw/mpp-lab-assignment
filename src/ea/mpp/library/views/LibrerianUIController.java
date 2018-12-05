package ea.mpp.library.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LibrerianController implements Initializable  {

	
	@FXML
	TextField memberID;
	
	@FXML
	TextField ISBN;
	
	@FXML
	AnchorPane bookInfoAnchorPane;
	
	@FXML
	Label bookInfo;
	
	@FXML
	Button checkout;
	
	@FXML
	public void getBookInfo(ActionEvent event) {
		System.out.print("ll");
		bookInfo.setVisible(true);
		checkout.setVisible(true);
	}
	
	public LibrerianController(){
		
	}
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
	}
}

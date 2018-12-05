package ea.mpp.library.views;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private BorderPane root;
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library System");
		initRootLayout();
//		initLogin();
		initLibraryMember();
	}

	public static void main(String[] args) {
		launch(args);

	}

	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/root.fxml"));
			root = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Login.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			root.setCenter(ap);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void initSearchBook() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Search.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			root.setCenter(ap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initLibraryMember() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("library-member.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			root.setCenter(ap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


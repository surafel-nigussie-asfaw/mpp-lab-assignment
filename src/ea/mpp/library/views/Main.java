package ea.mpp.library.views;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	private BorderPane root;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library System");
		initRootLayout();
		initLogin();

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
	
	public void initAddBook() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("book.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			root.setCenter(ap);	
			primaryStage.setResizable(false);
			primaryStage.setHeight(530);
			primaryStage.setWidth(607);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initUpdateBook() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("updateBook.fxml"));
			AnchorPane ap = (AnchorPane)loader.load();
			root.setCenter(ap);
			primaryStage.setResizable(false);
			primaryStage.setHeight(550);
			primaryStage.setWidth(900);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


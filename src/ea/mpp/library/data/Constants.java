package ea.mpp.library.data;

import javafx.stage.Stage;

public class Constants {
	private static Stage stage;
	
	public enum Roles {
		LIBRARIAN,
		ADMINSTRATOR
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}

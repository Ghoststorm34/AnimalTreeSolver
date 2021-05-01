package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main execution point for the system.
 * @author Alexander Ayers
 *
 */
public class Main extends Application {

	/**
	 * Executes the system.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args the required arguments
	 */
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/MainGUI.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Animal Guessing Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

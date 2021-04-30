package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.MainCodeBehind;


public class Main extends Application{

	
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setController(new MainCodeBehind());
//		loader.setLocation(getClass().getResource("/view/MainGUI.fxml"));
//		Pane pane = new Pane(loader.load());
		Parent pane = FXMLLoader.load(getClass().getResource("/view/MainGUI.fxml"));
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

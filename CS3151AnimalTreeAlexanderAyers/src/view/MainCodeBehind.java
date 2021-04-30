package view;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class MainCodeBehind {
  
	
	@FXML
    private MenuItem saveButton;

    @FXML
    private MenuItem loadButton;

    @FXML
    private Text responseValueText;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;
    
    @FXML
    private Button startButton;
    
    private MainController controller;
    
    public MainCodeBehind() {
    	this.controller = new MainController();
    }
    
    @FXML
    public void initalize() {
    }

    @FXML
    void handleNo(ActionEvent event) {

    }

    @FXML
    void handleYes(ActionEvent event) {

    }

    @FXML
    void loadFile(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {

    }
    

    @FXML
    void startGame(ActionEvent event) {
    	this.controller.startGame();
    	this.responseValueText.setText(this.controller.getTree().getCurrent().getValue().getValue());
    	this.yesButton.setVisible(true);
    	this.noButton.setVisible(true);
    	this.startButton.setVisible(false);
    }
}

package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MainCodeBehind {
   
	@FXML
    private GridPane newQuestionPane;

    @FXML
    private MenuItem saveButton3;

    @FXML
    private MenuItem loadButton3;

    @FXML
    private TextField animalNameTextField;

    @FXML
    private RadioButton yesRadioButton;

    @FXML
    private RadioButton noRadioButton;

    @FXML
    private Button submitButton1;

    @FXML
    private TextField questionTextBox;
    
    @FXML
    private GridPane responsePane;

    @FXML
    private MenuItem saveButton1;

    @FXML
    private MenuItem loadButton1;

    @FXML
    private Text responseValueText;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;
    
    @FXML
    private GridPane mainPane;

    @FXML
    private MenuItem saveButton2;

    @FXML
    private MenuItem loadButton2;

    @FXML
    private Button startButton;

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
    void handleSubmit(ActionEvent event) {

    }
    
    @FXML
    void startGame(ActionEvent event) {

    }
}

package view;

import java.util.Optional;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import model.NodeDirection;
import model.ResponseType;

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
		if (this.controller.getTree().getCurrent().getValue().getType().equals(ResponseType.ANSWER)) {
			this.createNewAnimal();
			this.controller.resetGame();
			this.showInfoDialog("Game has been reset", "Game has inputted your new question. Please play again.");
			this.responseValueText.setText(this.controller.getTextOfCurrent());
		} else {
			this.controller.traverseRight();
			this.responseValueText.setText(this.controller.getTextOfCurrent());
		}
	}

	private void createNewAnimal() {
		this.showInfoDialog("Answer Wrong", "Please enter in the following values for new animal.");
		String animal = this.showInputDialog("Input your Animal", "Name of your animal");
		String question = this.showInputDialog("Input a question",
				"Ensure this question differentiates itself from the guessed animal.");
		boolean yesOrNo = this.showYesNoDialog("Answer to your Question", "What is the answer to the previously question that you inputted");
		if(yesOrNo) {
			this.controller.addNewAnimal(animal, question, NodeDirection.YES);
		} else {
			this.controller.addNewAnimal(animal, question, NodeDirection.NO);
		}
	}

	@FXML
	void handleYes(ActionEvent event) {
		if (this.controller.getTree().getCurrent().getValue().getType().equals(ResponseType.ANSWER)) {
			this.showInfoDialog("Answer Correct", "Correct guess. Please hit the button to play again.");
			this.controller.resetGame();
			this.responseValueText.setText(this.controller.getTextOfCurrent());
		} else {
			this.controller.traverseLeft();
			this.responseValueText.setText(this.controller.getTextOfCurrent());
		}
	}

	private void showInfoDialog(String title, String content) {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle(title);
		info.setContentText(content);
		info.showAndWait();
	}

	private String showInputDialog(String title, String content) {
		TextInputDialog input = new TextInputDialog();
		input.setTitle(title);
		input.setContentText(content);
		input.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
		Optional<String> textFromInput = input.showAndWait();
		while(textFromInput.get().isBlank()) {
			textFromInput = input.showAndWait();
		}
		return textFromInput.get();
	}
	
	private boolean showYesNoDialog(String title, String content) {
		ButtonType yesType = new ButtonType("Yes", ButtonBar.ButtonData.YES);
		ButtonType noType = new ButtonType("No", ButtonBar.ButtonData.NO);
		Alert input = new Alert(AlertType.CONFIRMATION, content, yesType, noType);
		input.setTitle(title);
		Optional<ButtonType> result = input.showAndWait();
		
		if(result.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
			return true;
		} else {
			return false;
		}
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
		this.responseValueText.setText(this.controller.getTextOfCurrent());
		this.yesButton.setVisible(true);
		this.noButton.setVisible(true);
		this.startButton.setVisible(false);
	}
}

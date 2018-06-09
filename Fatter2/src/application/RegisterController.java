package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	
	RegisterModel registerModel = new RegisterModel();
	
	@FXML private TextField idTextField;
	@FXML private TextField firstPasswordField;
	@FXML private TextField secondPasswordField;
	@FXML private CheckBox maleCheckBox;
	@FXML private CheckBox femaleCheckBox;
	@FXML private TextField ageTextField;
	@FXML private TextField heightTextField;
	@FXML private TextField weightTextField;
	
	@FXML
	private void checkMale(ActionEvent event) {
		if(femaleCheckBox.isSelected()) {
			((CheckBox)event.getSource()).setSelected(false);
		}
	}
	
	@FXML
	private void checkFemale(ActionEvent event) {
		if(maleCheckBox.isSelected()) {
			((CheckBox)event.getSource()).setSelected(false);
		}
	}
	
	@FXML
	private void register(ActionEvent event) throws IOException {
		String strId = idTextField.getText();
		String firstPw = firstPasswordField.getText();
		String secondPw = secondPasswordField.getText();
		
		
		String sex = new String();
		
		if(maleCheckBox.isSelected() == true) {
			sex = "male";
		}
		else if(femaleCheckBox.isSelected() == true) {
			sex = "female";
		}
		
		String height = heightTextField.getText();
		String weight = weightTextField.getText();
		String age = ageTextField.getText();
		
		if(registerModel.registerUser(strId, firstPw, secondPw, sex, height, weight, age)) {
			Parent loader = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        Scene scene;
			scene = new Scene(loader);
			stage.setScene(scene);
			stage.setTitle("login");
			stage.show();
		}
	}
	
	@FXML
	private void cancel(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("login");
		stage.show();
	}
}

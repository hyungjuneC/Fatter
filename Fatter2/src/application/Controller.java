package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller  {
	RegisterModel registerModel = new RegisterModel();
	User user  = new User();
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
	private void returnAction(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void logout(ActionEvent event) throws IOException {	 
		Parent loader = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
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
		stage.show();
	}

	
	Alarm alarm = new Alarm();
	@FXML
	private void alarm(ActionEvent event){
		alarm.setAlarmTime();
	}
	
	@FXML
	private void addFood(ActionEvent event) throws IOException{
		Parent loader = FXMLLoader.load(getClass().getResource("addFoodUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML private Text IDuser2;
	
	@FXML
	private void setting(ActionEvent event) throws IOException {
		
		Parent loader = FXMLLoader.load(getClass().getResource("settingUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
		
		String a = IDuser2.getText();
		System.out.println(a);
        
        
	}
private LoginModel loginModel = new LoginModel();
	
	@FXML
	private TextField idText2Field;
	
	@FXML
	private PasswordField passwordField;
	
//	@FXML
//	private void login(ActionEvent event) throws IOException {
//		if(loginModel.compareIDPassword(idText2Field.getText(), passwordField.getText(),user)) {
//			Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
//			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	        Scene scene;
//			scene = new Scene(loader);
//			System.out.println(user.getId());
//			stage.setScene(scene);
//			stage.show();
//		}
//	}
	
	@FXML
	private void registerUI(ActionEvent event) throws IOException {
		 
		Parent loader = FXMLLoader.load(getClass().getResource("registerUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
        
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}

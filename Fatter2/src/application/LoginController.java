package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	

	private LoginModel loginModel = new LoginModel();
	
	@FXML
	private TextField idText2Field;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private void login(ActionEvent event) throws IOException {
		if(loginModel.compareIDPassword(idText2Field.getText(), passwordField.getText())) {
			Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        Scene scene;
			scene = new Scene(loader);
			stage.setScene(scene);
			stage.setTitle("main menu");
			stage.show();
		}
	}
	
	@FXML
	private void register(ActionEvent event) throws IOException {
		 
		Parent loader = FXMLLoader.load(getClass().getResource("registerUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("register menu");
		stage.show();
        
	}
	
}

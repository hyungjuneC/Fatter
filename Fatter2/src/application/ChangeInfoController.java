package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeInfoController {
	
	@FXML private TextField age;
	@FXML private TextField height;
	@FXML private TextField weight;

	@FXML
	private void changeInfo(ActionEvent event) throws IOException {
		
		DBModule db = new DBModule();
		
		db.changeUserDBInfo(age.getText(), height.getText() ,weight.getText());
		
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("main menu");
		stage.show();
	}
	
	@FXML
	private void cancel(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("main menu");
		stage.show();
	}
	
}

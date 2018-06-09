package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingController implements Initializable {
	
	@FXML Text userID;
	@FXML Text firstWeight;
	User recentuser = new User();
	DBModule db = new DBModule();

	
	@FXML
	private void returnAction(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("main menu");
		stage.show();
	}
	
	@FXML
	private void logout(ActionEvent event) throws IOException {	 
		Parent loader = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("login");
		stage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		db.getRecentUserDBInfo(recentuser);
		userID.setText(recentuser.getId());
		firstWeight.setText(String.valueOf(recentuser.getFirstWeight()));
		
	}
	
}

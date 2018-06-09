package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddFoodController {

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
	
	@FXML
	private void addFood(ActionEvent event) {
		
	}
	
}

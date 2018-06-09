package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginUI extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(root));
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

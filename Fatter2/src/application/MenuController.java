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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	
	Alarm alarm = new Alarm();
	@FXML
	private void alarm(ActionEvent event){
		alarm.getEatenTimeDB();
	}
	
	@FXML
	private void changeInfo(ActionEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("changeInfoUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("change user information");
		stage.show();
	}
	
	@FXML
	private void addFood(ActionEvent event) throws IOException{
		Parent loader = FXMLLoader.load(getClass().getResource("addFoodUI.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("add eaten food");
		stage.show();
	}
	
	@FXML
	private void setting(ActionEvent event) throws IOException {
		 
		Parent loader = FXMLLoader.load(getClass().getResource("settingUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("setting");
		stage.show();
        
	}
	
	@FXML CategoryAxis dailyX;
	@FXML NumberAxis dailyY;
	@FXML BarChart<Number,Number> daily;
	
	@FXML BarChart<Number,Number> weekly;
	@FXML CategoryAxis weeklyX;
	@FXML NumberAxis weeklyY;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
	}
}

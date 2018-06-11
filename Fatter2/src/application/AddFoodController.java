package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddFoodController implements Initializable{
	
	private ArrayList<FoodInfo> foodList ;

	private ObservableList<String> ListOfFoodName;
	private String userName;

	private DBModule myDBMoudle = new DBModule();

	private FoodInfo myFoodInfo = new FoodInfo();

	private Time time = new Time();
	@FXML private Label kcal;

    @FXML private Label protein;

    @FXML private Label fat;

    @FXML private Label carbo;
	
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
	private void addFood(ActionEvent event) throws IOException {
		userName= myDBMoudle.searchName();

		myDBMoudle.setEatenFoodByUser(userName,myFoodInfo);
		
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("main menu");
		stage.show();
	}

	
	@FXML

    private ComboBox<String> comboBox;
	
	
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		

				DBModule myDBModule = new DBModule();

				foodList = new ArrayList<FoodInfo>(myDBModule.getFoodDB());

				ListOfFoodName = FXCollections.observableArrayList();

		 

				for(int i = 0; i < foodList.size(); i++) {

					ListOfFoodName.add(foodList.get(i).getFoodName());

				}
	


				

				comboBox.setValue("Food list");

				comboBox.setItems(ListOfFoodName);

				

			}

			
		

			public void getFood(ActionEvent event) {
				Calendar cal = Calendar.getInstance();
				String date;
				date = ""+cal.get(Calendar.YEAR)+"/"+ cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DAY_OF_MONTH);
				
				for(int i =0;i<foodList.size(); i++) {

					if(foodList.get(i).getFoodName() == comboBox.getValue()) {

						kcal.setText(foodList.get(i).getKcal());

						protein.setText(foodList.get(i).getProtein());

						fat.setText(foodList.get(i).getFat());

						carbo.setText(foodList.get(i).getCatbo());
						

						myFoodInfo.setFoodName(foodList.get(i).getFoodName());
						
						myFoodInfo.setKcal(foodList.get(i).getKcal());

						myFoodInfo.setProtein(foodList.get(i).getProtein());

						myFoodInfo.setFat(foodList.get(i).getFat());

						myFoodInfo.setCatbo(foodList.get(i).getCatbo());
						
						myFoodInfo.setDate(date);

					}

				}
			}
	
}

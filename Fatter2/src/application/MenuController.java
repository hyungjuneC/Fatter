package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MenuController implements Initializable {
	private int deleteRow;
	DBModule db = new DBModule ();
	Alarm alarm = new Alarm();
	
	ArrayList<FoodInfo> userFood;
	@FXML
	private void alarm(ActionEvent event){
		alarm.setAlarmTime();
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
	private void deleteFood(ActionEvent event) throws IOException{
		
		ArrayList<FoodInfo> deleteFood= new ArrayList();
        deleteFood.addAll(userFood);
       		        		 		           
        deleteFood = db.deleteFoodDB(deleteRow);
        
        
			String userName = db.searchName();
		

			try {

	         File output = new File("UserFoodInfo_"+userName+".db");

	         FileWriter fw = new FileWriter(output);		   	      

	         fw.close();

			}catch(FileNotFoundException e) {

	         

			}catch(IOException e) {

				System.out.println(e);

			}
	

			for(int i =0;i<deleteFood.size(); i++) {
		      db.setEatenFoodByUser(userName,deleteFood.get(i));
			}
		
		Parent loader = FXMLLoader.load(getClass().getResource("menuUI3.fxml"));
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene;
		scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("main menu");
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
	private ObservableList<String> xInfo = FXCollections.observableArrayList();
	@FXML NumberAxis dailyY;
	@FXML BarChart<String, Float> daily;
	
	
	@FXML private TableView<TableRowDataModel> foodTableView;
	@FXML private TableColumn<TableRowDataModel, String> foodNameColumn;
	@FXML private TableColumn<TableRowDataModel, String> kcalColumn;
	@FXML private TableColumn<TableRowDataModel, String> proteinColumn;
	@FXML private TableColumn<TableRowDataModel, String> fatColumn;
	@FXML private TableColumn<TableRowDataModel, String> carboColumn;
	@FXML private TableColumn<TableRowDataModel, String> dateColumn;
	
	ObservableList<TableRowDataModel> foodList = FXCollections.observableArrayList();

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		xInfo.addAll("kcal", "carbo", "protein", "fat");
		dailyX.setCategories(xInfo);
		
		
		User user= new User();
		db.getUserDBInfo(db.searchName(),user);
	
		float[] nut = db.calculation(user);
		
		XYChart.Series<String, Float> series = new XYChart.Series<>();
		series.getData().add(new XYChart.Data<>("kcal", nut[0]));
		series.getData().add(new XYChart.Data<>("carbo", nut[1]));
		series.getData().add(new XYChart.Data<>("protein", nut[2]));
		series.getData().add(new XYChart.Data<>("fat", nut[3]));
		
		daily.getData().add(series);
		
		userFood = db.searchFoodByUser();
		//userFood.get(0).getFoodName();
		
		for(int i = 0; i < userFood.size(); i++) {
			//System.out.println(userFood.get(i).getFoodName());
			TableRowDataModel tmp = new TableRowDataModel(
					new SimpleStringProperty(userFood.get(i).getFoodName()), 
					new SimpleStringProperty (userFood.get(i).getKcal()), 
					new SimpleStringProperty(userFood.get(i).getProtein()), 
					new SimpleStringProperty(userFood.get(i).getFat()), 
					new SimpleStringProperty(userFood.get(i).getCatbo()),
					new SimpleStringProperty(userFood.get(i).getDate())
			);
			foodList.add(tmp);
		}

		foodNameColumn.setCellValueFactory(cellData -> cellData.getValue().foodNameProperty());
		kcalColumn.setCellValueFactory(cellData -> cellData.getValue().kcalProperty());
		proteinColumn.setCellValueFactory(cellData -> cellData.getValue().proteinProperty());
		fatColumn.setCellValueFactory(cellData -> cellData.getValue().fatProperty());
		carboColumn.setCellValueFactory(cellData -> cellData.getValue().carboProperty());
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		foodTableView.setItems(foodList);
		
		foodTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
		    
			
			
		@Override    
		public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
		        //Check whether item is selected and set value of selected item to Label
		        if(foodTableView.getSelectionModel().getSelectedItem() != null) 
		        {    
		           TableViewSelectionModel selectionModel = foodTableView.getSelectionModel();
		           ObservableList selectedCells = selectionModel.getSelectedCells();
		           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
		           deleteRow = tablePosition.getRow();
		           
		         }
		         }
		     });

	}
}

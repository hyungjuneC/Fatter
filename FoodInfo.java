
public class FoodInfo {

 private	String UserID;
	
 private	String data;
	
 private	int foodID;
	
 private	String foodName;
	
 private	double[] foodNutrient;
 
 FoodInfo(){
 }
//클래스의 정보를 저장하거나 값을 가져오기 위한 함수들
public int getFoodID() {
	return foodID;
}

public void setFoodID(int foodID) {
	this.foodID = foodID;
}

public String getFoodName() {
	return foodName;
}

public void setFoodName(String foodName) {
	this.foodName = foodName;
}

public double getFoodNutrient() {
	return foodNutrient;
}

public void setFoodNutrient(double foodNutrient) {
	this.foodNutrient = foodNutrient;
}
 

	 
 }
}

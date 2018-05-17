
public class FoodInfo {//음식의 정보를 저장하기 위한 클래스

 private	String UserID;
	
 private	String data;
	
 private	int foodID;
	
 private	String foodName;
	
 private	double[] foodNutrient; //배열의 형태로 각 index가 각 영양소를 나타냄
 
 FoodInfo(){//constructor
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

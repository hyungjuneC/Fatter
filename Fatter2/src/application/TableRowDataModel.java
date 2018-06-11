package application;

import javafx.beans.property.StringProperty;

public class TableRowDataModel {
    private StringProperty foodName;
    private StringProperty kcal;
    private StringProperty protein;
    private StringProperty fat;
    private StringProperty carbo;
    private StringProperty date;
 
    public TableRowDataModel(StringProperty foodName, StringProperty kcal, StringProperty protein, StringProperty fat, StringProperty carbo, StringProperty date) {
        this.foodName = foodName;
        this.kcal = kcal;
        this.protein = protein;
        this.carbo = carbo;
        this.fat = fat;
        this.date = date;
    }
 
    public StringProperty foodNameProperty() {
        return foodName;
    }
    public StringProperty kcalProperty() {
        return kcal;
    }
    public StringProperty proteinProperty() {
        return protein;
    }
    public StringProperty fatProperty() {
        return fat;
    }
    public StringProperty carboProperty() {
        return carbo;
    }
    public StringProperty dateProperty() {
    	return date;
    }
    
}

package org.team1;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

public class CalorieCalculatorModel{
    private SimpleDoubleProperty recentCaloriesBurnt;

    public String calculateCalories(String Activity, double time, double distance, double weight){
        Double calories  = (time * weight)/200;
        this.recentCaloriesBurnt.set(calories);
        return (Activity +" at a pace of" + (distance/time)+ " miles per hour will burn around" +calories + "calories.");

    }
}

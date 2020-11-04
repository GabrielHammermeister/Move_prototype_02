package com.example.move_prototype_02.Model;

import java.util.HashMap;

public class HabitModel {

    private String title;
    private int goal;
    private String unit;

    public HabitModel() {}

    public HabitModel(String title, int goal, String unit) {
        this.title = title;
        this.goal = goal;
        this.unit = unit;
    }

    public HabitModel(HashMap<String, Object> map){
        this.title = map.get("Title").toString();
        this.goal = Integer.parseInt(map.get("Goal").toString());
        this.unit = map.get("Unit").toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

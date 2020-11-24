package com.example.move_prototype_02.Model;


import java.util.ArrayList;

public class HabitModel {

    private String id;
    private String title;
    private int goal;
    private String unit;
    private String userID;
    private ArrayList<Boolean> frequency;
    private int points;

    public HabitModel() {
    }

    public HabitModel(String id, String title, int goal, String unit, String userID, ArrayList<Boolean> frequency, int points) {
        this.id = id;
        this.title = title;
        this.goal = goal;
        this.unit = unit;
        this.userID = userID;
        this.frequency = frequency;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArrayList<Boolean> getFrequency() {
        return frequency;
    }

    public void setFrequency(ArrayList<Boolean> frequency) {
        this.frequency = frequency;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

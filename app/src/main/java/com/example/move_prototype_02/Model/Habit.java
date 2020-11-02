package com.example.move_prototype_02.Model;

import java.util.Map;

public class Habit {

    private String userID;
    private String habitID;
    private String title;
    private int goal;
    private String unit;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setHabitID(String habitID) {
        this.habitID = habitID;
    }

    public String getUserID() {
        return userID;
    }

    public String getHabitID() {
        return habitID;
    }

    public Habit(Map<String, Object> mapa) {
        this.title = mapa.get("Title").toString();
        this.goal = Integer.parseInt(mapa.get("Goal").toString());
        this.unit = mapa.get("Unit").toString();
    }

    @Override
    public String toString() {
        return "Habit{" +
                "title='" + title + '\'' +
                ", goal=" + goal +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getGoal() {
        return goal;
    }

    public String getUnit() {
        return unit;
    }
}

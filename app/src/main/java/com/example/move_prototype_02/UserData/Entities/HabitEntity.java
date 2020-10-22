package com.example.move_prototype_02.UserData.Entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "habits")
public class HabitEntity {

    @PrimaryKey(autoGenerate = true)
    private int habitId;

    @ForeignKey(entity = UserEntity.class, parentColumns = {"userId"}, childColumns = {"userId"})
    private int userId;

//    @ForeignKey(entity = FreqEntity.class, parentColumns = {"freqId"}, childColumns = {"freqId"})
//    private int freqId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "unit")
    private String unit;

    @ColumnInfo(name = "goal")
    private int goal;
//
//    @ColumnInfo(name = "score")
//    private int score;

    public HabitEntity(int userId, String name, String unit, int goal) {
        this.userId = userId;
//        this.freqId = freqId;
        this.name = name;
        this.unit = unit;
        this.goal = goal;
//        this.score = score;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public int getHabitId() {
        return habitId;
    }

    public int getUserId() {
        return userId;
    }

//    public int getFreqId() {
//        return freqId;
//    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getGoal() {
        return goal;
    }

//    public int getScore() {
//        return score;
//    }
}

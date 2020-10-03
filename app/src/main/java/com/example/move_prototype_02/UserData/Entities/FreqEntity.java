package com.example.move_prototype_02.UserData.Entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "frequency")
public class FreqEntity {

    @PrimaryKey(autoGenerate = true)
    public int freqId;

    public Boolean dom;
    public Boolean seg;
    public Boolean ter;
    public Boolean qua;
    public Boolean qui;
    public Boolean sex;
    public Boolean sab;

}

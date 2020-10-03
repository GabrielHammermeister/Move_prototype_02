package com.example.move_prototype_02.UserData.Daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.move_prototype_02.UserData.Entities.HabitEntity;

import java.util.List;

@Dao
public interface HabitDao {

    @Insert
    void insert(HabitEntity habitEntity);

    @Delete
    void delete(HabitEntity habitEntity);

    @Update
    void update(HabitEntity habitEntity);

    // CHAMADO FORA DO REPOSITORIO
    @Query("SELECT * FROM habits WHERE userId=(:userId) AND freqId=(:freqId) ORDER BY habitId ASC")
    LiveData<List<HabitEntity>> getUserHabits(int userId, int freqId);



}

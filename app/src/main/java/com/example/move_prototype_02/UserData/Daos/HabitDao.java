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

    @Query("INSERT INTO habits(userId, name, unit, goal) VALUES(:userId, habitEntity)")
    void insert(HabitEntity habitEntity, int userId);

    @Delete
    void delete(HabitEntity habitEntity, int userId);

    @Update
    void update(HabitEntity habitEntity, int userId);

    // CHAMADO FORA DO REPOSITORIO
    @Query("SELECT * FROM habits WHERE userId=(:userId) ORDER BY habitId ASC")
    LiveData<List<HabitEntity>> getUserHabits(int userId);

    @Query("SELECT * FROM habits")
    LiveData<List<HabitEntity>> getAllHabits();



}

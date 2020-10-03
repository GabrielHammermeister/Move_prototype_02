package com.example.move_prototype_02.UserData.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.move_prototype_02.UserData.Entities.FreqEntity;

@Dao
public interface FreqDao {

    @Insert
    void insert(FreqEntity freqEntity);


    // CHAMADO FORA DO REPOSITORIO
    @Query("SELECT * FROM frequency WHERE freqId=(:freqId) ORDER BY freqId ASC")
    LiveData<FreqEntity> getHabitFreq(int freqId);

}

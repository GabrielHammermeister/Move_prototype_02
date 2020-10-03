package com.example.move_prototype_02.UserData;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.move_prototype_02.UserData.Daos.FreqDao;
import com.example.move_prototype_02.UserData.Daos.HabitDao;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.FreqEntity;
import com.example.move_prototype_02.UserData.Entities.HabitEntity;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

@Database(entities = {UserEntity.class, HabitEntity.class, FreqEntity.class}, version = 1)
public abstract class MoveDatabase extends RoomDatabase {

    private static MoveDatabase instance;

    public abstract UserDao userDao();
    public abstract HabitDao habitDao();
    public abstract FreqDao freqDao();

    public static synchronized MoveDatabase getUserDatabase(Context context){

        if(instance == null)
        {
            instance = Room.databaseBuilder(context, MoveDatabase.class, "MoveDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

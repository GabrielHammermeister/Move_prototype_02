package com.example.move_prototype_02.UserData.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.move_prototype_02.UserData.Entities.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    // CHAMADO FORA DO REPOSITORIO
    @Query("SELECT * FROM users WHERE username LIKE :username AND password LIKE :password")
    LiveData<UserEntity> loginLiveData(String username, String password);


    @Query("SELECT * FROM users WHERE username LIKE :username AND password LIKE :password")
    UserEntity login(String username, String password);
}

package com.example.move_prototype_02.UserData.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.move_prototype_02.UserData.MoveDatabase;
import com.example.move_prototype_02.UserData.Respositories.UserRepository;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

public class UserViewModel extends AndroidViewModel {

    MoveDatabase moveDatabase = MoveDatabase.getUserDatabase(getApplication());
    UserDao userDao = moveDatabase.userDao();
    UserRepository userRepository;
    LiveData<UserEntity> userEntityLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

}

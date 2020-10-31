package com.example.move_prototype_02.UserData.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.move_prototype_02.UserData.Respositories.UserRepository;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

public class UserViewModel extends AndroidViewModel {

    UserRepository userRepository;
    UserEntity userEntity;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);

    }

    public void register(UserEntity userEntity){
        userRepository.registerUser(userEntity);
    }

    public UserEntity login(String usuario, String senha){
        userEntity = userRepository.getUserLogin(usuario, senha);
        return userEntity;
    }

}

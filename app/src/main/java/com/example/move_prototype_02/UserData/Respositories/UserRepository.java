package com.example.move_prototype_02.UserData.Respositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.move_prototype_02.UserData.MoveDatabase;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

public class UserRepository {

    private UserDao userDao;
    private LiveData<UserEntity> userEntityLiveData;

    // Constructor
    public UserRepository(Application application)
    {
        MoveDatabase moveDatabase = MoveDatabase.getUserDatabase(application);
        userDao = moveDatabase.userDao();
    }

    // Metodo publico para registro
//    public void register(final UserEntity userEntity){
//        new registerUserAsyncTask(userDao).execute(userEntity);
//    }
//
//
//    private static class registerUserAsyncTask extends AsyncTask<UserEntity, Void, Void>{
//
//        UserDao userDao;
//
//        private registerUserAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(UserEntity... userEntities) {
//            userDao.registerUser(userEntities[0]);
//            return null;
//        }
//    }

}

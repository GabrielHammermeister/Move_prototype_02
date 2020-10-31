package com.example.move_prototype_02.UserData.Respositories;

import android.app.Application;

import com.example.move_prototype_02.UserData.MoveDatabase;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.UserEntity;

import java.util.concurrent.Executor;

public class UserRepository {

    private UserDao userDao;
    private UserEntity userEntity;

    // Constructor
    public UserRepository(Application application)
    {
        MoveDatabase moveDatabase = MoveDatabase.getUserDatabase(application);
        userDao = moveDatabase.userDao();
    }

    public UserEntity getUserLogin(final String usuario, final String senha){

        new Thread(new Runnable() {
            @Override
            public void run() {
                userEntity = userDao.login(usuario, senha);
            }
        }).start();
        return userEntity;
    }

    public void registerUser(UserEntity userEntity){
        new DirectExecutor().execute(new InsertRunnable(userEntity));
    }

// Implementando o Executor e o Runnables
    class DirectExecutor implements Executor {

        public void execute(Runnable r) {
            r.run();
        }
    }

    private class InsertRunnable implements Runnable{

        UserEntity userEntity;

        public InsertRunnable(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        @Override
        public void run() {
            userDao.registerUser(userEntity);
        }
    }



}

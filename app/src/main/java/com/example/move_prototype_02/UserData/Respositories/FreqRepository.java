package com.example.move_prototype_02.UserData.Respositories;

import android.app.Application;

import com.example.move_prototype_02.UserData.Daos.FreqDao;
import com.example.move_prototype_02.UserData.Entities.FreqEntity;
import com.example.move_prototype_02.UserData.MoveDatabase;

import java.util.concurrent.Executor;

public class FreqRepository {

    MoveDatabase moveDatabase;
    FreqDao freqDao;

    // Constructor
    public FreqRepository(Application application){

        moveDatabase = MoveDatabase.getUserDatabase(application);
        freqDao = moveDatabase.freqDao();
    }


    // Implementando metodos publicos
    public void insert(FreqEntity freqEntity){
        new DirectExecutor().execute(new InsertRunnable(freqEntity));
    }


    // Implementando Executor e Runnables
    class DirectExecutor implements Executor {

        public void execute(Runnable r) {
            r.run();
        }
    }

    private class InsertRunnable implements Runnable{

        FreqEntity freqEntity;

        public InsertRunnable(FreqEntity freqEntity) {
            this.freqEntity = freqEntity;
        }

        @Override
        public void run() {
            freqDao.insert(freqEntity);
        }
    }
}

package com.example.move_prototype_02.UserData.Respositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.move_prototype_02.UserData.Daos.HabitDao;
import com.example.move_prototype_02.UserData.Entities.HabitEntity;
import com.example.move_prototype_02.UserData.MoveDatabase;

import java.util.List;
import java.util.concurrent.Executor;

public class HabitRepository {

    MoveDatabase moveDatabase;
    HabitDao habitDao;
    LiveData<List<HabitEntity>> allHabits;

    // Constructor
    public HabitRepository(Application application) {

        moveDatabase = MoveDatabase.getUserDatabase(application);
        this.habitDao = moveDatabase.habitDao();
        allHabits = habitDao.getAllHabits();
    }


    // Metodos publicos de DML
    public void insert(HabitEntity habitEntity){
        new DirectExecutor().execute(new InsertRunnable(habitEntity));
    }

    public void delete(HabitEntity habitEntity){
        new DirectExecutor().execute(new DeleteRunnable(habitEntity));
    }

    public void update(HabitEntity habitEntity){
        new DirectExecutor().execute(new UpdateRunnable(habitEntity));
    }

    public LiveData<List<HabitEntity>> getAllHabits(int userId){
        List<HabitEntity> lista;
        LiveData<List<HabitEntity>> newAllHabits;
        lista = allHabits.getValue();

        for(HabitEntity habit: lista){
            if(habit.getUserId() == userId){
                newAllHabits
            }
        }
    }


    // Implementando o Executor e o Runnables
    class DirectExecutor implements Executor {

        public void execute(Runnable r) {
            r.run();
        }
    }

    private class InsertRunnable implements Runnable{

        HabitEntity habitEntity;

        public InsertRunnable(HabitEntity habitEntity) {
            this.habitEntity = habitEntity;
        }

        @Override
        public void run() {
            habitDao.insert(habitEntity);
        }
    }
    private class DeleteRunnable implements Runnable{

        HabitEntity habitEntity;

        public DeleteRunnable(HabitEntity habitEntity) {
            this.habitEntity = habitEntity;
        }

        @Override
        public void run() {
            habitDao.delete(habitEntity);
        }
    }
    private class UpdateRunnable implements Runnable{

        HabitEntity habitEntity;

        public UpdateRunnable(HabitEntity habitEntity) {
            this.habitEntity = habitEntity;
        }

        @Override
        public void run() {
            habitDao.update(habitEntity);
        }
    }

}

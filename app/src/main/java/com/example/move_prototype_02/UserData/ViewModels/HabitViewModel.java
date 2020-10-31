package com.example.move_prototype_02.UserData.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.move_prototype_02.UserData.Entities.HabitEntity;
import com.example.move_prototype_02.UserData.Respositories.HabitRepository;

import java.util.List;

public class HabitViewModel extends AndroidViewModel {
    private HabitRepository repository;
    private LiveData<List<HabitEntity>> allHabits;


    public HabitViewModel(@NonNull Application application) {
        super(application);
        repository = new HabitRepository(application);
    }

    public void insert(HabitEntity habitEntity){
        repository.insert(habitEntity);
    }

    public void delete(HabitEntity habitEntity){
        repository.delete(habitEntity);
    }

    public void update(HabitEntity habitEntity){
        repository.update(habitEntity);
    }

    public LiveData<List<HabitEntity>> getAllUserHabits(int userId){
        return repository.getAllUserHabits(userId);
    }


}

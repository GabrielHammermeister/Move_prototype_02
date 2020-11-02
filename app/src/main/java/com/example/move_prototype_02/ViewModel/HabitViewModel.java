package com.example.move_prototype_02.ViewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.move_prototype_02.Model.Habit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HabitViewModel extends ViewModel {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Habitos");
    private MutableLiveData<List<Habit>> allHabits = new MutableLiveData<>();
    private List<Habit> allTempHabits = new ArrayList<Habit>();
    private static String TAG = "HabitViewModel";
    private Map<String, Object> habit;


    public MutableLiveData<List<Habit>> getAllHabits(){

        collectionReference
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        allTempHabits.clear();
                        for(QueryDocumentSnapshot document: value){

                            habit = document.getData();
                            Habit aux = new Habit(habit);
                            aux.setUserID(document.getId());
                            allTempHabits.add(aux);
                        }
                    }
                });

        allHabits.setValue(allTempHabits);
        return allHabits;
    }



}

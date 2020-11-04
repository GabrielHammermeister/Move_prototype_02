package com.example.move_prototype_02.ViewModel;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.move_prototype_02.Model.HabitModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HabitViewModel extends ViewModel {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Habitos");
    private MutableLiveData<List<HabitModel>> allHabits = new MutableLiveData<>();
    private List<HabitModel> allTempHabitModels = new ArrayList<HabitModel>();
    private static String TAG = "HabitViewModel";
    private Map<String, Object> habit;


    public MutableLiveData<List<HabitModel>> getAllHabits(){

        collectionReference
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            Log.w(TAG, "listen failed: ", error);
                        }
                        if(value != null){
                            //we have a populated collection
                            allTempHabitModels.clear();
                            for(QueryDocumentSnapshot documentSnapshot: value){

//                                habit = documentSnapshot.getData();
//                                HabitModel newHabitModel = new HabitModel(habit);
//                                allTempHabitModels.add(newHabitModel);
                            }
                        }
                    }
                });
        allHabits.setValue(allTempHabitModels);
        return allHabits;
    }

    public HabitModel getUserHabit(String userID){

        final HabitModel[] aux = new HabitModel[1];
        collectionReference.document(userID).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                habit = value.getData();
//                aux[0] = new HabitModel(habit);

            }
        });

        return aux[0];
    }

}

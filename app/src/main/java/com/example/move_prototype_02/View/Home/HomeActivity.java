package com.example.move_prototype_02.View.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity{


    private ArrayList<HabitModel> allHabits = new ArrayList<HabitModel>();
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private static String TAG = "HomeActivity";
    private static String KEY_USERID = "userID";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        //Fragment container view requires access from supportfragmentmanager
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        //Getting navcontroller from the host fragment
        NavController navController = navHostFragment.getNavController();

        //Setting the navcontroller into bottonNavView, merging the container with the bottonNavView
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


        // USAR ON EVENT LISTENER
        Query query = firebaseFirestore.collection("Habitos").whereEqualTo(KEY_USERID, firebaseUser.getUid());
        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                List<DocumentSnapshot> allDocs = value.getDocuments();
                allHabits.clear();
                for (DocumentSnapshot doc: allDocs){

                    HabitModel habit = doc.toObject(HabitModel.class);
                    habit.setId(doc.getId());
                    allHabits.add(habit);

                }
            }
        });
    }

    public ArrayList<Fragment> getAllFragHabits(){

        ArrayList<Fragment> habitList = new ArrayList<Fragment>();

        for (HabitModel habit: allHabits){

            Habit_fragment habit_fragment = new Habit_fragment();
            habit_fragment.setCurrentHabit(habit);

            habitList.add(habit_fragment);
        }
        return habitList;
    }

    public ArrayList<HabitModel> getAllHabits(){
        return this.allHabits;
    }

}
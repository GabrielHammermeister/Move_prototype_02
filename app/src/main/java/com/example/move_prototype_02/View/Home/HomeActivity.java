package com.example.move_prototype_02.View.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    private HabitModel currentHabit;

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
    }


    public void setCurrentHabit(HabitModel currentHabitModel){
        this.currentHabit = currentHabitModel;
    }

    public HabitModel getCurrentHabit(){
        return this.currentHabit;
    }

}
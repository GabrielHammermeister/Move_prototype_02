package com.example.move_prototype_02.View.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.move_prototype_02.R;
import com.example.move_prototype_02.ViewModel.HabitViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    HabitViewModel habitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        habitViewModel = new ViewModelProvider(this).get(HabitViewModel.class);
        habitViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(HabitViewModel.class);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view); // represents the bottom nav view
        NavController navController = Navigation.findNavController(this,  R.id.fragment); // represents the home fragment
        NavigationUI.setupWithNavController(bottomNavigationView, navController);  // merge the nav bar with the fragment

    }

}
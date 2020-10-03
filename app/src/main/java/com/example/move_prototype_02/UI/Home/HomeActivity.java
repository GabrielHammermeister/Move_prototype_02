package com.example.move_prototype_02.UI.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.move_prototype_02.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view); // represents the bottom nav view
        NavController navController = Navigation.findNavController(this,  R.id.fragment); // represents the home fragment
        NavigationUI.setupWithNavController(bottomNavigationView, navController);  // merge the nav bar with the fragment

    }

}
package com.example.move_prototype_02.UI.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.move_prototype_02.HabitAdapter;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.UI.Auth.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    int currentUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        currentUserId = intent.getIntExtra("userId", 0);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        HabitAdapter adapter = new HabitAdapter();
        recyclerView.setAdapter(adapter);

        // VIEW MODEL GOES HERE

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view); // represents the bottom nav view
        NavController navController = Navigation.findNavController(this,  R.id.fragment); // represents the home fragment
        NavigationUI.setupWithNavController(bottomNavigationView, navController);  // merge the nav bar with the fragment

    }

}
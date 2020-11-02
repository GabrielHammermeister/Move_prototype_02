package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.move_prototype_02.R;


public class DisplayHabit_fragment extends Fragment {

    public DisplayHabit_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_display_habit_fragment, container, false);



        return view;
    }
}
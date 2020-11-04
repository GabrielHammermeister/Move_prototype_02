package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;

public class Habit_fragment extends Fragment {

    private TextView txtTitle, txtGoal, txtUnit;
    private ImageView imgIcon;


    public Habit_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habit, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String goal, title, unit;

        HomeActivity homeActivity = (HomeActivity) getActivity();
        HabitModel selectedHabitModel = homeActivity.getCurrentHabit();

        txtTitle = view.findViewById(R.id.text_nome_habito);
        txtGoal = view.findViewById(R.id.text_meta);
        txtUnit = view.findViewById(R.id.text_unidade);
        imgIcon = view.findViewById(R.id.imageView);

        goal = Integer.toString(selectedHabitModel.getGoal());
        title = selectedHabitModel.getTitle();
        unit = selectedHabitModel.getUnit();

        imgIcon.setImageResource(R.drawable.ic_baseline_palette_24);

        txtTitle.setText(title);
        txtGoal.setText(goal);
        txtUnit.setText(unit);

    }
}
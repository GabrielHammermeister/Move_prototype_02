package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.move_prototype_02.Adapter.HabitAdapter;
import com.example.move_prototype_02.Model.Habit;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.ViewModel.HabitViewModel;

import java.util.List;

public class Home_fragment extends Fragment{
    private HabitViewModel habitViewModel;

    public Home_fragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // 2. set layoutManger
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 3. create an adapter
        final HabitAdapter habitAdapter = new HabitAdapter();

        // 4. set adapter
        recyclerView.setAdapter(habitAdapter);

        // 5. ViewModel
        habitViewModel = new ViewModelProvider(requireActivity()).get(HabitViewModel.class);
        habitViewModel.getAllHabits().observe(getViewLifecycleOwner(), new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                habitAdapter.setHabits(habits);
            }
        });
    }
}
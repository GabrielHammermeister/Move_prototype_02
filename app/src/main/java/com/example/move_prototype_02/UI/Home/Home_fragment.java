package com.example.move_prototype_02.UI.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.move_prototype_02.HabitAdapter;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.UserData.Entities.HabitEntity;
import com.example.move_prototype_02.UserData.ViewModels.HabitViewModel;

import java.util.List;

public class Home_fragment extends Fragment{


    private HabitViewModel habitViewModel;

    public Home_fragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HomeActivity homeActivity = (HomeActivity) getActivity();

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        // 3. create an adapter
        final HabitAdapter habitAdapter = new HabitAdapter();

        // 4. set adapter
        recyclerView.setAdapter(habitAdapter);


        // 5. ViewModel

        HabitViewModel model = new ViewModelProvider(this).get(HabitViewModel.class);
        model.getAllUserHabits(homeActivity.getCurrentUserId()).observe(getViewLifecycleOwner(), new Observer<List<HabitEntity>>() {
            @Override
            public void onChanged(List<HabitEntity> habitEntities) {
                habitAdapter.setHabits(habitEntities);
            }
        });

        return view;

    }

}
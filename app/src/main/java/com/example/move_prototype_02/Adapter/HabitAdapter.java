package com.example.move_prototype_02.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.move_prototype_02.Model.Habit;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.View.Home.HomeActivity;
import com.example.move_prototype_02.ViewModel.HabitViewModel;

import java.util.ArrayList;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitHolder> {

    private List<Habit> habits = new ArrayList<>();



    @NonNull
    @Override
    public HabitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_button, parent, false);

        return new HabitHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitHolder holder, int position) {
        Habit currentHabit = habits.get(position);

        holder.button.setText(currentHabit.getTitle());
        holder.button.setTag(currentHabit.getUserID());
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return habits.size();
    }

    public static class HabitHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Button button;

        public HabitHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.habit_button);
        }

        @Override
        public void onClick(View view){

            HomeActivity homeActivity = (HomeActivity) view.getParent();
            HabitViewModel habitViewModel = new ViewModelProvider(homeActivity).get(HabitViewModel.class);

        }
    }
}

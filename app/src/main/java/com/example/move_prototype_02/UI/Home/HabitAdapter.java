package com.example.move_prototype_02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.move_prototype_02.UserData.Entities.HabitEntity;

import java.util.ArrayList;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitHolder> {

    private List<HabitEntity> habits = new ArrayList<>();

    @NonNull
    @Override
    public HabitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_button, parent, false);

        return new HabitHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitHolder holder, int position) {
        HabitEntity currentHabit = habits.get(position);

        holder.button.setText(currentHabit.getName());
    }

    public void setHabits(List<HabitEntity> habits) {
        this.habits = habits;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return habits.size();
    }

    class HabitHolder extends RecyclerView.ViewHolder {

        private Button button;

        public HabitHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.habit_button);
        }
    }
}

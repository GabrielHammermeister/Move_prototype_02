package com.example.move_prototype_02.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.View.Home.Habit_fragment;
import com.example.move_prototype_02.View.Home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitHolder> {

    private List<HabitModel> habitModels = new ArrayList<>();
    private Context context;

    public void addContext(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public HabitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_button, parent, false);

        return new HabitHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HabitHolder holder, int position) {
        final HabitModel currentHabitModel = habitModels.get(position);

//        holder.button.setText(currentHabitModel.getTitle());
//        holder.button.setTag(currentHabitModel.getUserID());
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                HomeActivity homeActivity = (HomeActivity) context;
//                homeActivity.setSelectedHabitModel(currentHabitModel);
//
//                FragmentManager fragmentManager = homeActivity.getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.home_fragment, new Habit_fragment());
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });
    }

    public void setHabitModels(List<HabitModel> habitModels) {
        this.habitModels = habitModels;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return habitModels.size();
    }

    public static class HabitHolder extends RecyclerView.ViewHolder{

        private Button button;

        public HabitHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.habit_button);
        }
    }
}

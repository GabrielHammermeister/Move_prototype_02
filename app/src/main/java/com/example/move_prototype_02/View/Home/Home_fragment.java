package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.ObservableSnapshotArray;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Home_fragment extends Fragment{

    private RecyclerView recyclerView;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private FirestoreRecyclerAdapter adapter;

    private static final String KEY_TITLE = "title";
    private static final String TAG = "Home_fragment";
    private static final String KEY_GOAL = "goal";
    private static final String KEY_UNIT = "unit";
    private static final String KEY_USERID = "userID";

    public Home_fragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        // HABITS RECYCLER VIEW
        recyclerView = view.findViewById(R.id.recyclerView);
        displayHabits(recyclerView);


        return view;

    }

    private class HabitViewHolder extends RecyclerView.ViewHolder {
        private Button button;

        public HabitViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.habit_button);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void displayHabits(RecyclerView recyclerView){

        // Query
        Query query = firebaseFirestore.collection("Habitos").whereEqualTo(KEY_USERID, firebaseUser.getUid());

        //RecyclerOptions
        FirestoreRecyclerOptions<HabitModel> options = new FirestoreRecyclerOptions.Builder<HabitModel>()
                .setQuery(query, HabitModel.class)
                .build();

        //RecyclerAdapter
        adapter = new FirestoreRecyclerAdapter<HabitModel, HabitViewHolder>(options) {
            @NonNull
            @Override
            public ObservableSnapshotArray<HabitModel> getSnapshots() {
                return super.getSnapshots();
            }

            @NonNull
            @Override
            public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_button, parent, false);
                return new HabitViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final HabitViewHolder holder, int position, @NonNull final HabitModel model) {

                holder.button.setText(model.getTitle());
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        HomeActivity homeActivity = (HomeActivity) getActivity();
                        ArrayList<HabitModel> allHabits = homeActivity.getAllHabits();

                        Bundle bundle = new Bundle();

                        int cont = 0, index = 0;
                        for(HabitModel habit: allHabits) {

                            if(habit.getId().equals(model.getId())){
                                index = cont;

                            }
                            cont++;
                        }
                        bundle.putInt("index", index);
                        Navigation.findNavController(view).navigate(R.id.viewPager2, bundle);
                    }
                });
            }
        };

        // 2. set layoutManger
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 4. set adapter
        recyclerView.setAdapter(adapter);
    }

}
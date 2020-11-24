package com.example.move_prototype_02.View.Home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.move_prototype_02.Model.HabitModel;
import com.example.move_prototype_02.R;
import com.example.move_prototype_02.Repository.FirestoreRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Habit_fragment extends Fragment {

    private TextView txtTitle, txtGoal, txtUnit, txtPoints, txtCheck;
    private ImageView imgIcon;
    private Button buttonCheck;
    private HabitModel currentHabit;

    private static final String KEY_ID = "id";
    private static final String TAG = "Habit_fragment";


    public Habit_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habit, container, false);

        setView(view);
        checkHabit();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageRef = firebaseStorage.getReference();
        String goal, title, unit, points, path = "images/triste-cachorro.jpg";

        goal = Integer.toString(currentHabit.getGoal());
        title = currentHabit.getTitle();
        unit = currentHabit.getUnit();
        points = Integer.toString(currentHabit.getPoints());

        // buscando imagem de acordo com o path
        storageRef
                .child(path)
                .getBytes(1024*1024)
                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        imgIcon.setImageBitmap(bitmap);
                    }
                });


        txtTitle.setText(title);
        txtGoal.setText(goal);
        txtUnit.setText(unit);
        txtPoints.setText(points);

    }

    public void setCurrentHabit(HabitModel habit){
        this.currentHabit = habit;
    }

    public void setView(View view){

        txtTitle = view.findViewById(R.id.text_nome_habito);
        txtGoal = view.findViewById(R.id.text_meta);
        txtUnit = view.findViewById(R.id.text_unidade);
        txtCheck = view.findViewById(R.id.textView_check);
        imgIcon = view.findViewById(R.id.imageView_icon);
        buttonCheck = view.findViewById(R.id.button_check);
        txtPoints = view.findViewById(R.id.textView_points);
    }

    public void checkHabit(){
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentHabit.setPoints(currentHabit.getPoints() + 1);
                updateHabit(currentHabit);
                txtPoints.setText(Integer.toString(currentHabit.getPoints()));
                txtCheck.setText("COMPLETO!");
            }
        });
    }

    public void updateHabit(HabitModel habitModel){
        FirestoreRepository repository = new FirestoreRepository();
        repository
                .getCollectionHabitos()
                .document(habitModel.getId())
                .update("points", habitModel.getPoints());
    }
}
package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.move_prototype_02.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class NewHabit_fragment extends Fragment {

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private static final String TAG = "NewHabit_fragment";
    private static final String KEY_TITLE = "title";
    private static final String KEY_GOAL = "goal";
    private static final String KEY_UNIT = "unit";
    private static final String KEY_USERID = "userID";

    private EditText editTextGoal, editTextTitle, editTextUnit;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button buttonGo;

    public NewHabit_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_new_habit, container, false);

        buttonGo = view.findViewById(R.id.b_go);
        editTextGoal = view.findViewById(R.id.text_meta);
        editTextTitle = view.findViewById(R.id.text_habito);
        editTextUnit = view.findViewById(R.id.text_unidade);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = editTextTitle.getText().toString();
                int goal = parseInt(editTextGoal.getText().toString());
                String unit = editTextUnit.getText().toString();

                // Criando um novo objeto Habito
                final Map<String, Object> habito = new HashMap<>();
                habito.put(KEY_TITLE, title);
                habito.put(KEY_GOAL, goal);
                habito.put(KEY_UNIT, unit);
                habito.put(KEY_USERID, firebaseUser.getUid());

                // Add a new document with a generated ID
                db.collection("Habitos").add(habito);
                Toast.makeText(getContext(), "Habito adicionado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.move_prototype_02.View.Home;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.move_prototype_02.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class NewHabit_fragment extends Fragment {

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private static final String TAG = "NewHabit_fragment";
    private static final String KEY_TITLE = "title";
    private static final String KEY_GOAL = "goal";
    private static final String KEY_UNIT = "unit";
    private static final String KEY_USERID = "userID";
    private static final String KEY_POINTS = "points";
    private static final String KEY_FREQ = "frequency";

    private static String uid = null;

    private EditText editTextGoal, editTextTitle, editTextUnit;
    private ToggleButton dom, seg, ter, qua, qui, sex, sab;
    private ArrayList<ToggleButton> toggleButtonArrayList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button buttonGo;

    public NewHabit_fragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_new_habit, container, false);

        setView(view);
        newHabit();

        return view;
    }



    public Map<String, Object> extractData() {

        String title = editTextTitle.getText().toString();
        int goal = parseInt(editTextGoal.getText().toString());
        String unit = editTextUnit.getText().toString();
        ArrayList<Boolean> freq = new ArrayList<>();

        for(ToggleButton toggleButton: toggleButtonArrayList){
            if(toggleButton.isChecked()){
                freq.add(true);
            } else {
                freq.add(false);
            }
        }

        // Criando um novo objeto Habito
        final Map<String, Object> habito = new HashMap<>();
        habito.put(KEY_TITLE, title);
        habito.put(KEY_GOAL, goal);
        habito.put(KEY_UNIT, unit);
        habito.put(KEY_FREQ, freq);
        habito.put(KEY_POINTS, 0);
        habito.put(KEY_USERID, firebaseUser.getUid());

        return habito;
    }

    public void newHabit(){
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Map<String, Object> habito = extractData();

                // Add a new document with a generated ID
                db.collection("Habitos").add(habito).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        uid = documentReference.getId();
                        db.collection("Habitos")
                                .document(uid)
                                .update("id", uid)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(getContext(), "Habito adicionado com sucesso", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setView(View view){
        buttonGo = view.findViewById(R.id.b_go);
        editTextGoal = view.findViewById(R.id.text_meta);
        editTextTitle = view.findViewById(R.id.text_habito);
        editTextUnit = view.findViewById(R.id.text_unidade);

        seg = view.findViewById(R.id.segunda);
        ter = view.findViewById(R.id.terca);
        qua = view.findViewById(R.id.quarta);
        qui = view.findViewById(R.id.quinta);
        sex = view.findViewById(R.id.sexta);
        sab = view.findViewById(R.id.sabado);
        dom = view.findViewById(R.id.domingo);

        toggleButtonArrayList = new ArrayList<>(List.of(dom, seg, ter, qua, qui, sex, sab));
        for(ToggleButton toggleButton: toggleButtonArrayList){
            setCheckListener(toggleButton);
        }
    }

    public void setCheckListener(ToggleButton toggleButton){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.checked));
                } else{
                    buttonView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.unchecked));
                }
            }
        });
    }
}

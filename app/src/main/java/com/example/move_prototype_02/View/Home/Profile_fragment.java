package com.example.move_prototype_02.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.move_prototype_02.Model.ProfileModel;
import com.example.move_prototype_02.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Profile_fragment extends Fragment {

    private FirebaseUser firebaseUser;
    private CollectionReference collectionReference;

    private TextView textViewName, textViewEmail, textViewAge, textViewSex;
    private ImageView imageViewProfile;

    private String name, sex, age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        firebaseUser = FirebaseAuth
                .getInstance()
                .getCurrentUser();

        collectionReference = FirebaseFirestore
                .getInstance()
                .collection("Profiles");

        textViewAge = view.findViewById(R.id.textViewAge);
        textViewName = view.findViewById(R.id.textViewName);
        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewSex = view.findViewById(R.id.textViewSex);
        imageViewProfile = view.findViewById(R.id.imageViewProfile);

        collectionReference
                .document(firebaseUser.getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        ProfileModel profileModel = documentSnapshot.toObject(ProfileModel.class);
                        name = profileModel.getName();
                        Boolean aux = profileModel.getSex();
                        age = Integer.toString(profileModel.getAge());

                        if(aux){
                            sex = "Male";
                        } else {
                            sex = "Female";
                        }

                        textViewAge.setText(age);
                        textViewName.setText(name);
                        textViewSex.setText(sex);
                        textViewEmail.setText(firebaseUser.getEmail());
                    }
                });

        return view;
    }
}
package com.example.move_prototype_02.View.Home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.move_prototype_02.Repository.FirestoreRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import io.grpc.Context;


public class Profile_fragment extends Fragment {

    private TextView textViewName, textViewEmail, textViewAge, textViewSex;
    private ImageView imageViewProfile;
    private FirestoreRepository repository;

    private String name;
    private String sex;
    private String age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        setView(view);
        displayData();

        return view;
    }

    public void displayData(){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        CollectionReference collectionReference = FirebaseFirestore.getInstance().collection("Profiles");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageRef = firebaseStorage.getReference();
        String path = "images/jacquin.png";

        collectionReference
                .document(firebaseUser.getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        ProfileModel profileModel = documentSnapshot.toObject(ProfileModel.class);
                        name = profileModel.getName();
                        Boolean aux = profileModel.getSex();
                        String aux2 = profileModel.getIdade();
                        age = profileModel.getIdade();

                        if(aux){
                            sex = "Male";
                        } else {
                            sex = "Female";
                        }

                        textViewAge.setText(age);
                        textViewName.setText(name);
                        textViewSex.setText(sex);
                        textViewEmail.setText(firebaseUser.getEmail());

                        storageRef
                                .child(path)
                                .getBytes(1024*1024)
                                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                    @Override
                                    public void onSuccess(byte[] bytes) {
                                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                        imageViewProfile.setImageBitmap(bitmap);
                                    }
                                });
                    }
                });


    }

    public void setView(View view){
        textViewAge = view.findViewById(R.id.textViewAge);
        textViewName = view.findViewById(R.id.textViewName);
        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewSex = view.findViewById(R.id.textViewSex);
        imageViewProfile = view.findViewById(R.id.imageViewProfile);
    }
}
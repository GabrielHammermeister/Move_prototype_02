package com.example.move_prototype_02.Repository;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirestoreRepository {

    private static final String KEY_USERID = "userID";
    private static final String TAG = "FirestoreRepository";

    private static FirebaseFirestore db;
    private CollectionReference collectionHabitos;
    private CollectionReference collectionProfiles;
    private FirebaseUser firebaseUser;
    private FirebaseStorage storage;
    private StorageReference storageRef;

    public FirestoreRepository(){
        db = FirebaseFirestore.getInstance();
        collectionHabitos = db.collection("Habitos");
        collectionProfiles = db.collection("Profiles");
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }

    public CollectionReference getCollectionHabitos() {
        return collectionHabitos;
    }

    public FirebaseFirestore getDb() {
        return db;
    }

    public CollectionReference getCollectionProfiles() {
        return collectionProfiles;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

}

package com.example.move_prototype_02.Repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FirestoreRepository {

    private static final String KEY_USERID = "userID";

    private static FirebaseFirestore db;
    private CollectionReference collectionHabitos;
    private CollectionReference collectionProfiles;
    private FirebaseUser firebaseUser;

    public FirestoreRepository(){
        db = FirebaseFirestore.getInstance();
        collectionHabitos = db.collection("Habitos");
        collectionProfiles = db.collection("Profiles");
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
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

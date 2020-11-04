package com.example.move_prototype_02.View.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.move_prototype_02.R;
import com.example.move_prototype_02.View.Home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private CollectionReference profiles = FirebaseFirestore.getInstance().collection("Profiles");

    private EditText  editTextPassword, editTextName, editTextEmail, editTextIdade;
    private ToggleButton toggleButtonSexo;
    private Button buttonRegistrar;

    private static String TAG = "SignupActivity";
    private String email, password, name;
    private int idade;
    private Boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.senha);
        editTextName = findViewById(R.id.editTextName);
        editTextIdade = findViewById(R.id.editTextIdade);
        toggleButtonSexo = findViewById(R.id.toggleButtonSexo);
        buttonRegistrar = findViewById(R.id.registrar);




        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                name = editTextName.getText().toString();
                idade = Integer.parseInt(editTextIdade.getText().toString());
                sex = toggleButtonSexo.isChecked();

                if(email.isEmpty()|| password.isEmpty() || name.isEmpty() || idade == 0){
                    Toast.makeText(SignupActivity.this, "Complete todos os Campos!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    createUser();
                    setProfileData();
                }
            }
        });


    }

    private void setProfileData() {

        firebaseAuth
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "signInWithEmail:success");

                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("name", name);
                            map.put("sex", sex);
                            map.put("idade", idade);

                            profiles
                                    .document(firebaseUser.getUid())
                                    .set(map);
                            Toast.makeText(SignupActivity.this, "Registro concluido com Sucesso!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                        }
                    }
                });



    }

    public void createUser(){

        firebaseAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    //UPDATE THE UI
                    //UPDATEUI(FirebaseUser user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignupActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    //DONT UPDATE THE UI
                }
            }
        });
    }
}
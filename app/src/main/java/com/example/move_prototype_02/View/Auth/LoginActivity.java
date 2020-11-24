package com.example.move_prototype_02.View.Auth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.move_prototype_02.R;
import com.example.move_prototype_02.View.Home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private Button buttonLogin;
    private TextView textViewRegister;
    private TextInputEditText textInputEditTextEmail, textInputEditTextPassword;
    private static final Boolean DEV_MODE = true;

    private static String TAG = "LoginActivity";
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonLogin = findViewById(R.id.b_login);
        textViewRegister = findViewById(R.id.Id_cadastro2);
        textInputEditTextEmail = findViewById(R.id.Id_userEmail);
        textInputEditTextPassword = findViewById(R.id.Id_userPassword);

        register();
        login();


        if(DEV_MODE){
            loginUser("gabriel.hammer523@gmail.com","ghmdc523");
        }

    }

    public void login(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = textInputEditTextEmail.getText().toString();
                password = textInputEditTextPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty() ){
                    Toast.makeText(LoginActivity.this, "Complete todos os campos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(email, password);
                }

            }
        });
    }

    public void loginUser(String email, String password){
        firebaseAuth
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "signInWithEmail:success");
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });

    }

    public void register(){
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }



}
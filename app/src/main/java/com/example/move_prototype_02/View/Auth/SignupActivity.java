package com.example.move_prototype_02.View.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.move_prototype_02.R;

public class SignupActivity extends AppCompatActivity {

    EditText username, password, name, lastname, email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = findViewById(R.id.usuario);
        password = findViewById(R.id.senha);
        name = findViewById(R.id.nome);
        lastname = findViewById(R.id.sobrenome);
        email = findViewById(R.id.email);

        register = findViewById(R.id.registrar);

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final UserEntity userEntity = new UserEntity(
//                        username.getText().toString(),
//                        password.getText().toString(),
//                        name.getText().toString(),
//                        lastname.getText().toString(),
//                        email.getText().toString()
//                        );
//
//                if(validateInput(userEntity))
//                {
//
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            MoveDatabase moveDatabase = MoveDatabase.getUserDatabase(getApplicationContext());
//                            UserDao userDao = moveDatabase.userDao();
//
//                            userDao.registerUser(userEntity);
//
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(), "Registro Concluido!", Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//                                }
//                            });
//                        }
//                    }).start();

//                }else{
//                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}
package com.example.move_prototype_02.UI.Auth;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.move_prototype_02.R;
import com.example.move_prototype_02.UI.Home.HomeActivity;
import com.example.move_prototype_02.UserData.Daos.UserDao;
import com.example.move_prototype_02.UserData.Entities.UserEntity;
import com.example.move_prototype_02.UserData.MoveDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    TextInputEditText userInput, passInput;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.b_login);
        textView = findViewById(R.id.Id_cadastro2);
        userInput = findViewById(R.id.Id_userEmail);
        passInput = findViewById(R.id.Id_userPassword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String usuario, senha;

                usuario = userInput.getText().toString();
                senha = passInput.getText().toString();

                if(usuario.isEmpty() || senha.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {

                    final UserEntity[] userEntity = new UserEntity[1];

                    MoveDatabase moveDatabase = MoveDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = moveDatabase.userDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            userEntity[0] = userDao.login(usuario, senha);
                            if(userEntity[0] == null)
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Credenciais Invalidas!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                int userId = userEntity[0].getUserId();

                                final Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.putExtra("userId", userId);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Credenciais Aceitas!", Toast.LENGTH_SHORT).show();
                                        startActivity(intent);
                                    }
                                });

                            }
                        }
                    }).start();
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

}
package com.example.move_prototype_02.View.Auth;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.move_prototype_02.R;
import com.example.move_prototype_02.View.Home.HomeActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    TextInputEditText userInput, passInput;

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

//                final String usuario, senha;
//
//                usuario = userInput.getText().toString();
//                senha = passInput.getText().toString();
//
//                if(usuario.isEmpty() || senha.isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
//                } else {
//
//                    UserEntity userEntity = null;
//                    userEntity = userViewModel.login(usuario, senha);
//
//                    if( userEntity == null)
//                    {
//                        Toast.makeText(getApplicationContext(), "Credenciais Invalidas!", Toast.LENGTH_SHORT).show();
//
//                    } else{
//
//                        Toast.makeText(getApplicationContext(), "Credenciais Aceitas!", Toast.LENGTH_SHORT).show();
//
//                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                        intent.putExtra("userId", userEntity.getUserId());
//                        startActivity(intent);
//                    }
//
//                }
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
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
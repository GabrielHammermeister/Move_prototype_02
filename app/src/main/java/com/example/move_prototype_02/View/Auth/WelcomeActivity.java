package com.example.move_prototype_02.View.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.move_prototype_02.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = findViewById(R.id.Id_cadastrar);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
            }
        });

    }

    public void goToLogin(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
package com.dicoding.picodiploma.e_maos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dicoding.picodiploma.e_maos.ui.login.LoginActivity;

public class siginOrRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_or_register);

        final Button button = findViewById(R.id.b_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(siginOrRegister.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }
}

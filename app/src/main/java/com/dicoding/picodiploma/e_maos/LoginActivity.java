package com.dicoding.picodiploma.e_maos;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;

    Button login;
    EditText username,password;
    TextView register;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db =new DatabaseHelper(this);
        username =(EditText)findViewById(R.id.editText_username);
        password =(EditText)findViewById(R.id.editText_password);
        login = (Button)findViewById(R.id.btn_login);
        register = (TextView)findViewById(R.id.textView_register);


        //        register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });

//        LOGIN
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean masuk = db.checkLogin(strUsername,strPassword);
                if(masuk==true){
                    Boolean updateSession =db.upgradeSession("ada",1);
                    if(updateSession==true){
                        Toast.makeText(getApplicationContext(),"Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Isikan Data Dengan Benar",Toast.LENGTH_SHORT).show();
                }

            }
        });





    }

}

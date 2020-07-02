package com.dicoding.picodiploma.e_maos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;

    Button register;
    EditText username,password, passwordConfirm;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        username =(EditText)findViewById(R.id.editText_username);
        password =(EditText)findViewById(R.id.editText_password);
        passwordConfirm =(EditText)findViewById(R.id.editText_passwordConfirmation);
        login = (TextView) findViewById(R.id.textView_loginRegis);
        register = (Button)findViewById(R.id.btn_registerRegis);

        //        Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

//        register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConfirm = passwordConfirm.getText().toString();
                if(strPassword.equals(strPasswordConfirm)){
                    Boolean daftar = db.insertUser(strUsername,strPassword);
                    if(daftar == true){
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent= new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

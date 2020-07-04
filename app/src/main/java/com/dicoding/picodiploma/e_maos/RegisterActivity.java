package com.dicoding.picodiploma.e_maos;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dicoding.picodiploma.e_maos.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class  RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etUsername, etDate, etEmail, etPassword, etCPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView login = findViewById(R.id.act_login);
        mAuth = FirebaseAuth.getInstance();

        final Button btnRegister = findViewById(R.id.btnregis);

        etUsername = findViewById(R.id.username);
        etDate = findViewById(R.id.dateof);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.RPassword);
        etCPassword = findViewById(R.id.RKPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = etUsername.getText().toString();
                final String date = etDate.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String kpassword = etCPassword.getText().toString();

                if(username.equals("") || date.equals("") || email.equals("") || password.equals("") || kpassword.equals("")){
                    Toast.makeText(RegisterActivity.this, "Form tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(RegisterActivity.this, "Registrasi akun berhasil", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, "Registrasi akun gagal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(viewLogin);
            }

        });


    }
}

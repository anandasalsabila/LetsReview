package com.caca.letsreview.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.caca.letsreview.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    /*  Nama : Ananda Salsabila
        Kelas: AKB-4/IF4
        NIM  : 10117133

        Progress : Menyelesaikan Register 16 July 2020
     */

    ProgressBar progressBar;
    EditText email;
    EditText password;
    Button register,login;
    FirebaseAuth firebaseAuth;
    TextView tvSambutan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
        progressBar = findViewById(R.id.progressBarRegister);
        email = findViewById(R.id.edtEmailRegister);
        password = findViewById(R.id.edtPasswordRegister);
        tvSambutan = findViewById(R.id.tvSambutan);
        register = findViewById(R.id.btnRegisterUser);
        login = findViewById(R.id.btnBackUser);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registered successfully, You can go back to LOGIN PAGE", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginDashboard.class);
                startActivity(intent);
            }
        });
    }
}
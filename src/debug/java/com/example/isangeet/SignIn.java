package com.example.isangeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {
    EditText signIn_emailTxt, signIn_passwordTxt;
    Button SignIn_btn;
    TextView signUpText;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signIn_emailTxt = findViewById(R.id.signIn_emailTxt);
        signIn_passwordTxt = findViewById(R.id.signIn_passwordTxt);
        SignIn_btn = findViewById(R.id.SignIn_btn);
        signUpText = findViewById(R.id.signUpText);
        mAuth = FirebaseAuth.getInstance();
        SignIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn.this, SongsList.class);
                startActivity(i);
            }
        });
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
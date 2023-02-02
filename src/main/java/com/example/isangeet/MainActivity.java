package com.example.isangeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText name, signUp_emailTxt, signUp_passwordTxt, confirm_passwordTxt;
    Button SignUp_btn;
    TextView signInText;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameTxt);
        signUp_emailTxt = findViewById(R.id.signUp_emailTxt);
        signUp_passwordTxt = findViewById(R.id.signUp_passwordTxt);
        confirm_passwordTxt = findViewById(R.id.confirm_passwordTxt);
        SignUp_btn = findViewById(R.id.SignUp_btn);
        signInText = findViewById(R.id.signInText);
        mAuth = FirebaseAuth.getInstance();

        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignIn.class);
                startActivity(i);
            }
        });
    }
    public void CreateAccount(View view) {
            String emailText = signUp_emailTxt.getText().toString();
            String passwordText = signUp_passwordTxt.getText().toString();
            mAuth.createUserWithEmailAndPassword(emailText,passwordText)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                            } else{
                            }
                        }
                    });
        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}
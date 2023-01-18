package com.example.clgmate_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity2 extends AppCompatActivity {

    Button btnRegister;
    EditText etUsername,etEmail,etPassword,etConfirmPassword;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        etUsername = findViewById(R.id.aREtUserName2);
        etEmail = findViewById(R.id.aREtEmail2);
        etPassword = findViewById(R.id.aREtPassword2);

        btnRegister = findViewById(R.id.aREtBtnRegister2);

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserCreate(etEmail.getText().toString(),etPassword.getText().toString());
                Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();


            }
        });
        TextView alreadyHaveAccountBtn = findViewById(R.id.alreadyHaveAccount);


        alreadyHaveAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Btn Clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LogInPage.class));
            }
        });

    }
    void UserCreate(String emailStr,String passwordStr){
        mAuth.createUserWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LogInPage.class));

                } else {
                    Toast.makeText(getApplicationContext(), "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void CreateUser() {
        String fullNameStr = etUsername.getText().toString();
        String emailStr = etEmail.getText().toString();
        String passwordStr = etPassword.getText().toString();
        if (TextUtils.isEmpty(fullNameStr)) {
            etUsername.setError("Name cannot be empty");
            etUsername.requestFocus();
        } else if (TextUtils.isEmpty(emailStr)) {
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
        } else if (TextUtils.isEmpty(passwordStr)) {
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        } else {

        }
    }
}
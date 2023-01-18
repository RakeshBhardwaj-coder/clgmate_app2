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
import com.google.firebase.auth.FirebaseUser;


public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText etUsername,etEmail,etPassword,etConfirmPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
// Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        SignInUser("Rb6108833@gmail.com","Rb610883@");


        if(currentUser != null){
            startActivity(new Intent(getApplicationContext(), log_in_page.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            startActivity(new Intent(getApplicationContext(), log_in_page.class));
        }
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        etUsername = findViewById(R.id.aREtUserName);
        etEmail = findViewById(R.id.aREtEmail);
        etPassword = findViewById(R.id.aREtPassword);
        etConfirmPassword = findViewById(R.id.aREtConfirmPassword);

        btnRegister = findViewById(R.id.aREtBtnRegister);
        SignInUser("Rb6108833@gmail.com","Rb610883@");
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Btn Clicked",Toast.LENGTH_SHORT).show();

                UserCreate();
            }
        });

        TextView btn = findViewById(R.id.already_have_account);






    }

    private void UserCreate(){

    }

public  void SignInUser(String emailStr, String passwordStr){
    mAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Toast.makeText(RegisterActivity.this, "Login Successfully.", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }else {
                Toast.makeText(getApplicationContext(), "LogIn Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
    });
}

    private void CreateUser() {
        String fullNameStr = etEmail.getText().toString();
        String emailStr = etEmail.getText().toString();
        String passwordStr = etPassword.getText().toString();
        String confirmPasswordStr = etConfirmPassword.getText().toString();
        if(TextUtils.isEmpty(fullNameStr)){
            etUsername.setError("Name cannot be empty");
            etUsername.requestFocus();
        }else if(TextUtils.isEmpty(emailStr)){
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
        } else if(TextUtils.isEmpty(passwordStr)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
        }
        else if(TextUtils.isEmpty(confirmPasswordStr)){
            etConfirmPassword.setError("Password cannot be empty");
            etConfirmPassword.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), log_in_page.class));

                    }else {
                        Toast.makeText(getApplicationContext(), "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
}
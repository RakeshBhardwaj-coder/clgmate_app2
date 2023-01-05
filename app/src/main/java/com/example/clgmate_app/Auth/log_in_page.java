package com.example.clgmate_app.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.clgmate_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class log_in_page extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            startActivity(new Intent(getApplicationContext(), log_in_page.class));
        }
    }
    public void LoginUser(){
//        String emailStr = etEmail.getText().toString();
//        String passwordStr = etPassword.getText().toString();
//        if(TextUtils.isEmpty(emailStr)){
//            etEmail.setError("Email cannot be empty");
//            etEmail.requestFocus();
//        }else if(TextUtils.isEmpty(passwordStr)){
//            etPassword.setError("Password cannot be empty");
//            etPassword.requestFocus();
//        }else{
//            mAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(getApplicationContext(), "Login Successfully.", Toast.LENGTH_SHORT).show();
//
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                    }else {
//                        Toast.makeText(getApplicationContext(), "LogIn Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            });
//        }
    }

}

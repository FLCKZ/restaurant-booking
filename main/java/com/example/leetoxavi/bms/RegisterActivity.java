package com.example.leetoxavi.bms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

import java.sql.*;

public class RegisterActivity extends AppCompatActivity {

    EditText userNameField;
    EditText phoneNumberField;
    EditText emailField;
    EditText passwordField;
    EditText confirmPasswordField;
    private FirebaseAuth mFirebaseAuth;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phoneNumberField = (EditText) findViewById(R.id.phone_numbers);
        userNameField = (EditText) findViewById(R.id.username);
        emailField = (EditText) findViewById(R.id.email);
        passwordField = (EditText) findViewById(R.id.password);
        confirmPasswordField = (EditText) findViewById(R.id.confirm_password);

        mFirebaseAuth = FirebaseAuth.getInstance();
        PD = new ProgressDialog(this);

        Button Register = (Button) findViewById(R.id.register_button);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerUser();

            }

        });

    }

    public void registerUser(){

        String password = passwordField.getText().toString().trim();
        String email = emailField.getText().toString().trim();
        String confirmPassword = confirmPasswordField.getEditableText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }


        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(confirmPassword)){
            Toast.makeText(this,"Please Confirm Password",Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(confirmPassword)){
            Toast.makeText(this, "passwords do not match. Please Enter again",Toast.LENGTH_LONG).show();
            return;
        }

        PD.setMessage("registering user...");
        PD.show();

        mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // start our profile
                    Toast.makeText(RegisterActivity.this,"registered succefully", Toast.LENGTH_SHORT).show();
                    PD.cancel();
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    RegisterActivity.this.startActivity(i);
                    return;
                }else{
                    Toast.makeText(RegisterActivity.this,"registration not succefull", Toast.LENGTH_SHORT).show();
                    PD.cancel();
                    return;
                }
            }
        });

    }


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public boolean isValidPhoneNumbers(String phoneNumber){
        if(phoneNumber.length() == 10){
            return true;
        }
        return false;
    }

}

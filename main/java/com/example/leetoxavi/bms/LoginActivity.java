package com.example.leetoxavi.bms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    EditText userNameField;
    EditText phoneNumberField;
    EditText emailField;
    EditText passwordField;
    private FirebaseAuth mFirebaseAuth;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //phoneNumberField = (EditText) findViewById(R.id.phone_numbers);
        //userNameField = (EditText) findViewById(R.id.username);
        emailField = (EditText) findViewById(R.id.login_email);
        passwordField = (EditText) findViewById(R.id.password);

        mFirebaseAuth = FirebaseAuth.getInstance();
        PD = new ProgressDialog(this);

        final Button Login = (Button)findViewById(R.id.login_button);
        TextView Register = (TextView) findViewById(R.id.register_text_view);

        Register.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Intent RegisterIntent = new Intent(view.getContext(), RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });



        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                userLogin();
            }
        });
    }
    public void userLogin(){

        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email is Required",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
            return;
        }

        PD.setMessage("Logging in...");
        PD.show();

        mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                PD.dismiss();
                if(task.isSuccessful()){
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Failed. Try Again",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}


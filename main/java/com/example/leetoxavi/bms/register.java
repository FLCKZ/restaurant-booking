
package com.example.knd563.helloworld;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class register extends Activity {

    EditText ET_CONTACTS,ET_USER_NAME,ET_USER_PASS,ET_E_MAIL;
    String contacts,user_name,user_pass,e_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ET_USER_NAME = (EditText)findViewById(R.id.username);
        ET_CONTACTS= (EditText)findViewById(R.id.phoneumbers);
        ET_USER_PASS = (EditText)findViewById(R.id.password);
        ET_E_MAIL = (EditText)findViewById(R.id.email);


    }

    public void userReg(View view) {

        user_name  = ET_USER_NAME.getText().toString();
        user_pass  = ET_USER_PASS.getText().toString();
        contacts  = ET_CONTACTS.getText().toString();
        e_mail = ET_E_MAIL.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,user_name,contacts,e_mail,user_pass);
        finish();


    }
}

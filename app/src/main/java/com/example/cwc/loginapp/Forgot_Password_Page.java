package com.example.cwc.loginapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Forgot_Password_Page extends AppCompatActivity {
    EditText t1;
    TextView t2;
    String s1;
    String s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password__page);
        t1  = (EditText)findViewById(R.id.editText2);
        t2  = (TextView)findViewById(R.id.textView14);
        Bundle b1 = getIntent().getExtras();//to get extras of intent and store them in b1 as a bundle
        s1 = b1.getString("User");// store the string from the bundle of data with key user in s1(getInt for integer and so on)
        t1.setText(s1);
    }
    private boolean isEmailValid(String email) {
        boolean em;
        if(email.contains("@")){
            em=true;
        }
        else if (email.contains(".com")){
            em=true;
        }
        else {
            em=false;
        }
        return em;
    }

    public void sendmail(View view) {
        s2 = t1.getText().toString();
        if(isEmailValid(t1.getText().toString())) {
            Snackbar.make(view, "An E-mail has been sent on the provided Username. Please check and follow.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            t2.setText("An e-mail has been sent to " + s2);
        }
        else if(TextUtils.isEmpty(t1.getText().toString())){
            t2.setText("Field can not be empty ");
        }
        else{
            t2.setText("Invalid format of e-mail " + s2);
        }
    }
}

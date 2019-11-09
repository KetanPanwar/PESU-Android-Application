package com.example.cwc.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseOptionsHome extends AppCompatActivity {
    MyUsersDetails myData;
    EditText email;
    TextView nemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_options_home);
        myData=new MyUsersDetails(this);
        email = (EditText)findViewById(R.id.emailhome);
        nemail= (TextView)findViewById(R.id.emailnotemphome);
    }

    public void gobutton(View view) {
        nemail.setText("");
        String fulldatabase=myData.getAll();
        if(TextUtils.isEmpty(email.getText().toString())){
            nemail.setText("Please enter an email to proceed");
        }

        else if(!myData.ValidateEmail(email.getText().toString().trim())){
            nemail.setText("e-mail not found in database");
        }
        else {
            Intent i1 = new Intent(this, DatabaseOptions.class);
            i1.putExtra("User", email.getText().toString().trim());
            startActivity(i1);
        }

    }

    public void newuserbutton(View view) {
        nemail.setText("");
        Intent i1 = new Intent(this, Registration_page.class);
        startActivity(i1);
    }

    public void searchoptionbutton(View view) {
        nemail.setText("");
        Intent i1 = new Intent(this, SearchPage.class);
        startActivity(i1);
    }

    public void viewdatabasebutton(View view) {
        nemail.setText("");
        myData.displayDetails();

    }
}

package com.example.cwc.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayRegistrationDetails extends AppCompatActivity {
    String s1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_registration_details);
        t1=(TextView)findViewById(R.id.detailsdisplay);
        Bundle b1 = getIntent().getExtras();
        s1 = b1.getString("User");
        t1.setText(s1);
    }
}

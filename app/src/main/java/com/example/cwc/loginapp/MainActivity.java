package com.example.cwc.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1,t2,t3;
    MyUsersDetails myData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","OnStart");
        setContentView(R.layout.activity_main);
        e1= (EditText)findViewById(R.id.homeusername);
        e2= (EditText)findViewById(R.id.homepassword);
        t1= (TextView)findViewById(R.id.usernamenotemp);
        t2= (TextView)findViewById(R.id.passwordnotemp);
        t3= (TextView)findViewById(R.id.notmatched);
        myData=new MyUsersDetails(this);

    }

    public void Registernow(View view) {
        Intent i1 = new Intent(this , Registration_page.class);//from this to second activity
        startActivity(i1);// to start or to fire the other activity using intent i1
    }

    public void Openguest(View view) {
        Intent i2 = new Intent(this , Guest_page.class);//from this to second activity
        startActivity(i2);// to start or to fire the other activity using intent i1
    }

    public void openfgpw(View view) {
        Intent i1 = new Intent(this , Forgot_Password_Page.class);//from this to second activity
        i1.putExtra("User",e1.getText().toString());//put the data in the intent before u fire it(dynamic storage so no saving of data)
        startActivity(i1);// to start or to fire the other activity using intent i1
    }


    public void loginnow(View view) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        if((TextUtils.isEmpty(e1.getText().toString()))||(TextUtils.isEmpty(e2.getText().toString()))){
            if(TextUtils.isEmpty(e1.getText().toString())){
                t1.setText("Please enter your Username");
            }
            if(TextUtils.isEmpty(e2.getText().toString())){
                t2.setText("Please enter the Password");
            }

        }
        else if(myData.Validateidpswd(e1.getText().toString().trim(),e2.getText().toString())){

            Intent i2 = new Intent(this, Login_page.class);
            i2.putExtra("User", e1.getText().toString().trim());
            startActivity(i2);
        }

        else if(!myData.Validateidpswd(e1.getText().toString().trim(),e2.getText().toString())&&myData.ValidateEmail(e1.getText().toString().trim())){
            t3.setText("Account exist but password incorrect");
        }
        else{
            t3.setText("No account exist with this username");
        }

    }

    public void databaseoptions(View view) {
        Intent i2 = new Intent(this, DatabaseOptionsHome.class);
        startActivity(i2);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","OnPause");
        e1.setText("");
        e2.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","OnDestroy");
    }
}

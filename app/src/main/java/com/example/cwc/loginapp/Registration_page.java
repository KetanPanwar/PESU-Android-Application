package com.example.cwc.loginapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration_page extends AppCompatActivity {
    EditText fname,mname,lname,email,pswd,cpswd,age,address,dob,pucp,pucn;
    TextView nfname,nlname,nemail,npswd,ncpswd,nage,ndob,npucp,npucn,ngender;
    RadioButton male, female , percentage , cgpa;
    String porgpa;
    String maleorfemale;
    boolean mf =false;
    boolean pg=false;
    MyUsersDetails myData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        fname =(EditText)findViewById(R.id.firstname);
        lname =(EditText)findViewById(R.id.lastname);
        mname=(EditText)findViewById(R.id.middlename);
        email = (EditText)findViewById(R.id.emailregistration);
        pswd = (EditText)findViewById(R.id.passwordregistration);
        cpswd = (EditText)findViewById(R.id.confirmpassregis);
        age =(EditText)findViewById(R.id.ageregistration);
        address=(EditText)findViewById(R.id.adressregistration);
        dob =(EditText)findViewById(R.id.dobregistration);
        pucp =(EditText)findViewById(R.id.pucperformance);
        pucn =(EditText)findViewById(R.id.pucnamereg);
        nfname =(TextView)findViewById(R.id.firstnamenotemp);
        nlname =(TextView)findViewById(R.id.lastnamenotemp);
        nemail = (TextView)findViewById(R.id.emailnotemp);
        npswd = (TextView)findViewById(R.id.passwordnotemp);
        ncpswd = (TextView)findViewById(R.id.cnfrmpswdnotemp);
        nage =(TextView)findViewById(R.id.agenotemp);
        ndob =(TextView)findViewById(R.id.dobnotemp);
        npucp =(TextView)findViewById(R.id.pucperformnotemp);
        npucn =(TextView)findViewById(R.id.pucnamenotemp);
        ngender = (TextView)findViewById(R.id.gendernotemp);
        male = (RadioButton)findViewById(R.id.male);
        female= (RadioButton)findViewById(R.id.female);
        percentage = (RadioButton)findViewById(R.id.percentage);
        cgpa = (RadioButton)findViewById(R.id.cgpa);
        myData=new MyUsersDetails(this);




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
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        Pattern PASSWORD_PATTERN
                = Pattern.compile(
                "[a-zA-Z0-9!@#$]{6,24}");

        return ((password.length() > 6)&&(PASSWORD_PATTERN.matcher(password).matches()));
    }


    private void fieldEmpty(TextView t1,int i){
        if(i==0) {
            t1.setText("Field can not be empty");
        }
        else{
            t1.setText("");
        }
    }

        public void maleclick(View view) {
            maleorfemale = "Male";
            mf = true;
        }

        public void femaleclick(View view) {
            maleorfemale = "Female";
            mf = true;
        }


        public void percentclick(View view) {
            porgpa = "Percentage";
            pg = true;
        }
        public void cgpaclick(View view) {
            porgpa = "CGPA";
            pg = true;
        }



    public void registerhere(View view) {
        fieldEmpty(nfname,1);
        fieldEmpty(nlname,1);
        fieldEmpty(nemail,1);
        fieldEmpty(npswd,1);
        fieldEmpty(nage,1);
        fieldEmpty(ndob,1);
        fieldEmpty(ncpswd,1);
        fieldEmpty(npucn,1);
        fieldEmpty(npucp,1);
        fieldEmpty(ngender,1);
        boolean b = true;
        {
        if (TextUtils.isEmpty(fname.getText().toString())) {
            b = false;
            fieldEmpty(nfname,0);
        } if (TextUtils.isEmpty(lname.getText().toString())) {
            b = false;
            fieldEmpty(nlname,0);
        }  if (TextUtils.isEmpty(email.getText().toString())) {
            b = false;
            fieldEmpty(nemail,0);
        }  if (TextUtils.isEmpty(pswd.getText().toString())) {
            b = false;
            fieldEmpty(npswd,0);
        }  if (TextUtils.isEmpty(cpswd.getText().toString())) {
            b = false;
            fieldEmpty(ncpswd,0);
        }  if (TextUtils.isEmpty(age.getText().toString())) {
            b = false;
            fieldEmpty(nage,0);
        }  if (TextUtils.isEmpty(dob.getText().toString())) {
            b = false;
            fieldEmpty(ndob,0);
        }  if (TextUtils.isEmpty(pucp.getText().toString())) {
            b = false;
            fieldEmpty(npucp,0);
        }  if (TextUtils.isEmpty(pucn.getText().toString())) {
            b = false;
            fieldEmpty(npucn,0);
        }
           if((!isPasswordValid(pswd.getText().toString()))&&!(TextUtils.isEmpty(pswd.getText().toString()))){
                b=false;
                npswd.setText("please enter the password in the required format");
        }
           if(!(TextUtils.isEmpty(pucp.getText().toString()))&&!(pg)){
                b=false;
                npucp.setText("Please choose Percentage or CGPA");
        }
            if(!mf){
            b=false;
            fieldEmpty(ngender,0);
        }
            if(!((pswd.getText().toString()).equals(cpswd.getText().toString()))&&!(TextUtils.isEmpty(cpswd.getText().toString()))){
                b=false;
                ncpswd.setText("not matching with above password");
        }
            if((!isEmailValid(email.getText().toString()))&&!(TextUtils.isEmpty(email.getText().toString()))){
                b=false;
                nemail.setText("please enter email in a valid format");
        }
            if(!TextUtils.isEmpty(email.getText().toString())&&myData.getAll().contains(email.getText().toString())){
            b=false;
            nemail.setText("This e-mail is already registered with us. Please try to log in.");
            }

        }
        {

            if (b) {
                myData.insertData(fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),email.getText().toString(),pswd.getText().toString(),age.getText().toString(),maleorfemale,address.getText().toString(),dob.getText().toString(),pucp.getText().toString(),pucn.getText().toString(),porgpa);
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please review your form", Toast.LENGTH_SHORT).show();
            }
        }

    }


}

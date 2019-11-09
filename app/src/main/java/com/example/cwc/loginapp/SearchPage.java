package com.example.cwc.loginapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SearchPage extends AppCompatActivity {
    EditText fname,mname,lname,email,age,address,dob,pucp,pucn;
    TextView nfname,nmname,nlname,nemail,nage,nadd,ndob,npucp,npucn,ngender,nsearch;
    RadioButton male, female , percentage , cgpa;
    RadioGroup gendergrp,porgpagrp;
    String porgpa;
    String maleorfemale;
    boolean mf =false;
    boolean pg=false;
    boolean srchtype=false;
    String srchtypetext;
    MyUsersDetails myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        fname =(EditText)findViewById(R.id.firstname);
        lname =(EditText)findViewById(R.id.lastname);
        mname=(EditText)findViewById(R.id.middlename);
        email = (EditText)findViewById(R.id.emailregistration);
        age =(EditText)findViewById(R.id.ageregistration);
        address=(EditText)findViewById(R.id.adressregistration);
        dob =(EditText)findViewById(R.id.dobregistration);
        pucp =(EditText)findViewById(R.id.pucperformance);
        pucn =(EditText)findViewById(R.id.pucnamereg);
        nfname =(TextView)findViewById(R.id.firstnamenotemp);
        nmname=(TextView)findViewById(R.id.mnamenotemp);
        nlname =(TextView)findViewById(R.id.lastnamenotemp);
        nemail = (TextView)findViewById(R.id.emailnotemp);
        nage =(TextView)findViewById(R.id.agenotemp);
        nadd=(TextView)findViewById(R.id.addnotemp);
        ndob =(TextView)findViewById(R.id.dobnotemp);
        npucp =(TextView)findViewById(R.id.pucperformnotemp);
        npucn =(TextView)findViewById(R.id.pucnamenotemp);
        ngender = (TextView)findViewById(R.id.gendernotemp);
        nsearch=(TextView)findViewById(R.id.srchnotemp);
        male = (RadioButton)findViewById(R.id.male);
        female= (RadioButton)findViewById(R.id.female);
        percentage = (RadioButton)findViewById(R.id.percentage);
        cgpa = (RadioButton)findViewById(R.id.cgpa);
        gendergrp=(RadioGroup)findViewById(R.id.gendergp);
        porgpagrp=(RadioGroup)findViewById(R.id.cgpaorpercentage);
        myData=new MyUsersDetails(this);




    }

    private void fieldEmpty(TextView t1,int i){
        if(i==0) {
            t1.setText("Atleast one field is required");
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



    public void Searchhere(View view) {
        //String [] sendexclusivesrch={fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),email.getText().toString(),age.getText().toString(),address.getText().toString(),dob.getText().toString(),pucp.getText().toString(),pucn.getText().toString(),maleorfemale,porgpa};
        fieldEmpty(nfname,1);
        fieldEmpty(nlname,1);
        fieldEmpty(nemail,1);
        fieldEmpty(nage,1);
        fieldEmpty(ndob,1);
        fieldEmpty(npucn,1);
        fieldEmpty(npucp,1);
        fieldEmpty(ngender,1);
        fieldEmpty(nmname,1);
        fieldEmpty(nadd,1);
        boolean b = true;
        {
            if(TextUtils.isEmpty(fname.getText().toString())&&TextUtils.isEmpty(mname.getText().toString())&&TextUtils.isEmpty(lname.getText().toString())&&TextUtils.isEmpty(email.getText().toString())&&TextUtils.isEmpty(age.getText().toString())&&TextUtils.isEmpty(address.getText().toString())&&TextUtils.isEmpty(dob.getText().toString())&&TextUtils.isEmpty(pucp.getText().toString())&&TextUtils.isEmpty(pucn.getText().toString())&&(!mf)&&(!pg)){
                b=false;
                fieldEmpty(nfname,0);
                fieldEmpty(nlname,0);
                fieldEmpty(nemail,0);
                fieldEmpty(nage,0);
                fieldEmpty(ndob,0);
                fieldEmpty(npucn,0);
                fieldEmpty(npucp,0);
                fieldEmpty(ngender,0);
                fieldEmpty(nmname,0);
                fieldEmpty(nadd,0);
            }
            if(!srchtype){
                b=false;
                nsearch.setText("Please choose the type of search.");
            }

        }
        {

            if (b) {
                if(srchtypetext.equals("inclusive")){
                    myData.InclusiveSearch(fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),email.getText().toString(),age.getText().toString(),address.getText().toString(),dob.getText().toString(),pucp.getText().toString(),pucn.getText().toString(),maleorfemale,porgpa);
                }
                    else if(srchtypetext.equals("exclusive")){
                    String [] sendexclusivesrch={fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),email.getText().toString(),age.getText().toString(),address.getText().toString(),dob.getText().toString(),pucp.getText().toString(),pucn.getText().toString(),maleorfemale,porgpa};
                    myData.ExclusiveSearch(sendexclusivesrch);
                }
            }
            else {
                Toast.makeText(this, "Please review your form", Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this,"onStart Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this,"onResume Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this,"onPause Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this,"onStop Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this,"onRestart Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this,"onDestroy Finished",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","OnDestroy");
    }

    public void refreshgender(View view) {
        gendergrp.clearCheck();
            mf=false;
            maleorfemale="";

    }

    public void refreshpucp(View view) {
        porgpagrp.clearCheck();
            pg=false;
            porgpa="";

    }

    public void inclusiveclick(View view) {
        srchtypetext="inclusive";
        srchtype=true;
    }

    public void inclusivehelp(View view) {
        Snackbar.make(view, "It will give you results of all the students having at least one of the provided fields.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void exclusiveclick(View view) {
        srchtypetext="exclusive";
        srchtype=true;
    }

    public void exclusivehelp(View view) {
        Snackbar.make(view, "It will give you results of all the students having all the provided fields.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

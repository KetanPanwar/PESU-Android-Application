package com.example.cwc.loginapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class DatabaseOptions extends AppCompatActivity {

    EditText fname,mname,lname,email,pswd,cpswd,age,address,dob,pucp,pucn;
    TextView nfname,nlname,nemail,npswd,ncpswd,nage,ndob,npucp,npucn,ngender;
    RadioButton male, female , percentage , cgpa;
    String porgpa,maleorfemale,emailatentry,recievedemail;
    boolean mf =false;
    boolean pg=false;
    MyUsersDetails myData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_option);
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
        Bundle b1 = getIntent().getExtras();
        recievedemail = b1.getString("User");
        email.setText(recievedemail);
        showdetails();
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
    public void clearall(){
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
    }


    public void showdetails() {
        clearall();
        emailatentry=email.getText().toString();
        myData.Checkrow(email.getText().toString(),fname,mname,lname,pswd,age,address,dob,pucp,pucn,male,female,percentage,cgpa);

    }

    public void Delete_stud(View view) {
        clearall();
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Delete Entry?");
        myAlert.setMessage("Are You Sure?(This process is irreversible)");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myData.DetetingItems(recievedemail);
                Toast.makeText(DatabaseOptions.this, "Item Deleted", Toast.LENGTH_SHORT).show();;
            }
        });//to finish the app
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();//to dismiss the alert box
            }
        });

        myAlert.setCancelable(false);//so that we can use it only by its options
        myAlert.show();// to show the alert

    }

    public void Update_stud(View view) {
        clearall();
        boolean b = true;

            if (!email.getText().toString().equals(recievedemail)){
                b=false;
                nemail.setText("You can not change e-mail address please register as a new user");
            }
            if(!TextUtils.isEmpty(cpswd.getText().toString())&&!pswd.getText().toString().equals(cpswd.getText().toString()))
            {
                b=false;
                ncpswd.setText("Passwords do not match");
            }
            if(TextUtils.isEmpty(cpswd.getText().toString())){
                b=false;
                ncpswd.setText("Please confirm your password");
        }

        {
            if(b){
                AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
                myAlert.setTitle("Update Entry?");
                myAlert.setMessage("Are You Sure?(You won't be able to retrive old data.)");
                myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myData.Updatedata(fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),email.getText().toString(),pswd.getText().toString(),age.getText().toString(),maleorfemale,address.getText().toString(),dob.getText().toString(),pucp.getText().toString(),pucn.getText().toString(),porgpa);
                        Toast.makeText(DatabaseOptions.this, "Sucessfully Updated", Toast.LENGTH_SHORT).show();
                    }
                });//to finish the app
                myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();//to dismiss the alert box
                    }
                });

                myAlert.setCancelable(false);//so that we can use it only by its options
                myAlert.show();// to show the alert

            }

            if(!b){
                Toast.makeText(this, "Please review your form", Toast.LENGTH_SHORT).show();
            }
        }


    }
}

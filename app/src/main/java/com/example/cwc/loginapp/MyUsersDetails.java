package com.example.cwc.loginapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MyUsersDetails extends SQLiteOpenHelper {
    static final private String DB_NAME = "UsersInfo";
    static final private String DB_TABLE = "Myusers";
    static final private int DB_VER = 1;

    Context ctx;
    SQLiteDatabase DB;
    Intent i1;
    String malefemaledefault,porgpadefault;



    public MyUsersDetails(Context ct) {
        super(ct, DB_NAME, null, DB_VER);
        ctx = ct;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DB_TABLE + " (_id integer primary key autoincrement,stu_fstname text,stu_midname text,stu_lstname text,stu_email text,stu_pswd text,stu_age text,stu_gender text,stu_add text,stu_dob text,stu_pucp text,stu_pucn text,stu_porgpa);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + DB_TABLE);

    }

    public void insertData(String fname, String mname, String lname, String email, String pswd, String age, String gender, String address, String dob, String pucp, String pucn, String porgpa) {
        DB = getWritableDatabase();
        DB.execSQL("insert into " + DB_TABLE + "(stu_fstname,stu_midname,stu_lstname,stu_email,stu_pswd,stu_age,stu_gender,stu_add,stu_dob,stu_pucp,stu_pucn,stu_porgpa) values('" + fname + "','" + mname + "','" + lname + "','" + email + "','" + pswd + "','" + age + "','" + gender + "','" + address + "','" + dob + "','" + pucp + "','" + pucn + "','" + porgpa + "');");
        Toast.makeText(ctx, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

    }

    public String getAll() {
        String passstring;
        DB = getWritableDatabase();
        Cursor cr = DB.rawQuery("Select * from " + DB_TABLE, null);
        StringBuilder str = new StringBuilder();
        int id = 1;
        while (cr.moveToNext()) {
            //int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            String s3 = cr.getString(3);
            String s4 = cr.getString(4);
            String s5 = cr.getString(5);
            String s6 = cr.getString(6);
            String s7 = cr.getString(7);
            String s8 = cr.getString(8);
            String s9 = cr.getString(9);
            String s10 = cr.getString(10);
            String s11 = cr.getString(11);
            String s12 = cr.getString(12);



            str.append("Student number " + id + "\n" + "First Name = " + s1 + "\nMiddle Name = " + s2 + "\nLast Name = " + s3 + "\nE-mail = " + s4 + "\nPassword = " + s5 + "\nAge = " + s6 + "\nGender = " + s7 + "\nAddress = " + s8 + "\nDOB = " + s9 + "\nPUC " + s12 + " = " + s10 + "\nPUC Name = " + s11 + "\n" + "\n");
            id++;
        }
        passstring = str.toString();
        return passstring;
    }

    public void displayDetails() {
        String finaldetails = getAll();
        i1 = new Intent(ctx, DisplayRegistrationDetails.class);
        i1.putExtra("User", finaldetails);
        ctx.startActivity(i1);
    }

    public void Checkrow(String email, EditText fname, EditText mname, EditText lname, EditText pswd, EditText age, EditText address, EditText dob, EditText pucp, EditText pucn, RadioButton male, RadioButton female, RadioButton percentage, RadioButton cgpa) {

            DB = getWritableDatabase();
            StringBuilder str = new StringBuilder();
        int id=1;
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + email + "'", null);
            while (cr.moveToNext()) {
                //int id= cr.getInt(0);
                String s1 = cr.getString(1);
                String s2 = cr.getString(2);
                String s3 = cr.getString(3);
                String s4 = cr.getString(4);
                String s5 = cr.getString(5);
                String s6 = cr.getString(6);
                String s7 = cr.getString(7);
                String s8 = cr.getString(8);
                String s9 = cr.getString(9);
                String s10 = cr.getString(10);
                String s11 = cr.getString(11);
                String s12 = cr.getString(12);
                fname.setText(s1);
                mname.setText(s2);
                lname.setText(s3);
                pswd.setText(s5);
                age.setText(s6);
                address.setText(s8);
                dob.setText(s9);
                pucp.setText(s10);
                pucn.setText(s11);
                malefemaledefault=s7;
                porgpadefault=s12;
                {
                    if (s7.equals("Male")) {
                        male.toggle();
                    } else {
                        female.toggle();
                    }
                }
                {
                    if (s12.equals("CGPA")) {
                        cgpa.toggle();
                    } else {
                        percentage.toggle();
                    }
                }


                str.append("Student number " + id + "\n" + "First Name = " + s1 + "\nMiddle Name = " + s2 + "\nLast Name = " + s3 + "\nE-mail = " + s4 + "\nPassword = " + s5 + "\nAge = " + s6 + "\nGender = " + s7 + "\nAddress = " + s8 + "\nDOB = " + s9 + "\nPUC " + s12 + " = " + s10 + "\nPUC Name = " + s11 + "\n" + "\n");
                id++;
            }


    }

    public void Updatedata(String fname, String mname, String lname, String email, String pswd, String age, String gender, String address, String dob, String pucp, String pucn, String porgpa) {
        if(gender==null){
            gender=malefemaledefault;
        }
        if(porgpa==null){
            porgpa=porgpadefault;
        }
        DB = getWritableDatabase();
        StringBuilder str = new StringBuilder();
        int id=1;
        DB.execSQL("Update " + DB_TABLE + " Set stu_fstname='" + fname + "', stu_midname='" + mname + "' , stu_lstname='" + lname + "', stu_pswd='" + pswd + "', stu_age='" + age + "', stu_gender='" + gender + "', stu_add='" + address + "', stu_dob='" + dob + "', stu_pucp='" + pucp + "', stu_pucn='" + pucn + "', stu_porgpa='" + porgpa + "' Where stu_email='" + email + "'");
        Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + email + "'", null);
        while (cr.moveToNext()) {
            //int id= cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            String s3 = cr.getString(3);
            String s4 = cr.getString(4);
            String s5 = cr.getString(5);
            String s6 = cr.getString(6);
            String s7 = cr.getString(7);
            String s8 = cr.getString(8);
            String s9 = cr.getString(9);
            String s10 = cr.getString(10);
            String s11 = cr.getString(11);
            String s12 = cr.getString(12);

            str.append("Student number " + id + "\n" + "First Name = " + s1 + "\nMiddle Name = " + s2 + "\nLast Name = " + s3 + "\nE-mail = " + s4 + "\nPassword = " + s5 + "\nAge = " + s6 + "\nGender = " + s7 + "\nAddress = " + s8 + "\nDOB = " + s9 + "\nPUC " + s12 + " = " + s10 + "\nPUC Name = " + s11 + "\n" + "\n");
            Intent i8 = new Intent(ctx, DisplayRegistrationDetails.class);
            i8.putExtra("User", str.toString());
            ctx.startActivity(i8);
            id++;
        }
    }
    public void DetetingItems(String emaildelete){
        DB = getWritableDatabase();
        DB.execSQL("Delete from " + DB_TABLE +" Where stu_email='" + emaildelete + "'");
    }
    public boolean ValidateEmail(String validemail){
        DB = getWritableDatabase();
        Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + validemail + "'", null);
        if(cr.getCount()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean Validateidpswd(String username , String password){
        DB = getWritableDatabase();
        Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + username + "' AND stu_pswd='"+ password +"'", null);
        if(cr.getCount()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public String ConstructData (Cursor cr) {
        DB = getWritableDatabase();
        StringBuilder str = new StringBuilder();
        int srchdisplay=1;
        while (cr.moveToNext()) {
            //int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            String s3 = cr.getString(3);
            String s4 = cr.getString(4);
            String s5 = cr.getString(5);
            String s6 = cr.getString(6);
            String s7 = cr.getString(7);
            String s8 = cr.getString(8);
            String s9 = cr.getString(9);
            String s10 = cr.getString(10);
            String s11 = cr.getString(11);
            String s12 = cr.getString(12);

            str.append("Student number " + srchdisplay + "\n" + "First Name = " + s1 + "\nMiddle Name = " + s2 + "\nLast Name = " + s3 + "\nE-mail = " + s4 + "\nPassword = " + s5 + "\nAge = " + s6 + "\nGender = " + s7 + "\nAddress = " + s8 + "\nDOB = " + s9 + "\nPUC " + s12 + " = " + s10 + "\nPUC Name = " + s11 + "\n" + "\n");
            srchdisplay++;
        }
        return str.toString();
    }
    public void InclusiveSearch(String fname,String mname,String lname,String email,String age,String address,String dob,String pucp,String pucn,String gender, String porgpa){
        StringBuilder srchstr = new StringBuilder();
        String srchfname="";
        String srchmname="";
        String srchlname="";
        String srchemail="";
        String srchage="";
        String srchaddress="";
        String srchdob="";
        String srchpucp="";
        String srchpucn="";
        String srchgender="";
        String srchporgpa="";
        if(!TextUtils.isEmpty(fname)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_fstname='" + fname + "'", null);
            srchfname=ConstructData(cr);

        }
        if(!TextUtils.isEmpty(mname)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_midname='" + mname + "'", null);
            srchmname=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(lname)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_lstname='" + lname + "'", null);
            srchlname=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(email)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + email + "'", null);
            srchemail=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(age)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_age='" + age + "'", null);
            srchage=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(address)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_add='" + address + "'", null);
            srchaddress=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(dob)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_dob='" + dob + "'", null);
            srchdob=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(pucp)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_pucp='" + pucp + "'", null);
            srchpucp=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(pucn)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_pucn='" + pucn + "'", null);
            srchpucn=ConstructData(cr);
        }
        if(!(gender==null)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_gender='" + gender + "'", null);
            srchgender=ConstructData(cr);
        }
        if(!(porgpa==null)){
            DB = getWritableDatabase();
            Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_porgpa='" + porgpa + "'", null);
            srchporgpa=ConstructData(cr);
        }
        if(!TextUtils.isEmpty(srchfname)){
            srchstr.append("The details of the students with first name "+fname+" are :-\n"+srchfname);
        }
        if(!TextUtils.isEmpty(srchmname)){
            srchstr.append("The details of the students with middle name "+mname+" are :-\n"+srchmname);
        }
        if(!TextUtils.isEmpty(srchlname)){
            srchstr.append("The details of the students with last name "+lname+" are :-\n"+srchlname);
        }
        if(!TextUtils.isEmpty(srchemail)){
            srchstr.append("The details of the student with email "+email+" is :-\n"+srchemail);
        }
        if(!TextUtils.isEmpty(srchage)){
            srchstr.append("The details of the student with age "+age+" are :-\n"+srchage);
        }
        if(!TextUtils.isEmpty(srchaddress)){
            srchstr.append("The details of the students with address "+address+" are :-\n"+srchaddress);
        }
        if(!TextUtils.isEmpty(srchdob)){
            srchstr.append("The details of the students with Date of Birth "+dob+" are :-\n"+srchdob);
        }
        if(!TextUtils.isEmpty(srchpucp)){
            srchstr.append("The details of the students with PUC CGPA/Percentage "+pucp+" are :-\n"+srchpucp);
        }
        if(!TextUtils.isEmpty(srchpucn)){
            srchstr.append("The details of the students with PUC name "+pucn+" are :-\n"+srchpucn);
        }
        if(!TextUtils.isEmpty(srchgender)){
            srchstr.append("The details of the students with gender "+gender+" are :-\n"+srchgender);
        }
        if(!TextUtils.isEmpty(srchporgpa)){
            srchstr.append("The details of the students evaluated in "+porgpa+" are :-\n"+srchporgpa);
        }
        {
            if(TextUtils.isEmpty(srchstr.toString())){
                Intent i5 = new Intent(ctx, DisplayRegistrationDetails.class);
                i5.putExtra("User", "*****Sorry no such entries found*****");
                ctx.startActivity(i5);
            }
            else{
                Intent i5 = new Intent(ctx, DisplayRegistrationDetails.class);
                i5.putExtra("User", srchstr.toString());
                ctx.startActivity(i5);
        }
        }
    }
    public void ExclusiveSearch(String [] srchdetails){
        String exclusivesrchdisplay;
        StringBuilder strcommand=new StringBuilder();
        String cmdinitials="Select * from " + DB_TABLE + " Where ";
        strcommand.append(cmdinitials);
        int chosewhereorend=1;
        String srchfname=srchdetails[0];
        String srchmname=srchdetails[1];
        String srchlname=srchdetails[2];
        String srchemail=srchdetails[3];
        String srchage=srchdetails[4];
        String srchaddress=srchdetails[5];
        String srchdob=srchdetails[6];
        String srchpucp=srchdetails[7];
        String srchpucn=srchdetails[8];
        String srchgender=srchdetails[9];
        String srchporgpa=srchdetails[10];
        if(!TextUtils.isEmpty(srchdetails[0])){
            strcommand.append("stu_fstname='");
            strcommand.append(srchfname);
            strcommand.append("'");
            chosewhereorend=0;
        }
        if(!TextUtils.isEmpty(srchdetails[1])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_midname='");
                strcommand.append(srchmname);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_midname='");
                strcommand.append(srchmname);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[2])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_lstname='");
                strcommand.append(srchlname);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_lstname='");
                strcommand.append(srchlname);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[3])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_email='");
                strcommand.append(srchemail);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_email='");
                strcommand.append(srchemail);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[4])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_age='");
                strcommand.append(srchage);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_age='");
                strcommand.append(srchage);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[5])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_add='");
                strcommand.append(srchaddress);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_add='");
                strcommand.append(srchaddress);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[6])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_dob='");
                strcommand.append(srchdob);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_dob='");
                strcommand.append(srchdob);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[7])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_pucp='");
                strcommand.append(srchpucp);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_pucp='");
                strcommand.append(srchpucp);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[8])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_pucn='");
                strcommand.append(srchpucn);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_pucn='");
                strcommand.append(srchpucn);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[9])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_gender='");
                strcommand.append(srchgender);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_gender='");
                strcommand.append(srchgender);
                strcommand.append("'");
                chosewhereorend=0;
            }
        }
        if(!TextUtils.isEmpty(srchdetails[10])){
            if(chosewhereorend==0){
                strcommand.append(" AND stu_porgpa='");
                strcommand.append(srchporgpa);
                strcommand.append("'");
            }
            else{
                strcommand.append("stu_porgpa='");
                strcommand.append(srchporgpa);
                strcommand.append("'");
            }
        }
        DB = getWritableDatabase();
        Cursor cr = DB.rawQuery(strcommand.toString(), null);
        exclusivesrchdisplay=ConstructData(cr);
        {
            if(TextUtils.isEmpty(exclusivesrchdisplay)){

                Intent i5 = new Intent(ctx, DisplayRegistrationDetails.class);
                i5.putExtra("User", "*****Sorry no such entries found*****");
                ctx.startActivity(i5);
            }

            else{
                Intent i5 = new Intent(ctx, DisplayRegistrationDetails.class);
                i5.putExtra("User", exclusivesrchdisplay);
                ctx.startActivity(i5);
            }

        }

    }
    public void setnav (String email,TextView name,TextView dob,TextView pucn ){
        DB = getWritableDatabase();
        Cursor cr = DB.rawQuery("Select * from " + DB_TABLE + " Where stu_email='" + email + "'", null);
        StringBuilder str = new StringBuilder();
        while (cr.moveToNext()) {
            //int id = cr.getInt(0);
            String firstnm = cr.getString(1);
            String milname = cr.getString(2);
            String lstnm = cr.getString(3);
            String eml = cr.getString(4);
            String dobs = cr.getString(9);
            String pucnam = cr.getString(11);
            name.setText(firstnm+" "+milname+" "+lstnm);
            dob.setText(dobs);
            pucn.setText(pucnam);

        }
    }

}


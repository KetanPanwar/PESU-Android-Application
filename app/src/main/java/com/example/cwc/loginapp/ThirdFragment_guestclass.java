package com.example.cwc.loginapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment_guestclass extends Fragment {
    View myview;
    TextView namea,pucnam,dobin;
    EditText fillemail;
    MyUsersDetails myData;
    Login_page lipg;


    public ThirdFragment_guestclass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.third_layout_guestpage, container, false);
        myData=new MyUsersDetails(getActivity());
        lipg=new Login_page();
        namea=(TextView)myview.findViewById(R.id.namprofile);
        pucnam=(TextView)myview.findViewById(R.id.pucnprofile);
        dobin=(TextView)myview.findViewById(R.id.dobprofile);
        fillemail=(EditText) myview.findViewById(R.id.emailprofile);
        /*Bundle b1 = getArguments().getBundle("EXTRA_USERNAME");
        String gteml=b1.toString();
        String gteml = getArguments().getString("EXTRA_USERNAME");
        String getdob = getArguments().getString("EXTRA_DOB");
        String getnm = getArguments().getString("EXTRA_NAME");
        String getpucn = getArguments().getString("EXTRA_PUCN");
        namea.setText(getnm);
        pucnam.setText(getpucn);
        dobin.setText(getdob);
        fillemail.setText("ketan123@yahoo.com");*/
        Login_page activity = (Login_page) getActivity();
        String recvdemail = activity.getMyData();
        //String recvdemail=lipg.getMyData();
       // namea.setText(data[2]);
        //pucnam.setText(data[3]);
        dobin.setText("done");
        fillemail.setText(recvdemail);
        myData.setnav(recvdemail,namea,dobin,pucnam);




        // Inflate the layout for this fragment
        return myview;
    }

    public void chngpswdprofile(View view) {
    }

    public void logoutfromprofile(View view) {
    }

    public void udateprofile(View view) {
    }
}

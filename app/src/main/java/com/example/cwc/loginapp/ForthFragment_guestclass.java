package com.example.cwc.loginapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForthFragment_guestclass extends Fragment {
    View myview;


    public ForthFragment_guestclass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.fourth_layout_guestpage, container, false);
        // Inflate the layout for this fragment
        return myview;
    }

}

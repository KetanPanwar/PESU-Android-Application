package com.example.cwc.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Login_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView nnamenav,ndobnav,npucnamenav,nemailnav;
    String recvdeml;
    MyUsersDetails myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myData=new MyUsersDetails(this);
        Bundle b1 = getIntent().getExtras();
        recvdeml = b1.getString("User");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setBackgroundColor(getResources().getColor(R.color.mywhitecolor));//for colors of layouts
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//in this go to activity_login_page and change background of nav_view
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        nnamenav=(TextView)header.findViewById(R.id.namenav);
        ndobnav=(TextView)header.findViewById(R.id.dobnav);
        npucnamenav=(TextView)header.findViewById(R.id.pucnamenav);
        nemailnav=(TextView)header.findViewById(R.id.emailnav);
        nemailnav.setText(recvdeml);
        myData.setnav(recvdeml,nnamenav,ndobnav,npucnamenav);

        /*Intent i5 = new Intent(this, ThirdFragment_guestclass.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_USERNAME",nemailnav.getText().toString());
        extras.putString("EXTRA_DOB",ndobnav.getText().toString());
        extras.putString("EXTRA_NAME",nnamenav.getText().toString());
        extras.putString("EXTRA_PUCN",npucnamenav.getText().toString());
        i5.putExtras(extras);
        ThirdFragment_guestclass fragobj = new ThirdFragment_guestclass();
        fragobj.setArguments(extras);
        //startActivity(i5);*/
    }
    public String  getMyData() {
        //String [] myString={"hello","hey"};//{nemailnav.getText().toString(),ndobnav.getText().toString(),nnamenav.getText().toString(),npucnamenav.getText().toString()};
        return recvdeml;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();


        if (id == R.id.myacadamics) {
            fm.beginTransaction().replace(R.id.Content_frame,new FirstFragment_guestclass()).commit();
            // Handle the camera action
        } else if (id == R.id.cie) {
            fm.beginTransaction().replace(R.id.Content_frame,new SecondFragment_guestclass()).commit();

        } else if (id == R.id.myprofile) {
            fm.beginTransaction().replace(R.id.Content_frame,new ThirdFragment_guestclass()).commit();

        } else if (id == R.id.announcements) {
            fm.beginTransaction().replace(R.id.Content_frame,new ForthFragment_guestclass()).commit();

        }else if (id == R.id.calandar) {
            fm.beginTransaction().replace(R.id.Content_frame,new FifthFragment_guestclass()).commit();

        }
        else if (id == R.id.notification) {
            fm.beginTransaction().replace(R.id.Content_frame,new sixthFragment_guestclass()).commit();

        }else if (id == R.id.pesuniversity) {
            fm.beginTransaction().replace(R.id.Content_frame,new SeventhFragment_guestclass()).commit();

        }else if (id == R.id.settings) {
            fm.beginTransaction().replace(R.id.Content_frame,new EighthFragment_guestclass()).commit();

        }else if (id == R.id.help) {
            fm.beginTransaction().replace(R.id.Content_frame,new ForthFragment_guestclass()).commit();

        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openURL(View view) {
        Uri u= Uri.parse("https://fb.com");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);

    }

    public void call(View view) {

        Uri u=Uri.parse("tel:9841517819");
        Intent i=new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void myLocation(View view) {


        // To Zoom
        // Uri mapuri = Uri.parse("geo:16.4649,80.5078?z=21");
        //To search nearby locations
        // Uri mapuri = Uri.parse("geo:16.4649,80.5078?q=restaurents");
        // Adding a marker
        // Uri mapuri = Uri.parse("geo:16.4649,80.5078?q=<16.4649>,<80.5078>");
        Uri mapuri = Uri.parse("geo:0,0?q=restaurents");
        Intent mapsIntent =new Intent(Intent.ACTION_VIEW,mapuri);
        mapsIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapsIntent);

    }
}
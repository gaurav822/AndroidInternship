package com.example.gettingdevicelocationdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView);
        client= LocationServices.getFusedLocationProviderClient(this);

    }

    public void getLocationDetails(View view) {

        getDeviceDetails();

    }

    private void getDeviceDetails() {
        client.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location=task.getResult();
                Geocoder geocoder=new Geocoder(MainActivity.this, Locale.getDefault());
                try {
                    List<Address> list=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                    String latitude=String.valueOf(list.get(0).getLatitude());
                    String longitude=String.valueOf(list.get(0).getLongitude());
                    String countryname=String.valueOf(list.get(0).getCountryName());
                    String locality=String.valueOf(list.get(0).getLocality());
                    String postalcode=String.valueOf(list.get(0).getPostalCode());
                    String addressLine=String.valueOf(list.get(0).getAddressLine(0));

                    tv.setText(latitude+","+longitude+"\n"
                    +countryname+"\n"+
                            locality+"\n"+postalcode+"\n"+addressLine);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
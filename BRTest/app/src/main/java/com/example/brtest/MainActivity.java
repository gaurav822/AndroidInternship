package com.example.brtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyReceiver receiver;
    IntentFilter filter;

    public static final String MY_CUSTOM_ACTION="com.example.brtest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver=new MyReceiver();
        filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(receiver,filter);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(receiver,
                        new IntentFilter(MY_CUSTOM_ACTION));

    }

    public void sendCustomBr(View view) {

        Intent i= new Intent(MY_CUSTOM_ACTION);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);

    }
}
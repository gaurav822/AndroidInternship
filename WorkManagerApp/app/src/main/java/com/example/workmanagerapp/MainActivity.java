package com.example.workmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    OneTimeWorkRequest workRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workRequest=new OneTimeWorkRequest.Builder(FirstWork.class).build();
    }

    public void Submit(View view){

        WorkManager.getInstance(this).enqueue(workRequest);
    }
}
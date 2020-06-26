package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.countInc);
        tv=(TextView) findViewById(R.id.textCount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Action
                a++;
                tv.setText(""+a);
            }
        });

        if(savedInstanceState!=null){
            String s= savedInstanceState.getString("gaurav");
            a=Integer.parseInt(s);
            tv.setText(""+a);

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("gaurav",tv.getText().toString());
    }

    public void display(View view) {
        //Action
        Toast.makeText(this,"Welcome to my Application",Toast.LENGTH_SHORT).show();

    }
}
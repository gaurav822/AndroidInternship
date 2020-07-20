package com.example.roomlivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText rollnumber,uname,mailid,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        rollnumber=(EditText) findViewById(R.id.rollnumber);
        uname=(EditText) findViewById(R.id.name);
        mailid=(EditText) findViewById(R.id.mailid);
        phone=(EditText) findViewById(R.id.phonenumber);
    }

    public void save(View view) {


            String roll = rollnumber.getText().toString();
            String name=uname.getText().toString();
            String mail=mailid.getText().toString();
            String mobile=phone.getText().toString();

            Student student =new Student();
            student.setRollNumber(roll);
            student.setName(name);
            student.setMailID(mail);
            student.setPhoneNumber(mobile);

//            MainActivity.database.myDao().insert(student);

            MainActivity.viewModel.insert(student);

            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

            finish();

    }
}
package com.example.inputcontrolstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String gender;

    EditText et_name,et_mobile,et_email,et_password;
    TextView tv;

    RadioButton r_male,r_female;
    CheckBox ch_android,ch_python,ch_java;
    Spinner sp_districts,sp_mandals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=(EditText) findViewById(R.id.name);
        et_mobile = (EditText) findViewById(R.id.mobile);
        tv=(TextView) findViewById(R.id.result);
        et_email=(EditText) findViewById(R.id.email);
        et_password=(EditText)findViewById(R.id.password);
        r_male=(RadioButton) findViewById(R.id.male);
        r_female=(RadioButton) findViewById(R.id.female);
        ch_android=(CheckBox) findViewById(R.id.android);
        ch_python=(CheckBox) findViewById(R.id.python);
        ch_java=(CheckBox) findViewById(R.id.java);
        sp_districts=(Spinner) findViewById(R.id.district);
        sp_mandals=(Spinner)findViewById(R.id.mandal);
        tv=(TextView) findViewById(R.id.result);

        ArrayAdapter<CharSequence> districtAdapter=ArrayAdapter.createFromResource(this,R.array.districts,android.R.layout.simple_spinner_item);
        sp_districts.setAdapter(districtAdapter);

        sp_districts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:
                        Toast.makeText(MainActivity.this,"Please Select District",Toast.LENGTH_SHORT).show();

                    case 1:
                        ArrayAdapter<CharSequence> lalitmandals=ArrayAdapter.createFromResource(MainActivity.this,R.array.Lalitpur_Mandals,android.R.layout.simple_spinner_item);
                        sp_mandals.setAdapter(lalitmandals);
                        break;

                    case 2:
                        ArrayAdapter<CharSequence> kathmandals =ArrayAdapter.createFromResource(MainActivity.this,R.array.Kathmandu_Mandals,android.R.layout.simple_spinner_item);
                        sp_mandals.setAdapter(kathmandals);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void submit(View view) {
        String name=et_name.getText().toString();
        String mobile=et_mobile.getText().toString();
        String email=et_email.getText().toString();
        String pass=et_password.getText().toString();
        String SelectedDistrict=sp_districts.getSelectedItem().toString();
        String SelectedMandal=sp_mandals.getSelectedItem().toString();


        if(r_male.isChecked()){

            gender=r_male.getText().toString();

        }

        if(r_female.isChecked()){

            gender=r_female.getText().toString();
        }

        StringBuilder builder=new StringBuilder();

        if(ch_java.isChecked()){

            builder.append(ch_java.getText().toString()+",");
        }

        if(ch_android.isChecked()){

            builder.append(ch_android.getText().toString()+",");
        }

        if(ch_python.isChecked()){

            builder.append(ch_python.getText().toString());
        }

        tv.setText(name+"\n"+mobile+"\n"+email+"\n"+pass+"\n"+gender+"\n"+builder.toString()+"\n"+SelectedDistrict+"\n"+SelectedMandal);

    }
}
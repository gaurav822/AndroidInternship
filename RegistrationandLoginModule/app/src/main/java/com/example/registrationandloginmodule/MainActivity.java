package com.example.registrationandloginmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,email,userName,pass;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    List<User> usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        name=findViewById ( R.id.name );
        email=findViewById ( R.id.emailid );
        userName=findViewById ( R.id.username );
        pass=findViewById ( R.id.password );
        usersList=new ArrayList<>();

        firebaseDatabase=FirebaseDatabase.getInstance ();
        reference=firebaseDatabase.getReference ();
    }

    public void register(View view) {

        final String n=name.getText ().toString ();
        final String mail=email.getText ().toString ();
        final String usern=userName.getText ().toString ();
        final String p=pass.getText ().toString ();

        reference.child ("Users").addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren ()){
                    User u =dataSnapshot.getValue (User.class);
                    usersList.add (u);

                }

                Log.i("Size",""+usersList.size ());
                if(usersList.size () !=0){
                    int count=0;
                    for (int i=0;i<usersList.size ();i++){
                        if((usern.equals ( usersList.get(i).getUsername()))){
                            Toast.makeText ( MainActivity.this,"The username already exists",Toast.LENGTH_SHORT ).show ();
                        }else{
                            count++;
                        }
                    }
                    if(count==usersList.size ()){
                        User u=new User(n,mail,usern,p);
                        reference.child ( "Users" ).push ().setValue ( u ).addOnSuccessListener ( new OnSuccessListener<Void> () {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText ( MainActivity.this,"Registration Successful!",Toast.LENGTH_SHORT ).show ();
                            }
                        } );
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void openloginPage(View view) {
        Intent i =new Intent ( this,LoginActivity.class );
        startActivity ( i );
    }
}


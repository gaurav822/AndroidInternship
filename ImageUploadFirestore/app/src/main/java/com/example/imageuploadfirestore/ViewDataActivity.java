package com.example.imageuploadfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity {

    RecyclerView rv;

    FirebaseDatabase database;
    DatabaseReference reference;

    List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        rv=(RecyclerView) findViewById(R.id.recycler);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();

        list=new ArrayList<>();

        reference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    User u = dataSnapshot.getValue(User.class);
                    list.add(u);

//                    Log.i("DATA",u.getName()+"\n");
//                    Log.i("DATA",u.getMobileno()+"\n");
//                    Log.i("DATA",u.getFilelocation()+"\n");
                }
                rv.setLayoutManager(new LinearLayoutManager(ViewDataActivity.this));
                rv.setAdapter(new MyAdapter(ViewDataActivity.this,list));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
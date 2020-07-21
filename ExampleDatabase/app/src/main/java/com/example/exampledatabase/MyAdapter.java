package com.example.exampledatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context ct;
    ArrayList<Pojo> list;
    public MyAdapter(MainActivity mainActivity, ArrayList<Pojo> list) {
        ct=mainActivity;
        this.list=list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));

    }

    @Override

    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        holder.tv.setText(list.get(position).getUname());
        holder.tv1.setText(list.get(position).getUnumber());
        holder.tv2.setText(list.get(position).getUroll());
        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To delete from Firebase
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("UserDetails");
                reference.child(list.get(position).uroll).removeValue();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv,tv1,tv2;
        ImageButton ib;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            ib=itemView.findViewById(R.id.del);

        }
    }
}

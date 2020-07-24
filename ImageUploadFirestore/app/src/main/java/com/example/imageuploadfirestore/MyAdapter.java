package com.example.imageuploadfirestore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context ct;
    List<User> list;
    public MyAdapter(ViewDataActivity viewDataActivity, List<User> list) {
        ct=viewDataActivity;
        this.list=list;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.row,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, int position) {

        User user=list.get(position);
        Glide.with(ct).load(user.getFilelocation()).into(holder.myiv);
        holder.tv1.setText(user.getName());
        holder.tv2.setText(user.getMobileno());

        holder.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile=holder.tv2.getText().toString();
                Uri u= Uri.parse("tel:"+mobile);
                Intent intent=new Intent(Intent.ACTION_DIAL,u);

                ct.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myiv;
        TextView tv1,tv2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myiv=itemView.findViewById(R.id.iv);
            tv1=itemView.findViewById(R.id.name);
            tv2=itemView.findViewById(R.id.mobile);
        }
    }
}

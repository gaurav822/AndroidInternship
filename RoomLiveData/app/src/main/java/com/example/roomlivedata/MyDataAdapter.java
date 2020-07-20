package com.example.roomlivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyDataViewHolder> {

    Context ct;
    List<Student> list;

    public MyDataAdapter(MainActivity mainActivity, List<Student> studentList) {

        ct=mainActivity;
        list=studentList;
    }

    @NonNull
    @Override
    public MyDataAdapter.MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(ct).inflate(R.layout.row_design,parent,false);
        return new MyDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.MyDataViewHolder holder, int position) {

        final Student student = list.get(position);
        holder.rroll.setText(student.getRollNumber());
        holder.rname.setText(student.getName());
        holder.rmail.setText(student.getMailID());
        holder.rmobile.setText(student.getPhoneNumber());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MainActivity.database.myDao().delete(student);
                MainActivity.viewModel.delete(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyDataViewHolder extends RecyclerView.ViewHolder {

        TextView rname,rroll,rmail,rmobile;
        ImageView delete,edit;

        public MyDataViewHolder(@NonNull View itemView) {
            super(itemView);
            rname=(TextView) itemView.findViewById(R.id.readName);
            rroll=(TextView) itemView.findViewById(R.id.readRoll);
            rmail=(TextView) itemView.findViewById(R.id.readmailid);
            rmobile=(TextView) itemView.findViewById(R.id.readmobile);

            delete=(ImageView) itemView.findViewById(R.id.delete);
            edit =(ImageView) itemView.findViewById(R.id.edit);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*Access Data from TextViews*/

                    final String name = rname.getText().toString();
                    final String roll = rroll.getText().toString();
                    final String mail = rmail.getText().toString();
                    final String mobile = rmobile.getText().toString();

                    ViewGroup viewGroup= view.findViewById(android.R.id.content);

                    View v =LayoutInflater.from(ct).inflate(R.layout.updatedata,viewGroup,false);

                    final EditText uname= v.findViewById(R.id.updatename);
                    final EditText uroll= v.findViewById(R.id.updaterollnumber);
                    final EditText umail= v.findViewById(R.id.updatemailid);
                    final EditText umobile= v.findViewById(R.id.updatemobilenumber);


                    Button update=v.findViewById(R.id.updatedata);
                    Button cancel=v.findViewById(R.id.canceldata);

                    final BottomSheetDialog dialog=new BottomSheetDialog(ct);
                    dialog.setContentView(v);
                    dialog.setCancelable(false);

                    uroll.setText(roll);
                    uname.setText(name);
                    umobile.setText(mobile);
                    umail.setText(mail);


                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            Student student=new Student();
                            student.setMailID(umail.getText().toString());
                            student.setName(uname.getText().toString());
                            student.setRollNumber(uroll.getText().toString());
                            student.setPhoneNumber(umobile.getText().toString());

                            MainActivity.viewModel.update(student);
                            Toast.makeText(ct, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();


                        }
                    });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();



                }
            });



        }
    }
}


package com.example.hanad.greenflagassignment1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanad.greenflagassignment1.model.CustomerModel;

import java.util.ArrayList;

/**
 * Created by hanad on 05/02/2018.
 *
 * Steps to follow:
 * 1. initialize the objects in the constructor
 * 2. Create Innter ViewHolder class
 * 2.1. MyViewHolder extend RecyclerView.ViewHolder
 */

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>{

    private Context applicationContext;
    private int row_customer;
    private  ArrayList<CustomerModel> arrayList;

    public PersonAdapter(Context applicationContext, int row_customer, ArrayList<CustomerModel> arrayList) {
        this.applicationContext = applicationContext;
        this.arrayList = arrayList;
        this.row_customer = row_customer;
    }

    /**
     * Load the row layout
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_customer,parent,false));

    }

    /**
     * Load data into individual UI
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mName.setText(arrayList.get(position).getName());
        holder.mUsername.setText(arrayList.get(position).getUsername());
        holder.mPassword.setText(arrayList.get(position).getPassword());
        holder.mAge.setText(arrayList.get(position).getAge());
        holder.mBirthday.setText(arrayList.get(position).getBirthday());

        holder.callItemClick(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Toast.makeText(applicationContext, arrayList.get(position).getName(),Toast.LENGTH_LONG).show();
                Toast.makeText(applicationContext, arrayList.get(position).getUsername(),Toast.LENGTH_LONG).show();
                Toast.makeText(applicationContext, arrayList.get(position).getPassword(),Toast.LENGTH_LONG).show();
                Toast.makeText(applicationContext, arrayList.get(position).getAge(),Toast.LENGTH_LONG).show();
                Toast.makeText(applicationContext, arrayList.get(position).getBirthday(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mName;
        private TextView mUsername;
        private TextView mPassword;
        private TextView mAge;
        private TextView mBirthday;



        private ItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.mName);
            mUsername = itemView.findViewById(R.id.mUsername);
            mPassword = itemView.findViewById(R.id.mPassword);
            mAge = itemView.findViewById(R.id.mAge);
            mBirthday = itemView.findViewById(R.id.mBirthday);

            itemView.setOnClickListener(this);
        }

    public void callItemClick(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
        @Override
        public void onClick(View view) {
            itemClickListener.OnClick(view,getPosition());
        }
    }
}

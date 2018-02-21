//package com.example.hanad.greenflagassignment1;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.hanad.greenflagassignment1.model.AccountCustomerModel;
//
//import java.util.ArrayList;
//
///**
// * Created by hanad on 05/02/2018.
// *
// * Steps to follow:
// * 1. initialize the objects in the constructor
// * 2. Create Innter ViewHolder class
// * 2.1. MyViewHolder extend RecyclerView.ViewHolder
// */
//
//class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder>{
//
//    private Context applicationContext;
//    private int row_customer;
//    private  ArrayList<AccountCustomerModel> accountCustomerModelArrayList;
//
//    public AccountAdapter(Context applicationContext, int row_customer, ArrayList<AccountCustomerModel> accountCustomerModelArrayList) {
//        this.applicationContext = applicationContext;
//        this.accountCustomerModelArrayList = accountCustomerModelArrayList;
//        this.row_customer = row_customer;
//    }
//
//    /**
//     * Load the row layout
//     * @param parent
//     * @param viewType
//     * @return
//     */
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_customer,parent,false));
//
//    }
//
//    /**
//     * Load data into individual UI
//     * @param holder
//     * @param position
//     */
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.mEmail.setText(accountCustomerModelArrayList.get(position).getEmail());
//        holder.mRepeatPassword.setText(accountCustomerModelArrayList.get(position).getRepeatPassword());
//
//        holder.callItemClick(new ItemClickListener() {
//            @Override
//            public void OnClick(View view, int position) {
//                Toast.makeText(applicationContext, accountCustomerModelArrayList.get(position).getEmail(),Toast.LENGTH_LONG).show();
//                Toast.makeText(applicationContext, accountCustomerModelArrayList.get(position).getRepeatPassword(),Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return accountCustomerModelArrayList.size();
//
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        private TextView mRepeatPassword;
//        private TextView mEmail;
//
//
//
//        private ItemClickListener itemClickListener;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            mRepeatPassword = itemView.findViewById(R.id.mRepeatPassword);
//            mEmail = itemView.findViewById(R.id.mEmail);
//
//
//
//            itemView.setOnClickListener(this);
//        }
//
//    public void callItemClick(ItemClickListener itemClickListener){
//        this.itemClickListener=itemClickListener;
//    }
//        @Override
//        public void onClick(View view) {
//            itemClickListener.OnClick(view,getPosition());
//        }
//    }
//}

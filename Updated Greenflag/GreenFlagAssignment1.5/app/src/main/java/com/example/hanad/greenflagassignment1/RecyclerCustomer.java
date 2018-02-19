package com.example.hanad.greenflagassignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import com.example.hanad.greenflagassignment1.controller.RealmHelper;
import com.example.hanad.greenflagassignment1.model.AccountCustomerModel;
import com.example.hanad.greenflagassignment1.model.CustomerModel;

import java.util.ArrayList;

import io.realm.Realm;

public class RecyclerCustomer extends AppCompatActivity {
    private Realm realm,realm2;
    private RealmHelper realmHelper;
    private ArrayList<CustomerModel> arrayList;
    private ArrayList<AccountCustomerModel> customerModelArrayList;
    ArrayList<String> stringArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_customer);

        initRealm();
        initRecyclerView();

    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.rvCustomer);
        //how should i display the items

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(new PersonAdapter(getApplicationContext(),R.layout.row_customer,arrayList));
        //recyclerView.setAdapter(new AccountAdapter(getApplicationContext(),R.layout.row_customer,customerModelArrayList));

    }

    public void initRealm(){
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);

        arrayList = new ArrayList<>();
        arrayList= realmHelper.getCustomerModels();

       // realm2= Realm.getDefaultInstance();
      //  realmHelper = new RealmHelper(realm2);
        //customerModelArrayList = new ArrayList<>();
        //customerModelArrayList= realmHelper.getAccountCustomerModels();

    }

}

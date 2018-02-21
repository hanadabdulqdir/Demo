package com.example.hanad.greenflagassignment1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import io.realm.Realm;

import com.example.hanad.greenflagassignment1.controller.RealmHelper;
//import com.example.hanad.greenflagassignment1.model.AccountCustomerModel;
import com.example.hanad.greenflagassignment1.model.CustomerModel;

public class DisplayContent extends ListActivity {
    private Realm realm;
    private RealmHelper realmHelper;

    private ArrayList<CustomerModel> arrayList;

    //private ArrayList<AccountCustomerModel> customerModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recycler_customer);

        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        arrayList = new ArrayList<>();
        arrayList = realmHelper.getCustomerModels();

        /**
         * Get model
         * put the model in the adapter
         * assign the adapter to the view
         *
         */
        ArrayAdapter<CustomerModel> arrayAdapter = new ArrayAdapter<CustomerModel>(
                DisplayContent.this,
                android.R.layout.simple_list_item_1,arrayList);

        getListView().setAdapter(arrayAdapter);

        /**
         *
         */

//        customerModelArrayList = new ArrayList<>();
//        customerModelArrayList = realmHelper.getAccountCustomerModels();
//
//        ArrayAdapter<AccountCustomerModel> arrayAccountAdapter = new ArrayAdapter<AccountCustomerModel>(
//                DisplayContent.this,
//                android.R.layout.simple_list_item_2);
//
//        getListView().setAdapter(arrayAccountAdapter);


    }
}

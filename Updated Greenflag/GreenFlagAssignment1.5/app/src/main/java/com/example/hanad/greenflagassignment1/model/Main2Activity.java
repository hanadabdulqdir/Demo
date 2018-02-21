package com.example.hanad.greenflagassignment1.model;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.hanad.greenflagassignment1.controller.RealmHelper;

import java.util.ArrayList;

import io.realm.Realm;

public class Main2Activity extends ListActivity {
    private Realm realm;
    private RealmHelper realmHelper;
    private ArrayList<CustomerModel> arrayList;
    ArrayList<String> stringArrayList;
    //private ArrayList<AccountCustomerModel> accountArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main2);

        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
        arrayList = new ArrayList<>();
        arrayList = realmHelper.getCustomerModels();
        stringArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {

            stringArrayList.add(arrayList.get(i).getName());
            stringArrayList.add(arrayList.get(i).getUsername());
            stringArrayList.add(arrayList.get(i).getPassword());
            stringArrayList.add(arrayList.get(i).getAge());
            stringArrayList.add(arrayList.get(i).getBirthday());
            stringArrayList.add(arrayList.get(i).getCountry());
            stringArrayList.add(arrayList.get(i).getImage());
            stringArrayList.add(arrayList.get(i).getRadio());
        }

        /**
         * Get Model
         * Put the model in the Adapter
         * Assign the adapter to the view
         */

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                Main2Activity.this,
                android.R.layout.simple_list_item_1,
                stringArrayList);
        getListView().setAdapter(arrayAdapter);

    }

}
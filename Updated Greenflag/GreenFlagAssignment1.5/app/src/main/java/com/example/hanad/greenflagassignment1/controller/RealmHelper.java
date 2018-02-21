package com.example.hanad.greenflagassignment1.controller;

/**
 * Created by hanad on 02/02/2018.
 */

import com.example.hanad.greenflagassignment1.model.CustomerModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 1.Initialize Realm & Create a constructor
 * 2. Create method for customer model
 * 3.
 */
public class RealmHelper {
    Realm realm;


    public RealmHelper(Realm realm) {
        this.realm = realm;
    }


    public void saveCustomer(final CustomerModel customerModel) {

        //asyncr
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(customerModel);
            }
        });
    }

    public ArrayList<CustomerModel> getCustomerModels() {
        ArrayList<CustomerModel> customerModelsArrayList = new ArrayList<>();

        RealmResults<CustomerModel> realmResults = realm.where(CustomerModel.class).findAll();

        for (CustomerModel customerModel : realmResults) {

            customerModelsArrayList.add(customerModel);
        }
        return customerModelsArrayList;
    }

}
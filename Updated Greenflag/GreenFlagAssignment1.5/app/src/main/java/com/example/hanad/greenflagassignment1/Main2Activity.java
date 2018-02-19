package com.example.hanad.greenflagassignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hanad.greenflagassignment1.controller.RealmBackupRestore;
import com.example.hanad.greenflagassignment1.controller.RealmHelper;
import com.example.hanad.greenflagassignment1.model.CustomerModel;
import com.example.hanad.greenflagassignment1.model.AccountCustomerModel;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.Realm;

public class Main2Activity extends AppCompatActivity {
    EditText email;
    EditText repeatPassword;

    Realm realm2;
    RealmHelper realmHelper;
    RealmBackupRestore realmBackupRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Create an account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        initRealm();
        realmBackupRestore = new RealmBackupRestore(this);
    }

//    public static boolean isValidPassword( EditText password) {
//
//        Pattern pattern;
//        Matcher matcher;
//        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$".toString();
//        pattern = Pattern.compile(PASSWORD_PATTERN);
//        matcher = (Matcher) pattern.matcher((CharSequence) password).toMatchResult();
//
//        return matcher.matches();
//    }
//
//    public static boolean isValidEmail( EditText email) {
//        Pattern pattern;
//        Matcher matcher;
//        String EMAIL_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$".toString();
//        pattern = Pattern.compile(EMAIL_PATTERN);
//        //matcher = pattern.matcher((CharSequence) email).toString();
//        matcher = (Matcher) pattern.matcher((CharSequence) email).toMatchResult();
//
//        return matcher.matches();
//    }


    @SuppressLint("WrongViewCast")
    public void init() {
        email = findViewById(R.id.mEmail);
        repeatPassword = findViewById(R.id.mRepeatPassword);

//        if (repeatPassword.getText().toString().length() < 8 && !isValidPassword(repeatPassword)
//                && !isValidEmail(email))  {
//            System.out.println("Not Valid");
//
//            //allow next page to be accessed
//
//        } else {
//
//            System.out.println("Valid");
//
//        }


    }


    public void initRealm() {
        realm2 = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm2);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onSave(View view) {//onClick
        Intent myIntent = new Intent(this, Main3Activity.class);//DisplayContent
        startActivity(myIntent);

        AccountCustomerModel accountCustomerModel = new AccountCustomerModel(
                email.getText().toString(),
                repeatPassword.getText().toString()
        );

        realmHelper.saveAccountCustomer(accountCustomerModel);
        realmBackupRestore.backup();


    }

    public void onClick(View view) {
        Intent myIntent = new Intent(this, Main3Activity.class);
        startActivity(myIntent);
    }
}

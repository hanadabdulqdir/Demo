package com.example.hanad.greenflagassignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanad.greenflagassignment1.controller.RealmBackupRestore;
import com.example.hanad.greenflagassignment1.controller.RealmHelper;
import com.example.hanad.greenflagassignment1.model.CustomerModel;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
//import com.example.hanad.greenflagassignment1.model.AccountCustomerModel;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.Realm;

public class Main2Activity extends AppCompatActivity implements Validator.ValidationListener {

    @Email
    @NotEmpty(message = "Requires email")
    @Length(min = 5, max = 15, message = "Must be greater then 5 & less then 15 characters")
    EditText email;

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_MIXED_CASE_SYMBOLS, message = "Password required min 6 characters")
    EditText password;

    @ConfirmPassword
    EditText repeatPassword;
    Button button;

    Validator validator;

    Realm realm;
    RealmHelper realmHelper;
    RealmBackupRestore realmBackupRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Create an account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.mEmail);
        password = findViewById(R.id.password);
        repeatPassword = findViewById(R.id.repeatePassword);

        validator = new Validator(this);
        validator.setValidationListener(this);

        //init();
        initRealm();
        realmBackupRestore = new RealmBackupRestore(this);

    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    public void onValidate(View view) {//onClick
       // validator.validate(true);
        Log.i("Test","OnClick validation");
        Intent myIntent = new Intent(this, Main3Activity.class);
        startActivity(myIntent);

//         Button button = (Button)findViewById(R.id.button);
//         button.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 validator.validate(true);
//
//             }
//         });
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Correct details - Validated", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }


    public void initRealm() {
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
    }
}

// @SuppressLint("WrongViewCast")
//public void init() {

//        EditText email = (EditText)findViewById(R.id.mEmail);
//        if( email.getText().toString().length() == 0 )
//            email.setError( "Email is required!" );

//        email = findViewById(R.id.mEmail);
//        repeatPassword = findViewById(R.id.mRepeatPassword);
//}


//    private void intent() {
//        Intent myIntent = new Intent(this, Main3Activity.class);//DisplayContent
//        startActivity(myIntent);
//    }
//
//    button.setOnClickListener(new OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            validator.validate();
//        }
//    });

// realmHelper.saveAccountCustomer(accountCustomerModel);
//realmBackupRestore.backup();


//    public void onClick(View view) {
//        Intent myIntent = new Intent(this, Main3Activity.class);
//        startActivity(myIntent);
//    }


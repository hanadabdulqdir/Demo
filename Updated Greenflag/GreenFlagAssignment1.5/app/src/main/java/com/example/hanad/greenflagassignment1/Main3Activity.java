package com.example.hanad.greenflagassignment1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import io.realm.Realm;

import com.example.hanad.greenflagassignment1.controller.RealmBackupRestore;
import com.example.hanad.greenflagassignment1.controller.RealmHelper;
import com.example.hanad.greenflagassignment1.model.CustomerModel;


public class Main3Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextAge;
    TextView editBirthday;
    RadioGroup GengerRadioGroup;

    Realm realm;
    RealmHelper realmHelper;
    RealmBackupRestore realmBackupRestore;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    Button btn;
    private static final int CAMERA_REQUEST = 123;
    ImageView imageView;
    static final Integer CAMERA = 0x5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Enter Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        initRealm();
        realmBackupRestore = new RealmBackupRestore(this);

        //spinner country
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Country_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "Selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //end

        //Datepicker
        btn = (Button) findViewById(R.id.btnImageSearch);
        imageView = (ImageView) findViewById(R.id.uploadImage);

        Button button = (Button) findViewById(R.id.btnBirthday);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        //end

        GengerRadioGroup = findViewById(R.id.firstGroup);
        GengerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked(checkedId);
                //Toast.makeText(Main3Activity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(int checkedId) {
        // Is the button now checked?
        //boolean checked = ((RadioButton) view).isChecked();
        boolean checked = true;

        // Check which radio button was clicked
        switch(checkedId) {
            case R.id.radioButton:
                if (checked)
                    Toast.makeText(this, "Selected Male ", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(this, "Selected Female ", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButton3:
                if (checked)
                    Toast.makeText(this, "Not Specified ", Toast.LENGTH_SHORT).show();
                    break;
        }
//        String currentSelected = onRadioButtonClicked(checkedId);
//        TextView currentSelceted = (TextView)findViewById(R.id.firstGroup);
//        currentSelceted.setText(currentSelected);
//        return currentSelected;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_WEEK, day);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.txtBirthday);
        textView.setText(currentDateString);
    }

    public void onClick(View view) {
        askForPermission(Manifest.permission.CAMERA, CAMERA);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);


       // onRadioButtonClicked(view);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(Main3Activity.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Main3Activity.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(Main3Activity.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(Main3Activity.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("WrongViewCast")
    public void init() {
        editTextName = findViewById(R.id.name);
        editTextUsername = findViewById(R.id.Username);
        editTextPassword = findViewById(R.id.password);
        editTextAge = findViewById(R.id.age);
        editBirthday = findViewById(R.id.txtBirthday);
        imageView=findViewById(R.id.uploadImage);
        spinner=findViewById(R.id.mCountry);
        GengerRadioGroup = findViewById(R.id.mRadio);

    }

    public void initRealm() {
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void SaveData(View view) {
        CustomerModel customerModel = new CustomerModel(
                editTextName.getText().toString(), editTextUsername.getText().toString(),
                editTextPassword.getText().toString(), editTextAge.getText().toString(),
                editBirthday.getText().toString(), spinner.getSelectedItem().toString(),
                imageView.getDrawable().toString()," dummy gender"
        );

        realmHelper.saveCustomer(customerModel);
        realmBackupRestore.backup();

        Intent intent = new Intent(Main3Activity.this, RecyclerCustomer.class);//DisplayContent
        startActivity(intent);
    }

}

package com.weboniselab.meghana.android.assignment5.androidassignment5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String firstname,lastname,mailid,phnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v){
        EditText etFirstName=(EditText) findViewById(R.id.etFirstName);
        EditText etLastName=(EditText) findViewById(R.id.etLastName);
        EditText etMailId=(EditText) findViewById(R.id.etMailId);
        EditText etPhNumber=(EditText) findViewById(R.id.etPhNumber);
        firstname=etFirstName.getText().toString();
        lastname=etLastName.getText().toString();
        mailid=etMailId.getText().toString();
        phnumber=etPhNumber.getText().toString();

        validate(firstname, lastname, mailid, phnumber);

    }

    public void validate(String firstname,String lastname, String mailid, String phnumber){
        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(MainActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(lastname)) {
            Toast.makeText(MainActivity.this, "Enter Last Name", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(mailid)) {
            Toast.makeText(MainActivity.this, "Enter Mail Id", Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(phnumber)) {
            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }

        if (!TextUtils.isEmpty(firstname) && !TextUtils.isEmpty(lastname) && !TextUtils.isEmpty(mailid) && !TextUtils.isEmpty(phnumber)){
            Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
        }
    }


}

package com.weboniselab.meghana.android.assignment5.android_assignment_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements View.OnClickListener{

    private final String TAG=getClass().getSimpleName();
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"***On Create***");
        Button btnSubmit=(Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "***On Start***");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "***On Resume***");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG,"***On Stop***");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG,"***On Destroy***");
    }


    @Override
    public void onClick(View v) {

        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        validate(username, password);

    }

    public void validate(String username,String password){

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(Login.this, "Enter Username", Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(password)) {
            Toast.makeText(Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
        }


        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){

            if(TextUtils.equals(username,password)) {
                Intent intent = new Intent(Login.this, AppHomePage.class);
                intent.putExtra("message", "Welcome " + username +"!!");
                startActivity(intent);
            }
            else
                Toast.makeText(Login.this, "Enter correct username and password", Toast.LENGTH_SHORT).show();

        }

    }



}

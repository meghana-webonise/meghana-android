package com.weboniselab.meghana.android.assignment6.databaseassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseOperatiopnsActivity extends Activity implements View.OnClickListener{

    EditText etName,etAge,etHeight,etWeight;
    Button btnSave,btnView;
    DatabaseHelper db;
    UserDetails userDetails;
    int age;
    double height,weight;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_operations);
        initialse();
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btnSave:
                if (validateInputData())
                saveDetailsToDatabase();
                break;
            case R.id.btnView:
                Intent intent=new Intent(DatabaseOperatiopnsActivity.this,ViewDetailsActivity.class);
                startActivity(intent);
                break;
        }
    }
    public boolean validateInputData() {
        boolean result = true;
        if (TextUtils.isEmpty(etName.getText().toString())){
            Toast.makeText(DatabaseOperatiopnsActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
            result=false;
        }
        else if (TextUtils.isEmpty(etAge.getText().toString())){
            Toast.makeText(DatabaseOperatiopnsActivity.this, "Entet age", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(etWeight.getText().toString())) {
            Toast.makeText(DatabaseOperatiopnsActivity.this, "Enter weight", Toast.LENGTH_SHORT).show();
            result = false;
        } else if (TextUtils.isEmpty(etHeight.getText().toString())){
            Toast.makeText(DatabaseOperatiopnsActivity.this, "Enter Height", Toast.LENGTH_SHORT).show();
            result=false;
        }
        else return true;

        return result;
    }

    public void saveDetailsToDatabase(){
        age=Integer.parseInt(etAge.getText().toString());
        name=etName.getText().toString();
        height=Double.parseDouble(etHeight.getText().toString());
        weight=Double.parseDouble(etWeight.getText().toString());
        userDetails = new UserDetails();
        userDetails.setAge(age);
        userDetails.setName(name);
        userDetails.setHeight(height);
        userDetails.setWeight(weight);
        db.addDetailsToDatabase(userDetails);
        Toast.makeText(DatabaseOperatiopnsActivity.this, "Data Saved !", Toast.LENGTH_SHORT).show();
    }

    public void initialse(){
        db=new DatabaseHelper(this);
        etName=(EditText) findViewById(R.id.etName);
        etAge=(EditText) findViewById(R.id.etAge);
        etHeight=(EditText) findViewById(R.id.etHeight);
        etWeight=(EditText) findViewById(R.id.etWeight);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnView=(Button) findViewById(R.id.btnView);
        btnSave.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }
}

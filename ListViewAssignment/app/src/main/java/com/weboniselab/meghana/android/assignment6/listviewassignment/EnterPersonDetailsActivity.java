package com.weboniselab.meghana.android.assignment6.listviewassignment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by webonise on 17/8/15.
 */
public class EnterPersonDetailsActivity extends Activity implements View.OnClickListener{
    EditText etName,etAge,etHeight,etWeight;
    Button btnSave,btnClear;
    PersonDetails personDetails;
    OpenHelperDatabase db;
    String name;
    int age;
    Double height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_person_details_activity);
        initialise();

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btnSave:
                if (validateInputData())
                    saveDetailsToDatabase();
                break;
            case R.id.btnClear:
                clearDetails();
                break;
        }
    }
    public void initialise(){
        db=new OpenHelperDatabase(this);
        etName=(EditText) findViewById(R.id.etName);
        etAge=(EditText) findViewById(R.id.etAge);
        etHeight=(EditText) findViewById(R.id.etHeight);
        etWeight=(EditText) findViewById(R.id.etWeight);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnClear=(Button) findViewById(R.id.btnClear);
        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    public boolean validateInputData() {

        if (TextUtils.isEmpty(etName.getText().toString())){
            Toast.makeText(EnterPersonDetailsActivity.this, getResources().getString(R.string.validateInputDataEnterName), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (TextUtils.isEmpty(etAge.getText().toString())){
            Toast.makeText(EnterPersonDetailsActivity.this, getResources().getString(R.string.validateInputDataEnterAge), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(etWeight.getText().toString())) {
            Toast.makeText(EnterPersonDetailsActivity.this, getResources().getString(R.string.validateInputDataEnterHeight), Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etHeight.getText().toString())){
            Toast.makeText(EnterPersonDetailsActivity.this, getResources().getString(R.string.validateInputDataEnterWeight), Toast.LENGTH_SHORT).show();
            return false;
        }
        else Toast.makeText(EnterPersonDetailsActivity.this,getResources().getString(R.string.validateInputDataSuccessfulEntry) , Toast.LENGTH_SHORT).show();

        return true;
    }

    public void saveDetailsToDatabase(){
        age=Integer.parseInt(etAge.getText().toString());
        name=etName.getText().toString();
        height=Double.parseDouble(etHeight.getText().toString());
        weight=Double.parseDouble(etWeight.getText().toString());
        personDetails = new PersonDetails();
        personDetails.setAge(age);
        personDetails.setName(name);
        personDetails.setHeight(height);
        personDetails.setWeight(weight);
        db.addDetailsToDatabase(personDetails);
    }

    public void clearDetails(){
        etName.setText("");
        etAge.setText("");
        etHeight.setText("");
        etWeight.setText("");
    }

}

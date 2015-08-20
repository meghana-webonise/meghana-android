package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by webonise on 20/8/15.
 */
public class EnterPersonDetailsFragment extends Fragment implements View.OnClickListener{

    Button btnSave,btnClear;
    EditText etName,etAge,etHeight,etWeight;
    Context context;
    PersonDetails personDetails;
    DatabaseOperations databaseOperations;
    String name;
    int age;
    Double height,weight;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.enter_person_details_fragment,container,false);
        context=container.getContext();
        initialise(view);
        return view;
    }

    public void initialise(View view){
        databaseOperations=new DatabaseOperations(context);
        btnSave=(Button) view.findViewById(R.id.btnSave);
        btnClear=(Button) view.findViewById(R.id.btnClear);
        etName=(EditText) view.findViewById(R.id.etName);
        etAge=(EditText) view.findViewById(R.id.etAge);
        etHeight=(EditText) view.findViewById(R.id.etHeight);
        etWeight=(EditText) view.findViewById(R.id.etWeight);
        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
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

    public boolean validateInputData() {

        if (TextUtils.isEmpty(etName.getText().toString())){
            Toast.makeText(context, getResources().getString(R.string.validateInputDataEnterName), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (TextUtils.isEmpty(etAge.getText().toString())){
            Toast.makeText(context, getResources().getString(R.string.validateInputDataEnterAge), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(etWeight.getText().toString())) {
            Toast.makeText(context, getResources().getString(R.string.validateInputDataEnterHeight), Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etHeight.getText().toString())){
            Toast.makeText(context, getResources().getString(R.string.validateInputDataEnterWeight), Toast.LENGTH_SHORT).show();
            return false;
        }
        else Toast.makeText(context,getResources().getString(R.string.validationSuccessful) , Toast.LENGTH_SHORT).show();

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
        databaseOperations.addDetailsToDatabase(personDetails);
    }

    public void clearDetails(){
        etName.setText("");
        etAge.setText("");
        etHeight.setText("");
        etWeight.setText("");
    }

}

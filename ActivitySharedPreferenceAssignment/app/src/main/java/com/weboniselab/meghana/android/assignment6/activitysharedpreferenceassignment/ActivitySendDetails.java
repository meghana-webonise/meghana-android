package com.weboniselab.meghana.android.assignment6.activitysharedpreferenceassignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySendDetails extends Activity implements View.OnClickListener {
    private final String TAG=getClass().getSimpleName();
    public static final String NAME="nameKey";
    public static final String HEIGHT="heightKey";
    public static final String WEIGHT="weightKey";
    public String name,height,weight;
    Button btnSave,btnRetrieve;
    EditText etName,etHeight,etWeight;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseViews();
        prefs=getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        btnSave.setOnClickListener(this);
        btnRetrieve.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btnSave:
                saveDetailsToFile();
                Toast.makeText(ActivitySendDetails.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRetrieve:
                retrieveDetailsFromFile();
                break;
        }
    }
    public void saveDetailsToFile() {
        name=etName.getText().toString();
        height=etHeight.getText().toString();
        Float heights=Float.parseFloat(height);
        weight=etWeight.getText().toString();
        Float weights=Float.parseFloat(weight);
        SharedPreferences.Editor editor = prefs.edit();
            editor.putString(NAME, name);
            editor.putFloat(HEIGHT, heights);
            editor.putFloat(WEIGHT, weights);
            editor.commit();
    }
    public void retrieveDetailsFromFile(){
        String name=prefs.getString(NAME,"");
        Float height=prefs.getFloat(HEIGHT, 0.0f);
        Float weight=prefs.getFloat(WEIGHT, 0.0f);
        Log.v(TAG, "name " + name);
        Log.v(TAG, "height " + height);
        Log.v(TAG, "weight " + weight);
        Intent intent=new Intent(ActivitySendDetails.this,ActivityViewDetails.class);
        intent.putExtra("NAME", name);
        intent.putExtra("HEIGHT",height);
        intent.putExtra("WEIGHT", weight);
        startActivity(intent);
    }
    public void initialiseViews(){
        etName=(EditText) findViewById(R.id.etName);
        etHeight=(EditText) findViewById(R.id.etHeight);
        etWeight=(EditText) findViewById(R.id.etWeight);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnRetrieve=(Button) findViewById(R.id.btnRetrieve);

    }
}

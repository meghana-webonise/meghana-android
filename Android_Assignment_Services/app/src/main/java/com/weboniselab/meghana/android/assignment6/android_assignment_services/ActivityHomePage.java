package com.weboniselab.meghana.android.assignment6.android_assignment_services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by webonise on 11/8/15.
 */
public class ActivityHomePage extends Activity implements View.OnClickListener{
    private final String TAG=getClass().getSimpleName();
    String inputField;
    int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btnSubmit=(Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v){
        EditText etInputField=(EditText) findViewById(R.id.etInputField);
        inputField=etInputField.getText().toString();
        input=Integer.parseInt(inputField);
        startService();

    }

    public void startService(){
        Intent intent=new Intent(this, ServiceAdditionOfNumbers.class);
        intent.putExtra(Constant.key_input_value,input);
        startService(intent);
        Log.v(TAG, "***Service Started***");

    }


}

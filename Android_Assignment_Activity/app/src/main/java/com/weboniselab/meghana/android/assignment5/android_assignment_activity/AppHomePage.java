package com.weboniselab.meghana.android.assignment5.android_assignment_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by webonise on 10/8/15.
 */
public class AppHomePage extends Activity{
    private final String TAG=getClass().getSimpleName();
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(TAG, "***On Create***");
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        msg=bundle.getString("message");
        TextView textView=(TextView) findViewById(R.id.tv);
        textView.setText(msg);

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
        Log.v(TAG, "***On Destroy***");
    }
}

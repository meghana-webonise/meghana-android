package com.weboniselab.meghana.android.assignment6.activitysharedpreferenceassignment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by webonise on 12/8/15.
 */
public class ActivityViewDetails extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("NAME");
        Float height=bundle.getFloat("HEIGHT");
        Float weight=bundle.getFloat("WEIGHT");
        TextView textView=(TextView) findViewById(R.id.tvName);
        textView.setText("NAME is " +name +" \nHEIGHT is "+ height+ " \nWEIGHT is "+weight);
    }
}

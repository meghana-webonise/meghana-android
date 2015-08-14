package com.weboniselab.meghana.android.assignment6.assignmentfilehandling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by webonise on 12/8/15.
 */
public class ActivityViewData extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data);
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
        String text=bundle.getString(getResources().getString(R.string.readDataFromFileText));
        TextView textView=(TextView) findViewById(R.id.tvViewData);
        textView.setText(text);
    }
}

package com.weboniselab.meghana.android.assignment6.databaseassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 13/8/15.
 */
public class ViewDetailsActivity extends Activity {
    TextView tvName;
    DatabaseHelper db= new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        initialise();
        viewDetailsFromDatabase();
    }

    public void viewDetailsFromDatabase() {
        List<UserDetails> userDetails = db.getAllDetails();
        for (UserDetails u : userDetails) {
            tvName.append("Name is : " +u.getName()+ " Age : " +u.getAge()+ " Height : " +u.getHeight()+ " Weight : " +u.getWeight());
            tvName.append("\n");
        }
    }

    public void initialise() {
        tvName = (TextView) findViewById(R.id.tvName);
    }
}
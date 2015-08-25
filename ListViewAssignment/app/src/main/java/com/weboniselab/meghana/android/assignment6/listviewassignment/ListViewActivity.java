package com.weboniselab.meghana.android.assignment6.listviewassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity implements View.OnClickListener{
    private PersonAdapter personAdapter;
    private ListView personList;
    OpenHelperDatabase openHelperDatabase;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);
        initialise();
    }

    @Override
    public void onClick(View view) {
            Intent intent = new Intent(ListViewActivity.this, EnterPersonDetailsActivity.class);
            startActivity(intent);

    }

    public void onListClick(){
        personList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public void initialise(){
        openHelperDatabase = new OpenHelperDatabase(this);
        personList=(ListView) findViewById(R.id.lvPersonList);
        personAdapter=new PersonAdapter(ListViewActivity.this,openHelperDatabase.getAllDetails());
        personList.setAdapter(personAdapter);
        onListClick();
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

    }
}

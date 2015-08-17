package com.weboniselab.meghana.android.assignment6.listviewassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by webonise on 14/8/15.
 */
public class PersonAdapter extends BaseAdapter {
    private List<PersonDetails> items;
    private Context context;
    TextView tvName,tvAge,tvHeight,tvWeight;
    Button btnDelete;
    public PersonAdapter(Context context, List<PersonDetails> items) {
        this.items = items;
        this.context = context;
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_row_adapter, null);
        }
        tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvAge = (TextView) convertView.findViewById(R.id.tvAge);
        tvHeight = (TextView) convertView.findViewById(R.id.tvHeight);
        tvWeight = (TextView) convertView.findViewById(R.id.tvWeight);
        btnDelete=(Button) convertView.findViewById(R.id.btnDelete);
        tvName.setText(items.get(position).getName());
        tvAge.setText(""+items.get(position).getAge());
        tvHeight.setText(items.get(position).getHeight().toString());
        tvWeight.setText(items.get(position).getWeight().toString());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }

}

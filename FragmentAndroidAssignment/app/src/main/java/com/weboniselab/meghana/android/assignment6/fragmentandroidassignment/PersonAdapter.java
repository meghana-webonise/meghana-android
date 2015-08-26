package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by webonise on 20/8/15.
 */
public class PersonAdapter extends BaseAdapter {
    ListView listView;
    private List<PersonDetails> items;
    private Context context;
    TextView tvName,tvAge,tvHeight,tvWeight;
    Button btnDelete;
    DatabaseOperations databaseOperations;
    public PersonAdapter(Context context, List<PersonDetails> items) {
        this.items = items;
        this.context = context;
        databaseOperations = new DatabaseOperations(context);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_row_adapter, null);
        }
        listView=(ListView) convertView.findViewById(R.id.listView);
        tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvAge = (TextView) convertView.findViewById(R.id.tvAge);
        tvHeight = (TextView) convertView.findViewById(R.id.tvHeight);
        tvWeight = (TextView) convertView.findViewById(R.id.tvWeight);
        btnDelete=(Button) convertView.findViewById(R.id.btnDelete);
        tvName.setText(items.get(position).getName());
        tvAge.setText(""+items.get(position).getAge());
        tvHeight.setText(items.get(position).getHeight().toString());
        tvWeight.setText(items.get(position).getWeight().toString());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            int ID=items.get(position).getId();
            @Override
            public void onClick(View v) {
                String e=String.valueOf(position);
                Log.d(getClass().getName(), e);
                databaseOperations.delete(position);
                items.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }



}

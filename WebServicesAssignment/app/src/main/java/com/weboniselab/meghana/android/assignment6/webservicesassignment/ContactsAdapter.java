package com.weboniselab.meghana.android.assignment6.webservicesassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by webonise on 25/8/15.
 */
public class ContactsAdapter extends BaseAdapter {
    ListView listView;
    private List<Contacts> items;
    TextView tvNAme;
    private Context context;
    TextView tvName;

    public ContactsAdapter(Context context, List<Contacts> items) {
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

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_each_list_item, null);
        }
        tvName=(TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(items.get(position).getName());
        return convertView;
    }
}

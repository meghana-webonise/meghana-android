package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by webonise on 20/8/15.
 */
public class ListViewFragment extends Fragment implements View.OnClickListener{
    private PersonAdapter personAdapter;
    private DatabaseOperations databaseOperations;
    private ListView personList;
    Button btnAdd;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view_fragment, null);
        context=container.getContext();
        initialise(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        replaceFragment();
    }

    public void onListClick(){
        personList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public void initialise(View view){
        databaseOperations=new DatabaseOperations(context);
        personList=(ListView) view.findViewById(R.id.listView);
        personAdapter=new PersonAdapter(context,databaseOperations.getAllDetails());
        personList.setAdapter(personAdapter);
        onListClick();

        btnAdd=(Button) view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    public void replaceFragment(){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        EnterPersonDetailsFragment enterPersonDetailsFragment=new EnterPersonDetailsFragment();

       fragmentTransaction.setCustomAnimations(R.anim.slide_out,R.anim.slide_in);
        fragmentTransaction.replace(R.id.fragment_container, enterPersonDetailsFragment, getResources().getString(R.string.fragmentTag));
        fragmentTransaction.addToBackStack(getResources().getString(R.string.fragmentTag));
        fragmentTransaction.commit();
    }

}

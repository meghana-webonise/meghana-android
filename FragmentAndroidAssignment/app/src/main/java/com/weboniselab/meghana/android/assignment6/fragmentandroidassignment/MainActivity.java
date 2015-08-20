package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();;
    }

    public void addFragment(){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        ListViewFragment listViewFragment=new ListViewFragment();
        //animation();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
        fragmentTransaction.add(R.id.fragment_container, listViewFragment, getResources().getString(R.string.mainActivityTag));
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed(){
        if(fragmentManager.getBackStackEntryCount()>0){
            fragmentManager.popBackStack();
        }
        super.onBackPressed();
    }
}

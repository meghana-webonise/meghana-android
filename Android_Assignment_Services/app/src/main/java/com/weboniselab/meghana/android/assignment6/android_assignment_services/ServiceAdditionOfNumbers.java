package com.weboniselab.meghana.android.assignment6.android_assignment_services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by webonise on 11/8/15.
 */
public class ServiceAdditionOfNumbers extends Service {

    private final String TAG=getClass().getSimpleName();
    int input,answer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent,int flags, int startId){
        Bundle bundle=intent.getExtras();

        Toast.makeText(ServiceAdditionOfNumbers.this, "Service Started", Toast.LENGTH_SHORT).show();
        input=bundle.getInt("input");
        answer=sumOfNumbers(input);
        Log.d(TAG, "The Answer is " + answer);
        stopService(intent);
        Log.v(TAG, "***Service Stopped***");
        return super.onStartCommand(intent,flags,startId);

    }

    public int sumOfNumbers(int input){
        int i,sum=0;
        for (i=1;i<=input;i++){
            sum+=i;
            Log.v(TAG,"Value is " +sum);
        }
        return sum;
    }


}

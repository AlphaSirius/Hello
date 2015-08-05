package com.example.sunil.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sunil on 28/7/15.
 */
public class MyReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("android :", context.getPackageName()+ "unique name it is");
    }
}

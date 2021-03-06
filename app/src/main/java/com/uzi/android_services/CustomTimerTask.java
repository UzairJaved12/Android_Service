package com.uzi.android_services;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.TimerTask;

public class CustomTimerTask extends TimerTask {

    private Context context;
    private Handler mHandler = new Handler();

    public CustomTimerTask(Context con) {
        this.context = con;
    }


    @Override
    public void run() {
        new Thread(new Runnable() {

            public void run() {

                mHandler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "Running", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).start();

    }
}

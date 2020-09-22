package com.uzi.android_services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

import static java.lang.Math.log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    boolean mBound = false;
    MyDownloadService mService;
        TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        Intent service = new Intent(MainActivity.this, RunAfterBootService.class);
        ContextCompat.startForegroundService(getApplicationContext(),service);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyDownloadService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyDownloadService.LocalBinder binder = (MyDownloadService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;

            binder.setCallback(new MyDownloadService.ProgressCallback() {
                @Override
                public void onProgressUpdate(final int progress) {
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          textView.setText(String.format(Locale.getDefault(),"99 ",progress));

                      }
                  });
                }

            });
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
}
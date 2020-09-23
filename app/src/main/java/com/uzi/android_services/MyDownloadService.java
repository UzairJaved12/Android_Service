  package com.uzi.android_services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import static android.os.Process.THREAD_PRIORITY_BACKGROUND;

/*
  public class MyDownloadService extends Service {
    private static final String TAG = "MyDownloadService";
      private static final int ONGOING_NOTIFICATION_ID = 1234 ;
      private Looper serviceLooper;
      private ServiceHandler serviceHandler;
      private int progress = 0;
      NotificationCompat.Builder notificationBuilder;
      NotificationManager notificationManager;
      private static final String CHANNEL_ID = "Channel id";
      private ProgressCallback callback;

      // Binder given to clients
      private final IBinder binder = new LocalBinder();
*
       * Class used for the client Binder.  Because we know this service always
       * runs in the same process as its clients, we don't need to deal with IPC.


      public class LocalBinder extends Binder {
          MyDownloadService getService() {
              Log.d(TAG, "getService: ");
              // Return this instance of LocalService so clients can call public methods
              return MyDownloadService.this;
          }
          void setCallback(ProgressCallback progressCallback){
             callback = progressCallback;
          }
      }
      // Handler that receives messages from the thread
      private final class ServiceHandler extends Handler {
          public ServiceHandler(Looper looper) {
              
              super(looper);
              Log.d(TAG, "ServiceHandler: ");
          }
          @Override
          public void handleMessage(Message msg) {
              final int arg = msg.arg1;
              Log.d(TAG, "handleMessage: ");
              // Normally we would do some work here, like download a file.
              // For our sample, we just sleep for 5 seconds.
             post(new Runnable() {
                 @Override
                 public void run() {
                     progress++;
                     if (progress <=2000){
                         notificationBuilder.setProgress(100,progress,false);
                         notificationManager.notify(ONGOING_NOTIFICATION_ID,notificationBuilder.build());
                         if (callback != null)
                         callback.onProgressUpdate(progress);
                         postDelayed(this,100);
                     }else {
                         stopForeground(true);
                         stopSelf(arg);

                     }
                 }
             });
              // Stop the service using the startId, so that we don't stop
              // the service in the middle of handling another job
          }
      }

      @RequiresApi(api = Build.VERSION_CODES.O)
      @Override
      public void onCreate() {
          Log.d(TAG, "onCreate: ");
          // Start up the thread running the service. Note that we create a
          // separate thread because the service normally runs in the process's
          // main thread, which we don't want to block. We also make it
          // background priority so CPU-intensive work doesn't disrupt our UI.
          HandlerThread thread = new HandlerThread("ServiceStartArguments",
                  THREAD_PRIORITY_BACKGROUND);
          thread.start();

          // Get the HandlerThread's Looper and use it for our Handler
          serviceLooper = thread.getLooper();
          serviceHandler = new ServiceHandler(serviceLooper);

          Intent notificationIntent = new Intent(this, MainActivity.class);
          PendingIntent pendingIntent =
                  PendingIntent.getActivity(this, 0, notificationIntent, 0);

         notificationBuilder =
                  new NotificationCompat.Builder(this,"Channel id" )
                          .setContentTitle("Tittle")
                          .setContentText("notification_message")
                          .setSmallIcon(R.drawable.ic_launcher_background)
                          .setContentIntent(pendingIntent);

// Notification ID cannot be 0.
          notificationManager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
           if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               if (notificationManager != null) {
                   notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Channel id", NotificationManager.IMPORTANCE_LOW));
               }
           }
          startForeground(ONGOING_NOTIFICATION_ID, notificationBuilder.build());
      }

      @Override
      public int onStartCommand(Intent intent, int flags, int startId) {
          Log.d(TAG, "onStartCommand: ");
          Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

          // For each start request, send a message to start a job and deliver the
          // start ID so we know which request we're stopping when we finish the job
          Message msg = serviceHandler.obtainMessage();
          msg.arg1 = startId;
          serviceHandler.sendMessage(msg);
          Toast.makeText(this, "Device is Running", Toast.LENGTH_SHORT).show();

          // If we get killed, after returning from here, restart
          return START_STICKY;
      }

      @Override
      public IBinder onBind(Intent intent) {
          Log.d(TAG, "onBind: ");

          // We don't provide binding, so return null
          return binder;

      }

      @Override
      public void onDestroy() {
          Log.d(TAG, "onDestroy: ");
          Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
      }
      public interface ProgressCallback{

          void onProgressUpdate(int progress);


      }
  }
*/

package com.example.hamza.assmnt4;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MTAG";
    public MyService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: service started");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: Service Started ");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        EventBus.getDefault().post(new HelloWorldEvent("EventBus!"));
        for (int i = 0; i <50; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "onStartCommand: service running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
        t.start();
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: Service Destroyed");
        super.onDestroy();
    }
}
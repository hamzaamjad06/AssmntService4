package com.example.hamza.assmnt4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        // register eventbus
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(HelloWorldEvent event) {
        Log.d("MTAG", "doThis:   this is the event " + event);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}

package com.ciccc_cirac.basicmusicplayer;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CICCC-CIRAC on 2017-08-11.
 */

public class MyBroadcastRecieverActivity  extends AppCompatActivity
implements View.OnClickListener{
    MyBroadcastReceiverDemo myBroadcastReceiverDemo;
    IntentFilter intentFilter;
    Button broadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast);
        myBroadcastReceiverDemo = new MyBroadcastReceiverDemo();
        intentFilter = new
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        broadcast = (Button)findViewById(R.id.button);
        broadcast.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcastReceiverDemo,
                intentFilter);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
        sendBroadcast(i);
    }
}

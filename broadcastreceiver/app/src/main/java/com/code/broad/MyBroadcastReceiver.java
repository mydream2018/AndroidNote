package com.code.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "这是我自己定义的广播接收器", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}

package com.code.broad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.code.broad.MY_BROADCAST");
                intent.setComponent(new ComponentName(getPackageName(), "com.code.broad.MyBroadcastReceiver"));
                sendOrderedBroadcast(intent, null);
                Intent intent2 = new Intent("com.code.broad.MY_BROADCAST");
                intent2.setComponent(new ComponentName("com.code.mainactivity", "com.code.mainactivity.AnotherBroadcastReceiver"));
                sendOrderedBroadcast(intent2, null);

            }
        });
    }
}
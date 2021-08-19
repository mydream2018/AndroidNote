package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Log.d("ThirdActivity", "Task id is" + getTaskId());
        ActivityCollector.addActivity(this);
        Button button = findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finshAll();
//                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestory3");
        ActivityCollector.removeActivity(this);
    }
}
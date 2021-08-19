package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Intent intent = getIntent();
//        String haha = intent.getStringExtra("say hello");
//        Log.d("SecondActivity", haha);
//        Toast.makeText(SecondActivity.this, haha, Toast.LENGTH_SHORT).show();
        Log.d("SecondActivity", "Task id is" + getTaskId());
        Button button = findViewById(R.id.button_2);
        ActivityCollector.addActivity(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class
                );
                startActivity(intent2);
//                intent2.putExtra("data_return", "Hello FirstActivity!!!!!!!!!!!");
//                setResult(RESULT_OK, intent2);
//                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent3 = new Intent();
        intent3.putExtra("data_return", "Hello FirstActivity!");
        setResult(RESULT_OK, intent3);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestory2");
        ActivityCollector.removeActivity(this);
    }
}
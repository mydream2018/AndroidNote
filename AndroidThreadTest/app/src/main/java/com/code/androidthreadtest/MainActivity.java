package com.code.androidthreadtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int  UPDATE_TEST = 1;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        Button changeText = findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }

    private Handler handler = new Handler(){

      public void handleMessage(Message msg){
          switch (msg.what){
              case UPDATE_TEST:
                  textView.setText("很高兴见到你！");
                  break;
              default:
                  break;
          }
      }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = UPDATE_TEST;
                        handler.sendMessage(msg);//将message信息发送出去
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
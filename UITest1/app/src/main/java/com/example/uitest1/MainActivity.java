package com.example.uitest1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity1";
    private ImageView imageView;
    private EditText editText;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, R.id.button+"");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "你点击了按钮"+v.getId(), Toast.LENGTH_SHORT).show();
//            }
//        });
        editText = findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.button:
//                Toast.makeText(getApplicationContext(), "实现接口的方式!"+v.getId(), Toast.LENGTH_LONG).show();
//                break;
            case R.id.button:
//                String str = editText.getText().toString();
//                imageView.setImageResource(R.mipmap.img_1);
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar.setVisibility(View.GONE);
//                }
//                progressBar.setVisibility(View.INVISIBLE);
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("这是一个对话框");
//                dialog.setMessage("弹出警告信息！");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("程序正在处理中");
                progressDialog.setMessage("程序加载中Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:break;
        }
    }
}
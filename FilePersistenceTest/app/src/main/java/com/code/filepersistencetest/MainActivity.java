package com.code.filepersistencetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        String text = load();
        if(!TextUtils.isEmpty(text)){
            editText.setText(text);
            editText.setSelection(text.length());
            Toast.makeText(this, "加载保存数据成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(editText.getText().toString());
    }

    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter bufferedWriter = null;
        try{
            out = openFileOutput("data", Context.MODE_APPEND);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String load(){
        StringBuilder content = new StringBuilder();
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        try{
            inputStream = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while((line = reader.readLine()) != null){
                content.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();

    }
}
package com.code.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button = null;
    private Button addData = null;
    private Button editData = null;
    private Button deleteData = null;
    private Button queryData = null;
    private static final String TAG = "MainActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.create_database);
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "BookStore.db",
                null, 5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();

            }
        });
        addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "安卓开发从入门到精通");
                values.put("author", "小呵呵");
                values.put("pages", 454);
                values.put("price", 16.95);
                db.insert("Book", null, values);
                values.clear();
                //开始组装第二条数据
                values.put("name", "安卓开发从入门到精通2");
                values.put("author", "小呵呵2");
                values.put("pages", 480);
                values.put("price", 17.95);
                db.insert("Book", null, values);
                values.clear();
                Toast.makeText(getBaseContext(), "新增数据成功", Toast.LENGTH_SHORT).show();
            }
        });
        editData = findViewById(R.id.edit_data);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "神雕侠侣");
                contentValues.put("pages", 9993);
                contentValues.put("author", "金庸3");
                contentValues.put("price", 10003);
                db.update("Book", contentValues, "name=? and id=?", new String[]{"天龙八部", "1"});
                Toast.makeText(getBaseContext(), "修改数据成功", Toast.LENGTH_SHORT).show();
            }
        });
        deleteData = findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "author=?", new String[]{"小呵呵2"});
                Toast.makeText(getBaseContext(), "删除数据成功", Toast.LENGTH_SHORT).show();
            }
        });
        queryData = findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null,
                        null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("author"));
                        @SuppressLint("Range") int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        @SuppressLint("Range") double prices = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "book name is:" + name);
                        Log.d(TAG, "author name is:" + author);
                        Log.d(TAG, "book pages is:" + pages);
                        Log.d(TAG, "book prices is:" + prices);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
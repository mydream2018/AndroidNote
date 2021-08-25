package com.code.testlitepal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.class";
    private Button addButton;
    private Button button;
    private Button updateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });

        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("碧血剑");
                book.setAuthor("金庸");
                book.setPrice(100);
                book.setPages(400);
                book.setPress("北京出版社");
                book.save();
            }
        });
        updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Book book = new Book();
////                book.setName("中国历史");
////                book.setAuthor("笑");
//                book.setToDefault("pages");
////                book.setPress("北京出版社");
////                book.setPrice(400);
////                book.setPages(488);
////                book.save();
////                book.setPrice(500);
////                book.save();
//                book.updateAll();
//                DataSupport.deleteAll(Book.class, "price>?", "100");
                List<Book> bookList = DataSupport.findAll(Book.class);
                Log.d(TAG, bookList.toString());
            }
        });
    }
}
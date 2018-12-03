package com.bwie.asus.chenxiaoyang1203;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.asus.chenxiaoyang1203.ActivityClass.CurstomLayout;
import com.bwie.asus.chenxiaoyang1203.Dao.SqliteDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  String[] desc=new String[]{"考拉","电动牙刷","尤妮佳","豆豆鞋","沐浴露","日东红茶"};

    CurstomLayout fall;
    CurstomLayout hotview;
    private EditText et;
    SqliteDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new SqliteDao(MainActivity.this);
        et = findViewById(R.id.et);
        fall = findViewById(R.id.fall);
        hotview = findViewById(R.id.hotview);

        for (String str:desc){
            TextView textView = new TextView(MainActivity.this);
            textView.setText(str);
            textView.setTextSize(20);
            hotview.addView(textView);
        }
        List<String> list=dao.selall();
        if (list.size()!=0){
            for (String string:list){
                TextView tv = new TextView(MainActivity.this);
                tv.setText(et.getText());
                tv.setTextColor(Color.GREEN);
                fall.addView(tv);
            }
        }
        //点击按钮添加
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText(et.getText());
                tv.setTextColor(Color.GREEN);
                boolean b = dao.sel(et.getText().toString());
                if (!et.getText().toString().equals("")&&b){
                    dao.add(et.getText().toString());
                    fall.addView(tv);
                }

            }
        });

        //点击图片清空
        findViewById(R.id.qk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delall();
                fall.removeAllViews();
            }
        });

    }
}

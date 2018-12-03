package com.bwie.asus.chenxiaoyang1203.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SqliteDao {

    private final SQLiteDatabase database;

    public SqliteDao(Context context){
        database = new SqlHelp(context).getWritableDatabase();

    }
    public  void add(String string){
        ContentValues values=new ContentValues();
        values.put("context",string);
        database.insert("history",null,values);

    }
    public void delall(){
        database.delete("history",null,null);
    }
    public boolean sel(String string){
        Cursor query = database.query("history",null,"context=?",new String[]{string},null,null,null);
        return query.getCount()==0?true:false;
    }
    public List<String> selall(){
        List<String> list=new ArrayList<>();
        Cursor query=database.query("history",null,null,null,null,null,null);
        while (query.moveToNext()){
            list.add(query.getString(query.getColumnIndex("context")));
        }
        return list;
    }

}

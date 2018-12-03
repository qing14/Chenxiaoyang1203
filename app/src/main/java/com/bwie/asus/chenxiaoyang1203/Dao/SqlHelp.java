package com.bwie.asus.chenxiaoyang1203.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SqlHelp extends SQLiteOpenHelper {

    public SqlHelp(@Nullable Context context) {
        super(context, "Shop.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table history(id integer primary key autoincrement,context text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

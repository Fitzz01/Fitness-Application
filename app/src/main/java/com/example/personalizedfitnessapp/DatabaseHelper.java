package com.example.personalizedfitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "SignUp.db";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase UserDatabase) {
        UserDatabase.execSQL("Create table user(name TEXT, email TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase UserDatabase, int i, int i1) {
        UserDatabase.execSQL("Drop table if exists user");
    }

    public boolean insertData(String name,String email, String password){
        SQLiteDatabase UserDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = UserDatabase.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }else
            return true;
    }

    public boolean checkNameAndPass(String password, String name){
        SQLiteDatabase UserDatabase = this.getWritableDatabase();
        Cursor cursor = UserDatabase.rawQuery("Select * from user where password =? and name =?", new String[]{password,name});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }

    public boolean checkUserEmail(String email){
        SQLiteDatabase UserDatabase = this.getWritableDatabase();
        Cursor cursor = UserDatabase.rawQuery("Select * from user where email =?", new String[]{email});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }

}

package com.example.arjadgym;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        DB.execSQL("create Table MyTable(username TEXT primary key, email TEXT, pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1)
    {
        DB.execSQL("drop Table if exists MyTable");
    }

    public Boolean insertuserdata(String username, String email, String pass)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues cv = new ContentValues ();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("pass", pass);

        long result=DB.insert("MyTable", null, cv);
        if(result==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from MyTable", null);
        return cursor;
    }
}

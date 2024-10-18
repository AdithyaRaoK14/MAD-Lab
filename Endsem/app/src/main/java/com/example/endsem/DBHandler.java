package com.example.endsem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "exam.db";

    private static final int DB_VERSION = 1;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE FEEDBACK (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, COURSE TEXT, SECTION TEXT, Q1 TEXT, Q2 TEXT)";
        db.execSQL(query);
    }

    public void insertFeedback(String name, String course, String sec, String q1, String q2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("COURSE", course);
        values.put("SECTION", sec);
        values.put("Q1", q1);
        values.put("Q2", q2);
        db.insert("FEEDBACK", null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FEEDBACK");
        onCreate(db);
    }

    public ArrayList<String> getFeedbacks(Context context) {
        ArrayList<String> feedback = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM FEEDBACK",null);
        while(c.moveToNext()){
            String enter = "";
            enter = c.getString(1)+" :: "+c.getString(2)+" :: "+c.getString(3)+" :: "+c.getString(4)+" :: "+c.getString(5);
            feedback.add(enter);
        }
        return feedback;
    }
}
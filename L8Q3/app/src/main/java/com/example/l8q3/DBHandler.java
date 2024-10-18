package com.example.l8q3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "review.db";

    private static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE REVIEW (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, YEAR INTEGER, RATING INTEGER)";
        db.execSQL(query);
    }

    public void addReview(String name, int year, int rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("YEAR", year);
        values.put("RATING", rating);
        db.insert("REVIEW", null, values);
        db.close();
    }

    public ArrayList<String> getMovieNames(){
        ArrayList<String> reviews = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM REVIEW";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            reviews.add(name);
        }
        cursor.close();
        db.close();
        return reviews;
    }

    public ArrayList<String> getMovieDetails(String name){
        ArrayList<String> reviews = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM REVIEW WHERE NAME='"+name+"' ";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            reviews.add(cursor.getString(1));
            reviews.add(cursor.getString(2));
            reviews.add(cursor.getString(3));
        }
        cursor.close();
        db.close();
        return reviews;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS REVIEW");
        onCreate(db);
    }
}
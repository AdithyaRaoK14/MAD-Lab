package com.example.l8q4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "student.db";
    private static final int DB_VERSION = 1;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE STUDENT (REG TEXT PRIMARY KEY, NAME TEXT, SEMESTER INTEGER, FACULTY TEXT, BRANCH TEXT)";
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addStudent(String regno, String name, String faculty, String branch, int semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("REG", regno);
        values.put("NAME", name);
        values.put("SEMESTER", semester);
        values.put("FACULTY", faculty);
        values.put("BRANCH", branch);
        db.insert("STUDENT", null, values);
        db.close();
    }

    public ArrayList<String> getStudentNames(){
        ArrayList<String> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM STUDENT",null);
        while(cursor.moveToNext()){
            students.add(cursor.getString(1));
        }
        cursor.close();
        db.close();
        return students;
    }

    public boolean updateStudent(String regno, String name, String faculty, String branch, int semester){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM STUDENT WHERE REG = '"+regno+"'",null);
        if(cursor.getCount()==0){
            return false;
        }
        cursor.close();
        db.close();
        SQLiteDatabase db1 = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("REG", regno);
        values.put("NAME", name);
        values.put("FACULTY", faculty);
        values.put("BRANCH", branch);
        values.put("SEMESTER", semester);
        db1.update("STUDENT", values, "REG=?", new String[]{regno});
        db1.close();
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
        onCreate(db);
    }

    public ArrayList<String> getStudentDetails(String name){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM STUDENT WHERE NAME = '"+name+"'",null);
        ArrayList<String> details = new ArrayList<>();
        if(cursor.getCount()==0){
            return details;
        }
        cursor.moveToNext();
        details.add(cursor.getString(0));
        details.add(cursor.getString(1));
        details.add(cursor.getString(2));
        details.add(cursor.getString(3));
        details.add(cursor.getString(4));
        cursor.close();
        db.close();
        return details;
    }

    public void deleteStudent(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("STUDENT", "name=?", new String[]{name});
        db.close();
    }
}
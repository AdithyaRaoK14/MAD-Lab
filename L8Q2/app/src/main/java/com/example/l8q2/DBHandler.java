package com.example.l8q2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "items.db";
    private static final int DB_VERSION = 1;
    public SQLiteDatabase database;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE ITEMS (id integer primary key autoincrement, name varchar, price float)";
        db.execSQL(query);
        insertItem(db, "Bread", "4");
        insertItem(db, "Milk", "5");
        insertItem(db, "Toothbrush", "4.5");
        insertItem(db, "Chicken", "6.75");
        insertItem(db, "Chocolate", "3.25");

        query = "CREATE TABLE BILL (id integer primary key autoincrement, item_name varchar, price float, quantity integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ITEMS");
        onCreate(db);
    }

    public void insertItem(SQLiteDatabase db, String name, String price) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        db.insert("ITEMS", null, values);
    }

    public void insertBillItem(Context context, String name, float price) {
        Cursor cursor = database.rawQuery("SELECT * FROM BILL WHERE ITEM_NAME=?", new String[]{name});
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            int quantityIndex = cursor.getColumnIndex("quantity");
            if (quantityIndex != -1) {
                int currentQuantity = cursor.getInt(quantityIndex);
                ContentValues values = new ContentValues();
                values.put("item_name", name);
                values.put("price", price);
                values.put("quantity", currentQuantity + 1);
                database.update("BILL", values, "item_name=?", new String[]{name});
            }
        } else {
            ContentValues values = new ContentValues();
            values.put("item_name", name);
            values.put("price", price);
            values.put("quantity", 1);
            database.insert("BILL", null, values);
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    public ArrayList<String> getItems(SQLiteDatabase db) {
        ArrayList<String> items = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM ITEMS", null);
        if (cursor.moveToFirst()) {
            do {
                items.add(cursor.getString(1) + " - " + cursor.getString(2)+"$");
            } while (cursor.moveToNext());
            cursor.close();
        }
        return items;
    }

    public void getBillItems(Context context){
        Cursor cursor = database.rawQuery("SELECT * FROM BILL", null);
        String val = "";
        if (cursor.moveToFirst()) {
            do {
                val += cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getInt(3)+"\n";
            } while (cursor.moveToNext());
            Toast.makeText(context, val, Toast.LENGTH_SHORT).show();
            cursor.close();
        }
        closeDatabase();
    }

    public void closeDatabase() {
        database.execSQL("DELETE FROM BILL");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        database = db;
    }
}
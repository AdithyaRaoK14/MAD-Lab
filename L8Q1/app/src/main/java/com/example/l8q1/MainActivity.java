package com.example.l8q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("MAD",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS CONTACT(email varchar, phone varchar, name varchar)");
    }

    public void insertRow(View view) {
        Intent intent = new Intent(MainActivity.this,Insert.class);
        startActivity(intent);
    }


}
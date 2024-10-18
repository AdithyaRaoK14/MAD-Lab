package com.example.l8q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add, view;
    EditText name, year, rating;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.back);
        view = findViewById(R.id.view);
        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        rating = findViewById(R.id.rating);
        dbHandler = new DBHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                int y = Integer.parseInt(year.getText().toString());
                int r = Integer.parseInt(rating.getText().toString());
                dbHandler.addReview(n, y, r);
                Toast.makeText(MainActivity.this, "Review Added", Toast.LENGTH_SHORT).show();
                name.setText("");
                year.setText("");
                rating.setText("");
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
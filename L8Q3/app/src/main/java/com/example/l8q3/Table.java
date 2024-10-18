package com.example.l8q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Table extends AppCompatActivity {

    TextView n,r,y;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        n = findViewById(R.id.movie_name);
        y = findViewById(R.id.year_name);
        r = findViewById(R.id.rating_name);
        back = findViewById(R.id.back_button);

        Intent intent = getIntent();
        n.setText(intent.getStringExtra("name"));
        y.setText(intent.getStringExtra("year"));
        r.setText(intent.getStringExtra("rating"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Table.this,ViewActivity.class);
                startActivity(i);
            }
        });
    }
}
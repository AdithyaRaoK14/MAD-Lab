package com.example.l8q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ListView list;
    DBHandler dbHandler;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        dbHandler = new DBHandler(this);
        ArrayList<String> list1 = dbHandler.getMovieNames();
        list = (ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
        list.setAdapter(adapter);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<String> movie = dbHandler.getMovieDetails(list.getItemAtPosition(i).toString());
                Intent intent = new Intent(ViewActivity.this,Table.class);
                intent.putExtra("name",movie.get(0));
                intent.putExtra("year",movie.get(1));
                intent.putExtra("rating",movie.get(2));
                startActivity(intent);
            }
        });
    }
}
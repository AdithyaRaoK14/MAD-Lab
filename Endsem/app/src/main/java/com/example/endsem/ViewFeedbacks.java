package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewFeedbacks extends AppCompatActivity {

    Button back;
    DBHandler dbHandler;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedbacks);
        back = findViewById(R.id.back);
        dbHandler = new DBHandler(this);
        list = findViewById(R.id.list);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewFeedbacks.this,MainActivity.class);
                startActivity(i);
            }
        });

        ArrayList<String> feedbacks = dbHandler.getFeedbacks(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,feedbacks);
        list.setAdapter(adapter);
    }
}
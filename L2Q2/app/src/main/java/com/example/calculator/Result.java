package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String val = intent.getStringExtra("Result");
        TextView tv = findViewById(R.id.resultVal);
        tv.setText(val);
    }

    public void onClickBack(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
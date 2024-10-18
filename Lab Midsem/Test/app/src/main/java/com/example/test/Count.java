package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Count extends AppCompatActivity {

    TextView tv1,tv2;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Intent intent = getIntent();
        tv1 = findViewById(R.id.count_val);
        tv2 = findViewById(R.id.selected_options);

        tv1.setText(intent.getStringExtra("Count"));
        tv2.setText(intent.getStringExtra("Options"));

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Count.this, MainActivity.class);
                finishActivity(0);
                startActivity(i);
            }
        });
    }
}
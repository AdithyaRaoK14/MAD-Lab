package com.example.l8q4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayStudents extends AppCompatActivity {

    TextView name,reg,sem,fac,branch;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);
        name = findViewById(R.id.nameTV);
        reg = findViewById(R.id.regTV);
        sem = findViewById(R.id.semTV);
        fac = findViewById(R.id.facTV);
        branch = findViewById(R.id.branchTV);
        back = findViewById(R.id.back);

        Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        reg.setText(i.getStringExtra("regno"));
        sem.setText(i.getStringExtra("sem"));
        fac.setText(i.getStringExtra("faculty"));
        branch.setText(i.getStringExtra("branch"));

        back.setOnClickListener(view -> {
            Intent i1 = new Intent(DisplayStudents.this,ViewStudents.class);
            startActivity(i1);
        });
    }
}
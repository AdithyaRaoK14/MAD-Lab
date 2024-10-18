package com.example.l8q4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    Button add;
    EditText name,reg,sem,fac,branch;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        add = findViewById(R.id.add_student);
        name = findViewById(R.id.name);
        reg = findViewById(R.id.studentid);
        sem = findViewById(R.id.semester);
        fac = findViewById(R.id.faculty);
        branch = findViewById(R.id.branch);
        dbHandler = new DBHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String r = reg.getText().toString();
                String s = sem.getText().toString();
                String f = fac.getText().toString();
                String b = branch.getText().toString();
                dbHandler.addStudent(r,n,f,b,Integer.parseInt(s));
                Toast.makeText(AddStudent.this, "Student Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
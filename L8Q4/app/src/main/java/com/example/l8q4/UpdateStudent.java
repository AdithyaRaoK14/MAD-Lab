package com.example.l8q4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {

    Button edit,back;
    EditText name,reg,sem,fac,branch;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        edit = findViewById(R.id.edit_student);
        name = findViewById(R.id.name_edit);
        reg = findViewById(R.id.studentid_edit);
        sem = findViewById(R.id.semester_edit);
        fac = findViewById(R.id.faculty_edit);
        branch = findViewById(R.id.branch_edit);
        back = findViewById(R.id.back_to_home);
        dbHandler = new DBHandler(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateStudent.this,MainActivity.class);
                startActivity(i);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String r = reg.getText().toString();
                String s = sem.getText().toString();
                String f = fac.getText().toString();
                String b = branch.getText().toString();
                if(dbHandler.updateStudent(r,n,f,b,Integer.parseInt(s))) {
                    Toast.makeText(UpdateStudent.this, "Student Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateStudent.this, "Student Not Found!", Toast.LENGTH_SHORT).show();
                    reg.setText("");
                }
            }
        });
    }
}
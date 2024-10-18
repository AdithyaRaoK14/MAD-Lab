package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHandler dbHandler;
    Button button,next;
    RadioGroup course,section,q1,q2;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DBHandler(this);
        course = findViewById(R.id.course);
        section = findViewById(R.id.section);
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        name = findViewById(R.id.nameET);
        button = findViewById(R.id.button);
        next = findViewById(R.id.next);

        next.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this,ViewFeedbacks.class);
            startActivity(i);
        });

        button.setOnClickListener(view -> {
            // Initializing the popup menu and giving the reference as current context
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);

            // Inflating popup menu from popup_menu.xml file
            popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                if(menuItem.getTitle().equals("Submit")){
                    if(name.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Student Name Required!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        RadioButton rb;
                        int selectedCourse =  course.getCheckedRadioButtonId();
                        if(selectedCourse==-1){
                            Toast.makeText(MainActivity.this, "Cannot leave course field empty!", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        rb = (RadioButton)course.findViewById(selectedCourse);
                        String scourse = rb.getText().toString();
                        int selectedSection=  section.getCheckedRadioButtonId();
                        if(selectedSection==-1){
                            Toast.makeText(MainActivity.this, "Cannot leave section field empty!", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        rb = (RadioButton)section.findViewById(selectedSection);
                        String ssection = rb.getText().toString();
                        int selectedQ1 =  q1.getCheckedRadioButtonId();
                        if(selectedQ1==-1){
                            Toast.makeText(MainActivity.this, "Cannot leave Q1 field empty!", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        rb = (RadioButton)q1.findViewById(selectedQ1);
                        String sq1 = rb.getText().toString();
                        int selectedQ2 =  q2.getCheckedRadioButtonId();
                        if(selectedQ2==-1){
                            Toast.makeText(MainActivity.this, "Cannot leave Q2 field empty!", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        rb = (RadioButton)q2.findViewById(selectedQ2);
                        String sq2 = rb.getText().toString();
                        dbHandler.insertFeedback(name.getText().toString(),scourse,ssection,sq1,sq2);
                        Toast.makeText(MainActivity.this, "Submission Successful", Toast.LENGTH_SHORT).show();
                        course.clearCheck();
                        section.clearCheck();
                        q1.clearCheck();
                        q2.clearCheck();
                        name.setText("");

                    }
                }

                return true;
            });
            // Showing the popup menu
            popupMenu.show();
        });
    }
}
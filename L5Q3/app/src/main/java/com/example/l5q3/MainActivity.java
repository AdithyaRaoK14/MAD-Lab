package com.example.l5q3;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button time,date,button,clear;
    String timeVal;
    String dateVal;
    Spinner src,dst;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        src=findViewById(R.id.source);
        dst=findViewById(R.id.destination);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.source_items, android.R.layout.simple_spinner_dropdown_item);
        src.setAdapter(ad);
        ad = ArrayAdapter.createFromResource(this,R.array.dest_items, android.R.layout.simple_spinner_dropdown_item);
        dst.setAdapter(ad);

        time=findViewById(R.id.time);
        date=findViewById(R.id.date);
        clear=findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                finishActivity(0);
                startActivity(i);

            }
        });

        time.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    timeVal = i + ":" + i1;
                }
            },hour,minute,false);
            timePickerDialog.show();
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateVal = i+"/"+(i1+1)+"/"+i2;
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Date - "+dateVal+"\nTime - "+timeVal,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Source - "+src.getSelectedItem().toString()+"\nDestination - "+dst.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                if(tb.isChecked()){
                    Toast.makeText(MainActivity.this,"Tatkaal Ticket",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Normal Ticket",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tb = findViewById(R.id.tb);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                if(hour<11){
                    Toast.makeText(MainActivity.this,"Tatkaal feature enables only after 11 AM",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
}
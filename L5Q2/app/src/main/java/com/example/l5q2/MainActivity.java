package com.example.l5q2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, CalendarView.OnDateChangeListener {
    Spinner src,dst;
    Calendar c;
    CalendarView cv;
    String finalDate;
    SimpleDateFormat df;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        src = findViewById(R.id.src);
        dst = findViewById(R.id.dst);
        cv = (CalendarView) findViewById(R.id.calendar);
        ArrayAdapter<CharSequence> ad1 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.source, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> ad2 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.destinations, android.R.layout.simple_spinner_dropdown_item);
        src.setAdapter(ad1);
        dst.setAdapter(ad2);
        c = Calendar.getInstance();
        cv.setOnDateChangeListener(this);
        df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        tb = findViewById(R.id.tb);
    }

    public void onClick(View view) {
        if(tb.isChecked()){
            Toast.makeText(getApplicationContext(),"FINAL VALUES\nFrom: "+src.getSelectedItem().toString()+"\nDestination: "+dst.getSelectedItem().toString()+"\nDate: "+finalDate+"\nRound Trip",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"FINAL VALUES\nFrom: "+src.getSelectedItem().toString()+"\nDestination: "+dst.getSelectedItem().toString()+"\nDate: "+finalDate+"\nOne-Way Trip",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONDAY,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        finalDate = df.format(c.getTimeInMillis());
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        finalDate = dayOfMonth+"/"+(month+1)+"/"+year;
    }

    public void clear(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        this.finishActivity(0);
    }
}
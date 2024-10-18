package com.example.q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.list_values, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ImageView image = (ImageView) findViewById(R.id.image);
        if (i==0){
            Toast.makeText(getApplicationContext(),"You selected fruits",Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.fruits);
        }
        else if (i==1){
            Toast.makeText(getApplicationContext(),"You selected vegetables",Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.vegetables);
        }
        else if (i==2){
            Toast.makeText(getApplicationContext(),"You selected herbs",Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.herbs);
        }
        else if (i==3){
            Toast.makeText(getApplicationContext(),"You selected dairy products",Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.dairy);
        }
        else if (i==4){
            Toast.makeText(getApplicationContext(),"You selected soft drinks",Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.softdrinks);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        image.setImageResource(R.drawable.ic_launcher_background);
    }
}
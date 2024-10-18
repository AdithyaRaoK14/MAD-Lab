package com.example.l5q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Confirmation extends AppCompatActivity {
    TextView type,vno,rc;
    int sno=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Intent intent = getIntent();
        type = (TextView) findViewById(R.id.type);
        vno = (TextView) findViewById(R.id.vno);
        rc = (TextView) findViewById(R.id.rc);
        type.setText(intent.getStringExtra("Type"));
        rc.setText(intent.getStringExtra("RC"));
        vno.setText(intent.getStringExtra("Vno"));
        Random rand = new Random();
        sno = rand.nextInt(10000);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickConfirm(View view) {
        Toast.makeText(getApplicationContext(), "TICKET BOOKED!\nSerial Number: "+sno+"\nVehicle Type: "+type.getText().toString()+"\nVehicle Number: "+vno.getText().toString()+"\nRC Number: "+rc.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
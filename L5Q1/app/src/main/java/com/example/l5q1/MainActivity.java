package com.example.l5q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = (Spinner) findViewById(R.id.spinner);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(getApplicationContext(), R.array.vehicle_list,android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(getApplicationContext(),Confirmation.class);
        intent.putExtra("Type",spin.getSelectedItem().toString());
        intent.putExtra("RC",et2.getText().toString());
        intent.putExtra("Vno",et1.getText().toString());
        startActivity(intent);
    }
}
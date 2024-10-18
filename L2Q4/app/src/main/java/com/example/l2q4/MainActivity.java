package com.example.l2q4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView tv = findViewById(R.id.tv);
        EditText et = findViewById(R.id.editTextText);
        if("".equals(et.getText().toString())){
            Toast.makeText(getApplicationContext(),"Enter something!",Toast.LENGTH_SHORT).show();
        }
        else{
            tv.setText(et.getText().toString());
        }
    }
}
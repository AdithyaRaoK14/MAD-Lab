package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Button opButton = (Button) view;
        String op = opButton.getText().toString();
        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();
        float val1=0,val2=0;
        try{
            val1 = Float.parseFloat(s1);
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Enter a valid first number",Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            val2 = Float.parseFloat(s2);
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Enter a valid second number",Toast.LENGTH_SHORT).show();
            return;
        }
        float res=0;
        switch(op){
            case "+": res = val1+val2;
            break;
            case "-": res = val1-val2;
            break;
            case "X": res = val1*val2;
            break;
            case "/": res = val1/val2;
            break;
        }
        String output = s1 + op + s2 + " = " + res;
        Intent intent = new Intent(this,Result.class);
        num1.setText("");
        num2.setText("");
        intent.putExtra("Result",output);
        startActivity(intent);
    }
}
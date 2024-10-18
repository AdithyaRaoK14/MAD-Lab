package com.example.lab2_q1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Welcome!", Toast.LENGTH_SHORT).show();
    }
    public void onClickBTN(View v){
        Toast.makeText(this,"Button Clicked!",Toast.LENGTH_SHORT).show();
    }
}
package com.example.l4q2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final ImageView image = new ImageView(this);
    final Toast toast = new Toast(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        if (view.getId() == R.id.toggle){
            ToggleButton tb = (ToggleButton) findViewById(R.id.toggle);
            if (tb.isChecked()){
                image.setImageResource(R.drawable.on);
            }
            else{
                image.setImageResource(R.drawable.off);
            }
        }
        else{
            image.setImageResource(R.drawable.hello);
        }
    }
}
package com.example.l3q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this, R.array.list_values, android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ImageView image = (ImageView) findViewById(R.id.imageView2);
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
}
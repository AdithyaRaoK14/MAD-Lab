package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.list, android.R.layout.simple_list_item_1);
        lv.setAdapter(ad);
        LinearLayout parent = findViewById(R.id.parent);
        Toast toast = new Toast(this);
        view = LayoutInflater.from(this).inflate(R.layout.custom_toast, parent, false);

        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)view.findViewById(R.id.textView)).setText("Toast");
                toast.show();
            }
        });
    }
}
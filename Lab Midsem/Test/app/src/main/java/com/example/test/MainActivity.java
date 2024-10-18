package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Button settings,count;
    RadioButton r1,r2,r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,settings);
                popupMenu.getMenuInflater().inflate(R.menu.options_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getTitle().toString().equals("Reset Survey")){
                            Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                            r1.setChecked(false);
                            r2.setChecked(false);
                            r3.setChecked(false);
                        }
                        if(menuItem.getTitle().toString().equals("Export Survey")){
                            String s1 = "";
                            if(r1.isChecked()){
                                s1 = s1+r1.getText().toString()+"\n";
                            }if(r2.isChecked()){
                                s1 = s1+r2.getText().toString()+"\n";
                            }if(r3.isChecked()){
                                s1 = s1+r3.getText().toString()+"\n";
                            }
                            Toast.makeText(MainActivity.this, "CURRENT SETTINGS\n" + s1, Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        count = findViewById(R.id.count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;
                String selected_options="";
                String countVal="";
                if(r1.isChecked()){
                    count+=1;
                    selected_options+=r1.getText().toString()+"\n";
                }
                if(r2.isChecked()){
                    count+=1;
                    selected_options+=r2.getText().toString()+"\n";
                }
                if(r3.isChecked()){
                    count+=1;
                    selected_options+=r3.getText().toString()+"\n";
                }
                countVal+=count;
                Intent intent = new Intent(MainActivity.this, Count.class);
                intent.putExtra("Count",countVal);
                intent.putExtra("Options",selected_options);
                finishActivity(0);
                startActivity(intent);
            }
        });
    }
}
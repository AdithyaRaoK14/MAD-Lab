package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class DarkMode extends AppCompatActivity {

    RadioGroup rg;
    RadioButton b,m,c;
    Button button,submit;
    PopupMenu popupMenu;
    String icecream,cuisine;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bg_dark);
        rg = findViewById(R.id.rg);
        b = findViewById(R.id.Butterscotch);
        c = findViewById(R.id.Chocolate);
        m = findViewById(R.id.Mango);
        button = findViewById(R.id.button);
        submit = findViewById(R.id.submit);
        tb = findViewById(R.id.tb);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu = new PopupMenu(DarkMode.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        cuisine = menuItem.getTitle().toString();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(i);
                icecream = rb.getText().toString();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DarkMode.this, "Cuisine: " + cuisine + "\nIcecream: " + icecream, Toast.LENGTH_SHORT).show();
            }
        });

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tb.isChecked()) {
                    Intent i = new Intent(DarkMode.this,MainActivity.class);
                    finishActivity(0);
                    startActivity(i);
                }
            }
        });
    }
}
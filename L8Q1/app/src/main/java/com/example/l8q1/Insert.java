package com.example.l8q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    SQLiteDatabase db;
    EditText name,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert3);
        db = openOrCreateDatabase("MAD",MODE_PRIVATE,null);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        Button insert = findViewById(R.id.insertbutton);
        Button back = findViewById(R.id.back);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    db.execSQL("INSERT INTO CONTACT VALUES("+ email.getText().toString() +","+ phone.getText().toString() +","+ name.getText().toString() +")");
                    Toast.makeText(Insert.this,"Inserted Successfully",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(Insert.this,"Error Inserting",Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insert.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

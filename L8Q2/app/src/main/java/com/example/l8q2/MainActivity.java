    package com.example.l8q2;

    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.os.Bundle;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.Spinner;
    import android.widget.TextView;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        Spinner spinner;
        TextView cost;
        Button add, get;
        DBHandler dbHandler;
        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            spinner = findViewById(R.id.spinner);
            cost = findViewById(R.id.cost);
            add = findViewById(R.id.add);
            get = findViewById(R.id.bill);
            cost.setText("Total Cost: 0$");

            dbHandler = new DBHandler(this);
            ArrayList<String> items = dbHandler.getItems(dbHandler.database);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
            spinner.setAdapter(adapter);

            add.setOnClickListener(view -> {
                String numberOnly = cost.getText().toString().replaceAll("[^0-9.]", "");
                double total_cost = Double.parseDouble(numberOnly);
                numberOnly = spinner.getSelectedItem().toString().replaceAll("[^0-9.]", "");
                double item_cost = Double.parseDouble(numberOnly);
                cost.setText("Total Cost: " + (item_cost + total_cost) + "$");
                dbHandler.insertBillItem(MainActivity.this, spinner.getSelectedItem().toString().split(" - ")[0], (float) item_cost);
            });

            get.setOnClickListener(view -> {
                dbHandler.getBillItems(MainActivity.this);
                cost.setText("Total Cost: 0$");
            });

        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            dbHandler.closeDatabase();
        }

        @Override
        protected void onPause() {
            super.onPause();
            dbHandler.closeDatabase();
        }
    }
    package com.example.l8q4;
    
    import androidx.appcompat.app.AppCompatActivity;
    
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.ContextMenu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.Toast;
    
    import java.util.ArrayList;
    import java.util.Objects;

    public class ViewStudents extends AppCompatActivity {
    
        ListView list;
        Button back;
        DBHandler dbHandler;
        ArrayList<String> names;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_students);
    
            list = findViewById(R.id.list);
            back = findViewById(R.id.back);
    
            dbHandler = new DBHandler(this);
            names = dbHandler.getStudentNames();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
            list.setAdapter(adapter);
            registerForContextMenu(list);
    
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ViewStudents.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
    
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
    
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            assert info != null;
            int position = info.position; // Get the position of the long-pressed item
            if (Objects.equals(item.getTitle(), "Delete")) {
                dbHandler.deleteStudent(list.getItemAtPosition(position).toString());
                names.remove(position);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names);
                list.setAdapter(adapter);
                Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId()==R.id.Display){
                ArrayList<String> details = dbHandler.getStudentDetails(list.getItemAtPosition(position).toString());
                Intent i = new Intent(ViewStudents.this,DisplayStudents.class);
                i.putExtra("regno",details.get(0));
                i.putExtra("name",details.get(1));
                i.putExtra("sem",details.get(2));
                i.putExtra("faculty",details.get(3));
                i.putExtra("branch",details.get(4));
                startActivity(i);
            }
            return true;
        }
    }
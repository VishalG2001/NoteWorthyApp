package com.example.notyy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText et;
    FloatingActionButton fab;
    FloatingActionButton ub;
    ArrayAdapter noteAdapter;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase database;


 static ArrayList<String> stringList = new ArrayList<>();


    //String notes[] = {"Vishal", "Kunal vishLjefihs gsjkjb ebrh fgdsbjb sjnjdr jfekbr rehrbbr gd", "Neha", "Karishma", "manju"};

    @SuppressLint(value = {"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        // et = findViewById(R.id.pictext);
        fab = findViewById(R.id.addnewnote);
        ub = findViewById(R.id.updatebutton);
        dataBaseHelper = new DataBaseHelper(MainActivity.this);

         //showNotesOnListView();

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "create new note", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        public void openNewNote(View) {Toast.makeText(this, "new note created..", Toast.LENGTH_SHORT).show();}
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "new note created..", Toast.LENGTH_SHORT).show();
                Intent nnote = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(nnote);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the cursor associated with the adapter
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);

                // Extract the data from the cursor and create a NoteModel object
                int id2 = cursor.getInt(cursor.getColumnIndexOrThrow("ID"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("TITLE_TITLE"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("NOTE_NOTE"));

                NoteModel clickedNote = new NoteModel(id2 , title, content); // Assuming appropriate constructor

                // Now you have the NoteModel object associated with the clicked item
                // Proceed with your delete operation using this object
                dataBaseHelper.deleteNote(clickedNote);
                //showNotesOnListView();
//                Cursor newCursor = (Cursor) dataBaseHelper.getlistnote(); // Assuming getAllNotes() returns a new cursor with updated data
//                ((CursorAdapter) listView.getAdapter()).swapCursor(newCursor);
                return true;
            }
        });

        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //almost workinng maybe issue with 2 activities
                List<NoteModel> everynote = dataBaseHelper.getlistnote();
                Toast.makeText(MainActivity.this, everynote.toString(), Toast.LENGTH_SHORT).show();


            }
        });
        // Open your SQLite database (replace "YourDatabaseName" with your actual database name)
        database = openOrCreateDatabase("notes.db", MODE_PRIVATE, null);

        // Replace "YourTableName" with the actual name of your table
        Cursor cursor = database.rawQuery("SELECT ID as _id, * FROM notty", null);

        // Create and set the custom adapter
        CustomAdapter adapter = new CustomAdapter(this, cursor);
        listView.setAdapter(adapter);

    }

    private void showNotesOnListView() {
        List<NoteModel> everynote = dataBaseHelper.getlistnote() ;

        noteAdapter = new ArrayAdapter<NoteModel>(MainActivity.this, android.R.layout.simple_list_item_1,dataBaseHelper.getlistnote());
        listView.setAdapter(noteAdapter);
    }
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        if (database != null) {
            database.close();
        }
    }

    protected void deleteNoteClick(){

    }
}
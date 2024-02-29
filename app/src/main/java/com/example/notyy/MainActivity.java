package com.example.notyy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.widget.Adapter;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
         showNotesOnListView();

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
        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //almost workinng maybe issue with 2 activities
                List<NoteModel> everynote = dataBaseHelper.getlistnote();
                Toast.makeText(MainActivity.this, everynote.toString(), Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void showNotesOnListView() {
        List<NoteModel> everynote = dataBaseHelper.getlistnote() ;

        noteAdapter = new ArrayAdapter<NoteModel>(MainActivity.this, android.R.layout.simple_list_item_1,dataBaseHelper.getlistnote());
        listView.setAdapter(noteAdapter);
    }
}
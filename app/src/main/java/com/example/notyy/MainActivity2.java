package com.example.notyy;

import static com.example.notyy.MainActivity.stringList;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
EditText txtview;
EditText txtview2;
Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtview = findViewById(R.id.titlenote);
        txtview2 = findViewById(R.id.notenote);
        button = findViewById(R.id.savenote);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check1 = txtview.getText().toString();
                String check2 = txtview2.getText().toString();
                if (check1.length()==0 && check2.length()==0){
                    Intent send = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(send);
                    Toast.makeText(MainActivity2.this, "Nothing to Save", Toast.LENGTH_SHORT).show();
                }else{
                NoteModel noteModel = new NoteModel(1,txtview.getText().toString(),txtview2.getText().toString());
                Intent send = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(send);
                Toast.makeText(MainActivity2.this, "note added", Toast.LENGTH_SHORT).show();
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity2.this);
                boolean success = dataBaseHelper.addNote(noteModel);
                //Toast.makeText(MainActivity2.this, "Success= "+success, Toast.LENGTH_SHORT).show();

            }}



        });

    }
}
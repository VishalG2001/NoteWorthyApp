package com.example.notyy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String NOTTY = "notty";
    public static final String TITLE_TITLE = "TITLE_TITLE";
    public static final String NOTE_NOTE = "NOTE_NOTE";
    public static final String ID_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "notes.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String newnote = "CREATE TABLE " + NOTTY + "(" + ID_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE_TITLE + " TEXT," + NOTE_NOTE + " TEXT )";
        db.execSQL(newnote);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean deleteNote(NoteModel noteModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String delnote ="DELETE  FROM " + NOTTY + " WHERE " + ID_ID + " = " + noteModel.getId();
        Cursor cursor = db.rawQuery(delnote, null);
        if (cursor.moveToFirst()){
            return true;
        }

        else {
        return false;
    }}

    public boolean addNote(NoteModel noteModel) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE_TITLE, noteModel.getTitle());
        contentValues.put(NOTE_NOTE, noteModel.getNote());
        long insert = db.insert(NOTTY, null, contentValues);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public List<NoteModel> getlistnote(){
        List<NoteModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ NOTTY;
        SQLiteDatabase db= this.getReadableDatabase();  //change it to this.getWritableDatabase()
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do {
                int noteID=cursor.getInt(0);
                String titleNamee = cursor.getString(1);
                String noteNamee = cursor.getString(2);
                NoteModel newNote = new NoteModel(noteID,titleNamee,noteNamee);

                returnList.add(newNote);

            }while (cursor.moveToNext());
        }else {

        }
        cursor.close();
        db.close();
        return returnList;
    }
}

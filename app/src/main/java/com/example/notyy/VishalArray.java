//package com.example.notyy;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.database.Cursor;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.cursoradapter.widget.CursorAdapter;
//import androidx.cursoradapter.widget.SimpleCursorAdapter;
//
//import java.util.ArrayList;
//
//public class VishalArray extends CursorAdapter {
//
//    public VishalArray(Context context, Cursor cursor) {
//        super(context, cursor, 0);
//    }
//
//    public View newView(VishalArray VishalArray.this, Cursor cursor, ViewGroup parent) {
//        // Inflate your custom layout for each item
//        return LayoutInflater.from(MainActivity.this).inflate(R.layout.layy, parent, false);
//    }
//
//    @Override
//    public void bindView(View view, Context context, Cursor cursor) {
//        // Access the two columns from the cursor
//        String upperText = cursor.getString(cursor.getColumnIndexOrThrow("columnUpper"));
//        String lowerText = cursor.getString(cursor.getColumnIndexOrThrow("columnLower"));
//
//        // Set the two lines of text in your custom layout
//        TextView textViewUpper = view.findViewById(R.id.textViewUpper);
//        TextView textViewLower = view.findViewById(R.id.textViewLower);
//
//        textViewUpper.setText(upperText);
//        textViewLower.setText(lowerText);
//    }
//
//    @Override
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        return null;
//    }
//}
//

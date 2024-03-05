package com.example.notyy;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomAdapter extends CursorAdapter {

    public CustomAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.layy, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewColumn1 = view.findViewById(R.id.textViewUpper);
        TextView textViewColumn2 = view.findViewById(R.id.textViewLower);

        // Assuming that "column1" and "column2" are the column names in your database
        String column1Value = cursor.getString(cursor.getColumnIndexOrThrow("TITLE_TITLE"));
        String column2Value = cursor.getString(cursor.getColumnIndexOrThrow("NOTE_NOTE"));

        textViewColumn1.setText(column1Value);
        textViewColumn2.setText(column2Value);
    }
}

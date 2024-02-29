package com.example.notyy;

public class NoteModel {
    private int id;
    private String title;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void setNote(String note) {
        this.note = note;
    }

    public NoteModel(int id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }



}
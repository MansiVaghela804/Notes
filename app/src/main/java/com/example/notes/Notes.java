package com.example.notes;

import android.util.EventLogTags;

public class Notes {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_DESCRIPTION = "description";

    private int id;
    private String note;
    private String description;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_DESCRIPTION + " TEXT "
                    + ")";

    public Notes() {
    }

    public Notes(int id, String note, String description) {
        this.id = id;
        this.note = note;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

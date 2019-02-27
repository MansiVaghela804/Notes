package com.example.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Db_Name";
    private static final int VERSION = 1;

    public DbHelper(Context ctxt) {
        super(ctxt, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Notes.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Notes.TABLE_NAME);
        onCreate(db);
    }

    public void insertNote(Notes note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Notes.COLUMN_NOTE, note.getNote());
        cv.put(Notes.COLUMN_DESCRIPTION, note.getDescription());
//      Insert Row
        db.insert(Notes.TABLE_NAME, null, cv);

//        DB Connection Close
        db.close();
    }
    public Cursor GetPrice(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(
                Notes.TABLE_NAME,
                new String[]{Notes.COLUMN_ID,Notes.COLUMN_NOTE,Notes.COLUMN_DESCRIPTION},
                null,null,null,null,null);
        return cursor;
    }
    public int UpdateNote(Notes note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Notes.COLUMN_NOTE, note.getNote());
        values.put(Notes.COLUMN_DESCRIPTION, note.getNote());
        // updating row
        return db.update(Notes.TABLE_NAME, values, Notes.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void DeleteNote(Notes note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Notes.TABLE_NAME, Notes.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

    public ArrayList<Notes> getNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Notes.TABLE_NAME,
                new String[]{Notes.COLUMN_NOTE, Notes.COLUMN_DESCRIPTION},
                null,null,
                null,null,null);

        ArrayList<Notes> notes = new ArrayList<>();
        while(cursor.moveToNext()){
            Notes note = new Notes();
            note.setNote(cursor.getString(cursor.getColumnIndex(Notes.COLUMN_NOTE)));
            note.setDescription(cursor.getString(cursor.getColumnIndex(Notes.COLUMN_DESCRIPTION)));
            notes.add(note);
        }
        return notes;

    }
}
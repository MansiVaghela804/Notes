package com.example.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
package com.example.lets_go;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "card.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_card";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "card_name";
    private static final String COLUMN_CB1 = "checkbox1";
    private static final String COLUMN_CB2 = "checkbox2";
    private static final String COLUMN_CB3 = "checkbox3";
    private static final String COLUMN_CB4 = "checkbox4";
    private static final String COLUMN_CB5 = "checkbox5";
    private static final String COLUMN_CB6 = "checkbox6";
    private static final String COLUMN_CB7 = "checkbox7";
    private static final String COLUMN_CB8 = "checkbox8";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CB1  + " TEXT, " +
                COLUMN_CB2  + " TEXT, " +
                COLUMN_CB3  + " TEXT, " +
                COLUMN_CB4  + " TEXT, " +
                COLUMN_CB5  + " TEXT, " +
                COLUMN_CB6  + " TEXT, " +
                COLUMN_CB7  + " TEXT, " +
                COLUMN_CB8  + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addCard(String name, String cb1, String cb2, String cb3, String cb4, String cb5, String cb6, String cb7, String cb8){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_CB1, cb1);
        cv.put(COLUMN_CB2, cb2);
        cv.put(COLUMN_CB3, cb3);
        cv.put(COLUMN_CB4, cb4);
        cv.put(COLUMN_CB5, cb5);
        cv.put(COLUMN_CB6, cb6);
        cv.put(COLUMN_CB7, cb7);
        cv.put(COLUMN_CB8, cb8);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){ //fail 시
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Succesfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}

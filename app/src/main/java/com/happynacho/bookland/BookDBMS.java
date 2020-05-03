package com.happynacho.bookland;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDBMS extends SQLiteOpenHelper {

    private static final String DB_FILE = "id13441212_dbbooks";
    private static final String TABLE = "Books";
    private static final String FIELD_ID_BOOK = "id_book";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_AUTHOR = "author";
    private static final String FIELD_CATEGORY = "category";
    private static final String FIELD_EDITORIAL = "editorial";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_PRICE = "price";
    private static final String FIELD_PICTURE = "url_picture";

    public BookDBMS(Context context){

        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID_BOOK + " INT PRIMARY KEY, " +
                FIELD_TITLE + " TEXT NOT NULL, " +
                FIELD_AUTHOR + " TEXT NOT NULL, " +
                FIELD_CATEGORY + " TEXT NOT NULL, " +
                FIELD_EDITORIAL + " TEXT NOT NULL, " +
                FIELD_DESCRIPTION + " TEXT NOT NULL, " +
                FIELD_PRICE + " TEXT NOT NULL, " +
                FIELD_PICTURE + " TEXT NOT NULL)";
        db.execSQL(query);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE;
        String[] params = {TABLE};
        db.execSQL(query, params);
    }
}

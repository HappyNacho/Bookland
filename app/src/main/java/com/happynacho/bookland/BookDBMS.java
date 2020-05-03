package com.happynacho.bookland;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class BookDBMS extends SQLiteOpenHelper {

    private static final String DB_FILE = "id13441212_dbbookssV3";
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

        db.execSQL("drop table if exists "+ TABLE);
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID_BOOK + " TEXT PRIMARY KEY, " +
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
    public boolean insertBook(Book book)
    {
        SQLiteDatabase database = this.getWritableDatabase(); // We obtain an instance of our database
        ContentValues contentValues = new ContentValues(); // We insert the data using one variable of type ContentValues
        contentValues.put("id_book", Integer.parseInt(book.getId()));
        contentValues.put("title", book.getTitle());
        contentValues.put("author", book.getAuthor());
        contentValues.put("category", book.getCategory());
        contentValues.put("editorial", book.getEditorial());
        contentValues.put("description", book.getDescription());
        contentValues.put("price", book.getPrice());
        contentValues.put("url_picture", book.getUrl_image());
        database.insert("Books",null,contentValues); //We insert

        return true;
    }
    public ArrayList<Book> getAllBooks()
    {
        // This arraylist defines a personalized list containing objects of type "User"
        // Managing the instance of Table as a Java Class allows to have control of
        // data from table.

        ArrayList<Book> users_list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor result = database.rawQuery("SELECT * FROM "+TABLE, null);
        Log.e(null ,"SELECT * FROM "+TABLE);

        if(result.moveToFirst()) {
            Log.e(null, "We have data, OHH YEAAAH!!");
            while (result.moveToNext()) {
                Book current_book = new Book(
                        result.getString(result.getColumnIndex(FIELD_ID_BOOK)),
                        result.getString(result.getColumnIndex(FIELD_TITLE)),
                        result.getString(result.getColumnIndex(FIELD_AUTHOR)),
                        result.getString(result.getColumnIndex(FIELD_CATEGORY)),
                        result.getString(result.getColumnIndex(FIELD_EDITORIAL)),
                        result.getString(result.getColumnIndex(FIELD_DESCRIPTION)),
                        result.getString(result.getColumnIndex(FIELD_PRICE)),
                        result.getString(result.getColumnIndex(FIELD_PICTURE))
                );
                users_list.add(current_book);
            }
        }
        else
            Log.e(null, "Oh no, no data!!");

        return users_list;
    }
}

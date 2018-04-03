package com.example.majedibrahim.synonymfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by majedibrahim on 3/24/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "synonyms.db";
    private static final String TABLE_NAME = "synonyms";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";

    SQLiteDatabase sqLiteDatabase;
    private static final String TABLE_CREATE = "create table synonyms (id integer primary key not null , " +
            "word text not null , synonym text not null);";


    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase = sqLiteDatabase;

    }


    public void insertWord(contact c)
    {
     sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from synonyms";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_WORD , c.getWord());
        values.put(COLUMN_SYNONYM , c.getSynonym());

        sqLiteDatabase.insert(TABLE_NAME , null , values);
        sqLiteDatabase.close();

    }

    public String searchSyn(String word)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "select word , synonym from "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do {
              a = cursor.getString(0);


                if(a.equals(word))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }
    public String searchSyn1(String word)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "select word , synonym "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do {

                b = cursor.getString(1);

                if(b.equals(word))
                {
                    a = cursor.getString(0);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);

    }
}

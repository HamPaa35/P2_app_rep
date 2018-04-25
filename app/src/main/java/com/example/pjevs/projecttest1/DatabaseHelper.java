package com.example.pjevs.projecttest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "itemsAndCategories.db";
    public static final String TABLE_ITEMS = "items";
    public static final String COLUM_NAME = "name";
    public static final String COLUM_ITEMCATEGORY = "itemCategory";
    public static final String COLUM_DATE = "expirationDate";
    public static final String COLUM_STORAGEMETHOD = "storageMethod";
    public static final String COLUM_OPENCLOSED = "openClosed";



    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

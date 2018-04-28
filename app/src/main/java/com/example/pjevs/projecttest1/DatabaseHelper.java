package com.example.pjevs.projecttest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {

    //This is needed in case the dataBase changes version, this is so the app can reference the new or old version
    private static final int DATABASE_VERSION = 1;
    //The Name of the dataBase
    private static final String DATABASE_NAME = "itemsAndCategories.db";
    //The name of the table in the dataBase
    public static final String TABLE_ITEMS = "items";
    //The different columns in the dataBase
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ITEMCATEGORY = "itemCategory";
    public static final String COLUMN_DATE = "expirationDate";
    public static final String COLUMN_STORAGEMETHOD = "storageMethod";
    public static final String COLUMN_OPENCLOSED = "openClosed";

    //The constructor of the dataBase
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //This method creates a quary in the SQLite syntax, that creates the dataBase with the right data fields of the right type
    @Override
    public void onCreate(SQLiteDatabase db) {
        String quary = "CREATE TABLE " + TABLE_ITEMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT" + ");";
        db.execSQL(quary);
    }

    //This deletes the old table if we ever update it, not sure why we would do this
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    //This method adds the the item with its name to the dataBase
    public void addItem (ItemClass item){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, ItemClass.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    //This would delete the entry in the dataBase
    public void deleteItem (String itemName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_NAME + "=\"" + itemName + "\";");
    }

    //This does not work at all
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        //This is properly the error
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name")) != null) {
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}

package com.example.pjevs.projecttest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    //This is needed in case the dataBase changes version, this is so the app can reference the new or old version
    private static final int DATABASE_VERSION = 1;
    //The Name of the dataBase
    private static final String DATABASE_NAME = "itemsAndCategories.db";
    //The name of the table in the dataBase
    public static final String TABLE_ITEMS = "items";
    //The different columns in the dataBase

    public static final String COLUMN_ITEM_ARRAY = "itemArray";

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
                COLUMN_ITEM_ARRAY + " TEXT " +
                //COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //COLUMN_NAME + " TEXT," +
                //COLUMN_ITEMCATEGORY + " TEXT," +
                //COLUMN_DATE + " TEXT," +
                //COLUMN_STORAGEMETHOD + " TEXT," +
                //COLUMN_OPENCLOSED + " TEXT" +
                ");";
        db.execSQL(quary);
    }

    //This deletes the old table if we ever update it, not sure why we would do this
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    /*public void addSerialArray(ArrayList arrayList) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("uniqueArrays", new JSONArray(arrayList));
        String serialArrayList = json.toString();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, serialArrayList);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }*/

    /*public ArrayList getSerialArray() throws JSONException {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("name"));
            }while (c.moveToNext());
        }
        db.close();
        JSONObject json = new JSONObject(dbString);

        ArrayList itemsFromDB = json.optJSONArray("uniqueArrays");

        return itemsFromDB;
    }*/

    //This method adds the the item with its name to the dataBase
    public void addItem (ItemClass item){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.getName());
        values.put(COLUMN_ITEMCATEGORY, item.getItemCategory());
        values.put(COLUMN_DATE, item.getExpirationDate());
        values.put(COLUMN_STORAGEMETHOD, item.getStorageMethod());
        values.put(COLUMN_OPENCLOSED, item.getOpenClosed());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    //This would delete the entry in the dataBase
    public void deleteItem (String itemName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_NAME + "=\"" + itemName + "\";");
    }

    public ArrayList<String> getItemList(){
            ArrayList<String> itemList = new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMS, new String[]{COLUMN_NAME, COLUMN_ITEMCATEGORY, COLUMN_DATE}, null, null, null,null,null);
        while (cursor.moveToNext()){
            int index = cursor.getColumnIndex(COLUMN_NAME);
            itemList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return  itemList;
    }

    public ArrayList<ItemClass> savedItems() {
        String query = "SELECT  * FROM " + TABLE_ITEMS;

        ArrayList<ItemClass> itemsFromDatabase = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ItemClass itemFromDatabase;

        if (cursor.moveToFirst()) {
            do {
                itemFromDatabase = new ItemClass();

                itemFromDatabase.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                itemFromDatabase.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                itemFromDatabase.setItemCategory(cursor.getString(cursor.getColumnIndex(COLUMN_ITEMCATEGORY)));
                itemFromDatabase.setExpirationDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                itemFromDatabase.setStorageMethod(cursor.getString(cursor.getColumnIndex(COLUMN_STORAGEMETHOD)));
                itemFromDatabase.setOpenClosed(cursor.getString(cursor.getColumnIndex(COLUMN_OPENCLOSED)));
                itemsFromDatabase.add(itemFromDatabase);
            } while (cursor.moveToNext());
        }


        return itemsFromDatabase;
    }

    public String dbNameToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("name"));
            }while (c.moveToNext());
        }
        db.close();
        return dbString;
    }

    public String dbCategoryToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("itemCategory"));

            }while (c.moveToNext());
        }
        //This is properly the error
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name")) != null) {

            }
        }
        db.close();
        return dbString;
    }

    public String dbExpirationDateToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("expirationDate"));
            }while (c.moveToNext());
        }
        //This is properly the error
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name")) != null) {

            }
        }
        db.close();
        return dbString;
    }

    public String dbStorageMethodToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("storageMethod"));
            }while (c.moveToNext());
        }
        //This is properly the error
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name")) != null) {

            }
        }
        db.close();
        return dbString;
    }

    public String dbOpenClosedToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            do{
                dbString += c.getString(c.getColumnIndex("openClosed"));
            }while (c.moveToNext());
        }
        //This is properly the error
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name")) != null) {

            }
        }
        db.close();
        return dbString;
    }
}

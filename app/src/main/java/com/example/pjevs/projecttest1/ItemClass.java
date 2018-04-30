package com.example.pjevs.projecttest1;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.Date;



public class ItemClass extends FileManager implements Serializable{
    //The variables of the ItemClass
    private static int _id;
    private static String name;
    private static String itemCategory;
    private static String expirationDate;
    private static String storageMethod;
    private static String openClosed;
    //These constructors needs to be cleaned up at some point

    public ItemClass(){

    }

    public ItemClass(String name) {
        this.name = name;
    }

    public ItemClass(String name, Category itemCategory, String exportationDate, Storage storageMethod, String openClosed) {
        this.name = name;
        this.itemCategory = itemCategory.getName();
        this.expirationDate = exportationDate;
        this.storageMethod = storageMethod.getName();
        this.openClosed = openClosed;
    }

    public ItemClass(String name, String exportationDate, String openClosed) {
        this.name = name;
        this.expirationDate = exportationDate;
        this.openClosed = openClosed;
    }


    public static int get_id() {
        return _id;
    }

    public static void set_id(int _id) {
        ItemClass._id = _id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public static String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public static String getOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(String openClosed) {
        this.openClosed = openClosed;
    }
}

package com.example.pjevs.projecttest1;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;



public class ItemClass extends FileManager{

    public static String name;
    String itemCategory;
    String expirationDate;
    String storageMethod;
    Boolean openClosed;

    public ItemClass(String name) {
        this.name = name;
    }

    public ItemClass(String name, Category itemCategory, String expartationDate, Storage storageMethod, Boolean openClosed) {
        this.name = name;
        this.itemCategory = itemCategory.getName();
        this.expirationDate =expartationDate;
        this.storageMethod = storageMethod.getName();
        this.openClosed=openClosed;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    //public void setItemCategory(String itemCategory) {
    //    this.itemCategory = itemCategory.getName();
    //}

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    //public void setStorageMethod(Storage storageMethod) {
    //    this.storageMethod = storageMethod;
    //}

    public String getOpenClosed() {
        if (openClosed){
            return "Open";
        }
        else {
            return "Closed";
        }
    }

    public void setOpenClosed(Boolean openClosed) {
        this.openClosed = openClosed;
    }
}

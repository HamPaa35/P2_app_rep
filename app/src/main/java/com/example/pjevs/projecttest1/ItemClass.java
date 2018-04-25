package com.example.pjevs.projecttest1;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;



public class ItemClass extends FileManager{

    String name;
    Category itemCategory;
    Date expirationDate;
    Storage storageMethod;
    Boolean openClosed;

    public ItemClass(String name, Category itemCategory, Date expartationDate, Storage storageMethod, Boolean openClosed) {
        this.name=name;
        this.itemCategory=itemCategory;
        this.expirationDate =expartationDate;
        this.storageMethod=storageMethod;
        this.openClosed=openClosed;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Storage getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(Storage storageMethod) {
        this.storageMethod = storageMethod;
    }

    public Boolean getOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(Boolean openClosed) {
        this.openClosed = openClosed;
    }
}

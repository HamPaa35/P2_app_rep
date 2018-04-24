package com.example.pjevs.projecttest1;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;

public class ItemClass extends FileManager{

    String name;
    Category itemCategory;
    Date expartationDate;
    Storage storageMethod;
    Boolean openClosed;

    public ItemClass(String name, Category itemCategory, Date expartationDate, Storage storageMethod, Boolean openClosed) {
        this.name=name;
        this.itemCategory=itemCategory;
        this.expartationDate=expartationDate;
        this.storageMethod=storageMethod;
        this.openClosed=openClosed;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myStringArray);
    }

    public int i = 0;

    public String[] myStringArray = new String[i];

    ArrayAdapter adapter;


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

    public Date getExpartationDate() {
        return expartationDate;
    }

    public void setExpartationDate(Date expartationDate) {
        this.expartationDate = expartationDate;
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

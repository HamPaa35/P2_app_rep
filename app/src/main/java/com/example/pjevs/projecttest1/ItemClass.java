package com.example.pjevs.projecttest1;

import java.io.Serializable;
import java.util.ArrayList;


public class ItemClass extends FileManager implements Serializable{

    //The variables of the ItemClass
    private int _id;
    private String name;
    private String itemCategory;
    private String expirationDate;
    private String storageMethod;
    private String openClosed;
    private int spinnerCatPos;
    private int spinnerStorPos;
    static int consumedCounter;
    static int trashedCounter;
    private static ArrayList<ItemClass> itemList = new ArrayList<>();
    //These constructors needs to be cleaned up at some point

    public ItemClass(){

    }

    public ItemClass(String name) {
        this.name = name;
    }

    public ItemClass(String name, Category itemCategory, String exportationDate, Storage storageMethod, String openClosed, int spinnerCatPos, int spinnerStorPos) {
        this.name = name;
        this.itemCategory = itemCategory.getName();
        this.expirationDate = exportationDate;
        this.storageMethod = storageMethod.getName();
        this.openClosed = openClosed;
        this.spinnerCatPos = spinnerCatPos;
        this.spinnerStorPos = spinnerStorPos;

        itemList.add(this);
    }

    public ItemClass(String name, String itemCategory, String exportationDate, String storageMethod, String openClosed, int spinnerCatPos, int spinnerStorPos) {
        this.name = name;
        this.itemCategory = itemCategory;
        this.expirationDate = exportationDate;
        this.storageMethod = storageMethod;
        this.openClosed = openClosed;
        this.spinnerCatPos = spinnerCatPos;
        this.spinnerStorPos = spinnerStorPos;

        itemList.add(this);
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(String openClosed) {
        this.openClosed = openClosed;
    }

    public int getSpinnerCatPos() {
        return spinnerCatPos;
    }

    public void setSpinnerCatPos(int spinnerCatPos) {
        this.spinnerCatPos = spinnerCatPos;
    }

    public int getSpinnerStorPos() {
        return spinnerStorPos;
    }

    public void setSpinnerStorPos(int spinnerStorPos) {
        this.spinnerStorPos = spinnerStorPos;
    }

    public static ArrayList<ItemClass> getItemList() {
        return itemList;
    }

    public static void setItemList(ArrayList<ItemClass> itemList) {
        ItemClass.itemList = itemList;
    }

    public static int getPercentageOfItemsConsumed(){
        int percentage;
        if (ItemClass.consumedCounter == 0 && ItemClass.trashedCounter == 0) {
            percentage = 100;
        } else if (ItemClass.consumedCounter == 0 && ItemClass.trashedCounter == 1) {
            percentage = 0;
        } else {
            percentage = ItemClass.consumedCounter*100/(ItemClass.consumedCounter+ItemClass.trashedCounter);
        }
        return percentage;
    }
}

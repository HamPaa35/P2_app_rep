package com.example.pjevs.projecttest1;

import java.util.ArrayList;

public class Category extends FileManager {

    //The attributes for the Category class
    private String name;
    private String TypicalExpirationOpen;
    private String TypicalExpirationClosed;
    private String storageMethod;
    private static ArrayList<Category> categoryList = new ArrayList<Category>();

    //The constructor of the Category class
    public Category (String name, String TypicalExpirationOpen, String TypicalExpirationClosed, String storageMethod){
        this.name = name;
        this.TypicalExpirationOpen = TypicalExpirationOpen;
        this.TypicalExpirationClosed = TypicalExpirationClosed;
        this.storageMethod = storageMethod;

        categoryList.add(this);
    }
// Getter- and setter-methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypicalExpirationOpen() {
        return TypicalExpirationOpen;
    }

    public void setTypicalExpirationOpen(String typicalExpirationOpen) {
        this.TypicalExpirationOpen = typicalExpirationOpen;
    }

    public String getTypicalExpirationClosed() {
        return TypicalExpirationClosed;
    }

    public void setTypicalExpirationClosed(String typicalExpirationClosed) {
        TypicalExpirationClosed = typicalExpirationClosed;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public static ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    public static void setItemList(ArrayList<Category> itemList) {
        Category.categoryList = itemList;
    }

    public static ArrayList<String> getCategoryToStringArrList(){
        ArrayList<String> categoryToStringArrList = new ArrayList<String>();
        for(Category category : categoryList){
            categoryToStringArrList.add(category.getName());
        }
        return categoryToStringArrList;
    }

    @Override
    public String toString() {
        String category = ("Name " + name + "Typical expiration when opened: " + TypicalExpirationOpen +
        "Typical expiration when closed: " + TypicalExpirationClosed + "Is typically stored in: " +
                storageMethod);
        return category;
    }
}

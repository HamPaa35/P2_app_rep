package com.example.pjevs.projecttest1;

import java.io.Serializable;
import java.util.ArrayList;

public class Category extends FileManager implements Serializable {

    //The attributes for the Category class
    private String name;
    private String TypicalExpirationOpen;
    private String TypicalExpirationClosed;
    private String storageMethod;
    private int spinnerCatPos;
    private int spinnerStorPos;
    private Boolean isFavorite = false;
    private static ArrayList<Category> categoryList = new ArrayList<Category>();
    private static ArrayList<String> categoryListArrString = Category.getCategoryToStringArrList();
    private static String[] categoryListString = categoryListArrString.toArray(new String[categoryListArrString.size()]);

    //The constructor of the Category class
    public Category (String name, String TypicalExpirationOpen, String TypicalExpirationClosed, String storageMethod, int spinnerStorPos){
        this.name = name;
        this.TypicalExpirationOpen = TypicalExpirationOpen;
        this.TypicalExpirationClosed = TypicalExpirationClosed;
        this.storageMethod = storageMethod;
        this.spinnerStorPos = spinnerStorPos;

        categoryList.add(this);
    }

    public Category (String name, String TypicalExpirationOpen, String TypicalExpirationClosed, Storage storageMethod, int spinnerStorPos){
        this.name = name;
        this.TypicalExpirationOpen = TypicalExpirationOpen;
        this.TypicalExpirationClosed = TypicalExpirationClosed;
        this.storageMethod = storageMethod.getName();
        this.spinnerStorPos = spinnerStorPos;

        categoryList.add(this);
    }

    public Category (String name, String TypicalExpirationOpen, String TypicalExpirationClosed, String storageMethod, int spinnerStorPos, boolean isFavorite){
        this.name = name;
        this.TypicalExpirationOpen = TypicalExpirationOpen;
        this.TypicalExpirationClosed = TypicalExpirationClosed;
        this.storageMethod = storageMethod;
        this.spinnerStorPos = spinnerStorPos;
        this.isFavorite = isFavorite;

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

    public static void setCategoryList(ArrayList<Category> catList) {
        Category.categoryList = catList;
    }

    public static ArrayList<String> getCategoryToStringArrList(){
        ArrayList<String> categoryToStringArrList = new ArrayList<String>();
        for(Category category : categoryList){
            categoryToStringArrList.add(category.getName());
        }
        return categoryToStringArrList;
    }

    public static String[] getCategoryListString() {
        return categoryListString;
    }

    public static void setCategoryListString(String[] categoryListString) {
        Category.categoryListString = categoryListString;
    }

    public int getSpinnerStorPos() {
        return spinnerStorPos;
    }

    public void setSpinnerStorPos(int spinnerStorPos) {
        this.spinnerStorPos = spinnerStorPos;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public int getSpinnerCatPos() {
        return spinnerCatPos;
    }

    public void setSpinnerCatPos(int spinnerCatPos) {
        this.spinnerCatPos = spinnerCatPos;
    }

    public static ArrayList<Category> getFavCatArrList() {
        ArrayList<Category> favCatArrList = new ArrayList<>();

        for(Category category : categoryList){

            if(category.getFavorite()){
                category.setSpinnerCatPos(categoryList.indexOf(category));
                favCatArrList.add(category);
            }

        }

        return favCatArrList;
    }

    @Override
    public String toString() {
        String category = ("Name " + name + "Typical expiration when opened: " + TypicalExpirationOpen +
        "Typical expiration when closed: " + TypicalExpirationClosed + "Is typically stored in: " +
                storageMethod);
        return category;
    }
}

package com.example.pjevs.projecttest1;

public class Category extends FileManager {

    //The attributes for the Category class
    private String name;
    private int TypicalExpirationOpen;
    private int TypicalExpirationClosed;
    private String storageMethod;

    //The constructor of the Category class
    public Category (String name, int TypicalExpirationOpen, int TypicalExpirationClosed, Storage storageMethod){
        this.name = name;
        this.TypicalExpirationOpen = TypicalExpirationOpen;
        this.TypicalExpirationClosed = TypicalExpirationClosed;
        this.storageMethod = storageMethod.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypicalExpirationOpen() {
        return TypicalExpirationOpen;
    }

    public void setTypicalExpirationOpen(int typicalExpirationOpen) {
        TypicalExpirationOpen = typicalExpirationOpen;
    }

    public int getTypicalExpirationClosed() {
        return TypicalExpirationClosed;
    }

    public void setTypicalExpirationClosed(int typicalExpirationClosed) {
        TypicalExpirationClosed = typicalExpirationClosed;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    @Override
    public String toString() {
        String category = ("Name " + name + "Typical expiration when opened: " + TypicalExpirationOpen +
        "Typical expiration when closed: " + TypicalExpirationClosed + "Is typically stored in: " +
                storageMethod);
        return category;
    }
}

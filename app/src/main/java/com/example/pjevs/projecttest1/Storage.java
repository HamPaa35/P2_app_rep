package com.example.pjevs.projecttest1;

import java.util.ArrayList;

public class Storage extends FileManager {

    private static ArrayList<Storage> storageList = new ArrayList<Storage>();
    private static ArrayList<String> storageArrString = Storage.getStorageToStringArrList();
    private static String[] categoryListString = storageArrString.toArray(new String[storageArrString.size()]);

    private String name;

    public Storage(String name){
        this.name = name;

        storageList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<String> getStorageToStringArrList(){
        ArrayList<String> storageToStringArrList = new ArrayList<String>();
        for(Storage storage : storageList){
            storageToStringArrList.add(storage.getName());
        }
        return storageToStringArrList;
    }
}

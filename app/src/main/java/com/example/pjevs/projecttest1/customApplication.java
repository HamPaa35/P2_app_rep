package com.example.pjevs.projecttest1;

import android.app.Application;

public class customApplication extends Application {

    DatabaseHelper dbHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHandler = new DatabaseHelper(this, null, null, 1);
        ItemClass.setItemList(dbHandler.savedItems());
    }
}



package com.example.pjevs.projecttest1;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class customApplication extends Application {

    DatabaseHelper dbHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHandler = new DatabaseHelper(this, null, null, 1);
        ItemClass.setItemList(dbHandler.savedItems());
    }
}



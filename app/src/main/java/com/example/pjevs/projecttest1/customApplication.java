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

        //Initializing preset storages and categories
        Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Storage cupBoard = new Storage("Cupboard");


        Category brød = new Category("Brød", "5", "7", "Cupboard", 2);
        Category kød = new Category("Kød", "5", "7", "Fridge", 0);
        Category ærter = new Category("Ærter", "30", "35", "Freezer", 1);

    }
}



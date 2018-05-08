package com.example.pjevs.projecttest1;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class customApplication extends Application {

    public static boolean setupState;
    DatabaseHelper dbHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHandler = new DatabaseHelper(this, null, null, 1);
        ItemClass.setItemList(dbHandler.savedItems());
        FileManager.loadSetup(this);

        //Initializing preset storages and categories
        Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Storage cupBoard = new Storage("Cupboard");

        Category bread = new Category("Bread", "5", "7", "Cupboard", 2);

        if(!setupState) {

            Category meat = new Category("Meat", "5", "7", "Fridge", 0);
            Category peas = new Category("Peas", "30", "35", "Freezer", 1);

            ItemClass tutorialItem = new ItemClass("Tutorial item", meat, "", fridge, "Closed", 2, meat.getSpinnerStorPos());

            FileManager.saveCatData(this);
            FileManager.saveItemData(this);

            setupState = true;

            FileManager.saveSetup(this);
        }

    }
}



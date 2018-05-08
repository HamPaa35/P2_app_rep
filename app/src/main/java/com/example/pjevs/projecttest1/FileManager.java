package com.example.pjevs.projecttest1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FileManager {
    static void writeToFile() throws IOException {

    }

    public static void loadItemData(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences items", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Item list", null);
        Type type = new TypeToken<ArrayList<ItemClass>>() {}.getType();
        ArrayList<ItemClass> tempLoad;
        tempLoad = gson.fromJson(json, type);
        ItemClass.setItemList(tempLoad);
    }

    public static void saveItemData(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences items", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(ItemClass.getItemList());
        editor.putString("Item list", json);
        editor.apply();
    }

    public static void loadCatData(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences cat", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Category list", null);
        Type type = new TypeToken<ArrayList<Category>>() {}.getType();
        ArrayList<Category> tempLoad;
        tempLoad = gson.fromJson(json, type);
        Category.setCategoryList(tempLoad);
    }

    public static void saveCatData(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences cat", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Category.getCategoryList());
        editor.putString("Category list", json);
        editor.apply();
    }

    public static void saveTrashCount(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences trash", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Trash count", ItemClass.trashedCounter);
        editor.apply();
    }

    public static void loadTrashCount(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences trash", MODE_PRIVATE);
        int trashCountTemp = sharedPreferences.getInt("Trash count", 0);
        ItemClass.trashedCounter = trashCountTemp;

    }

    public static void saveConsumedCount(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences consumed", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Consumed count", ItemClass.consumedCounter);
        editor.apply();
    }

    public static void loadConsumedCount(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences consumed", MODE_PRIVATE);
        int consumedCountTemp = sharedPreferences.getInt("Consumed count", 0);
        ItemClass.consumedCounter = consumedCountTemp;
    }

    public static void saveSetup(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences setup", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Setup", customApplication.setupState);
        editor.apply();
    }

    public static void loadSetup(Context context){
        context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences setup", MODE_PRIVATE);
        Boolean setupTemp = sharedPreferences.getBoolean("Setup", false);
        customApplication.setupState = setupTemp;
    }
}

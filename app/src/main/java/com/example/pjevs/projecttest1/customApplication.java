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

    @Override
    public void onCreate() {
        super.onCreate();
        FileManager.loadSetup(this);

        //Initializing preset storages and categories
        Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Storage cupBoard = new Storage("Cupboard");

        Category bread = new Category("Bread", "5", "7", "Cupboard", 2);

        if(!setupState) {

            Category meat = new Category("Meat", "5", "7", "Fridge", 0);
            Category peas = new Category("Peas", "30", "35", "Freezer", 1);
            Category ColdCuts = new Category("Cold Cuts", "1-4 days", "14 days", "Fridge", 0);
            Category ThreeStarColdCuts = new Category("3-star cold cuts", "4-8 days", "1 month", fridge, 0);
            Category pate = new Category("pâté", "7 days", "14 days", fridge, 0);
            Category MackerelSalad = new Category("Mackerel Salad", "5 days", "1 month", fridge,0);
            Category FrozenVegetables = new Category("Frozen Vegetables", "1 day", "2 years", freezer, 1);
            Category FrenchFries = new Category("French Fries", "1 day", "1 year", freezer, 1 );
            Category FrozenRolls = new Category("Frozen rolls", "1 day", "1 year", freezer, 1);
            Category Cocoa = new Category("Cocoa", "2-3 days", "3 months", fridge, 1 );
            Category Jam = new Category("Jam", "1 year, 5 months", "1 year, 5 months", cupBoard, 2);
            Category IrmaBearnaiseSauce = new Category("Irma Bearnaise Sauce", "9 months", "9 months", cupBoard, 2);
            Category IrmaCreamSauce = new Category("Irma Cream Sauce", "10 months", "10 months", cupBoard, 2);
            Category Riberhus1960 = new Category("Riberhus 1960", "1-2 weeks", "1,5 months", fridge, 0);
            Category RiberhusSmoked = new Category("Riberhus Smoked", "1-2 weeks", "1,5 months", fridge,0);
            Category bukoChili = new Category("Buko Chili", "5 days", "3 months",fridge , 0 );
            Category bukoPikant = new Category("Buko Pikant", "5 days", "2 months", fridge , 0);
            Category bukoNaturel = new Category("Buko Naturel", "5 days", "2 months", fridge , 0);
            Category bukoMushroom = new Category("Buko Mushroom", "8 days", "3 months", fridge, 0);
            Category bukoShrimps = new Category("Buko Mushrooms", "8 days", "4 months", fridge, 0);
            Category ThiseChiliCheese = new Category("Thise Chili Cheese", "1,5 months", "1,5 months", fridge, 0);
            Category LandanaChiliCheese = new Category("Landana Chili Cheese", "3,5 months", "3,5 months", fridge, 0);
            Category CoopGratedCheddar = new Category("Coop Grated Cheddar", "2 months", "2 months", fridge, 0);
            Category CoopMoccarella = new Category("Coop Mozzarella", "3,5 months", "3,5 months", fridge, 0);
            Category CheasySaladCheese = new Category("Cheasy Salad Cheese", "4-6 days", "2 months", fridge, 0);
            Category CoopSaladCheese = new Category("Coop Salad Cheese", "4-6 days", "1 month", fridge, 0);
            Category Ribeye = new Category("Ribeye", "4 days", "4 days", fridge,0 );
            Category GrillSteak = new Category("Grill Steak", "4 days", "4 days", fridge,0 );
            Category RoastBeef = new Category("Roast Beef", "4 days", "4 days",fridge ,0 );
            Category GroundMeat = new Category("Ground Meat", "7 days", "7 days", fridge,0 );
            Category ChickenFillet = new Category("Chicken Fillet", "10 days", "10 days",fridge ,0 );
            Category Egg = new Category("Egg", "20 days", "20 days", fridge ,0 );
            Category Yoghurt = new Category("Yoghurt", "4-6 days", "20 days", fridge,0 );
            Category Butter = new Category("Butter", "2 months", "2 months", fridge,0 );
            Category Milk = new Category("Milk", "3-4 days", "10 days", fridge, 0);
            Category WhippingCream = new Category("Whipping Cream", "10 days", "10 days",fridge ,0 );



            ItemClass tutorialItem = new ItemClass("Tutorial item", meat, "", fridge, "Closed", 0, bread.getSpinnerStorPos());

            FileManager.saveCatData(this);
            FileManager.saveItemData(this);

            setupState = true;

            FileManager.saveSetup(this);
        }
    }
}



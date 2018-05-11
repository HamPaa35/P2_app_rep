package com.example.pjevs.projecttest1;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            Category bukoShrimps = new Category("Buko Shrimps", "8 days", "4 months", fridge, 0);
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
            Category LactoseFreeMilk = new Category("Lactose Free Milk", "4-5 days", "30 days",fridge ,0 );
            Category CannedBeans = new Category("Canned Beans", "2,5 years", "2,5 years", cupBoard, 2);
            Category MarinatedHerring = new Category("Marinated Herring", "10 days", "6 months",fridge ,0 );
            Category Shrimps = new Category("Shrimps", "3-5 days", "1 month",fridge ,0 );
            Category FishCakes = new Category("Fish Cakes", "4 days", "1 month",fridge ,0 );
            Category Havarti = new Category("Havarti", "1-2 weeks", "4 months", fridge,0 );
            Category EcoHavarti = new Category("Eco Havarti", "1-2 weeks", "2 months", fridge ,0 );
            Category Buns = new Category("Buns", "3-7 days", "7 days", cupBoard,2 );
            Category RyeBread = new Category("Rye Bread", "3-4 days", "7 days",cupBoard ,2 );
            Category ToastBread = new Category("Toast Bread", "3-4", "7 days", cupBoard,2 );
            Category Oatmeal = new Category("Oatmeal", "1 year", "1 year", cupBoard, 2);
            Category Crispbread = new Category("Crispbread", "6 months", "6 months", cupBoard,2 );
            Category SupermarkedCake = new Category("Supermarked Cake", "5 days", "2 months", cupBoard, 2);
            Category Sugar = new Category("Sugar", "Unlimited", "Unlimited",cupBoard ,2 );
            Category PowderedSugar = new Category("Powdered Sugar", "2,5 years", "2,5 years",cupBoard ,2 );
            Category WheatFlour = new Category("Wheat Flour", "1 year", "1 year",cupBoard ,2 );
            Category Nutella = new Category("Nutella", "10 months", "10 months",cupBoard ,2 );
            Category LayingOnChocolate = new Category("Laying-On Chocolate", "1 year, 2 months", "1 year, 2 months", fridge ,0 );
            Category SpicesSeasoning = new Category("Spices", "3-4 years", "3-4 years",cupBoard ,2 );
            Category CanMackerelFillet = new Category("Can Mackerel Fillet", "7 days", "4-5 years",cupBoard ,2 );
            Category CanRoe = new Category("Can Roe", "2 days", "2-3 years",cupBoard ,2 );
            Category Rice = new Category("Rice", "4 months", "4 months", cupBoard,2 );
            Category EcoSpaghetti = new Category("Eco Spaghetti", "6 months", "6 months", cupBoard,2 );
            Category WholemealSpaghetti = new Category("Wholemeal Spaghetti", "2,5 months", "2,5 months",cupBoard ,2 );
            Category CoopSpaghetti = new Category("Coop Spaghetti", "2,5 years", "2,5 years",cupBoard ,2 );







            sortTheCategoryListAlphabetically();

            ItemClass tutorialItem = new ItemClass("Tutorial item", meat, "", fridge, "Closed", 0, bread.getSpinnerStorPos());

            FileManager.saveCatData(this);
            FileManager.saveItemData(this);

            setupState = true;

            FileManager.saveSetup(this);
        }
    }
    public static void sortTheCategoryListAlphabetically(){
        Collections.sort(Category.getCategoryList(), new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getName().compareTo(o2.getName());
        }
        });
    }
}



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
            Category ColdCuts = new Category("Cold Cuts", "4", "14", "Fridge", 0);
            Category ThreeStarColdCuts = new Category("3-star cold cuts", "4", "30", fridge, 0);
            Category pate = new Category("Pâté", "7", "14", fridge, 0);
            Category MackerelSalad = new Category("Mackerel Salad", "5", "30", fridge,0);
            Category FrozenVegetables = new Category("Frozen Vegetables", "1", "730", freezer, 1);
            Category FrenchFries = new Category("French Fries", "1", "365", freezer, 1 );
            Category FrozenRolls = new Category("Frozen rolls", "1", "365", freezer, 1);
            Category Cocoa = new Category("Cocoa", "3", "90", fridge, 1 );
            Category Jam = new Category("Jam", "547", "547", cupBoard, 2);
            Category IrmaBearnaiseSauce = new Category("Bearnaise Sauce", "270", "270", cupBoard, 2);
            Category IrmaCreamSauce = new Category("Cream Sauce", "300", "300", cupBoard, 2);
            Category Riberhus = new Category("Cheese Riberhus", "7", "45", fridge, 0);
            Category bukoCheese = new Category("Cheese Buko", "5-8", "60",fridge , 0 );
            Category ThiseChiliCheese = new Category("Thise Chili Cheese", "45", "45", fridge, 0);
            Category LandanaChiliCheese = new Category("Landana Chili Cheese", "105", "105", fridge, 0);
            Category CoopGratedCheddar = new Category("Coop Grated Cheddar", "60", "60", fridge, 0);
            Category CoopMoccarella = new Category("Coop Mozzarella", "105", "105", fridge, 0);
            Category CheasySaladCheese = new Category("Salad Cheese", "6", "30", fridge, 0);
            Category Steak = new Category("Steak Beef", "4", "4", fridge,0 );
            Category ChickenFillet = new Category("Chicken Fillet", "10", "10",fridge ,0 );
            Category Egg = new Category("Egg", "20", "20", fridge ,0 );
            Category Yoghurt = new Category("Yoghurt", "6", "20", fridge,0 );
            Category Butter = new Category("Butter", "60", "60", fridge,0 );
            Category Milk = new Category("Milk", "4", "10", fridge, 0);
            Category WhippingCream = new Category("Whipping Cream", "10", "10",fridge ,0 );
            Category LactoseFreeMilk = new Category("Lactose Free Milk", "5", "30",fridge ,0 );
            Category CannedBeans = new Category("Canned Beans", "912", "912", cupBoard, 2);
            Category MarinatedHerring = new Category("Marinated Herring", "10", "180",fridge ,0 );
            Category Shrimps = new Category("Shrimps", "5", "30",fridge ,0 );
            Category FishCakes = new Category("Fish Cakes", "4", "30",fridge ,0 );
            Category Havarti = new Category("Havarti", "10", "120", fridge,0 );
            Category EcoHavarti = new Category("Eco Havarti", "10", "60", fridge ,0 );
            Category Buns = new Category("Buns", "4", "7", cupBoard,2 );
            Category RyeBread = new Category("Rye Bread", "4", "7",cupBoard ,2 );
            Category ToastBread = new Category("Toast Bread", "4", "7", cupBoard,2 );
            Category Oatmeal = new Category("Oatmeal", "365", "365", cupBoard, 2);
            Category Crispbread = new Category("Crispbread", "180", "180", cupBoard,2 );
            Category SupermarkedCake = new Category("Supermarked Cake", "5", "60", cupBoard, 2);
            Category Sugar = new Category("Sugar", "1095", "1095",cupBoard ,2 );
            Category PowderedSugar = new Category("Powdered Sugar", "912", "912",cupBoard ,2 );
            Category WheatFlour = new Category("Wheat Flour", "395", "365",cupBoard ,2 );
            Category Nutella = new Category("Nutella", "300", "300",cupBoard ,2 );
            Category LayingOnChocolate = new Category("Laying-On Chocolate", "425", "425", fridge ,0 );
            Category SpicesSeasoning = new Category("Spices", "1095", "1095",cupBoard ,2 );
            Category CanMackerelFillet = new Category("Can Mackerel Fillet", "7", "1400",cupBoard ,2 );
            Category CanRoe = new Category("Can Roe", "2", "1095",cupBoard ,2 );
            Category Rice = new Category("Rice", "120", "120", cupBoard,2 );
            Category EcoSpaghetti = new Category("Eco Spaghetti", "180", "180", cupBoard,2 );
            Category WholemealSpaghetti = new Category("Wholemeal Spaghetti", "75", "75",cupBoard ,2 );
            Category CoopSpaghetti = new Category("Spaghetti", "912", "912",cupBoard ,2 );
            Category Pasta = new Category("Pasta", "1095", "1095", cupBoard ,2 );
            Category Pickles = new Category("Pickles", "730", "730",fridge ,0 );
            Category Gherkins = new Category("Gherkins", "730", "730",fridge ,0 );
            Category Beets = new Category("Beets", "730", "730",fridge ,0 );
            Category CannedCorn = new Category("Canned Corn", "2", "1095",cupBoard ,2 );
            Category CannedPotatoes = new Category("Canned Potatoes", "2", "730",fridge ,0 );
            Category Remoulade = new Category("Remoulade", "105", "105", fridge,0 );
            Category Mayo = new Category("Mayo", "120", "120", fridge,0 );
            Category BeauvaisKetchup = new Category("Ketchup", "120", "60", fridge, 0);
            Category Mustard = new Category("Mustard", "150", "150", fridge, 0);
            Category CoopSourCreame = new Category("Sour Cream", "240", "240", fridge, 0);
            Category CoopThousandIsland = new Category("Thousand Island", "240", "240", fridge, 0);
            Category GarlicDressing = new Category("Garlic Dressing", "270", "270", fridge, 0);
            Category PastaSauce = new Category("Pasta Sauce", "730", "730", cupBoard, 2);
            Category CocaCola = new Category("Coca Cola", "5", "180", fridge, 0);
            Category EcoOrangeJuice = new Category("Eco Orange Juice", "5", "300", fridge, 0);
            Category CoopOrangeJuice = new Category("Orange Juice", "5", "30", fridge, 0);
            Category EcoAppleJuice = new Category("Eco Apple Juice", "5", "300", fridge, 0);
            Category CoopAppleJuice = new Category("Apple Juice", "5", "30", fridge, 0);

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



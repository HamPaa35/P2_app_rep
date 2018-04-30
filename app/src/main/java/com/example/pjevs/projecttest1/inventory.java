package com.example.pjevs.projecttest1;


import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;




public class inventory extends AppCompatActivity {

    private static final String TAG = "Inventory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Log.d(TAG, "onCreate: Started");
        ListView foodList = (ListView) findViewById(R.id.foodList);

        Intent addItemIntent = getIntent();
        ItemClass addedItem = (ItemClass)addItemIntent.getSerializableExtra("addedItem");

        //A lot of placeholder items, this will need to be a loop at some point
        Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
        Category altGodtFralandet = new Category("Alt godt fra landet", 3, 1, fridge);

        ArrayList<ItemClass> itemList = new ArrayList<>();

        itemList.add(addedItem);

        //itemList.add(test1);
        /*itemList.add(test2);
        itemList.add(test3);
        itemList.add(test4);
        itemList.add(test5);
        itemList.add(test6);
        itemList.add(test7);
        itemList.add(test8);
        itemList.add(test9);*/
        //Here all the items are added to the listView, using the activity_item layout
        itemListAdapter adapter = new itemListAdapter(this, R.layout.activity_item, itemList);
        foodList.setAdapter(adapter);

    }
    //These just open new activities based on a button press
    public void openOverview(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void openAddItem(View view){
        Intent intent = new Intent(getApplicationContext(), additem.class);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

}

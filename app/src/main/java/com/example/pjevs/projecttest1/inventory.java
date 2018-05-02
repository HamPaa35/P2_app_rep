package com.example.pjevs.projecttest1;


import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class inventory extends AppCompatActivity {

    private static final String TAG = "Inventory";
    int _ID = 0;
    ArrayList<ItemClass> itemList = ItemClass.getItemList();
    Intent addItemIntent;
    ItemClass testOfDb;
    DatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Log.d(TAG, "onCreate: Started");
        final ListView foodList = (ListView) findViewById(R.id.foodList);

        dbHandler = ((customApplication)getApplication()).dbHandler;

        //A lot of placeholder items, this will need to be a loop at some point
        Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
        Category altGodtFralandet = new Category("Alt godt fra landet", 3, 1, fridge);

        //addItemIntent = getIntent();
        //testOfDb = new ItemClass(dbHandler.dbNameToString(), dbHandler.dbCategoryToString(), dbHandler.dbExpirationDateToString(), dbHandler.dbStorageMethodToString(), dbHandler.dbOpenClosedToString());

        itemListAdapter adapter = new itemListAdapter(this, R.layout.activity_item, itemList);
        //itemList.add(testOfDb);
        //itemList.add((ItemClass)addItemIntent.getSerializableExtra("addedItem"));
        foodList.setAdapter(adapter);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent til infoside, hvor man kan edit sit instance.
                //Åben editItem
            }
        });

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

    public void openSettings(View view) {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }
}

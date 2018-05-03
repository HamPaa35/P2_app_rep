package com.example.pjevs.projecttest1;


import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;


public class inventory extends AppCompatActivity {

    private static final String TAG = "Inventory";
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
        /*Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
        Category altGodtFralandet = new Category("Alt godt fra landet", 3, 1, fridge);*/

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
                //Toast.makeText(getApplicationContext(), "Ja det virker, og kom så tilbage til arbejdet!", Toast.LENGTH_SHORT).show();
                //Toast.makeText(inventory.this, "Sorry, but you fucked up the dialog. You can go home now.", Toast.LENGTH_LONG).show();
                //editItemPushed();
                dialog();

            }
        });

    }
    private void openInventory(){
        Intent intent = new Intent(getApplicationContext(), inventory.class);
        startActivity(intent);
    }

    private void dialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.dialogalertdesign, null);

        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        Button editBtn = (Button) promptView.findViewById(R.id.editBtn);
        Button cancelBtn = (Button) promptView.findViewById(R.id.cancelBtn);
        Button delBtn = (Button) promptView.findViewById(R.id.delBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editItemPushed();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openInventory();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.remove(itemList);
                //Toast.makeText(inventory.this, "Item deleted, trust me!", Toast.LENGTH_SHORT).show();
            }
        });

        alertD.setView(promptView);
        alertD.show();

    }


    private void editItemPushed() {
        Intent intent = new Intent(getApplicationContext(), editItem.class);
        startActivity(intent);
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
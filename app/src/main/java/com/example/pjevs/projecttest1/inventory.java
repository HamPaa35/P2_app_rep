package com.example.pjevs.projecttest1;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class inventory extends AppCompatActivity {

    private static final String TAG = "Inventory";
    //ArrayList<ItemClass> itemList = ItemClass.getItemList();
    Intent addItemIntent;
    ItemClass testOfDb;
    DatabaseHelper dbHandler;
    itemListAdapter adapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Log.d(TAG, "onCreate: Started");
        final ListView foodList = (ListView) findViewById(R.id.foodList);

        FileManager.loadItemData(this);

        //dbHandler = ((customApplication)getApplication()).dbHandler;
        //A lot of placeholder items, this will need to be a loop at some point
        /*Storage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
        Category altGodtFralandet = new Category("Alt godt fra landet", 3, 1, fridge);*/

        //addItemIntent = getIntent();
        //testOfDb = new ItemClass(dbHandler.dbNameToString(), dbHandler.dbCategoryToString(), dbHandler.dbExpirationDateToString(), dbHandler.dbStorageMethodToString(), dbHandler.dbOpenClosedToString());

        adapter = new itemListAdapter(this, R.layout.activity_item, ItemClass.getItemList());
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
                dialog(position);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void openInventory(){
        Intent intent = new Intent(getApplicationContext(), inventory.class);
        startActivity(intent);
    }

    private void dialog(final int itemPosition) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.dialogalertdesign, null);

        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        TextView dialogName = (TextView) promptView.findViewById(R.id.itemNameDialog);
        Button editBtn = (Button) promptView.findViewById(R.id.editBtn);
        Button cancelBtn = (Button) promptView.findViewById(R.id.cancelBtn);
        Button delBtn = (Button) promptView.findViewById(R.id.delBtn);
        Button consumedBtn = (Button) promptView.findViewById(R.id.buttonDialogConsumed);

        dialogName.setText(ItemClass.getItemList().get(itemPosition).getName());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editItemPushed(itemPosition);
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
                ItemClass.getItemList().remove(itemPosition);
                adapter.notifyDataSetChanged();
                ItemClass.trashedCounter++;
                FileManager.saveTrashCount(getApplicationContext());
                FileManager.saveItemData(getApplicationContext());
                openInventory();
            }
        });

        consumedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemClass.getItemList().remove(itemPosition);
                adapter.notifyDataSetChanged();
                ItemClass.consumedCounter++;
                FileManager.saveConsumedCount(getApplicationContext());
                FileManager.saveItemData(getApplicationContext());
                openInventory();
            }
        });

        alertD.setView(promptView);
        alertD.show();

    }


    private void editItemPushed(int itemPosition) {

        /*Intent intent = new Intent(getApplicationContext(), editItem.class);
        startActivity(intent);*/

        Intent i = new Intent(this, editItem.class);
        i.putExtra("Item to edit", ItemClass.getItemList().get(itemPosition));
        i.putExtra("Item position", itemPosition);
        startActivity(i);
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

    public void openStatistics(View view){
        Intent intent = new Intent(this, statisticsActivity.class);
        startActivity(intent);
    }

}
package com.example.pjevs.projecttest1;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class inventory extends AppCompatActivity {

    private static final String TAG = "Inventory";
    itemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Log.d(TAG, "onCreate: Started");
        final ListView foodList = (ListView) findViewById(R.id.foodList);

        FileManager.loadItemData(this);

        adapter = new itemListAdapter(this, R.layout.activity_item, ItemClass.getItemList());

        foodList.setAdapter(adapter);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        ListView foodList = (ListView) findViewById(R.id.foodList);

        Storage fridge = new Storage("Fridge");
        Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
        ItemClass test1 = new ItemClass("Muslinger", altGodtFraHavet,"26-05-2018", fridge, true);


        ArrayList<ItemClass> itemList = new ArrayList<>();
        itemList.add(test1);

        itemListAdapter adapter = new itemListAdapter(this, R.layout.activity_item, itemList);
        foodList.setAdapter(adapter);

        /*Button to open the additem class
        Button addBtn = (Button) findViewById(R.id.addbtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddItem();
            }
        });*/

        /*Button to open the Overview
        Button overViewBtn = (Button) findViewById(R.id.overviewbtn);
        overViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOverview();
            }
        }
        );*/
    }

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

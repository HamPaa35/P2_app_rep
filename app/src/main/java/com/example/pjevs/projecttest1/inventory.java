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

    private static final String TAG = "inventory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, myStringArray);

        ListView foodList = (ListView) findViewById(R.id.foodList);
        foodList.setAdapter(adapter);




        Button overviewbtn = (Button) findViewById(R.id.overviewbtn);
        overviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOverview();
            }
        });


        Button addbtn = (Button) findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItem();
            }
        });
    }
public void addNewItem(){
        Intent intent = new Intent(this, additem.class);
        startActivity(intent);
}
    public void openOverview(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

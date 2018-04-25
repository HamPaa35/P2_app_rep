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

        //Button to open the additem class
        Button addBtn = (Button) findViewById(R.id.addbtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddItem();
            }

            public void openAddItem(){
                Intent intent = new Intent(getApplicationContext(), additem.class);
                startActivity(intent);
            }
        });

        //Button to open the Overview
        Button overViewBtn = (Button) findViewById(R.id.overviewbtn);
        overViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOverview();
            }

            public void openOverview(){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });
    }



}

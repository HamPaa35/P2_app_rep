package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class statisticsActivity extends AppCompatActivity {

    TextView trashedStats;
    TextView consumedStats;
    TextView percentageConsumed;

    int percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        FileManager.loadTrashCount(this);
        FileManager.loadConsumedCount(this);

        trashedStats = findViewById(R.id.textViewTrashedStat);
        consumedStats = findViewById(R.id.textViewConsumedStats);
        percentageConsumed = findViewById(R.id.textPercentage);

        percentage = ItemClass.consumedCounter/(ItemClass.trashedCounter + ItemClass.consumedCounter)*100;

        trashedStats.setText("Items trashed: " + ItemClass.trashedCounter);
        consumedStats.setText("Items consumed: " + ItemClass.consumedCounter);
        percentageConsumed.setText("Consumed VS trashed items: " + percentage);

    }

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

    public void openInventory(View view){
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);

    }
}

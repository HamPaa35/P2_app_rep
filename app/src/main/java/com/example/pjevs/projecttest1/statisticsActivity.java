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

    private float percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        FileManager.loadTrashCount(this);
        FileManager.loadConsumedCount(this);

        trashedStats = findViewById(R.id.textViewTrashedStat);
        consumedStats = findViewById(R.id.textViewConsumedStats);
        percentageConsumed = findViewById(R.id.textPercentage);

        trashedStats.setText("Items trashed: " + ItemClass.trashedCounter);
        consumedStats.setText("Items consumed: " + ItemClass.consumedCounter);

        if (ItemClass.consumedCounter == 0){
            percentage = 100;
        }
        else{
            int trashPlusConsumed = 1 + 1;
            int consumedDivTrash = 1/trashPlusConsumed;
            percentage = consumedDivTrash * 100;
        }

        percentageConsumed.setText("Consumed VS trashed items: " + percentage + "%");

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

package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void openOverview(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openInventory(View view){
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);

    }

    public void openAddItem(View view){
        Intent intent = new Intent(getApplicationContext(), additem.class);
        intent.putExtra("Category spinner position", 0);
        startActivity(intent);
    }

    public void openGeneralSettings(View view){
        Intent intent = new Intent(getApplicationContext(), GeneralSettings.class);
        startActivity(intent);
    }

    public void openNotifications(View view){
        Intent intent = new Intent(getApplicationContext(), Notifications.class);
        startActivity(intent);
    }

    public void openCategoriesActivity(View view){
        Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
        startActivity(intent);
    }

    public void openStatistics(View view){
        Intent intent = new Intent(this, statisticsActivity.class);
        startActivity(intent);
    }

}

package com.example.pjevs.projecttest1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openInventory(View view){
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);
}

    public void openSettings(View view){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
}

    public void openTest(View view){
        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }

    public void openAddItem(View view){
        Intent intent = new Intent(getApplicationContext(), additem.class);
        startActivity(intent);
    }

    public void openEditItemTestTestTest(View view){
        Intent intent = new Intent(getApplicationContext(), editItem.class);
        startActivity(intent);
    }

    public void openStatistics(View view){
        Intent intent = new Intent(this, statisticsActivity.class);
        startActivity(intent);
    }
}

package com.example.pjevs.projecttest1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    categoryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView categoryListView = (ListView) findViewById(R.id.catFavList);

        FileManager.loadCatData(getApplicationContext());

        adapter = new categoryListAdapter(this, R.layout.activity_main, Category.getCategoryList());

        adapter = new categoryListAdapter(this, R.layout.activity_category, Category.getFavCatArrList());
        categoryListView.setAdapter(adapter);

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                favCategoryPushed(position);
            }
        });

    }

    private void favCategoryPushed(int catPosition) {
        Intent i = new Intent(this, additem.class);
        i.putExtra("Category spinner position", Category.getFavCatArrList().get(catPosition).getSpinnerCatPos());
        startActivity(i);
    }

    public void openInventory(View view) {
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void openAddItem(View view){
        Intent intent = new Intent(getApplicationContext(), additem.class);
        intent.putExtra("Category spinner position", 0);
        startActivity(intent);
    }

    public void openStatistics(View view){
        Intent intent = new Intent(this, statisticsActivity.class);
        startActivity(intent);
    }
}

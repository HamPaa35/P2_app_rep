package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    ArrayList<Category> categoryList = Category.getCategoryList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        final ListView categoryListView = (ListView) findViewById(R.id.categoryList);

        //A lot of placeholder items, this will need to be a loop at some pointStorage fridge = new Storage("Fridge");
        Storage freezer = new Storage("Freezer");
        Category altGodtFraHavet = new Category("Alt godt fra havet", "1 Days", "2 Days", freezer.getName());
        Category altGodtFraLandet = new Category("Alt godt fra landet", "3 Days", "4 Days", freezer.getName());

        //addItemIntent = getIntent();
        //testOfDb = new ItemClass(dbHandler.dbNameToString(), dbHandler.dbCategoryToString(), dbHandler.dbExpirationDateToString(), dbHandler.dbStorageMethodToString(), dbHandler.dbOpenClosedToString());

        categoryListAdapter adapter = new categoryListAdapter(this, R.layout.activity_category, categoryList);
        categoryList.add(altGodtFraHavet);
        categoryList.add(altGodtFraLandet);
        //itemList.add((ItemClass)addItemIntent.getSerializableExtra("addedItem"));
        categoryListView.setAdapter(adapter);


    }

    public void BackToSettings(View view){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void addNewCategory(View view){
        Intent intent = new Intent(this, AddCategoryActivity.class);
        startActivity(intent);
    }
}

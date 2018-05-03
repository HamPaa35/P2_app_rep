package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

//This class is controlling what is shown on the "additem" activity
public class AddCategoryActivity extends AppCompatActivity {

    //Initializing preset storages and categories
    Storage fridge = new Storage("Fridge");
    Storage freezer = new Storage("Freezer");
    Storage cupBoard = new Storage("Cupboard");

    DatabaseHelper dbHandler;

    //The setup of the category- and the datePicker
    private EditText categoryName;
    private EditText categoryExpirationOpen;
    private EditText getCategoryExpirationClosed;
    Spinner storageDropdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        dbHandler = ((customApplication)getApplication()).dbHandler;


    categoryName = (EditText) findViewById(R.id.addCategoryName);
    categoryExpirationOpen = (EditText) findViewById(R.id.categoryExpirationOpen);
    getCategoryExpirationClosed = (EditText) findViewById(R.id.categoryExpirationClosed);


    storageDropdown();
    }
    //Goes back to the most recent activity
    public void closeAddCategory(View view){
        finish();
    }

    public String getCategoryName(){
        return categoryName.getText().toString();
    }

    public String getCategoryExpirationOpen(){
        return categoryExpirationOpen.getText().toString();
    }

    public String getCategoryExpirationClosed(){
        return getCategoryExpirationClosed.getText().toString();
    }

    //This function tells what is shown in the storingDropdown
    public void storageDropdown(){
        storageDropdown = findViewById(R.id.storageCategorySpinner);
        String[] storing = new String[]{fridge.getName(), freezer.getName(), cupBoard.getName()};
        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storing);
        storageDropdown.setAdapter(storageAdapter);
    }
    public void finnishButton(View view){
        Category addedCategory = new Category(getCategoryName(), getCategoryExpirationOpen(), getCategoryExpirationClosed() ,storageDropdown.getSelectedItem().toString());
        openCategories();
    }

    public void openCategories(){
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

}
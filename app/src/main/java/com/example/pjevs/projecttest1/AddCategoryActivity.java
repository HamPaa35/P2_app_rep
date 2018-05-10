package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

//This class is controlling what is shown on the "additem" activity
public class AddCategoryActivity extends AppCompatActivity {

    //The initialisation of the different storage methods, to be used in the storage drop down
    ArrayList<String> storageListArrString = Storage.getStorageToStringArrList();
    String[] storageListString = storageListArrString.toArray(new String[storageListArrString.size()]);

    //The setup of the Views in the activity
    private EditText categoryName;
    private EditText categoryExpirationOpen;
    private EditText getCategoryExpirationClosed;
    Spinner storageDropdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        //Gets the Views from the XML files
        categoryName = (EditText) findViewById(R.id.addCategoryName);
        categoryExpirationOpen = (EditText) findViewById(R.id.categoryExpirationOpen);
        getCategoryExpirationClosed = (EditText) findViewById(R.id.categoryExpirationClosed);

        storageDropdown();
    }
    //Goes back to the most recent activity
    public void closeAddCategory(View view){
        finish();
    }

    //Returns the name the user has entered into the EditText View
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
        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storageListString);
        storageDropdown.setAdapter(storageAdapter);
    }

    //Takes the info added to the category and adds it to the array and database
    public void finnishButton(View view){
        Category addedCategory = new Category(getCategoryName(), getCategoryExpirationOpen(), getCategoryExpirationClosed() ,storageDropdown.getSelectedItem().toString(), storageDropdown.getSelectedItemPosition());
        FileManager.saveCatData(this);
        openCategories();
    }

    public void openCategories(){
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

}
package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class editCategory extends AppCompatActivity {

    ArrayList<String> storageListArrString = Storage.getStorageToStringArrList();
    String[] storageListString = storageListArrString.toArray(new String[storageListArrString.size()]);

    EditText catName;
    EditText catOpenExsp;
    EditText catClosedExsp;
    Spinner storageDropper;

    private int catPosition;
    private Category catToBeEdited;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_category);

        catName = findViewById(R.id.editTextEditCat);
        catOpenExsp = findViewById(R.id.editTextEditCatOpen);
        catClosedExsp = findViewById(R.id.editTextEditCatClosed);

        Intent itemToEdit = getIntent();
        catPosition = (Integer) itemToEdit.getSerializableExtra("Category position");
        catToBeEdited = (Category) itemToEdit.getSerializableExtra("Category to edit");

        catName.setText(catToBeEdited.getName());
        catOpenExsp.setText(catToBeEdited.getTypicalExpirationOpen());
        catClosedExsp.setText(catToBeEdited.getTypicalExpirationClosed());

        storageDropper();

    }

    public void storageDropper() {
        storageDropper = findViewById(R.id.spinnerEditCat);
        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storageListString);
        storageDropper.setAdapter(storageAdapter);

        storageDropper.setSelection(catToBeEdited.getSpinnerStorPos());
    }

    public void finnishButton(View view) {
        Category editedCategory = new Category(catName.getText().toString(), catOpenExsp.getText().toString(), catClosedExsp.getText().toString(), storageDropper.getSelectedItem().toString(), storageDropper.getSelectedItemPosition());
        Category.getCategoryList().remove(catPosition);
        openCategoriesActivity();
        //Intent i = new Intent(this, inventory.class);
        //i.putExtra("AddedItem", test);
        //startActivity(i);
    }

    public void closeAddItem(View view){
        finish();
    }

    public void openCategoriesActivity(){
        Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
        startActivity(intent);
    }
}

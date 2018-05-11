package com.example.pjevs.projecttest1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//This class is controlling what is shown on the "additem" activity
public class additem extends AppCompatActivity {

    //Initialises the arrays used for the dropdown menus
    ArrayList<String> categoryListArrString = Category.getCategoryToStringArrList();
    String[] categoryListString = categoryListArrString.toArray(new String[categoryListArrString.size()]);

    ArrayList<String> storageListArrString = Storage.getStorageToStringArrList();
    String[] storageListString = storageListArrString.toArray(new String[storageListArrString.size()]);

    //The setup of the different views in the activity
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText itemName;
    private Switch openClosedSwitch;
    Spinner storageDropdown;
    Spinner categoryDropdown;

    int catPosition;

    //This is used for an if else statement further down
    private String expirationDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        Intent favCatPositions = getIntent();
        catPosition = (Integer) favCatPositions.getSerializableExtra("Category spinner position");

        //The views are connected to the Views in the Activity
        itemName = (EditText) findViewById(R.id.addCategoryName);
        mDisplayDate = (TextView) findViewById(R.id.Date);
        openClosedSwitch = (Switch) findViewById(R.id.switch1);

        //Setup of the layout of the picked date
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(additem.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        //The listener which calls the time from the system. The month-number in the program would show January as 0, hence the "month + 1"
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
                expirationDate = date;
            }
        };

        categoryDropdown();
        storageDropdown();
    }

    //Goes back to the most recent activity
    public void closeAddItem(View view){
        finish();
    }

    //This function decides the return of "openClosedSwitch".
    public String checkSwitch(){
        if(openClosedSwitch.isChecked()){ return "Open";}
        else return "Closed";

    }

    public String itemName(){
        return itemName.getText().toString();
    }

    //This function tells what is shown in the categorySpinner
    public void categoryDropdown(){
        categoryDropdown = findViewById(R.id.categorySpinner);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoryListString);
        categoryDropdown.setPrompt("Pick a category");
        categoryDropdown.setAdapter(categoryAdapter);
        categoryDropdown.setSelection(catPosition);
        categoryDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int pos, long id) {
                storageDropdown.setSelection(Category.getCategoryList().get(categoryDropdown.getSelectedItemPosition()).getSpinnerStorPos());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {


            }});
    }

    //This function tells what is shown in the storingDropdown
    public void storageDropdown(){
        storageDropdown = findViewById(R.id.storageSpinner);
        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storageListString);
        storageDropdown.setPrompt("Pick a storage method");
        storageDropdown.setAdapter(storageAdapter);
        storageDropdown.setSelection(Category.getCategoryList().get(categoryDropdown.getSelectedItemPosition()).getSpinnerStorPos());

    }

    //Takes the info added to the category and adds it to the array and database
    public void finnishButton(View view){
        ItemClass addedItem = new ItemClass(itemName(), categoryDropdown.getSelectedItem().toString(), expirationDate, storageDropdown.getSelectedItem().toString(), checkSwitch(), categoryDropdown.getSelectedItemPosition(), storageDropdown.getSelectedItemPosition());
        FileManager.saveItemData(this);
        openInventory();
    }

    public void openInventory(){
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);
    }

    public String timeRemaining(Date then) {
        Date now = new Date();
        long diff = then.getTime() - now.getTime();
        String remaining = "";
        if (diff >= 86400000) {
            long days = diff / 86400000;
            remaining += "" + days + "days";
            diff -= days * 86400000;
        }
        //... similar math for hours, minutes
        return remaining;
    }

}
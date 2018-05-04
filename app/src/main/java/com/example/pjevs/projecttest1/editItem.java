package com.example.pjevs.projecttest1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class editItem extends AppCompatActivity {
    ArrayList<String> categoryListArrString = Category.getCategoryToStringArrList();
    String[] categoryListString = categoryListArrString.toArray(new String[categoryListArrString.size()]);
//From here : Attributes to DatePicker in TextView
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView itemNameTest;
    private EditText itemName;
    private String expirationDate;
    //To here : Attributes to DatePicker in TextView

//From here : Attributes to categoryPicker
Spinner categoryDropper;
Spinner storageDropper;
    Storage fridge = new Storage("Fridge");
    Storage freezer = new Storage("Freezer");
    Storage cupBoard = new Storage("Cupboard");


//To Here : Attributes to categoryPicker
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
//From here : DatePicker in TextView
        itemNameTest = (TextView) findViewById(R.id.itemName);
       mDisplayDate = (TextView) findViewById(R.id.datePicker);
       itemName = (EditText) findViewById(R.id.addCategoryName);

        Intent itemToEdit = getIntent();

        ItemClass itemToBeEdited = (ItemClass) itemToEdit.getSerializableExtra("Item to edit");

        itemNameTest.setText(itemToBeEdited.getName());

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(editItem.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                }
                });

            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    month = month + 1;
                    String date = day + "/" + month + "/" + year;
                    mDisplayDate.setText(date);
                    expirationDate = date;
                }
            };


categoryDropper();
storageDropper();


        }
    //To here : DatePicker in TextView
    public void categoryDropper() {
        categoryDropper = findViewById(R.id.categoryPicker);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoryListString);
        categoryDropper.setAdapter(categoryAdapter);
    }

    public void storageDropper(){
        storageDropper = findViewById(R.id.storageDropper);
        String[] storing = new String[] {freezer.getName(), fridge.getName(), cupBoard.getName()};
        ArrayAdapter<String> storingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storing);
        storageDropper.setAdapter(storingAdapter);

    }





    }






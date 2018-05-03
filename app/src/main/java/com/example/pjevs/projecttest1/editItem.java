package com.example.pjevs.projecttest1;

import android.app.DatePickerDialog;
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

import java.util.Calendar;

public class editItem extends AppCompatActivity {

//From here : Attributes to DatePicker in TextView
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText itemName;
    private String expirationDate;
    //To here : Attributes to DatePicker in TextView

//From here : Attributes to categoryPicker
Spinner categoryDropper;
    Storage fridge = new Storage("Fridge");
    Storage freezer = new Storage("Freezer");
    Storage cupBoard = new Storage("Cupboard");
    Category altGodtFraHavet = new Category("Alt godt fra havet", "3", "1", fridge.getName());
    Category altGodtFralandet = new Category("Alt godt fra landet", "3", "1", freezer.getName());


//To Here : Attributes to categoryPicker
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
//From here : DatePicker in TextView
       mDisplayDate = (TextView) findViewById(R.id.datePicker);
       itemName = (EditText) findViewById(R.id.addCategoryName);

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



        }
    //To here : DatePicker in TextView
    public void categoryDropper(){
        categoryDropper = findViewById(R.id.categoryPicker);
        String[] items = new String[]{altGodtFraHavet.getName(), altGodtFralandet.getName()};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        categoryDropper.setAdapter(categoryAdapter);
    }
// From here : categorySpinner




    }






package com.example.pjevs.projecttest1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class additem extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

    /*Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
    cancelBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        openInventory();
        }
    });*/

    mDisplayDate = (TextView) findViewById(R.id.Date);

    ArrayList<String> foods = new ArrayList<>();
    foods.add("Mælk");
    foods.add("Brød");
    foods.add("Frugt");
    foods.add("Grøntsager");
    foods.add("Alt godt fra havet");

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

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Mælk", "Frugt", "Alt godt fra havet"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.spinner2);
        String[] storing = new String[]{"Freezer -20°", "Refrigerator 5°", "Storage 18°" };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storing);
        dropdown2.setAdapter(adapter2);

    }
    //Goes back to the most recent activity
    public void closeAddItem(View view){
        finish();
    }

}




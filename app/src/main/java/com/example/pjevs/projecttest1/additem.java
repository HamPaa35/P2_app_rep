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
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class additem extends AppCompatActivity {


    Storage fridge = new Storage("Fridge");
    Storage freezer = new Storage("Freezer");
    Storage cupBoard = new Storage("Cupboard");
    Category altGodtFraHavet = new Category("Alt godt fra havet", 3, 1, fridge);
    Category altGodtFralandet = new Category("Alt godt fra landet", 3, 1, freezer);
    public ItemClass test = new ItemClass();

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText itemName;
    private Switch openClosedSwitch;
    private TextView testView;

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
    itemName = (EditText) findViewById(R.id.addItemName);
    mDisplayDate = (TextView) findViewById(R.id.Date);
    openClosedSwitch =(Switch) findViewById(R.id.switch1);
    testView = (TextView) findViewById(R.id.testView);

    /*ArrayList<String> foods = new ArrayList<>();
    foods.add("Mælk");
    foods.add("Brød");
    foods.add("Frugt");
    foods.add("Grøntsager");
    foods.add("Alt godt fra havet");*/

    setItemName();

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
                test.setExpirationDate(date);
                updateTest();
            }
        };

        categoryDropdown();
        storageDropdown();
        openClosedSwitch();
    }
    //Goes back to the most recent activity
    public void closeAddItem(View view){
        finish();
    }

    public String checkSwitch(){
        if(openClosedSwitch.isChecked()){ return "Open";}
        else return "Closed";

    }

    public void setItemName(){
        test.setName(itemName.getText().toString());

        updateTest();
    }

    public void categoryDropdown(){
        Spinner categoryDropdown = findViewById(R.id.categorySpinner);
        String[] items = new String[]{altGodtFraHavet.getName(), altGodtFralandet.getName()};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        categoryDropdown.setAdapter(categoryAdapter);
        test.setItemCategory(categoryDropdown.getSelectedItem().toString());

        updateTest();
    }

    public void storageDropdown(){
        Spinner storageDropdown = findViewById(R.id.storageSpinner);
        String[] storing = new String[]{fridge.getName(), freezer.getName(), cupBoard.getName()};
        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storing);
        storageDropdown.setAdapter(storageAdapter);
        test.setStorageMethod(storageDropdown.getSelectedItem().toString());

        updateTest();
    }

    public void openClosedSwitch(){
        test.setOpenClosed(checkSwitch());

        updateTest();
    }

    public void updateTest(){
        testView.setText("1" + test.getName() + "2" + test.getItemCategory() + "3" + test.getExpirationDate() + "4" + test.getStorageMethod() + "5" + test.getOpenClosed());
    }

}




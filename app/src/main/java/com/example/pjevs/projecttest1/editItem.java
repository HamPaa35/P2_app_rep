package com.example.pjevs.projecttest1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class editItem extends AppCompatActivity {

    ArrayList<String> categoryListArrString = Category.getCategoryToStringArrList();
    String[] categoryListString = categoryListArrString.toArray(new String[categoryListArrString.size()]);

    ArrayList<String> storageListArrString = Storage.getStorageToStringArrList();
    String[] storageListString = storageListArrString.toArray(new String[storageListArrString.size()]);

    //From here : Attributes to DatePicker in TextView
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText itemName;
    private String expirationDatePicked;
    private String expirationDate;
    private Button cancelButton;
    private Button finishButton;
    private Switch openClosed;

    int itemPosition;
    private ItemClass itemToBeEdited;
    //To here : Attributes to DatePicker in TextView

    //From here : Attributes to categoryPicker
    Spinner categoryDropper;
    Spinner storageDropper;


    //To Here : Attributes to categoryPicker
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //From here : DatePicker in TextView
        mDisplayDate = (TextView) findViewById(R.id.datePicker);
        itemName = (EditText) findViewById(R.id.editTextEditItem);
        cancelButton = (Button) findViewById(R.id.cancelBtnEdit);
        finishButton = (Button) findViewById(R.id.finishBtnEdit);
        openClosed = (Switch) findViewById(R.id.switchEdit);

        Intent itemToEdit = getIntent();
        itemPosition = (Integer) itemToEdit.getSerializableExtra("Item position");
        itemToBeEdited = (ItemClass) itemToEdit.getSerializableExtra("Item to edit");
        expirationDate = itemToBeEdited.getExpirationDate();
        expirationDatePicked = "";

        itemName.setText(itemToBeEdited.getName());
        setSwitchStateFromItemToBeEdited(itemToBeEdited);

        if (itemToBeEdited.getExpirationDate().equals("")) {
            mDisplayDate.setText("Expiration date");
        } else {
            mDisplayDate.setText(expirationDate);
        }

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
                expirationDatePicked = date;
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

        categoryDropper.setSelection(itemToBeEdited.getSpinnerCatPos());
    }

    public String expirationDate (){
        if(expirationDatePicked.equals("")){
            return expirationDate;
        }
        else{
            return expirationDatePicked;
        }
    }

    public void storageDropper() {
        storageDropper = findViewById(R.id.storageDropper);
        ArrayAdapter<String> storingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, storageListString);
        storageDropper.setAdapter(storingAdapter);

        storageDropper.setSelection(Category.getCategoryList().get(categoryDropper.getSelectedItemPosition()).getSpinnerStorPos());
    }

    public void finnishButton(View view) {
        ItemClass addedItem = new ItemClass(itemName(), categoryDropper.getSelectedItem().toString(), expirationDate(), storageDropper.getSelectedItem().toString(), checkSwitch(), categoryDropper.getSelectedItemPosition(), storageDropper.getSelectedItemPosition());
        ItemClass.getItemList().remove(itemPosition);
        FileManager.saveItemData(this);
        openInventory();
    }

    public void openInventory() {
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);
    }

    public String itemName(){
        return itemName.getText().toString();
    }

    public String checkSwitch(){
        if(openClosed.isChecked()){ return "Open";}
        else return "Closed";

    }

    public void setSwitchStateFromItemToBeEdited(ItemClass item){
        String itemOpenClosed = item.getOpenClosed();
        if(itemOpenClosed.equals("Open")){
            openClosed.setChecked(true);
        }
        else{
            openClosed.setChecked(false);
        }
    }

    public void closeAddItem(View view){
        finish();
    }

}






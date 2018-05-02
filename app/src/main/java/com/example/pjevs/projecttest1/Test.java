package com.example.pjevs.projecttest1;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    EditText itemInput;
    TextView itemList;
    DatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        itemInput = (EditText) findViewById(R.id.addItemBox);
        itemList = (TextView) findViewById(R.id.itemText);
        dbHandler = ((customApplication)getApplication()).dbHandler;
        printDatabase();
    }

    private void printDatabase() {
        String dbString = dbHandler.dbNameToString();
        itemList.setText(dbString);
        itemInput.setText("");
    }

    public void deleteButtonClicked(View view){
        String inputText = itemInput.getText().toString();
        dbHandler.deleteItem(inputText);
        printDatabase();
    }

    public void addButtonClicked(View view){
        ItemClass item = new ItemClass(itemInput.getText().toString());
        dbHandler.addItem(item);
        printDatabase();
    }
}

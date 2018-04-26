package com.example.pjevs.projecttest1;

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
        dbHandler = new DatabaseHelper(this, null, null, 1);
        printDatabase();
    }

    private void printDatabase() {
        String dbString = dbHandler.databaseToString();
        itemList.setText(dbString);
        itemInput.setText("");
    }

    public void addButtonClicked(View view){
        ItemClass item = new ItemClass(itemInput.getText().toString());
        dbHandler.addItem(item);
        printDatabase();
    }
}

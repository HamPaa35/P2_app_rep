package com.example.pjevs.projecttest1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inventorybtn = (Button) findViewById(R.id.inventorybtn);
        inventorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInventory();
            }
        });

    Button settingsbtn = (Button) findViewById(R.id.settingsbtn);
    settingsbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openSettings();
        }
    });



    }

public void openInventory(){
        Intent intent = new Intent(this, inventory.class);
        startActivity(intent);

}

public void openSettings(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);

}
}

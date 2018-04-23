package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button overviewbtn2 = (Button) findViewById(R.id.overviewbtn2);
        overviewbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOverview();
            }
        });
    }
    public void openOverview(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    void test(){

    }

    void Kaspertest(){

    }

    void Mathiastest(){
        
    }

    void Kasperkigger(){

    }

    void Samme(){

    }

}

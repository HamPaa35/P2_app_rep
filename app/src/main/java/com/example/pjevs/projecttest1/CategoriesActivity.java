package com.example.pjevs.projecttest1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class CategoriesActivity extends AppCompatActivity {

    categoryListAdapter adapter;
    ImageButton favoriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        final ListView categoryListView = (ListView) findViewById(R.id.categoryList);
        favoriteButton = findViewById(R.id.imageButtonFavorite);

        FileManager.loadCatData(getApplicationContext());

        adapter = new categoryListAdapter(this, R.layout.activity_category, Category.getCategoryList());
        categoryListView.setAdapter(adapter);

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog(position);
            }
        });
    }

    private void dialog(final int catPosition) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.dialogalertdesign_category, null);

        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        TextView dialogName = (TextView) promptView.findViewById(R.id.itemNameDialogCategories);
        Button editBtn = (Button) promptView.findViewById(R.id.editBtnCategories);
        Button cancelBtn = (Button) promptView.findViewById(R.id.cancelBtnCategories);
        Button delBtn = (Button) promptView.findViewById(R.id.delBtnCategories);

        dialogName.setText(Category.getCategoryList().get(catPosition).getName());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCategoryPushed(catPosition);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategoriesActivity();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.getCategoryList().remove(catPosition);
                adapter.notifyDataSetChanged();
                FileManager.saveCatData(getApplicationContext());
                openCategoriesActivity();
            }
        });

        alertD.setView(promptView);
        alertD.show();

    }

    public void BackToSettings(View view){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void addNewCategory(View view){
        Intent intent = new Intent(this, AddCategoryActivity.class);
        startActivity(intent);
    }

    public void openCategoriesActivity(){
        Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
        startActivity(intent);
    }

    private void editCategoryPushed(int catPosition) {
        Intent i = new Intent(this, editCategory.class);
        i.putExtra("Category to edit", Category.getCategoryList().get(catPosition));
        i.putExtra("Category position", catPosition);
        startActivity(i);
    }

    public void onFavoriteClicked(View view){
        favoriteButton.setImageResource(android.R.drawable.btn_star_big_on);
    }
}
